import static Utils.*

class WordDB {

    def db = []
    def charcount = [:]
    def tree = [:]

    WordDB() {
        getClass().getResource("/wordList.txt").eachLine {db << it}
        charcount = db.collectEntries {
            [(it): countChars(it)]
        }

        charcount.each {word, cc ->
            def subtree = tree
            ('a'..'z').each {
                subtree.putIfAbsent(cc.getOrDefault(it, 0), it=='z'?[]:[:])
                subtree = subtree.get(cc.getOrDefault(it, 0))
            }
            subtree.add(word)
        }
    }

    def isWordValid(String word) {
        db.any {
            it == word
        }
    }

    def isCharListValid(Map m) {
        def st = tree
        ('a'..'z').every {
            if (!st.containsKey(m.getOrDefault(it, 0))) return false
            st = st[m.getOrDefault(it, 0)]
        }
    }

    def find(Map m) {
        def st = tree
        if (('a'..'z').every {
            if (!st.containsKey(m.getOrDefault(it, 0))) return false
            st = st[m.getOrDefault(it, 0)]
        })
        st else []
    }

    def getWordListForLength(int len) {
        db[len]
    }

    def getCharcountDB() {
        charcount
    }

}