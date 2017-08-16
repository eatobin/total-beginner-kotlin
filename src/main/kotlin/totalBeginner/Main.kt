package totalBeginner

object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        var tvBorrowers: List<Borrower> = emptyList()
        var tvBooks: List<Book> = emptyList()

        tvBorrowers = Library.addItem(Borrower.makeBorrower("Jim", 3), tvBorrowers)
        tvBorrowers = Library.addItem(Borrower.makeBorrower("Sue", 3), tvBorrowers)
        tvBooks = Library.addItem(Book.makeBook("War And Peace", "Tolstoy", null), tvBooks)
        tvBooks = Library.addItem(Book.makeBook("Great Expectations", "Dickens", null), tvBooks)
        println("\nJust created new library")
        println(Library.statusToString(tvBooks, tvBorrowers))
//
//        println("Check out War And Peace to Sue")
//        tvBooks = Library.checkOut("Sue", "War And Peace", tvBorrowers, tvBooks)
//        println(Library.statusToString(tvBooks, tvBorrowers))
//
//        println("Now check in War And Peace from Sue...")
//        tvBooks = Library.checkIn("War And Peace", tvBooks)
//        println("...and check out Great Expectations to Jim")
//        tvBooks = Library.checkOut("Jim", "Great Expectations", tvBorrowers, tvBooks)
//        println(Library.statusToString(tvBooks, tvBorrowers))
//
//        println("Add Eric and The Cat In The Hat")
//        tvBorrowers = Library.addBorrower(Borrower("Eric", 1), tvBorrowers)
//        tvBooks = Library.addBook(Book("The Cat In The Hat", "Dr. Seuss"), tvBooks)
//        println("Check Out Dr. Seuss to Eric")
//        tvBooks = Library.checkOut("Eric", "The Cat In The Hat", tvBorrowers, tvBooks)
//        println(Library.statusToString(tvBooks, tvBorrowers))
//
//        println("Now let's do some BAD stuff...\n")
//
//        println("Add a borrower that already exists (Borrower('Jim', 3))")
//        tvBorrowers = Library.addBorrower(Borrower("Jim", 3), tvBorrowers)
//        println("No change to Test Library:")
//        println(Library.statusToString(tvBooks, tvBorrowers))
//
//        println("Add a book that already exists (Book('War And Peace', 'Tolstoy'))")
//        tvBooks = Library.addBook(Book("War And Peace", "Tolstoy"), tvBooks)
//        println("No change to Test Library:")
//        println(Library.statusToString(tvBooks, tvBorrowers))
//
//        println("Check out a valid book to an invalid person (checkOut('JoJo', 'War And Peace', borrowers))")
//        tvBooks = Library.checkOut("JoJo", "War And Peace", tvBorrowers, tvBooks)
//        println("No change to Test Library:")
//        println(Library.statusToString(tvBooks, tvBorrowers))
//
//        println("Check out an invalid book to an valid person (checkOut('Sue', 'Not A Book', borrowers))")
//        tvBooks = Library.checkOut("Sue", "Not A Book", tvBorrowers, tvBooks)
//        println("No change to Test Library:")
//        println(Library.statusToString(tvBooks, tvBorrowers))
//
//        println("Last - check in a book not checked out (checkIn('War And Peace'))")
//        tvBooks = Library.checkIn("War And Peace", tvBooks)
//        println("No change to Test Library:")
//        println(Library.statusToString(tvBooks, tvBorrowers))
//
//        println("And... that's all...")
//        println("Thanks - bye!\n")
//
    }
}
