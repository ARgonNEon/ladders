db = new WordDB()

println db.countWordsForLength()

println new Anagram(db).find('mglauaeco')

println db.isCharListValid(Utils.countChars('guacamole'))