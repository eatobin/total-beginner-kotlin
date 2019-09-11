import com.beust.klaxon.Klaxon
import total_beginner.Book
import total_beginner.Borrower

private val br1 = Borrower("Borrower1", 1)

val result = Klaxon().toJsonString(br1)

println(result)

val result2 = Klaxon().parse<Borrower>(result)

println(result2)

private val bk1 = Book("Title1", "Author1")

val result3 = Klaxon().toJsonString(bk1)

println(result3)

val result4 = Klaxon().parse<Book>(result3)

println(result4)

private val br11 = Borrower("Borrower1", 1)
private val br22 = Borrower("Borrower2", 2)
private val br33 = Borrower("Borrower3", 3)

private val brs1 = listOf(br11, br22)
private val brs2 = listOf(br11, br22, br33)

val ls = Klaxon().toJsonString(brs1)
println(ls)
val v = (Klaxon().parseArray<Borrower>(ls))
println(v)
