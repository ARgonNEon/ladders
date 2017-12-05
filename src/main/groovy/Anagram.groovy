import static Utils.*

class Anagram {

    WordDB db;

    Anagram(WordDB db) {
        this.db = db
    }

    def find(String word) {
        word = word.toLowerCase()
        def charcount = countChars(word)
        def e1 = charcount.entrySet().first()
        def m = db.getCharcountDBForLength(word.size()).findAll {
            it.value.equals(charcount)
        }
        m.collect{it.key}
    }
}