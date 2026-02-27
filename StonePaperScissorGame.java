import java.util.Random;
import java.util.Scanner;

public class StonePaperScissorGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int userScore = 0;
        int computerScore = 0;

        System.out.println("=== Welcome to Stone, Paper, Scissor Game ===");
        System.out.println("First to reach 3 wins is the hero , if you didnt your loser :) !");
        System.out.println("--------------------------------------------");

        while (userScore < 3 && computerScore < 3) {

            int userChoice = getUserChoice(sc);
            int computerChoice = random.nextInt(3) + 1;

            System.out.println("You chose: " + toText(userChoice));
            System.out.println("Computer chose: " + toText(computerChoice));

            int result = getWinner(userChoice, computerChoice);

            if (result == 0) {
                System.out.println("Result: It's a tie!");
            } else if (result == 1) {
                System.out.println("Result: You win this round!");
                userScore++;
            } else {
                System.out.println("Result: Computer wins this round!");
                computerScore++;
            }

            System.out.println("Score => You: " + userScore + " | Computer: " + computerScore);
            System.out.println("--------------------------------------------");
        }

        if (userScore == 3) {
            System.out.println("Congratulations! You are the champion :)");
        } else {
            System.out.println("Computer wins the game!");
        }

        sc.close();
    }

    private static int getUserChoice(Scanner sc) {

        while (true) {
            System.out.println("1 = Stone, 2 = Paper, 3 = Scissor");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); 
                continue;
            }

            int choice = sc.nextInt();

            if (choice >= 1 && choice <= 3) {
                return choice;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private static int getWinner(int user, int computer) {

        if (user == computer) {
            return 0; 
        }

        if ((user == 1 && computer == 3) ||
            (user == 2 && computer == 1) ||
            (user == 3 && computer == 2)) {
            return 1; 
        }

        return -1; 
    }

    private static String toText(int choice) {
        switch (choice) {
            case 1: return "Stone";
            case 2: return "Paper";
            case 3: return "Scissor";
            default: return "Unknown";
        }
    }
}