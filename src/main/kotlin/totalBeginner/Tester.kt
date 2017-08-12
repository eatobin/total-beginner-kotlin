//package totalBeginner
//
//import junit.framework.Assert
//import junit.framework.TestCase
//
//fun getName2(br: Borrower, c: Int): String {
//    if (c == 0) {
//        return br.name.toLowerCase()
//    } else {
//        return br.name.toUpperCase()
//    }
//}
//
//fun testFindBorrower2() {
//    Assert.assertEquals(br5, Library.findBorrower2("BORROWER5", brs3, { Borrower.getName2(it, 1) }))
//    Assert.assertEquals(br4, Library.findBorrower2("borrower4", brs3, { Borrower.getName2(it, 0) }))
//    Assert.assertNull(Library.findBorrower2("BORROWER5", brs3, { Borrower.getName2(it, 0) }))
//    Assert.assertNull(Library.findBorrower2("borrower4", brs3, { Borrower.getName2(it, 1) }))
//    Assert.assertEquals(br1, Library.findBorrower2("Borrower1", brs3, { Borrower.getName(it) }))
//}
