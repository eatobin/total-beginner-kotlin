import Borrower.Companion.getName

data class Book(val title: Title, val author: Author, val borrower: Borrower? = null) {

    companion object {

        fun getTitle(bk: Book): Title = bk.title

        fun getAuthor(bk: Book): Author = bk.author

        fun setAuthor(a: Author, bk: Book): Book = bk.copy(author = a)

        fun getBorrower(bk: Book): Borrower? = bk.borrower

        fun setBorrower(br: Borrower?, bk: Book): Book = bk.copy(borrower = br)

        private fun availableString(bk: Book): String {
            val br = getBorrower(bk)
            return if (br == null) {
                "Available"
            } else {
                "Checked out to " + getName(br)
            }
        }

        fun bookToString(bk: Book): String {
            return getTitle(bk) +
                    " by " + getAuthor(bk) +
                    "; " + availableString(bk)
        }

    }

}
