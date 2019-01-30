package total_beginner

import junit.framework.TestCase
import total_beginner.Book.Companion.bookToString
import total_beginner.Book.Companion.getAuthor
import total_beginner.Book.Companion.getBorrower
import total_beginner.Book.Companion.getTitle
import total_beginner.Book.Companion.setAuthor
import total_beginner.Book.Companion.setBorrower

class BookTest : TestCase() {

    private val br1 = Borrower("Borrower1", 1)
    private val bk1 = Book("Title1", "Author1", br1)
    private val bk2 = Book("Title2", "Author2", null)

    fun testGetTitle() {
        assertEquals("Title1", getTitle(bk1))
    }

    fun testGetAuthor() {
        assertEquals("Author2", getAuthor(bk2))
    }

    fun testSetAuthor() {
        assertEquals(Book(title = "Title1", author = "Author11", borrower = br1), setAuthor("Author11", bk1))
    }

    fun testGetBorrowerSomeone() {
        assertEquals(br1, getBorrower(bk1))
    }

    fun testGetBorrowerNull() {
        assertNull(getBorrower(bk2))
    }

    fun testSetBorrowerSomeone() {
        val nbr = Book(title = "Title2", author = "Author2",
                borrower = Borrower(name = "BorrowerNew", maxBooks = 111))
        assertEquals(nbr,
                setBorrower(Borrower(name = "BorrowerNew", maxBooks = 111), bk2))
    }

    fun testSetBorrowerNull() {
        val nbr = Book(title = "Title1", author = "Author1",
                borrower = null)
        assertEquals(nbr, setBorrower(null, bk1))
    }

    fun testBookToStringSomeone() {
        assertEquals("Title1 by Author1; Checked out to Borrower1", bookToString(bk1))
    }

    fun testBookToStringNull() {
        assertEquals("Title2 by Author2; Available", bookToString(bk2))
    }

}
