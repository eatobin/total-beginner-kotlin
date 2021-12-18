import Library.addItem
import Library.booksToJsonString
import Library.borrowersToJsonString
import Library.checkIn
import Library.checkOut
import Library.findItem
import Library.getBooksForBorrower
import Library.jsonStringToBooks
import Library.jsonStringToBorrowers
import Library.removeBook
import Library.statusToString
import kotlin.test.Test
import kotlin.test.assertEquals

private val br1 = Borrower("Borrower1", 1)
private val br2 = Borrower("Borrower2", 2)
private val br3 = Borrower("Borrower3", 3)

private val brs1 = listOf(br1, br2)
private val brs2 = listOf(br1, br2, br3)

private val bk1 = Book("Title1", "Author1", br1)
private val bk2 = Book("Title2", "Author2", null)
private val bk3 = Book("Title3", "Author3", br3)
private val bk4 = Book("Title4", "Author4", br3)

private val bks1 = listOf(bk1, bk2)
private val bks2 = listOf(bk1, bk2, bk3)
private val bks3 = listOf(bk1, bk2, bk3, bk4)
private val bks4 = listOf(bk1, bk3, bk4, (Book(title = "Title2", author = "Author2", borrower = br2)))
private val bks5 = listOf(bk2, Book(title = "Title1", author = "Author1", borrower = null))

private const val jsonStringBorrowers = """[{"name":"Borrower1","maxBooks":1},{"name":"Borrower2","maxBooks":2}]"""
private const val jsonStringBorrowersBad = """[{"nameX":"Borrower1","maxBooks":1},{"name":"Borrower2","maxBooks":2}]"""
private const val jsonStringBooks =
    """[{"title":"Title1","author":"Author1","borrower":{"name":"Borrower1","maxBooks":1}},{"title":"Title2","author":"Author2","borrower":null}]"""
private const val jsonStringBooksBad =
    """[{"title":"Title1","authorX":"Author1","borrower":{"name":"Borrower1","maxBooks":1}},{"title":"Title2","author":"Author2","borrower":null}]"""
private const val jsonStringBooksBadFile =
    """[{"title";"Title1","author":"Author1","borrower":{"name":"Borrower1","maxBooks":1}},{"title":"Title2","author":"Author2","borrower":null}]"""
private const val jsonStringBooksNoBorrowerOn2 =
    """[{"title":"Title1","author":"Author1","borrower":{"name":"Borrower1","maxBooks":1}},{"title":"Title2","author":"Author2"}]"""

private const val ss =
    "\n--- Status Report of Test Library ---\n\nTest Library: 3 books; 3 borrowers.\n\nTitle1 by Author1; Checked out to Borrower1\nTitle2 by Author2; Available\nTitle3 by Author3; Checked out to Borrower3\n\nBorrower1 (1 books)\nBorrower2 (2 books)\nBorrower3 (3 books)\n\n--- End of Status Report ---\n"

class LibraryTest {
    @Test
    fun testAddBorrower() {
        assertEquals(brs2, addItem(br3, brs1))
        assertEquals(brs1, addItem(br2, brs1))
    }
}

//    "addBook should add a Book" {
//        addItem(bk3, bks1).shouldBe(bks2)
//        addItem(bk2, bks1).shouldBe(bks1)
//    }
//
//    "removeBook should remove a Book" {
//        removeBook(bk3, bks2).shouldBe(bks1)
//        removeBook(bk3, bks1).shouldBe(bks1)
//    }
//
//    "findItem should find a Book" {
//        findItem("Title1", bks2) { Book.getTitle(it) }.shouldBe(bk1)
//        findItem("Title11", bks2) { Book.getTitle(it) }.shouldBeNull()
//    }
//
//    "findItem should find a Borrower" {
//        findItem("Borrower1", brs2) { Borrower.getName(it) }.shouldBe(br1)
//        findItem("Borrower11", brs2) { Borrower.getName(it) }.shouldBeNull()
//    }
//
//    "getBooksForBorrower should find the Books for a Borrower" {
//        getBooksForBorrower(br2, bks1).shouldBe(listOf())
//        getBooksForBorrower(br1, bks1).shouldBe(listOf(bk1))
//        getBooksForBorrower(br3, bks3).shouldBe(listOf(bk3, bk4))
//    }
//
//    "a Book should check out" {
//        checkOut("Borrower2", "Title1", brs1, bks1).shouldBe(bks1)
//        checkOut("Borrower2", "NoTitle", brs1, bks1).shouldBe(bks1)
//        checkOut("NoName", "Title1", brs1, bks1).shouldBe(bks1)
//        checkOut("Borrower1", "Title2", brs1, bks1).shouldBe(bks1)
//        checkOut("Borrower2", "Title2", brs2, bks3).shouldBe(bks4)
//    }
//
//    "a Book should check in" {
//        checkIn("Title1", bks1).shouldBe(bks5)
//        checkIn("Title2", bks1).shouldBe(bks1)
//        checkIn("NoTitle", bks1).shouldBe(bks1)
//    }
//
//    "a Library should have a status" {
//        statusToString(bks2, brs2).shouldBe(ss)
//    }
//
//    "a JSON string should convert to objects" {
//        jsonStringToBorrowers(jsonStringBorrowers).shouldBe(brs1)
//        jsonStringToBooks(jsonStringBooks).shouldBe(bks1)
//        jsonStringToBooks(jsonStringBooksNoBorrowerOn2).shouldBe(bks1)
//        jsonStringToBorrowers(jsonStringBorrowersBad).shouldBe(emptyList())
//        jsonStringToBooks(jsonStringBooksBad).shouldBe(emptyList())
//        jsonStringToBooks(jsonStringBooksBadFile).shouldBe(emptyList())
//    }
//
//    "objects should convert to a JSON string" {
//        borrowersToJsonString(brs1).shouldBe("""[{"maxBooks" : 1, "name" : "Borrower1"}, {"maxBooks" : 2, "name" : "Borrower2"}]""")
//        booksToJsonString(bks1).shouldBe("""[{"author" : "Author1", "borrower" : {"maxBooks" : 1, "name" : "Borrower1"}, "title" : "Title1"}, {"author" : "Author2", "title" : "Title2"}]""")
//    }
//
//})
