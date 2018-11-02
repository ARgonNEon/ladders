import static Utils.*
import static searchalgorithms.BreadthFirstSearch.breadthFirstSearch;

class Ladders {

    WordDB db = new WordDB()

    def ladders(String start, String end) {
        [start, end].each {
            if (!db.isCharListValid(countChars(it))) {
                println "$it is no valid word."
                System.exit(1)} 
            }
        def l = breadthFirstSearch(countChars(start), countChars(end), {
            def actions = addEachLetter(it)
            actions.addAll(removeOneLetter(it))
            actions
        },
                {
                    db.isCharListValid(it)
                }).drop(1).reverse().drop(1).collect {
            db.find(it)[0]
        }
        if (l.empty) {
            if (start == end) {
                return [start]
            } else {
                println "No Solution!"
                return []
            }
        }
        l.add(0, start)
        l.add(end)
        l
    }

}
