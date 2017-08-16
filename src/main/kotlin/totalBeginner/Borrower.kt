package totalBeginner

data class Borrower(val name: String, val maxBooks: Int) {

    companion object {

        fun makeBorrower(name: String, maxBooks: Int): Borrower = Borrower(name = name, maxBooks = maxBooks)

        fun getName(br: Borrower): String = br.name

        fun setName(n: String, br: Borrower): Borrower = br.copy(name = n)

        fun getMaxBooks(br: Borrower): Int = br.maxBooks

        fun setMaxBooks(mb: Int, br: Borrower): Borrower = br.copy(maxBooks = mb)

        fun borrowerToString(br: Borrower): String {
            return getName(br) + " (" + getMaxBooks(br) + " books)"
        }
    }

}
