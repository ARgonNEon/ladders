all:
	gradle assemble
	java -jar build/libs/ladders-1.0-SNAPSHOT.jar croissant baritone
