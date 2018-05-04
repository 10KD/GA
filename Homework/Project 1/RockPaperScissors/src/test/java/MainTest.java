package test.java;

import org.junit.Before;
import org.junit.Test;
import play.Game;
import static org.junit.Assert.*;

public class MainTest {

    private String expectedValue;
    private String actualValue;
    private Game game;

    @Before
    public void setUp(){
        game = new Game();
    }


    @Test
    public void testEvanluateHandsScenarioOne(){

        game.playerOne.name = "one";
        game.playerTwo.name = "two";
        game.hands.put(-1, game.playerOne);
        game.hands.put(-1, game.playerTwo);

        expectedValue = "Tie Game!";
        actualValue = game.evaluateHands();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testEvanluateHandsScenarioTwo(){

        game.playerOne.name = "one";
        game.playerTwo.name = "two";
        game.hands.put(-1, game.playerOne);
        game.hands.put(1, game.playerTwo);

        expectedValue = game.playerOne.name + " Wins!";
        actualValue = game.evaluateHands();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testEvanluateHandsScenarioThree(){

        game.playerOne.name = "one";
        game.playerTwo.name = "two";
        game.hands.put(-1, game.playerOne);
        game.hands.put(0, game.playerTwo);

        expectedValue = game.playerTwo.name + " Wins!";
        actualValue = game.evaluateHands();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testEvanluateHandsScenarioFour(){

        game.playerOne.name = "one";
        game.playerTwo.name = "two";
        game.hands.put(1, game.playerOne);
        game.hands.put(0, game.playerTwo);

        expectedValue = game.playerOne.name + " Wins!";
        actualValue = game.evaluateHands();
        assertEquals(expectedValue, actualValue);
    }
}
