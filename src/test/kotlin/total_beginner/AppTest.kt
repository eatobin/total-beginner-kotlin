package total_beginner

import io.kotlintest.matchers.types.shouldBeNull
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import total_beginner.App.newBooksFromJsonString
import total_beginner.App.readFileIntoJsonString

private const val jsonStringBorrowers = """[
  {
    "name": "Borrower100",
    "maxBooks": 100
  },
  {
    "name": "Borrower200",
    "maxBooks": 200
  }
]
"""
private val br1 = Borrower("Borrower100", 100)
private val br2 = Borrower("Borrower200", 200)
private val bk1 = Book("Title100", "Author100", br1)
private val bk2 = Book("Title200", "Author200", null)
private val bks = listOf(bk1, bk2)

class AppTest : StringSpec({

    "readFileIntoJsonString should read a file into a string" {
        readFileIntoJsonString("borrowers-before.json").shouldBe(jsonStringBorrowers)
        readFileIntoJsonString("not-a-file.json").shouldBeNull()

    }

    "newBooksFromJsonString should make List<Book> from a file" {
        newBooksFromJsonString("books-before.json").shouldBe(bks)
//        readFileIntoJsonString("not-a-file.json").shouldBeNull()

    }
})
