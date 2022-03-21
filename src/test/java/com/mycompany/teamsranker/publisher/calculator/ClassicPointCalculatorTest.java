package com.mycompany.teamsranker.publisher.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alex
 */
public class ClassicPointCalculatorTest {

    /**
     * Test of getPoints method, of class ClassicPointCalculator. verify
     * calculation of points works well 3 for wins, 1 for tie and 0 for lose.
     */
    @Test
    public void testGetPoints() {
        int wonGames = 10;
        int tiedGames = 10;
        int lostGames = 5;
        PointCalculator instance = new ClassicPointCalculator();
        int expResult = 40;
        int result = instance.getPoints(wonGames, tiedGames, lostGames);
        assertEquals(expResult, result);
    }

}
