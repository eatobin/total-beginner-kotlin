package totalBeginner

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Library {

    fun <A> addItem(x: A, xs: List<A>): List<A> {
        return if (xs.contains(x))
            xs
        else
            xs.plusElement(x)
    }

    fun removeBook(bk: Book, bks: List<Book>): List<Book> =
            bks.filter { it != bk }

    fun <A> findItem(tgt: String, coll: List<A>, f: (A) -> String): A? {
        val result: List<A> = coll.filter { it -> f(it) == tgt }
        return result.firstOrNull()
    }

    fun getBooksForBorrower(br: Borrower, bks: List<Book>): List<Book> =
            bks.filter { Book.getBorrower(it) == br }

    private fun numBooksOut(br: Borrower, bks: List<Book>): Int =
            getBooksForBorrower(br, bks).count()

    private fun notMaxedOut(br: Borrower, bks: List<Book>): Boolean =
            numBooksOut(br, bks) < Borrower.getMaxBooks(br)

    private fun bookNotOut(bk: Book): Boolean =
            Book.getBorrower(bk) == null

    private fun bookOut(bk: Book): Boolean =
            Book.getBorrower(bk) != null

    fun checkOut(n: String, t: String, brs: List<Borrower>, bks: List<Book>): List<Book> {
        val mbk: Book? = findItem(t, bks) { Book.getTitle(it) }
        val mbr: Borrower? = findItem(n, brs) { Borrower.getName(it) }
        return if (mbk != null && mbr != null && notMaxedOut(mbr, bks) && bookNotOut(mbk)) {
            val newBook = Book.setBorrower(mbr, mbk)
            val fewerBooks = removeBook(mbk, bks)
            addItem(newBook, fewerBooks)
        } else bks
    }

    fun checkIn(t: String, bks: List<Book>): List<Book> {
        val mbk: Book? = findItem(t, bks) { Book.getTitle(it) }
        return if (mbk != null && bookOut(mbk)) {
            val newBook = Book.setBorrower(null, mbk)
            val fewerBooks = removeBook(mbk, bks)
            addItem(newBook, fewerBooks)
        } else bks
    }

    private fun libraryToString(bks: List<Book>, brs: List<Borrower>): String {
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
                bks.joinToString("\n") { it -> Book.bookToString(it) } + "\n" +
                "\n" +
                brs.joinToString("\n") { it -> Borrower.borrowerToString(it) } + "\n" +
                "\n" +
                "--- End of Status Report ---" +
                "\n"
    }

    fun jsonStringToBorrowers(jsonString: String): List<Borrower> {
        val gson = Gson()
        return try {
            gson.fromJson(jsonString, object : TypeToken<List<Borrower>>() {}.type)
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun jsonStringToBooks(jsonString: String): List<Book> {
        val gson = Gson()
        return try {
            gson.fromJson(jsonString, object : TypeToken<List<Book>>() {}.type)
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun borrowersToJsonString(brs: List<Borrower>): String {
        val gson = Gson()
        return gson.toJson(brs)
    }

    fun booksToJsonString(bks: List<Book>): String {
        val gson = Gson()
        return gson.toJson(bks)
    }

}
