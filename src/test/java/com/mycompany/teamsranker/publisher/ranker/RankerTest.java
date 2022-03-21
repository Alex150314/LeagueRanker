package com.mycompany.teamsranker.publisher.ranker;

import com.mycompany.teamsranker.publisher.beans.Team;
import com.mycompany.teamsranker.publisher.calculator.ClassicPointCalculator;
import com.mycompany.teamsranker.publisher.calculator.PointCalculator;
import com.mycompany.teamsranker.publisher.gameinput.FileGameDataReader;
import com.mycompany.teamsranker.publisher.gameinput.GameDataReader;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alex
 */
public class RankerTest {

    public static final String TEST_FILE_PATH = "src/test/resources/games.txt";
    private final String MALFORMED_TEST_FILE_PATH = "src/test/resources/games_malformed.txt";
    GameDataReader dataReader = new FileGameDataReader(TEST_FILE_PATH);
    PointCalculator pointCalculator = new ClassicPointCalculator();
    Ranker ranker = new Ranker(dataReader, pointCalculator);

    /**
     * Test rankTeams if has the correct ranking and correct size
     * @throws java.lang.Exception
     */
    @Test
    public void testRankTeams() throws Exception {
        List<Team> teamsResult = ranker.rankTeams();
        int SIZE_EXPECTED = 5;
        assertTrue(teamsResult.size() == SIZE_EXPECTED);
        checkInfoIsCorrect(teamsResult);
        teamsResult.forEach(System.out::println);
    }

    /**
     * Used to verify if information is correct in the teams list.
     *
     * @param teamsResult Teams list resulted from ranker execution.
     */
    private void checkInfoIsCorrect(List<Team> teamsResult) {

        Team firstPlace = teamsResult.get(0);
        Team secondPlace = teamsResult.get(1);
        Team thirdPlace = teamsResult.get(2);
        Team fourthPlace = teamsResult.get(3);
        Team fifthPlace = teamsResult.get(4);

        //Check names
        assertEquals("Tarantulas", firstPlace.getName());
        assertEquals("Lions", secondPlace.getName());
        assertEquals("FC Awesome", thirdPlace.getName());
        assertEquals("Snakes", fourthPlace.getName());
        assertEquals("Grouches", fifthPlace.getName());

        //Check points
        assertEquals(6, firstPlace.getPoints());
        assertEquals(5, secondPlace.getPoints());
        assertEquals(1, thirdPlace.getPoints());
        assertEquals(1, fourthPlace.getPoints());
        assertEquals(0, fifthPlace.getPoints());

        //Check wonGames
        assertEquals(2, firstPlace.getWonGames());
        assertEquals(1, secondPlace.getWonGames());
        assertEquals(0, thirdPlace.getWonGames());
        assertEquals(0, fourthPlace.getWonGames());
        assertEquals(0, fifthPlace.getWonGames());

        //Check tiedGames
        assertEquals(0, firstPlace.getTiedGames());
        assertEquals(2, secondPlace.getTiedGames());
        assertEquals(1, thirdPlace.getTiedGames());
        assertEquals(1, fourthPlace.getTiedGames());
        assertEquals(0, fifthPlace.getTiedGames());

        //Check lostGames
        assertEquals(0, firstPlace.getLostGames());
        assertEquals(0, secondPlace.getLostGames());
        assertEquals(1, thirdPlace.getLostGames());
        assertEquals(1, fourthPlace.getLostGames());
        assertEquals(1, fifthPlace.getLostGames());

    }

    /**
     * Test that expects an ArayIndexOutOBoundsException due the last line in
     * file doest contain a comma separator. thats why doesn't exist the second
     * part that includes the guest team information.
     *
     * @throws Exception
     */
    @Test
    public void testRankerWithMalFormedFile() throws Exception {
        GameDataReader dataReaderMalformedFile = new FileGameDataReader(MALFORMED_TEST_FILE_PATH);
        Ranker ranker = new Ranker(dataReaderMalformedFile, pointCalculator);
        ArrayIndexOutOfBoundsException ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            ranker.rankTeams();
        });
        assertEquals("1", ex.getMessage());
    }

}
