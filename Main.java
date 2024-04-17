import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Elder Scrolls text RPG.");
        System.out.println("Character creator:");

        Player player = PlayerCreation.createCharacter();

        System.out.println("To recap...");
        System.out.println("You are " + player.getName()+", a " + player.getRace()+".");
        List<String> skills = player.getSkills();

        System.out.println("You hail from the country of " + player.getCountry() + ", and are known for your skills in " + skills.get(PlayerCreation.getPrioSkill(player.getSkills())));

        Game.startGameLoop(player.getRace(),player.getCountry(),player.getName());







    }


}
