package totalBeginner

import junit.framework.TestCase
import org.junit.Assert

class BorrowerTest : TestCase() {

    val br1 = Borrower.makeBorrower("Borrower1", 1)

    fun testBorrowerConstructor() {
        Assert.assertEquals(br1, Borrower("Borrower1", 1))
    }

    fun testGetName() {
        Assert.assertEquals("Borrower1", Borrower.getName(br1))
    }

    fun testSetName() {
        Assert.assertEquals(br1, Borrower.setName("Borrower1", Borrower("Jack", 1)))
    }

    fun testGetMaxBooks() {
        Assert.assertEquals(1, Borrower.getMaxBooks(br1))
    }

    fun testSetMaxBooks() {
        Assert.assertEquals(Borrower("Borrower1", 11), Borrower.setMaxBooks(11, br1))
    }

    fun testToString() {
        Assert.assertEquals("Borrower1 (1 books)", Borrower.borrowerToString(br1))
    }

}
