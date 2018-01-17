package totalBeginner

import arrow.core.Either
import junit.framework.TestCase
import org.junit.Assert

class LibraryTest : TestCase() {

    private val br1 = Borrower.makeBorrower("Borrower1", 1)
    private val br2 = Borrower.makeBorrower("Borrower2", 2)
    private val br3 = Borrower.makeBorrower("Borrower3", 3)

    private val brs1 = listOf(br1, br2)
    private val brs2 = listOf(br1, br2, br3)

    private val bk1 = Book.makeBook("Title1", "Author1", br1)
    private val bk2 = Book.makeBook("Title2", "Author2", null)
    private val bk3 = Book.makeBook("Title3", "Author3", br3)
    private val bk4 = Book.makeBook("Title4", "Author4", br3)

    private val bks1 = listOf(bk1, bk2)
    private val bks2 = listOf(bk1, bk2, bk3)
    private val bks3 = listOf(bk1, bk2, bk3, bk4)
    private val bks4 = listOf(bk1, bk3, bk4, (Book(title = "Title2", author = "Author2", borrower = br2)))
    private val bks5 = listOf(bk2, Book(title = "Title1", author = "Author1", borrower = null))


    private val jsonStringBorrowers = "[{\"name\":\"Borrower1\",\"maxBooks\":1},{\"name\":\"Borrower2\",\"maxBooks\":2}]"
    private val jsonStringBooks = "[{\"title\":\"Title1\",\"author\":\"Author1\",\"borrower\":{\"name\":\"Borrower1\",\"maxBooks\":1}},{\"title\":\"Title2\",\"author\":\"Author2\",\"borrower\":null}]"

    private val ss = "\n--- Status Report of Test Library ---\n\nTest Library: 3 books; 3 borrowers.\n\nTitle1 by Author1; Checked out to Borrower1\nTitle2 by Author2; Available\nTitle3 by Author3; Checked out to Borrower3\n\nBorrower1 (1 books)\nBorrower2 (2 books)\nBorrower3 (3 books)\n\n--- End of Status Report ---\n"

    fun testAddBorrower() {
        Assert.assertEquals(brs2, Library.addItem(br3, brs1))
        Assert.assertEquals(brs1, Library.addItem(br2, brs1))
    }

    fun testAddBook() {
        Assert.assertEquals(bks2, Library.addItem(bk3, bks1))
        Assert.assertEquals(bks1, Library.addItem(bk2, bks1))
    }

    fun testRemoveBook() {
        Assert.assertEquals(bks1, Library.removeBook(bk3, bks2))
        Assert.assertEquals(bks1, Library.removeBook(bk3, bks1))
    }

    fun testFindBook() {
        Assert.assertEquals(bk1, Library.findItem("Title1", bks2, { Book.getTitle(it) }))
        Assert.assertNull(Library.findItem("Title11", bks2, { Book.getTitle(it) }))
    }

    fun testFindBorrower() {
        Assert.assertEquals(br1, Library.findItem("Borrower1", brs2, { Borrower.getName(it) }))
        Assert.assertNull(Library.findItem("Borrower11", brs2, { Borrower.getName(it) }))
    }

    fun testGetBooksForBorrower() {
        Assert.assertEquals(listOf<Book>(), Library.getBooksForBorrower(br2, bks1))
        Assert.assertEquals(listOf(bk1), Library.getBooksForBorrower(br1, bks1))
        Assert.assertEquals(listOf(bk3, bk4), Library.getBooksForBorrower(br3, bks3))
    }

    fun testCheckOut() {
        Assert.assertEquals(bks1, Library.checkOut("Borrower2", "Title1", brs1, bks1))
        Assert.assertEquals(bks1, Library.checkOut("Borrower2", "NoTitle", brs1, bks1))
        Assert.assertEquals(bks1, Library.checkOut("NoName", "Title1", brs1, bks1))
        Assert.assertEquals(bks1, Library.checkOut("Borrower1", "Title2", brs1, bks1))
        Assert.assertEquals(bks4, Library.checkOut("Borrower2", "Title2", brs2, bks3))
    }

    fun testCheckIn() {
        Assert.assertEquals(bks5, Library.checkIn("Title1", bks1))
        Assert.assertEquals(bks1, Library.checkIn("Title2", bks1))
        Assert.assertEquals(bks1, Library.checkIn("NoTitle", bks1))
    }

    fun testStatusToString() {
        Assert.assertEquals(ss, Library.statusToString(bks2, brs2))
    }

    fun testJsonStringToObjects() {
        Assert.assertEquals(brs1, Library.jsonStringToBorrowers(jsonStringBorrowers))
        Assert.assertEquals(bks1, Library.jsonStringToBooks(jsonStringBooks))
    }

    fun testReadFileIntoJsonString2() {
        val s1 = Main.readFileIntoJsonString2("noFile.json")
        Assert.assertEquals(Either.left("File read error."), s1)
        val s2 = Main.readFileIntoJsonString2("little.json")
        Assert.assertEquals(Either.right("[{\"name\":\"Borrower1001\"}]"), s2)
    }

    fun testBorrowersToJsonString() {
        Assert.assertEquals("[{\"name\":\"Borrower1\",\"maxBooks\":1},{\"name\":\"Borrower2\",\"maxBooks\":2}]", Library.borrowersToJsonString(brs1))
    }

    fun testBooksToJsonString() {
        Assert.assertEquals("[{\"title\":\"Title1\",\"author\":\"Author1\",\"borrower\":{\"name\":\"Borrower1\",\"maxBooks\":1}},{\"title\":\"Title2\",\"author\":\"Author2\"}]", Library.booksToJsonString(bks1))
    }

}
