package totalBeginner

import junit.framework.TestCase
import org.junit.Assert

class LibraryTest : TestCase() {

    val br1 = Borrower(name = "Borrower1", maxBooks = 1)
    val br2 = Borrower(name = "Borrower2", maxBooks = 2)
    val br3 = Borrower(name = "Borrower3", maxBooks = 3)
//    val br4 = Borrower(name = "borrower4", maxBooks = 4)
//    val br5 = Borrower(name = "BORROWER5", maxBooks = 5)

    val brs1 = listOf(br1, br2)
    val brs2 = listOf(br1, br2, br3)
//    val brs3 = listOf(br1, br2, br3, br4, br5)

    val bk1 = Book(title = "Title1", author = "Author1", borrower = br1)
    val bk2 = Book(title = "Title2", author = "Author2")
    val bk3 = Book(title = "Title3", author = "Author3", borrower = br3)
    val bk4 = Book(title = "Title4", author = "Author4", borrower = br3)

    val bks1 = listOf(bk1, bk2)
    val bks2 = listOf(bk1, bk2, bk3)
    val bks3 = listOf(bk1, bk2, bk3, bk4)

    val ss = "\n--- Status Report of Test Library ---\n\nTest Library: 3 books; 3 borrowers.\n\nTitle1 by Author1; Checked out to Borrower1\nTitle2 by Author2; Available\nTitle3 by Author3; Checked out to Borrower3\n\nBorrower1 (1 books)\nBorrower2 (2 books)\nBorrower3 (3 books)\n\n--- End of Status Report ---\n"

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
        Assert.assertEquals(listOf(bk1,
                Book(title = "Title2", author = "Author2",
                        borrower = Borrower(name = "Borrower2", maxBooks = 2))),
                Library.checkOut("Borrower2", "Title2", brs1, bks1))
    }

    fun testCheckIn() {
        Assert.assertEquals(listOf(bk2,
                Book(title = "Title1", author = "Author1", borrower = null)),
                Library.checkIn("Title1", bks1))
        Assert.assertEquals(bks1, Library.checkIn("Title2", bks1))
        Assert.assertEquals(bks1, Library.checkIn("NoTitle", bks1))
    }

    fun testStatusToString() {
        Assert.assertEquals(ss, Library.statusToString(bks2, brs2))
    }

}
