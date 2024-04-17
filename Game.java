import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void startGameLoop(String playerRace, String playerCountry, String playerName) throws InterruptedException {
        if (playerCountry.equals("High Rock")) {
            if (playerRace.equals("Imperial")) {
                System.out.println("You awaken inside an inn, the smell of freshly baked bread and mead lingering in the air. Sunlight filters through the curtains, casting a warm glow across the room. As you stretch and rub the sleep from your eyes, memories of the road blur together. How did you end up here?");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("The sound of clinking tankards and jovial laughter drifts up from the common room below. You sit up in bed, your Imperial garb wrinkled from sleep. Glancing around the room, you notice a map of High Rock pinned to the wall. It serves as a reminder of the unfamiliar territory you find yourself in.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("As you rise from the bed, you feel a sense of disorientation wash over you. Last you remember, you were on assignment from the Imperial City. Now, you find yourself in a cozy inn nestled amidst the rugged hills of High Rock. What twists of fate have brought you to this place?");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("The soft creak of floorboards underfoot echoes in the quiet room. You catch a glimpse of yourself in the mirror, your Imperial features reflecting back at you. In the corner, a satchel sits, its contents a mystery waiting to be unraveled. Perhaps there are clues within to shed light on your journey.");
                TimeUnit.SECONDS.sleep(1);

                System.out.println("1. Leave the room.");
                System.out.println("2. Investigate the satchel.");
                System.out.println("3. Talk to the innkeeper.");

                int choice = getIntInput("What do you do?",1,3);
                TimeUnit.SECONDS.sleep(1);

                if (choice == 1) {
                    System.out.println("You left the room and descended down the creaky stairs to the common room of the inn.");

                }
                else if (choice == 2) {
                    System.out.println("You investigate the satchel.");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Inside the satchel, you find 300 gold, a strange pendant, and a sealed letter addressed to you.");
                    System.out.println("You add these items to your inventory and carefully read the letter.");
                    Item Strange_Pendant = new Item("Strange Pendant",500) {
                        @Override
                        public String description() {
                            System.out.println("A strange pendant, made of gold with a gemstone in the middle.");
                            return null;
                        }
                    };
                    Player.addItem(Strange_Pendant);
                    Player.getInventory();

                }
                else if (choice == 3) {
                    System.out.println("You approach the innkeeper, a stout Breton woman, wiping a tankard behind the bar.");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Innkeeper: 'Good morning, traveler! What can I do for you?'");

                }
                else {
                    System.out.println("Invalid choice. Please choose a valid option.");
                }
            }

        }
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
