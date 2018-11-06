package totalBeginner

import junit.framework.TestCase
import totalBeginner.Borrower.Companion.borrowerToString
import totalBeginner.Borrower.Companion.getName
import totalBeginner.Borrower.Companion.setMaxBooks
import totalBeginner.Borrower.Companion.setName

class BorrowerTest : TestCase() {

    private val br1 = Borrower("Borrower1", 1)

    fun testBorrowerConstructor() {
        assertEquals(br1, Borrower("Borrower1", 1))
    }

    fun testGetName() {
        assertEquals("Borrower1", getName(br1))
    }

    fun testSetName() {
        assertEquals(br1, setName("Borrower1", Borrower("Jack", 1)))
    }

    fun testGetMaxBooks() {
        assertEquals(1, Borrower.getMaxBooks(br1))
    }

    fun testSetMaxBooks() {
        assertEquals(Borrower("Borrower1", 11), setMaxBooks(11, br1))
    }

    fun testToString() {
        assertEquals("Borrower1 (1 books)", borrowerToString(br1))
    }

}
