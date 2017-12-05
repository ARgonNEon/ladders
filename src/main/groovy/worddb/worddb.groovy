package worddb


class WordDB {

    static def db = createWordDB()

    static def createWordDB() {
        def db = [:]
        new File("src/main/resources/wordList.txt").eachLine {
            db.putIfAbsent(it.length(), [])
            db[it.length()].add(it)
        }
        db
    }

    def countWordsWithLength() {
        map.collectEntries { key, value ->
            [(key): value.size()]
        }
    }

}