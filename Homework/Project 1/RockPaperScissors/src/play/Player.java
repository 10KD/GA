package play;

import java.util.Random;
import java.util.Scanner;

public class Player {

    public int hand;
    public String name;

    public boolean won;

    public Player(){}

    public void getHand(){
        if (name == "RPS Bot 9001"){
            getRobotHand();

        } else {
            hand = 404;
            Scanner read = new Scanner(System.in);
            System.out.println(name + ", which do you choose: Rock, Paper or Scissors?");
            while (hand == 404){

                String input = read.next().toLowerCase();
                try {
                    switch (input){
                        case "rock":
                            hand = 1;
                            break;
                        case "paper":
                            hand = -1;
                            break;
                        case "scissors":
                            hand = 0;
                            break;
                        case "scissor":
                            hand = 0;
                            break;
                        default:
                            System.out.println(name + ", please choose a valid input (Rock, Paper or Scissors): ");
                            break;
                    }
                } catch (NullPointerException e){
                    e.printStackTrace();
                    System.out.println("Invalid input!");
                }
            }
        }
    }

    private void getRobotHand(){
        // rng plucked from https://stackoverflow.com/questions/27976857/how-to-get-random-number-with-negative-number-in-range
        Random random = new Random();
        hand = random.nextInt(2) * (random .nextBoolean() ? -1 : 1);
    }
}
