package totalBeginner

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Library {

    fun <A> addItem(x: A, xs: List<A>): List<A> {
        if (xs.contains(x))
            return xs
        else
            return xs.plusElement(x)
    }

    fun removeBook(bk: Book, bks: List<Book>): List<Book> =
            bks.filter { it != bk }

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
        val mbk: Book? = findItem(t, bks, { Book.getTitle(it) })
        val mbr: Borrower? = findItem(n, brs, { Borrower.getName(it) })
        if (mbk != null && mbr != null && notMaxedOut(mbr, bks) && bookNotOut(mbk)) {
            val newBook = Book.setBorrower(mbr, mbk)
            val fewerBooks = removeBook(mbk, bks)
            return addItem(newBook, fewerBooks)
        } else return bks
    }

    fun checkIn(t: String, bks: List<Book>): List<Book> {
        val mbk: Book? = findItem(t, bks, { Book.getTitle(it) })
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

    fun jsonStringToBorrowers(jsonString: String): List<Borrower> {
        val gson = Gson()
        val borrowerList: List<Borrower> = gson.fromJson(jsonString, object : TypeToken<List<Borrower>>() {}.type)
        return borrowerList
    }

    fun jsonStringToBooks(jsonString: String): List<Book> {
        val gson = Gson()
        val bookList: List<Book> = gson.fromJson(jsonString, object : TypeToken<List<Book>>() {}.type)
        return bookList
    }

}
