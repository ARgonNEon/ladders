package worddb

class WordDB {

    def db = createWordDB()

    static def createWordDB() {

        def db = [:]
        getClass().getResource("/wordList.txt").eachLine {
            db.putIfAbsent(it.length(), [])
            db[it.length()].add(it)
        }
        db
    }

    def countWordsWithLength() {
        db.collectEntries { key, value ->
            [(key): value.size()]
        }
    }

}