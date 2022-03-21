/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teamsranker.publisher.formatter;

import com.mycompany.teamsranker.publisher.beans.Team;
import com.mycompany.teamsranker.publisher.calculator.ClassicPointCalculator;
import com.mycompany.teamsranker.publisher.calculator.PointCalculator;
import com.mycompany.teamsranker.publisher.gameinput.FileGameDataReader;
import com.mycompany.teamsranker.publisher.gameinput.GameDataReader;
import com.mycompany.teamsranker.publisher.ranker.Ranker;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.mycompany.teamsranker.publisher.ranker.RankerTest.*;

/**
 *
 * @author Alex
 */
public class ClassicRankOutputTest {

    
    private GameDataReader dataReader = new FileGameDataReader(TEST_FILE_PATH);
    private PointCalculator pointCalculator = new ClassicPointCalculator();
    private Ranker ranker = new Ranker(dataReader, pointCalculator);
    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private ClassicRankOutput rankOutput = new ClassicRankOutput(outputContent);

    private StringBuilder expectedRankTable = new StringBuilder()
            .append("1. Tarantulas, 6 pts")
            .append("\n2. Lions, 5 pts")
            .append("\n3. FC Awesome, 1 pt")
            .append("\n3. Snakes, 1 pt")
            .append("\n5. Grouches, 0 pts\n");

    /**
     * Test of printRank method checks if the stream contains the expected table.
     */
    @Test
    public void testPrintRank() throws Exception {
        List<Team> teamsList = ranker.rankTeams();
        rankOutput.printRank(teamsList);
        assertEquals(expectedRankTable.toString(), outputContent.toString());
        assertTrue(outputContent.toString().contains("1. Tarantulas"));
    }

    /**
     * Test of buildOutput method, of class ClassicRankOutput.
     * verify if string returned contains the expected formatted rank table.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuildOutput() throws Exception {
        List<Team> teamsList = ranker.rankTeams();
        String formattedOutputResult = rankOutput.buildOutput(teamsList);
        assertTrue(formattedOutputResult.contains("1. Tarantulas"));
        assertTrue(formattedOutputResult.contains("2. Lions"));
        assertTrue(formattedOutputResult.contains("3. FC Awesome"));
        assertTrue(formattedOutputResult.contains("3. Snakes"));
        assertTrue(formattedOutputResult.contains("5. Grouches"));

        assertEquals(expectedRankTable.toString(), formattedOutputResult);
    }

}
