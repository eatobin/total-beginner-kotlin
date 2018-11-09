package totalBeginner

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import totalBeginner.Borrower.Companion.borrowerToString
import totalBeginner.Borrower.Companion.getMaxBooks
import totalBeginner.Borrower.Companion.getName
import totalBeginner.Borrower.Companion.setMaxBooks
import totalBeginner.Borrower.Companion.setName

private val br1 = Borrower("Borrower1", 1)

class BorrowerTest : StringSpec({
    "getName should return the Borrower name" {
        getName(br1).shouldBe("Borrower1")
    }

    "setName should set the Borrower name" {
        setName("Borrower1", Borrower("Jack", 1)).shouldBe(br1)
    }

    "getMaxBooks should return the Borrower maxBooks" {
        getMaxBooks(br1).shouldBe(1)
    }

    "setMaxBooks should set the Borrower maxBooks" {
        setMaxBooks(11, br1).shouldBe(Borrower("Borrower1", 11))
    }

    "the Borrower string should print" {
        borrowerToString(br1).shouldBe("Borrower1 (1 books)")
    }
})
