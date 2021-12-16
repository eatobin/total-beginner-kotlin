import Book.Companion.getAuthor
import Book.Companion.getTitle
import Book.Companion.setAuthor
import kotlin.test.Test
import kotlin.test.assertEquals

private val br1 = Borrower("Borrower1", 1)
private val bk1 = Book("Title1", "Author1", br1)
private val bk2 = Book("Title2", "Author2")

class BookTest {
    @Test
    fun testGetTitle() {
        assertEquals("Title1", getTitle(bk1))
    }

    @Test
    fun testGetAuthor() {
        assertEquals("Author2", getAuthor(bk2))
    }

    @Test
    fun testSetAuthor() {
        assertEquals(Book(title = "Title1", author = "Author11", borrower = br1), setAuthor("Author11", bk1))
    }
}

//    "setAuthor should set the Book author" {
//        setAuthor("Author11", bk1).shouldBe(Book(title = "Title1", author = "Author11", borrower = br1))
//    }
//
//    "getBorrower-someone should get the Book borrower" {
//        getBorrower(bk1).shouldBe(br1)
//    }
//
//    "getBorrower-null should get the Book borrower - null" {
//        getBorrower(bk2).shouldBe(null)
//    }
//
//    "setBorrower-someone should set the Book borrower" {
//        val nbr = Book(title = "Title2", author = "Author2",
//                borrower = Borrower(name = "BorrowerNew", maxBooks = 111))
//        setBorrower(Borrower(name = "BorrowerNew", maxBooks = 111), bk2).shouldBe(nbr)
//    }
//
//})
