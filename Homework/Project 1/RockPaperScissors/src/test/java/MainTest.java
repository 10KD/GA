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

        game1.hands.put(-1, game1.playerOne.name);
        game1.hands.put(-1, game1.playerTwo.name);

        String expectedValue = "Tie Game!";
        String actualValue = game1.evaluateHands();
        assertEquals(expectedValue, actualValue);

        Game game2 = new Game();
        game2.playerOne.name = "one";
        game2.playerTwo.name = "two";
        game2.hands.put(-1, game2.playerOne.name);
        game2.hands.put(1, game2.playerTwo.name);

        expectedValue = game2.playerOne.name + " Wins!";
        actualValue = game2.evaluateHands();
        assertEquals(expectedValue, actualValue);

        Game game3 = new Game();
        game3.playerOne.name = "one";
        game3.playerTwo.name = "two";
        game3.hands.put(-1, game3.playerOne.name);
        game3.hands.put(0, game3.playerTwo.name);

        expectedValue = game3.playerTwo.name + " Wins!";
        actualValue = game3.evaluateHands();
        assertEquals(expectedValue, actualValue);

        Game game4 = new Game();
        game4.playerOne.name = "one";
        game4.playerTwo.name = "two";
        game4.hands.put(1, game4.playerOne.name);
        game4.hands.put(0, game4.playerTwo.name);

        expectedValue = game4.playerOne.name + " Wins!";
        actualValue = game4.evaluateHands();
        assertEquals(expectedValue, actualValue);
    }
}
