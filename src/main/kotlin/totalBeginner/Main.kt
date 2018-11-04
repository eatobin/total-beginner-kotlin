package totalBeginner

import arrow.core.Either
import java.io.BufferedReader
import java.io.File

object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        var tvBorrowers: List<Borrower> = emptyList()
        var tvBooks: List<Book> = emptyList()

        val jsonBorrowersFileBefore = "borrowers-before.json"
        val jsonBooksFile = "books-before.json"
        val jsonBorrowersFileAfter = "borrowers-after.json"
        val jsonBorrowersFileBad = "bad-borrowers.json"
        val emptyFile = "empty.json"

        tvBorrowers = Library.addItem(Borrower("Jim", 3), tvBorrowers)
        tvBorrowers = Library.addItem(Borrower("Sue", 3), tvBorrowers)
        tvBooks = Library.addItem(Book("War And Peace", "Tolstoy", null), tvBooks)
        tvBooks = Library.addItem(Book("Great Expectations", "Dickens", null), tvBooks)
        println("\nJust created new library")
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Check out War And Peace to Sue")
        tvBooks = Library.checkOut("Sue", "War And Peace", tvBorrowers, tvBooks)
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Now check in War And Peace from Sue...")
        tvBooks = Library.checkIn("War And Peace", tvBooks)
        println("...and check out Great Expectations to Jim")
        tvBooks = Library.checkOut("Jim", "Great Expectations", tvBorrowers, tvBooks)
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Add Eric and The Cat In The Hat")
        tvBorrowers = Library.addItem(Borrower("Eric", 1), tvBorrowers)
        tvBooks = Library.addItem(Book("The Cat In The Hat", "Dr. Seuss", null), tvBooks)
        println("Check Out Dr. Seuss to Eric")
        tvBooks = Library.checkOut("Eric", "The Cat In The Hat", tvBorrowers, tvBooks)
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Now let's do some BAD stuff...\n")

        println("Add a borrower that already exists (Borrower('Jim', 3))")
        tvBorrowers = Library.addItem(Borrower("Jim", 3), tvBorrowers)
        println("No change to Test Library:")
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Add a book that already exists (Book('War And Peace', 'Tolstoy'))")
        tvBooks = Library.addItem(Book("War And Peace", "Tolstoy", null), tvBooks)
        println("No change to Test Library:")
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Check out a valid book to an invalid person (checkOut('JoJo', 'War And Peace', borrowers))")
        tvBooks = Library.checkOut("JoJo", "War And Peace", tvBorrowers, tvBooks)
        println("No change to Test Library:")
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Check out an invalid book to an valid person (checkOut('Sue', 'Not A Book', borrowers))")
        tvBooks = Library.checkOut("Sue", "Not A Book", tvBorrowers, tvBooks)
        println("No change to Test Library:")
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Last - check in a book not checked out (checkIn('War And Peace'))")
        tvBooks = Library.checkIn("War And Peace", tvBooks)
        println("No change to Test Library:")
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Okay... let's finish with some persistence. First clear the whole library:")
        tvBorrowers = emptyList()
        tvBooks = emptyList()
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Lets read in a new library from \"borrowers-before.json\" and \"books-before.json\":")
        tvBorrowers = newBorrowersFromJsonString(jsonBorrowersFileBefore)
        tvBooks = newBooksFromJsonString(jsonBooksFile)
        println(Library.statusToString(tvBooks, tvBorrowers))
        println("Add... a new borrower:")
        tvBorrowers = Library.addItem(Borrower("BorrowerNew", 300), tvBorrowers)
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Save the revised borrowers to \"borrowers-after.json\"")
        val jsonBrsStr = Library.borrowersToJsonString(tvBorrowers)
        writeJsonStringToFile(jsonBrsStr, "borrowers-after.json")

        println("Clear the whole library again:")
        tvBorrowers = emptyList()
        tvBooks = emptyList()
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Then read in the revised library from \"borrowers-after.json\" and \"books-before.json\":")
        tvBorrowers = newBorrowersFromJsonString(jsonBorrowersFileAfter)
        tvBooks = newBooksFromJsonString(jsonBooksFile)
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Last... delete the file \"borrowers-after.json\"")
        File(jsonBorrowersFileAfter).delete()

        println("Then try to make a library using the deleted \"borrowers-after.json\" and \"borrowers-after.json\":")
        tvBorrowers = newBorrowersFromJsonString(jsonBorrowersFileAfter)
        tvBooks = newBooksFromJsonString(jsonBorrowersFileAfter)
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("And if we read in a file with mal-formed json content... like \"bad-borrowers.json\" and \"borrowers-after.json\":")
        tvBorrowers = newBorrowersFromJsonString(jsonBorrowersFileBad)
        tvBooks = newBooksFromJsonString(jsonBorrowersFileAfter)
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("Or how about reading in an empty file... \"empty.json\" (for borrowers and books):")
        tvBorrowers = newBorrowersFromJsonString(emptyFile)
        tvBooks = newBooksFromJsonString(emptyFile)
        println(Library.statusToString(tvBooks, tvBorrowers))

        println("And... that's all...")
        println("Thanks - bye!\n")

    }

    private fun readFileIntoJsonString(fp: String): String? {
        return try {
            val bufferedReader: BufferedReader = File(fp).bufferedReader()
            bufferedReader.use { it.readText() }
        } catch (e: Exception) {
            null
        }
    }

    fun readFileIntoJsonString2(fp: String): Either<String, String> {
        return try {
            val bufferedReader: BufferedReader = File(fp).bufferedReader()
            Either.right(bufferedReader.use { it.readText() })
        } catch (e: Exception) {
            Either.left("File read error.")
        }
    }

    private fun newBooksFromJsonString(bksfp: String): List<Book> {
        val mJsonBksStr: String? = Main.readFileIntoJsonString(bksfp)
        return if (mJsonBksStr != null) {
            Library.jsonStringToBooks(mJsonBksStr)
        } else emptyList()
    }

    private fun newBorrowersFromJsonString(brsfp: String): List<Borrower> {
        val mJsonBrsStr: String? = Main.readFileIntoJsonString(brsfp)
        return if (mJsonBrsStr != null) {
            Library.jsonStringToBorrowers(mJsonBrsStr)
        } else emptyList()
    }

    private fun writeJsonStringToFile(js: String, fp: String) {
        File(fp).bufferedWriter().use { out -> out.write(js) }
    }

}
