//package totalBeginner
//
//import junit.framework.TestCase
//import totalBeginner.Library.addItem
//import totalBeginner.Library.booksToJsonString
//import totalBeginner.Library.borrowersToJsonString
//import totalBeginner.Library.checkIn
//import totalBeginner.Library.checkOut
//import totalBeginner.Library.findItem
//import totalBeginner.Library.getBooksForBorrower
//import totalBeginner.Library.jsonStringToBooks
//import totalBeginner.Library.jsonStringToBorrowers
//import totalBeginner.Library.removeBook
//import totalBeginner.Library.statusToString
//
//class LibraryTest : TestCase() {
//
//    private val br1 = Borrower("Borrower1", 1)
//    private val br2 = Borrower("Borrower2", 2)
//    private val br3 = Borrower("Borrower3", 3)
//
//    private val brs1 = listOf(br1, br2)
//    private val brs2 = listOf(br1, br2, br3)
//
//    private val bk1 = Book("Title1", "Author1", br1)
//    private val bk2 = Book("Title2", "Author2", null)
//    private val bk3 = Book("Title3", "Author3", br3)
//    private val bk4 = Book("Title4", "Author4", br3)
//
//    private val bks1 = listOf(bk1, bk2)
//    private val bks2 = listOf(bk1, bk2, bk3)
//    private val bks3 = listOf(bk1, bk2, bk3, bk4)
//    private val bks4 = listOf(bk1, bk3, bk4, (Book(title = "Title2", author = "Author2", borrower = br2)))
//    private val bks5 = listOf(bk2, Book(title = "Title1", author = "Author1", borrower = null))
//
//
//    private val jsonStringBorrowers = "[{\"name\":\"Borrower1\",\"maxBooks\":1},{\"name\":\"Borrower2\",\"maxBooks\":2}]"
//    private val jsonStringBooks = "[{\"title\":\"Title1\",\"author\":\"Author1\",\"borrower\":{\"name\":\"Borrower1\",\"maxBooks\":1}},{\"title\":\"Title2\",\"author\":\"Author2\",\"borrower\":null}]"
//    private val jsonStringBooksShort = "[{\"title\":\"Title1\",\"author\":\"Author1\",\"borrower\":{\"name\":\"Borrower1\",\"maxBooks\":1}},{\"title\":\"Title2\",\"author\":\"Author2\"}]"
//
//    private val ss = "\n--- Status Report of Test Library ---\n\nTest Library: 3 books; 3 borrowers.\n\nTitle1 by Author1; Checked out to Borrower1\nTitle2 by Author2; Available\nTitle3 by Author3; Checked out to Borrower3\n\nBorrower1 (1 books)\nBorrower2 (2 books)\nBorrower3 (3 books)\n\n--- End of Status Report ---\n"
//
//    fun testAddBorrower() {
//        assertEquals(brs2, addItem(br3, brs1))
//        assertEquals(brs1, addItem(br2, brs1))
//    }
//
//    fun testAddBook() {
//        assertEquals(bks2, addItem(bk3, bks1))
//        assertEquals(bks1, addItem(bk2, bks1))
//    }
//
//    fun testRemoveBook() {
//        assertEquals(bks1, removeBook(bk3, bks2))
//        assertEquals(bks1, removeBook(bk3, bks1))
//    }
//
//    fun testFindBook() {
//        assertEquals(bk1, findItem("Title1", bks2) { Book.getTitle(it) })
//        assertNull(findItem("Title11", bks2) { Book.getTitle(it) })
//    }
//
//    fun testFindBorrower() {
//        assertEquals(br1, findItem("Borrower1", brs2) { Borrower.getName(it) })
//        assertNull(findItem("Borrower11", brs2) { Borrower.getName(it) })
//    }
//
//    fun testGetBooksForBorrower() {
//        assertEquals(listOf<Book>(), getBooksForBorrower(br2, bks1))
//        assertEquals(listOf(bk1), getBooksForBorrower(br1, bks1))
//        assertEquals(listOf(bk3, bk4), getBooksForBorrower(br3, bks3))
//    }
//
//    fun testCheckOut() {
//        assertEquals(bks1, checkOut("Borrower2", "Title1", brs1, bks1))
//        assertEquals(bks1, checkOut("Borrower2", "NoTitle", brs1, bks1))
//        assertEquals(bks1, checkOut("NoName", "Title1", brs1, bks1))
//        assertEquals(bks1, checkOut("Borrower1", "Title2", brs1, bks1))
//        assertEquals(bks4, checkOut("Borrower2", "Title2", brs2, bks3))
//    }
//
//    fun testCheckIn() {
//        assertEquals(bks5, checkIn("Title1", bks1))
//        assertEquals(bks1, checkIn("Title2", bks1))
//        assertEquals(bks1, checkIn("NoTitle", bks1))
//    }
//
//    fun testStatusToString() {
//        assertEquals(ss, statusToString(bks2, brs2))
//    }
//
//    fun testJsonStringToObjects() {
//        assertEquals(brs1, jsonStringToBorrowers(jsonStringBorrowers))
//        assertEquals(bks1, jsonStringToBooks(jsonStringBooks))
//        assertEquals(bks1, jsonStringToBooks(jsonStringBooksShort))
//    }
//
//    fun testBorrowersToJsonString() {
//        assertEquals("[{\"name\":\"Borrower1\",\"maxBooks\":1},{\"name\":\"Borrower2\",\"maxBooks\":2}]", borrowersToJsonString(brs1))
//    }
//
//    fun testBooksToJsonString() {
//        assertEquals("[{\"title\":\"Title1\",\"author\":\"Author1\",\"borrower\":{\"name\":\"Borrower1\",\"maxBooks\":1}},{\"title\":\"Title2\",\"author\":\"Author2\",\"borrower\":null}]", booksToJsonString(bks1))
//    }
//
//}
