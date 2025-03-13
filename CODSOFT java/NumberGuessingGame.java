import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        Random r = new Random();
        int totalRounds = 3;  
        int maxchances = 5; 
        int range = 100; 
        System.out.println("Welcome to the Number Guessing Game soldier!");

        for (int round = 1; round <= totalRounds; round++){
            int numberToGuess = r.nextInt(range) + 1;
            int numberOfchances = 0;
            boolean win = false;

            System.out.println("\nRound " + round);
            System.out.println("I have selected a number between 1 and " + range + ". guess it");

            while (numberOfchances < maxchances) {
                System.out.print("Enter your guess: ");
                int guess = S.nextInt();
                numberOfchances++;

                if (guess < numberToGuess) {
                    System.out.println("Your guess is too low Soldier. Try again");
                } else if (guess > numberToGuess) {
                    System.out.println("Your guess is too high Soldier. Try again");
                } else {
                    win = true;
                    System.out.println("Congratulations Soldier! You Won the Game");
                    System.out.println("you guessed the correct number in" + numberOfchances + "chances");
                }

                if (numberOfchances == maxchances && !win) {
                    System.out.println("You have reached the maximum no of attempts. The correct number was " + numberToGuess);
                }
            }
            range *= 2;
            maxchances -= 1;
        }
        System.out.println("\nGame Over! Thank you for playing");
        S.close();
    }
}