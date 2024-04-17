import java.util.ArrayList;
import java.util.List;

public class Player extends Character {
    private int armor, damage;
    private String name, race, country;
    private List<String> skills;
    private static ArrayList<Item> inventory;

    public Player(int armor, int damage, String name, String race, List<String> skills, String country) {
        this.armor = armor;
        this.damage = damage;
        this.name = name;
        this.race = race;
        this.skills = skills;
        this.inventory = new ArrayList<>();
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getSkills() {
        return skills;
    }

    public static void getInventory() {
        System.out.println(inventory);
    }


    @Override
    public void info() {
        System.out.println("Your name is: " + name + " and you are a " + race);
        System.out.println("Current AC: " + armor);
        System.out.println("Current Damage: " + damage);
        System.out.println("Skills: " + skillsToString());
        System.out.println("Inventory: " + inventoryToString());
    }

    public static void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    private String skillsToString() {
        StringBuilder sb = new StringBuilder();
        for (String skill : skills) {
            sb.append(skill).append(", ");
        }
        return sb.toString().substring(0, sb.length() - 2);
    }

    static String inventoryToString() {
        if (inventory.isEmpty()) {
            return "Empty";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Item item : inventory) {
                sb.append(item.getName()).append(", ");
            }
            return sb.toString().substring(0, sb.length() - 2);
        }
    }
}
