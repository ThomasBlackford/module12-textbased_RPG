import java.util.Scanner;

public class ChoiceHandler {

    public static void presentChoice(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        int choice = getPlayerChoice(options.length);

        handleChoice(choice);
    }

    private static int getPlayerChoice(int length) {
        return 0;
    }

    private static void handleChoice(int choice) {

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
            scanner.nextLine();
        } while (input < min || input > max);
        return input;
    }
}
