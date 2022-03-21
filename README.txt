Application solution has been created using a maven java project.
Run: mvn install or mvn clean install

To run main class you can run next command to consume the games information from a file passing the filepath into the first argument:
Using this approach, output will be printed through console output.

$:	mvn exec:java -Dexec.mainClass="com.mycompany.teamsranker.publisher.GameRankerMain" -Dexec.args="c/path/to/file/games.txt"

Also you can run with two command arguments first argument as said before is to read the games information from file, 
the second argument is to set a new output file where application will write the rank table results.
	
$:	mvn exec:java -Dexec.mainClass="com.mycompany.teamsranker.publisher.GameRankerMain" -Dexec.args="/path/to/file/games.txt /path/to/create/file/rankTable.txt"


