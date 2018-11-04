package totalBeginner

import junit.framework.TestCase

class BorrowerTest : TestCase() {

    private val br1 = Borrower("Borrower1", 1)

    fun testBorrowerConstructor() {
        assertEquals(br1, Borrower("Borrower1", 1))
    }

    fun testGetName() {
        assertEquals("Borrower1", Borrower.getName(br1))
    }

    fun testSetName() {
        assertEquals(br1, Borrower.setName("Borrower1", Borrower("Jack", 1)))
    }

    fun testGetMaxBooks() {
        assertEquals(1, Borrower.getMaxBooks(br1))
    }

    fun testSetMaxBooks() {
        assertEquals(Borrower("Borrower1", 11), Borrower.setMaxBooks(11, br1))
    }

    fun testToString() {
        assertEquals("Borrower1 (1 books)", Borrower.borrowerToString(br1))
    }

}
