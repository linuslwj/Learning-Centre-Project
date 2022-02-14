import  java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("P1 choose rock, paper or scissors? ");
        String playerOne = input.next();
        System.out.println("P2 choose rock, paper or scissors? ");
        String playerTwo = input.next();

        if (playerOne.equals("rock") && playerTwo.equals("scissors") || (playerOne.equals("scissors") && playerTwo.equals("paper")) || (playerOne.equals("paper") && playerTwo.equals("rock"))) {
            System.out.println("Player 1 wins!");
        }
        else if (playerTwo.equals("rock") && playerOne.equals("scissors") || (playerTwo.equals("scissors") && playerOne.equals("paper")) || (playerTwo.equals("paper") && playerOne.equals("rock"))) {
            System.out.println("Player 2 wins!");
        }
        else {
            System.out.println("Its a tie!");
        }

        /*
        if (playerOne.equals("rock")) {
            if (playerTwo.equals("scissors")) {
                System.out.println("Player 1 wins!");
            }  else if (playerTwo.equals("paper")) {
                System.out.println("Player 2 wins!");
            } else {
                System.out.println("Its a tie!");
            }
        } else if (playerOne.equals("paper")) {
            if (playerTwo.equals("rock")) {
                System.out.println("Player 1 wins!");
            } else if (playerTwo.equals("scissors")) {
                System.out.println("Player 2 wins!");
            } else {
                System.out.println("Its a tie!");
            }
        }
        else {
            if (playerTwo.equals("paper")) {
                System.out.println("Player 1 wins!");
            } else if (playerTwo.equals("rock")) {
                System.out.println("Player 2 wins!");
            } else {
                System.out.println("Its a tie!");
            }
        }
    */

    }
}