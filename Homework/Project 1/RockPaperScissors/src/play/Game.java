package play;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

    // setup

    private boolean gameover = false;
    private Scanner read = new Scanner(System.in);
    public HashMap<Integer, Player> hands = new HashMap<>();
    private HashMap<Integer, String> handTypes = new HashMap<>();
    {
        handTypes.put(1, "Rock");
        handTypes.put(0, "Scissors");
        handTypes.put(-1, "Paper");
    }
    public Player playerOne = new Player();
    public Player playerTwo = new Player();
    public ArrayList<String> history = new ArrayList<>();
    {
        history.add("<< GAME HISTORY >>");
    }
    public int historyIndex = 1;


    public Game(){}

    // game menu loop
    public void play(){
        System.out.println("Welcome to Rock, Paper, Scissors ALPHA!");
        try{
            while (!gameover){
                String menuSelection = menu();
                if (menuSelection.equals("play")) {
                    getPlayerNames();
                    getHands();
                    evaluateHands();
                    Thread.sleep(2000);
                } else if (menuSelection.equals("history")) {
                    if (history.size() > 1) {
                        for (String record:history) {
                            System.out.println(record);
                        }
                    } else {
                        System.out.println("No games have been played yet.");
                    }
                    Thread.sleep(2000);
                } else if (menuSelection.equals("quit")){
                    System.out.println("Thanks for playing! Goodbye.");
                    gameover = true;
                } else {
                    System.out.println("Invalid answer. Please choose 'play, history, or quit': ");
                }
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Invalid Input!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String menu(){
        System.out.println("");
        System.out.println("< MAIN MENU >");
        System.out.println(" ----------- ");
        System.out.println("1. Type 'play' to play");
        System.out.println("2. Type 'history' to view your game history");
        System.out.println("Type 'quit' to exit");
        String result = read.next().toLowerCase();
        return result;
    }

    private void getHands(){
        hands = new HashMap<>();
        playerOne.getHand();
        hands.put(playerOne.hand, playerOne);
        playerTwo.getHand();
        hands.put(playerTwo.hand, playerTwo);
    }

    private void getPlayerNames(){
        playerOne.won = false;
        playerTwo.won = false;

        try {
            boolean loop = true;

            while (loop) {

                System.out.println("Would you like to play against a bot?");
                String playAgainstComputer = read.next();
                if (playAgainstComputer.equals("yes") || playAgainstComputer.equals("y")) {

                    playerTwo.name = "RPS Bot 9001";
                    System.out.println("Delightful. My buddy '" + playerTwo.name + "' will play against you");
                    System.out.println("");
                    System.out.println("Enter your name: ");
                    playerOne.name = read.next();
                    loop = false;

                } else if (playAgainstComputer.equals("no") || playAgainstComputer.equals("n")) {
                    System.out.println("Enter name for player 1: ");
                    playerOne.name = read.next();

                    System.out.println("Enter name for player 2: ");
                    playerTwo.name = read.next();
                    loop = false;

                } else {
                    System.out.println("Invalid answer. Please choose between 'yes' / 'no': ");
                }
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Invalid Input!");
        }

    }

    // determines winner based on sum of hands. If Rock is 1 and paper is -1, paper wins.
    // the sum of 1 + -1 is 0, if sum is 0, -1 wins.
    public String evaluateHands(){
        System.out.println(playerOne.name + " chose " + handTypes.get(playerOne.hand));
        System.out.println(playerTwo.name + " chose " + handTypes.get(playerTwo.hand));
        int handsSum = addHands();

        if (hands.size() < 2){
            System.out.println("Tie Game!");
            addToHistory("Tie!");
            return "Tie Game!";

        } else if (handsSum == 1){
            System.out.println(hands.get(1).name + " Wins!");
            addToHistory(hands.get(1).name + " Won!");
            hands.get(1).won = true;
            return hands.get(1).name + " Wins!";

        } else if (handsSum == 0) {
            System.out.println(hands.get(-1).name + " Wins!");
            addToHistory(hands.get(-1).name + " Won!");
            hands.get(-1).won = true;
            return hands.get(-1).name + " Wins!";

        } else if (handsSum == -1) {
            System.out.println(hands.get(0).name + " Wins!");
            addToHistory(hands.get(-1).name + " Won!");
            hands.get(0).won = true;
            return hands.get(0).name + " Wins!";

        }
        return "Hands error. There are more than two hands";
    }

    private int addHands(){
        int sum = 0;
        for (int hand: hands.keySet()) {
            sum += hand;
        }
        return sum;
    }

    private void addToHistory(String result){
        history.add(
                "Game " + historyIndex + ": " + playerOne.name + " chose " + handTypes.get(playerOne.hand)
                        + " and " + playerTwo.name + " chose " + handTypes.get(playerTwo.hand) + ". " + result
        );
        historyIndex++;
    }
}
