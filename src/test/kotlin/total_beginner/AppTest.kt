package total_beginner

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

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

class AppTest : StringSpec({

    "readFileIntoJsonString should read a file into a string" {
        total_beginner.App.readFileIntoJsonString("borrowers-before.json").shouldBe(jsonStringBorrowers)

    }
})
