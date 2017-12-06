class Utils {

    static def countChars(String word) {
        def charcount = [:]
        word.toList().each {
            charcount.putIfAbsent(it, 0)
            charcount[it]++
        }
        charcount
    }

    static def removeOneLetter(Map m) {
        m.collect {key, value ->
            def word = m.findAll {it.key != key}.collectEntries {it}
            if (value >= 2) {
                word[key] = value -1
            }
            word
        }
    }

    static def addEachLetter(Map m) {
        ('a'..'z').collect {
            def word = m.findAll {it.key != it}.collectEntries {it}
            word.putIfAbsent(it, 0)
            word[it]+=1
            word
        }
    }
}
