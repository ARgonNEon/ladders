def ladders = new Ladders()
println "Seach tree for word lookup created. Starting search..."
ladders.ladders(args[0], args[1]).each {println it}