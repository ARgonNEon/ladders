import static Utils.*

class Anagram {

    WordDB db;

    Anagram(WordDB db) {
        this.db = db
    }

    def findString(String word) {
        return find(countChars(word))
    }

    def find(word) {
        def charcount = word
        def e1 = charcount.entrySet().first()
        def len = word.inject(0) {val, it -> val + it.value}
        def m = db.getCharcountDBForLength(len).findAll {
            it.value.equals(charcount)
        }
        m.collect{it.key}
    }
}