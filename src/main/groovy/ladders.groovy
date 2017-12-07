def start = args[0]
def goal = args[1]
println "start word: $start"
println "goal word: $goal"

def ladders = new Ladders()
println "Seach tree for word lookup created. Starting search..."
println() 

new File("output.txt").withWriter {w ->
    ladders.ladders(start, goal).each {
    println it
    w << "$it\n"
}}

println()
println "Solution written to output.txt"
