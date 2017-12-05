import static Utils.*

class WordDB {

    def db = createWordDB()
    def charcount = createCharCountDB(db)

    static def createWordDB() {
        def db = [:]
        getClass().getResource("/wordList.txt").eachLine {
            db.putIfAbsent(it.length(), [])
            db[it.length()].add(it)
        }
        db
    }

    static def createCharCountDB(worddb) {
        worddb.collectEntries {key, value ->
            [(key): value.collectEntries {
                [(it): countChars(it)]
            }]
        }
    }

    def countWordsForLength() {
        db.collectEntries { key, value ->
            [(key): value.size()]
        }
    }

    def isWordValid(String word) {
        db[word.length()].any {
            it == word
        }
    }

    def isCharListValid(l) {
        def len = l.inject(0) {val, it -> val + it.value}
        charcount[len].any {key, value ->
            value.equals(l)
        }
    }

    def getWordListForLength(int len) {
        db[len]
    }

    def getCharcountDBForLength(int len) {
        charcount[len]
    }

}