import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Elder Scrolls text RPG.");
        System.out.println("Character creator:");

        Character character = PlayerCreation.createCharacter();



    }

    private static int getIntInput(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input! Please enter a number between " + min + " and " + max + ": ");
                scanner.next();
            }
            input = scanner.nextInt();
            scanner.nextLine();  // Consume newline
        } while (input < min || input > max);
        return input;
    }
}
