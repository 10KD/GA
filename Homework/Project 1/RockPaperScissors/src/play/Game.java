package play;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Game {

    public HashMap<Integer, String> hands = new HashMap<Integer, String>();
    public boolean gameover = false;
    public String playerOne = "Player 1";
    public String playerTwo = "Player 2";
    private int numHands = 0;


    public void Game(){}

    public void play(){
        while (!gameover){
//            receiveHands();
            evaluateHands();
        }
    }

//    public String

    public String evaluateHands(){

        if (hands.size() < 2){
            return "Tie Game!";
        } else if (addHands() == 1){
            return hands.get(1) + " Wins!";
        } else if (addHands() == 0) {
            return hands.get(-1) + " Wins!";
        } else if (addHands() == -1) {
            return hands.get(0) + " Wins!";
        }

        return "idk";
    }

    public int addHands(){
        int sum = 0;
        for (int hand: hands.keySet()) {
            sum += hand;
        }
        return sum;
    }
}
