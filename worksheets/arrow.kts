import arrow.core.Either
import arrow.core.None
import arrow.core.Option
import arrow.core.Some

val someValue: Option<String> = Some("I am wrapped in something")
someValue
val value = when (someValue) {
    is Some -> someValue.t
    is None -> "Nope"
}
value

val right: Either<String, Int> = Either.Right(5)
right
val left: Either<String, Int> = Either.Left("Something went wrong")
left
val value2 = when (right) {
    is Either.Right -> right.b
    is Either.Left -> "Nope again"
}
value2
val value3 = when (left) {
    is Either.Right -> 66
    is Either.Left -> left.a
}
value3
