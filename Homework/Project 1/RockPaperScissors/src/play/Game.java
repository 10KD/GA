package play;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

    private boolean gameover = false;
    private Scanner read = new Scanner(System.in);
    public HashMap<Integer, Player> hands;
    private HashMap<Integer, String> handTypes = new HashMap<>();
    {
        handTypes.put(1, "Rock");
        handTypes.put(0, "Scissors");
        handTypes.put(-1, "Paper");
    }
    public Player playerOne = new Player();
    public Player playerTwo = new Player();
    public ArrayList<String> history = new ArrayList<>();
    public int historyIndex = 1;


    public Game(){}

    public void play(){
        System.out.println("Welcome to Rock, Paper, Scissors ALPHA!");
        try{
            while (!gameover){
                String loadMenu = menu();
                if (loadMenu.equals("play")) {
                    getPlayerNames();
                    getHands();
                    evaluateHands();
    //                repeat();
                } else if (loadMenu.equals("history")) {
                    for (String record:history) {
                        System.out.println(record);
                    }
                } else if (loadMenu.equals("quit")){
                    System.out.println("Thanks for playing! Goodbye.");
                    gameover = true;
                } else {
                    System.out.println("Invalid answer. Please choose 'play, history, or quit': ");
                }
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Invalid Input!");
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


    private void repeat(){
        System.out.println("Would you like to play again?");
        boolean loop = true;
        try {

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
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Invalid Input!");
        }
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
                if (playAgainstComputer.equals("yes")) {

                    playerTwo.name = "RPS Bot 9001";
                    System.out.println("Delightful. My buddy '" + playerTwo.name + "' will play against you");
                    System.out.println("");
                    System.out.println("Enter your name: ");
                    playerOne.name = read.next();
                    loop = false;

                } else if (playAgainstComputer.equals("no")) {
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


    public String evaluateHands(){
        System.out.println(playerOne.name + " chose " + handTypes.get(playerOne.hand));
        System.out.println(playerTwo.name + " chose " + handTypes.get(playerTwo.hand));
//        System.out.println("hands count: " + hands.size());
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
        return "idk";
    }

    private int addHands(){
        int sum = 0;
        for (int hand: hands.keySet()) {
            sum += hand;
        }
//        System.out.println("hands sum: " + sum);
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
