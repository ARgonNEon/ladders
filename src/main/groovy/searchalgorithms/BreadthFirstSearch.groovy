package searchalgorithms

def static breadthFirstSearch(start, goal, actions, validityCheck) {
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
            path.add(start)
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
