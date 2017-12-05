class Utils {

    static def countChars(String word) {
        def charcount = [:]
        word.toList().each {
            charcount.putIfAbsent(it, 0)
            charcount[it]++
        }
        charcount
    }
}
