def ladders = new Ladders()
println "Seach tree for word lookup created. Starting search..."
println() 

new File("output.txt").withWriter {w ->
    ladders.ladders(args[0], args[1]).each {
    println it
    w << "$it\n"
}}

println()
println "Solution written to output.txt"
