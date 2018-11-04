package totalBeginner

import junit.framework.TestCase

class BookTest : TestCase() {

    private val br1 = Borrower("Borrower1", 1)
    private val bk1 = Book("Title1", "Author1", br1)
    private val bk2 = Book("Title2", "Author2", null)

    fun testGetTitle() {
        assertEquals("Title1", Book.getTitle(bk1))
    }

    fun testGetAuthor() {
        assertEquals("Author2", Book.getAuthor(bk2))
    }

    fun testSetAuthor() {
        assertEquals(Book(title = "Title1", author = "Author11", borrower = br1), Book.setAuthor("Author11", bk1))
    }

    fun testGetBorrowerSomeone() {
        assertEquals(br1, Book.getBorrower(bk1))
    }

    fun testGetBorrowerNull() {
        assertNull(Book.getBorrower(bk2))
    }

    fun testSetBorrowerSomeone() {
        val nbr = Book(title = "Title2", author = "Author2",
                borrower = Borrower(name = "BorrowerNew", maxBooks = 111))
        assertEquals(nbr,
                Book.setBorrower(Borrower(name = "BorrowerNew", maxBooks = 111), bk2))
    }

    fun testSetBorrowerNull() {
        val nbr = Book(title = "Title1", author = "Author1",
                borrower = null)
        assertEquals(nbr, Book.setBorrower(null, bk1))
    }

    fun testBookToStringSomeone() {
        assertEquals("Title1 by Author1; Checked out to Borrower1", Book.bookToString(bk1))
    }

    fun testBookToStringNull() {
        assertEquals("Title2 by Author2; Available", Book.bookToString(bk2))
    }

}
