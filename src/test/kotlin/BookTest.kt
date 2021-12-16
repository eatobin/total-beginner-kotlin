import Book.Companion.getAuthor
import Book.Companion.getBorrower
import Book.Companion.getTitle
import Book.Companion.setAuthor
import Book.Companion.setBorrower
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

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

    @Test
    fun testGetBorrower() {
        assertEquals(br1, getBorrower(bk1))
    }

    @Test
    fun testGetBorrowerNull() {
        assertNull(getBorrower(bk2))
    }

    @Test
    fun testSetBorrowerSomeone() {
        val nbr = Book(
            title = "Title2", author = "Author2",
            borrower = Borrower(name = "BorrowerNew", maxBooks = 111)
        )
        assertEquals(nbr, setBorrower(Borrower(name = "BorrowerNew", maxBooks = 111), bk2))
    }
}
