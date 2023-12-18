import java.util.*;

class guess {

    int count = 0;
    private int user_guess;

    public void check(int targeted_number) {

        for (int h = 15; h > 0; h--) {
            int user_guess = getUser_guess();
            if (user_guess > targeted_number) {
                System.out.println("Your number is larger");
            } else if (user_guess == targeted_number) {
                System.out.println("You Guess the right number that is " + user_guess);
                System.out.println("you take " + (16 - h) + " attempts to guess right number");
                count = 1;
                break;
            } else {
                System.out.println("Your number is smaller");
            }
            System.out.println(h - 1 + " attempts left!!");
        }

        if (count == 0) {
            System.out.println("\nGame Over");
        }
    }

    public int getUser_guess() {

        Scanner ans = new Scanner(System.in);

        try {
            System.out.print("\nGuess the Number: ");
            user_guess = ans.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Enter the value in integer");
            getUser_guess();
        }

        if (user_guess >= 100) {
            System.out.println("Enter the number which is between 1 to 100");
            getUser_guess();
        }

        return user_guess;
    }
}

public class number_game {
    public static void main(String[] args) {
        System.out.println("Welcome to Number Guessing Game");
        int count = 1, score;
        while (true) {
            guess num = new guess();
            System.out.println("\nRound " + count);
            int targeted_number = (int) (Math.random() * 100);
            System.out.println("Guess the number between 1 to 100");
            num.check(targeted_number);
            Scanner ans = new Scanner(System.in);
            String playAgain;

            do {
                System.out.println("\nDo you want to play another round? (y/n): ");
                playAgain = ans.next().toLowerCase();
            } while (!playAgain.equals("y") && !playAgain.equals("n"));

            if (num.count == 0)
                score = count - 1;
            else
                score = count;

            if (playAgain.equals("n")) {
                System.out.println("\nThanks for playing! Exiting the game.");
                System.out.println("Your Score is: " + score);
                break;
            }

            count++;
        }
    }
}
