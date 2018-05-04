package play;


import java.util.HashMap;
import java.util.Scanner;

public class Game {

    public Scanner read = new Scanner(System.in);
    public HashMap<Integer, String> hands;
    public HashMap<Integer, String> handTypes = new HashMap<>();
    {
        handTypes.put(1, "Rock");
        handTypes.put(0, "Scissors");
        handTypes.put(-1, "Paper");
    }
    public boolean gameover = false;
    public Player playerOne = new Player();
    public Player playerTwo = new Player();


    public Game(){}

    public void play(){

        while (!gameover){
            getPlayerNames();
            getHands();
            evaluateHands();
            repeat();
        }
    }


    public void repeat(){
        System.out.println("Would you like to play again?");
        boolean loop = true;
        while (loop){
            String answer = read.next().toLowerCase();
            if (answer.equals("no")){
                System.out.println("Thanks for playing! Goodbye.");
                gameover = true;
                loop = false;
            } else if (answer.equals("yes")){
                loop = false;
            } else {
                System.out.println("Invalid answer. Please choose between 'yes' / 'no': ");
            }
        }
    }

    public void getHands(){
        hands = new HashMap<>();
        playerOne.getHand();
        hands.put(playerOne.hand, playerOne.name);
        playerTwo.getHand();
        hands.put(playerTwo.hand, playerTwo.name);
    }

    public void getPlayerNames(){
        System.out.println("Would you like to play against a bot?");
        String playAgainstComputer = read.next();

        if (playAgainstComputer.equals("yes")){

            playerOne.name = "RPS Bot 9001";
            System.out.println("Delightful. My buddy '" + playerOne.name + "' will play against you");
            System.out.println("");
            System.out.println("Enter your name: ");

            playerTwo.name = read.next();
        } else {
            System.out.println("Enter name for player 1: ");

            playerOne.name = read.next();
            System.out.println("Enter name for player 2: ");

            playerTwo.name = read.next();
        }

    }


    public String evaluateHands(){
        System.out.println(playerOne.name + " chose " + handTypes.get(playerOne.hand));
        System.out.println(playerTwo.name + " chose " + handTypes.get(playerTwo.hand));
        System.out.println("hands count: " + hands.size());
        int handsSum = addHands();

        if (hands.size() < 2){
            System.out.println("Tie Game!");
            return "Tie Game!";

        } else if (handsSum == 1){
            System.out.println(hands.get(1) + " Wins!");
            return hands.get(1) + " Wins!";

        } else if (handsSum == 0) {
            System.out.println(hands.get(-1) + " Wins!");
            return hands.get(-1) + " Wins!";

        } else if (handsSum == -1) {
            System.out.println(hands.get(0) + " Wins!");
            return hands.get(0) + " Wins!";

        }
        return "idk";
    }

    private int addHands(){
        int sum = 0;
        for (int hand: hands.keySet()) {
            sum += hand;
        }
        System.out.println("hands sum: " + sum);
        return sum;
    }
}
