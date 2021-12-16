//package total_beginner
//
//import io.kotlintest.shouldBe
//import io.kotlintest.specs.StringSpec
//import total_beginner.Book.Companion.getAuthor
//import total_beginner.Book.Companion.getBorrower
//import total_beginner.Book.Companion.getTitle
//import total_beginner.Book.Companion.setAuthor
//import total_beginner.Book.Companion.setBorrower
//
//private val br1 = Borrower("Borrower1", 1)
//private val bk1 = Book("Title1", "Author1", br1)
//private val bk2 = Book("Title2", "Author2")
//
//class BookTest : StringSpec({
//
//    "getTitle should return the Book title" {
//        getTitle(bk1).shouldBe("Title1")
//    }
//
//    "getAuthor should return the Book author" {
//        getAuthor(bk2).shouldBe("Author2")
//    }
//
//    "setAuthor should set the Book author" {
//        setAuthor("Author11", bk1).shouldBe(Book(title = "Title1", author = "Author11", borrower = br1))
//    }
//
//    "getBorrower-someone should get the Book borrower" {
//        getBorrower(bk1).shouldBe(br1)
//    }
//
//    "getBorrower-null should get the Book borrower - null" {
//        getBorrower(bk2).shouldBe(null)
//    }
//
//    "setBorrower-someone should set the Book borrower" {
//        val nbr = Book(title = "Title2", author = "Author2",
//                borrower = Borrower(name = "BorrowerNew", maxBooks = 111))
//        setBorrower(Borrower(name = "BorrowerNew", maxBooks = 111), bk2).shouldBe(nbr)
//    }
//
//})
