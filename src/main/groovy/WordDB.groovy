import static Utils.*

class WordDB {

    def db = []
    def tree = [:]

    WordDB() {
        getClass().getResource("/wordList.txt").eachLine {db << it}
        def charcount = db.collectEntries {
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

    def isCharListValid(Map m) {
        def subtree = tree
        ('a'..'z').every {
            if (!subtree.containsKey(m.getOrDefault(it, 0))) return false
            subtree = subtree[m.getOrDefault(it, 0)]
        }
    }

    def find(Map m) {
        def subtree = tree
        ('a'..'z').every {
            if (!subtree.containsKey(m.getOrDefault(it, 0))) return false
            subtree = subtree[m.getOrDefault(it, 0)]
        } ? subtree : []
    }
}