import Borrower.Companion.borrowerToString
import Borrower.Companion.getMaxBooks
import Borrower.Companion.getName
import Borrower.Companion.setMaxBooks
import Borrower.Companion.setName
import kotlin.test.Test
import kotlin.test.assertEquals

private val br1 = Borrower("Borrower1", 1)

class BorrowerTest {
    @Test
    fun testGetName() {
        assertEquals("Borrower1", getName(br1))
    }

    @Test
    fun testSetName() {
        assertEquals(br1, setName("Borrower1", Borrower("Jack", 1)))
    }

    @Test
    fun testGetMaxBooks() {
        assertEquals(1, getMaxBooks(br1))
    }

    @Test
    fun testSetMaxBooks() {
        assertEquals(Borrower("Borrower1", 11), setMaxBooks(11, br1))
    }

    @Test
    fun testBorrowerToString() {
        assertEquals("Borrower1 (1 books)", borrowerToString(br1))
    }
}
