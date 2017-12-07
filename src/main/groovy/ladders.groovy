def ladders = new Ladders()
println "Seach tree for word lookup created. Starting search..."
println ""
println "Found solution:"

def outfile = new File("output.txt")

new File("output.txt").withWriter {w ->
    ladders.ladders(args[0], args[1]).each {
    println it
    w << "$it\n"
}}

println ""
println "Solution written to output.txt"
