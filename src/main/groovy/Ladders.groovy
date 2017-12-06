import static Utils.*

class Ladders {

    WordDB db = new WordDB()
    Anagram anagram = new Anagram(db)

    def ladders(String start, String end) {
        def startList = countChars(start)
        def goalList = countChars(end)
        breadthFirstSearch(startList, goalList, {
            def actions = addEachLetter(it)
            actions.addAll(removeOneLetter(it))
            actions
        },
                {
                    db.isCharListValid(it)
                }).reverse().collect {
            anagram.find(it)[0]
        }
    }

    def breadthFirstSearch(start, goal, actions, validityCheck) {
        def frontier = [start]
        def explored = []
        def meta = [:]

        while (!frontier.empty) {
            def node = frontier.remove(0)
            explored.add(node)

            if (node == goal) {
                def path = []
                def s = node
                while (s != start) {
                    path.add(s)
                    s = meta[s]
                }
                return path
            }

            actions(node).findAll {
                validityCheck(it) && !explored.contains(it)
            }.each { child ->
                meta[child] = node
                frontier.add(child)
            }
        }
        return []
    }
}
