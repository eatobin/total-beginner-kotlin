package totalBeginner

object Library {

    fun <A> addItem(x: A, xs: List<A>): List<A> {
        if (xs.contains(x))
            return xs
        else
            return xs.plusElement(x)
    }

    fun removeBook(bk: Book, bks: List<Book>): List<Book> =
            bks.filter { it != bk }

    fun findBook(t: String, bks: List<Book>): Book? {
        val coll: List<Book> = bks.filter { Book.getTitle(it) == t }
        if (coll.isEmpty()) {
            return null
        } else return coll.first()
    }

    fun findBorrower(n: String, brs: List<Borrower>): Borrower? {
        val coll: List<Borrower> = brs.filter { Borrower.getName(it) == n }
        if (coll.isEmpty()) {
            return null
        } else return coll.first()
    }

    fun <A> findItem(tgt: String, coll: List<A>, f: (A) -> String): A? {
        val result: List<A> = coll.filter { it -> f(it) == tgt }
        return result.firstOrNull()
    }

    fun getBooksForBorrower(br: Borrower, bks: List<Book>): List<Book> =
            bks.filter { Book.getBorrower(it) == br }

    fun numBooksOut(br: Borrower, bks: List<Book>): Int =
            getBooksForBorrower(br, bks).count()

    fun notMaxedOut(br: Borrower, bks: List<Book>): Boolean =
            numBooksOut(br, bks) < Borrower.getMaxBooks(br)

    fun bookNotOut(bk: Book): Boolean =
            Book.getBorrower(bk) == null

    fun bookOut(bk: Book): Boolean =
            Book.getBorrower(bk) != null

    fun checkOut(n: String, t: String, brs: List<Borrower>, bks: List<Book>): List<Book> {
        val mbk: Book? = findBook(t, bks)
        val mbr: Borrower? = findBorrower(n, brs)
        if (mbk != null && mbr != null && notMaxedOut(mbr, bks) && bookNotOut(mbk)) {
            val newBook = Book.setBorrower(mbr, mbk)
            val fewerBooks = removeBook(mbk, bks)
            return addItem(newBook, fewerBooks)
        } else return bks
    }

    fun checkIn(t: String, bks: List<Book>): List<Book> {
        val mbk: Book? = findBook(t, bks)
        if (mbk != null && bookOut(mbk)) {
            val newBook = Book.setBorrower(null, mbk)
            val fewerBooks = removeBook(mbk, bks)
            return addItem(newBook, fewerBooks)
        } else return bks
    }

    fun libraryToString(bks: List<Book>, brs: List<Borrower>): String {
        return "Test Library: " +
                bks.count() +
                " books; " +
                brs.count() +
                " borrowers."
    }

    fun statusToString(bks: List<Book>, brs: List<Borrower>): String {
        return "\n" +
                "--- Status Report of Test Library ---\n" +
                "\n" +
                libraryToString(bks, brs) + "\n" +
                "\n" +
                bks.map { it -> Book.bookToString(it) }.joinToString("\n") + "\n" +
                "\n" +
                brs.map { it -> Borrower.borrowerToString(it) }.joinToString("\n") + "\n" +
                "\n" +
                "--- End of Status Report ---" +
                "\n"
    }

}
