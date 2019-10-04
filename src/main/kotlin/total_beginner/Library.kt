package total_beginner

import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import total_beginner.Book.Companion.bookToString
import total_beginner.Book.Companion.getBorrower
import total_beginner.Book.Companion.getTitle
import total_beginner.Book.Companion.setBorrower
import total_beginner.Borrower.Companion.borrowerToString
import total_beginner.Borrower.Companion.getMaxBooks
import total_beginner.Borrower.Companion.getName
import java.io.StringReader

object Library {

    fun <A> addItem(x: A, xs: List<A>): List<A> {
        return if (xs.contains(x))
            xs
        else
            xs.plusElement(x)
    }

    fun removeBook(bk: Book, bks: Books): Books =
            bks.filter { it != bk }

    fun <A> findItem(tgt: String, coll: List<A>, f: (A) -> String): A? {
        val result: List<A> = coll.filter { f(it) == tgt }
        return result.firstOrNull()
    }

    fun getBooksForBorrower(br: Borrower, bks: Books): Books =
            bks.filter { getBorrower(it) == br }

    private fun numBooksOut(br: Borrower, bks: Books): Int =
            getBooksForBorrower(br, bks).count()

    private fun notMaxedOut(br: Borrower, bks: Books): Boolean =
            numBooksOut(br, bks) < getMaxBooks(br)

    private fun bookNotOut(bk: Book): Boolean =
            getBorrower(bk) == null

    private fun bookOut(bk: Book): Boolean =
            getBorrower(bk) != null

    fun checkOut(n: Name, t: Title, brs: Borrowers, bks: Books): Books {
        val mbk: Book? = findItem(t, bks) { getTitle(it) }
        val mbr: Borrower? = findItem(n, brs) { getName(it) }
        return if (mbk != null && mbr != null && notMaxedOut(mbr, bks) && bookNotOut(mbk)) {
            val newBook = setBorrower(mbr, mbk)
            val fewerBooks = removeBook(mbk, bks)
            addItem(newBook, fewerBooks)
        } else bks
    }

    fun checkIn(t: Title, bks: Books): Books {
        val mbk: Book? = findItem(t, bks) { getTitle(it) }
        return if (mbk != null && bookOut(mbk)) {
            val newBook = setBorrower(null, mbk)
            val fewerBooks = removeBook(mbk, bks)
            addItem(newBook, fewerBooks)
        } else bks
    }

    private fun libraryToString(bks: Books, brs: Borrowers): String {
        return "Test Library: " +
                bks.count() +
                " books; " +
                brs.count() +
                " borrowers."
    }

    fun statusToString(bks: Books, brs: Borrowers): String {
        return "\n" +
                "--- Status Report of Test Library ---\n" +
                "\n" +
                libraryToString(bks, brs) + "\n" +
                "\n" +
                bks.joinToString("\n") { bookToString(it) } + "\n" +
                "\n" +
                brs.joinToString("\n") { borrowerToString(it) } + "\n" +
                "\n" +
                "--- End of Status Report ---" +
                "\n"
    }

    fun jsonStringToBorrowers(jsonString: jsonString): Borrowers {
        val result = Klaxon().parseArray<Borrower>(jsonString)
        return result ?: emptyList()

    }

    fun jsonStringToBooks(jsonString: jsonString): Books {
        val klaxon = Klaxon()
        JsonReader(StringReader(jsonString)).use { reader ->
            val result = arrayListOf<Book>()
            reader.beginArray {
                while (reader.hasNext()) {
                    val book = klaxon.parse<Book>(reader)
                    if (book != null)
                        result.add(book)
                }
            }
            return result
        }
    }

    fun borrowersToJsonString(brs: Borrowers): jsonString {
        return Klaxon().toJsonString(brs)
    }

    fun booksToJsonString(bks: Books): jsonString {
        return Klaxon().toJsonString(bks)
    }

}
