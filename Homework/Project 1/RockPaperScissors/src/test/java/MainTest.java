package test.java;


import org.junit.Before;
import org.junit.Test;
import play.Game;
import static org.junit.Assert.*;

public class MainTest {

    @Before
    public void setUp(){

    }


    @Test
    public void testEvaluateHands(){

        Game game1 = new Game();
        game1.playerOne.name = "one";
        game1.playerTwo.name = "two";

        game1.hands.put(-1, game1.playerOne);
        game1.hands.put(-1, game1.playerTwo);

        String expectedValue = "Tie Game!";
        String actualValue = game1.evaluateHands();
        assertEquals(expectedValue, actualValue);

        Game game2 = new Game();
        game2.playerOne.name = "one";
        game2.playerTwo.name = "two";
        game2.hands.put(-1, game2.playerOne);
        game2.hands.put(1, game2.playerTwo);

        expectedValue = game2.playerOne.name + " Wins!";
        actualValue = game2.evaluateHands();
        assertEquals(expectedValue, actualValue);

        Game game3 = new Game();
        game3.playerOne.name = "one";
        game3.playerTwo.name = "two";
        game3.hands.put(-1, game3.playerOne);
        game3.hands.put(0, game3.playerTwo);

        expectedValue = game3.playerTwo.name + " Wins!";
        actualValue = game3.evaluateHands();
        assertEquals(expectedValue, actualValue);

        Game game4 = new Game();
        game4.playerOne.name = "one";
        game4.playerTwo.name = "two";
        game4.hands.put(1, game4.playerOne);
        game4.hands.put(0, game4.playerTwo);

        expectedValue = game4.playerOne.name + " Wins!";
        actualValue = game4.evaluateHands();
        assertEquals(expectedValue, actualValue);
    }
}
