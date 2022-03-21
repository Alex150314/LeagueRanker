package com.mycompany.teamsranker.publisher.gameinput;

import com.mycompany.teamsranker.publisher.beans.Game;
import com.mycompany.teamsranker.publisher.exceptions.RankerException;
import com.mycompany.teamsranker.publisher.exceptions.UnableToAccessDataException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.mycompany.teamsranker.publisher.ranker.RankerTest.*;

/**
 *
 * @author Alex
 */
public class FileGameDataReaderTest {

    /**
     * Test of getGamesResults method, check games are created as expected.
     */
    @Test
    public void testGetGamesResults() throws Exception {
        GameDataReader fileGameDataReader = new FileGameDataReader(TEST_FILE_PATH);
        List<Game> gamesResults = fileGameDataReader.getGamesResults();
        assertEquals(5, gamesResults.size());
        assertEquals(new Game("Lions", 3, "Snakes", 3), gamesResults.get(0));
        assertEquals(new Game("Tarantulas", 1, "FC Awesome", 0), gamesResults.get(1));
        assertEquals(new Game("Lions", 1, "FC Awesome", 1), gamesResults.get(2));
        assertEquals(new Game("Tarantulas", 3, "Snakes", 1), gamesResults.get(3));
        assertEquals(new Game("Lions", 4, "Grouches", 0), gamesResults.get(4));
    }

    /**
     * Check when filepath is wrong and it must to throws a RankerException
     *
     * @throws com.mycompany.teamsranker.publisher.exceptions.RankerException
     */
    @Test
    public void testGetGamesResultsWrongPath() throws RankerException {
        String badFilePath = "src/test/resources/badpath.txt";
        GameDataReader fileGameDataReader = new FileGameDataReader(badFilePath);
        RankerException ex = assertThrows(UnableToAccessDataException.class, () -> {
            fileGameDataReader.getGamesResults();
        });
        assertEquals("Error trying to read file from path: " + badFilePath, ex.getMessage());
    }

}
