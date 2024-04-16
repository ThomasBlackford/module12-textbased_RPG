import java.util.*;

public class PlayerCreation {
    private static Scanner scanner = new Scanner(System.in);

    public static final String[] SKILLS = {"One-Handed", "Two-Handed", "Archery", "Block", "Smithing", "Heavy Armor", "Light Armor", "Pickpocket", "Lockpicking", "Sneak", "Alchemy", "Speech", "Illusion", "Conjuration", "Destruction", "Restoration", "Alteration", "Enchanting"};
    public static final String[] RACES = {"Human", "High Elf", "Orc", "Khajiit", "Argonian", "Nord", "Breton", "Redguard", "Dunmer"};
    public static final String[] COUNTRIES = {"Skyrim", "Cyrodiil", "Morrowind", "High Rock", "Hammerfell", "Summerset Isles", "Valenwood", "Elsweyr", "Black Marsh"};

    public static final String[] SKILL_DESCRIPTIONS = {
            "Mastery of wielding a single weapon in combat. Increases your damage with One-Handed weapons.",
            "Proficiency in using two-handed weapons effectively. Increases your damage with Two-Hnaded weapons.",
            "Skill in using bows and arrows for ranged combat. Increases damage with ranged weapons.",
            "Ability to block incoming attacks with a shield or weapon. Increases ammount of damage you can block.",
            "Knowledge and ability in crafting and improving weapons and armor. Allows you to craft and improve weapons and armor.",
            "Proficiency in wearing and effectively using heavy armor. Reduces incoming damage when wearing heavy armor.",
            "Proficiency in wearing and effectively using light armor. Reduces incoming damage when wearing light armor.",
            "Ability to pickpocket items from others without being detected. Increases success rate of pickpocket attempts.",
            "Ability to pick locks and open doors without keys. Increases success rate of lockpicking attempts.",
            "Ability to move silently and remain undetected by enemies. Increases sneakiness and decreases chance of detection.",
            "Knowledge of alchemical ingredients and their effects. Allows you to craft potions and poisons.",
            "Ability to persuade and influence others in conversation. Increases success rate of persuasion attempts.",
            "Ability to cast spells of the Illusion school. Allows you to cast illusion spells.",
            "Ability to summon creatures and weapons from other realms. Allows you to summon creatures and weapons.",
            "Ability to cast spells of the Destruction school. Allows you to cast destruction spells.",
            "Ability to cast spells of the Restoration school. Allows you to cast restoration spells.",
            "Ability to cast spells of the Alteration school. Allows you to cast alteration spells.",
            "Ability to enchant items with magical properties. Allows you to enchant weapons and armor."
    };

    public static final String[] RACE_DESCRIPTIONS = {
            "Imperials are versatile and adaptable, known for their determination and ambition. They hail from Cyrodil",
            "High Elves are skilled in magic and have a natural affinity for the arcane arts. They hail from the Summerset isles.",
            "Orcs are renowned for their strength and combat prowess, often serving as formidable warriors. They hail from High Rock.",
            "Agile and stealthy, Khajiit are known for their prowess in thievery and agility, hailing from the desert province of Elsweyr.",
            "Hailing from the swamps and marshes of Black Marsh, Argonians are adept at surviving in harsh environments and are skilled in guerrilla warfare.",
            "Hailing from the frigid province of Skyrim, Nords are fierce warriors with a strong sense of honor and tradition.",
            "Bretons are skilled in magic and diplomacy, known for their ability to resist magical effects and their talent for negotiation and persuasion, originating from the province of High Rock.",
            "Redguards are masterful warriors from the desert province of Hammerfell, known for their skill with swords and their resilience in combat.",
            "Hailing from the volcanic land of Morrowind, Dunmer are proficient in magic and stealth, often serving as skilled assassins and mages."
    };

    public static final String[] COUNTRY_DESCRIPTIONS = {
            "Skyrim is a rugged, northern province known for its harsh climate and fierce warriors.",
            "Cyrodiil is the heart of the Empire, a diverse province with a rich history and culture.",
            "Morrowind is a volcanic land inhabited by the Dunmer, known for their proficiency in magic and stealth.",
            // Add descriptions for other countries...
    };

    public static List<String> createPlayerSkills() {
        System.out.println("Welcome to the skill selector");

        List<String> skills = new ArrayList<>();
        for (String skill : SKILLS) {
            skills.add(skill + ": 5");
        }

        System.out.println("Select your main skill of focus: ");
        String mainFocus = selectSkill();
        skills.set(Arrays.asList(SKILLS).indexOf(mainFocus), mainFocus + ": 20");

        return skills;
    }

    public static Player createCharacter() {
        System.out.println("Welcome to the character creator!");

        System.out.print("Enter character name: ");
        String name = scanner.nextLine();

        System.out.println("Available races:");
        for (int i = 0; i < RACES.length; i++) {
            System.out.println((i + 1) + ". " + RACES[i]);
        }

        int raceIndex = getIntInput("Choose character race: ", 1, RACES.length) - 1;
        String race = RACES[raceIndex];

        System.out.println(RACE_DESCRIPTIONS[raceIndex]);
        System.out.println("Are you sure you want to be a " + race + "? (yes/no)");
        String confirmation = scanner.nextLine();
        if (!confirmation.equalsIgnoreCase("yes")) {
            return null; // Exit character creation if the player changes their mind
        }

        System.out.println("Select a country to start in:");
        for (int i = 0; i < COUNTRIES.length; i++) {
            System.out.println((i + 1) + ". " + COUNTRIES[i]);
        }

        int countryIndex = getIntInput("Choose a country: ", 1, COUNTRIES.length) - 1;
        String country = COUNTRIES[countryIndex];

        System.out.println(COUNTRY_DESCRIPTIONS[countryIndex]);
        System.out.println("Are you sure you want to start in " + country + "? (yes/no)");
        confirmation = scanner.nextLine();
        if (!confirmation.equalsIgnoreCase("yes")) {
            return null; // Exit character creation if the player changes their mind
        }

        List<String> skills = createPlayerSkills();

        // Set armor and damage to default values for now
        int armor = 0;
        int damage = 0;

        return new Player(armor, damage, name, race, country, skills);
    }

    private static String selectSkill() {
        for (int i = 0; i < SKILLS.length; i++) {
            System.out.println((i + 1) + ". " + SKILLS[i]);
        }

        int skillIndex = getIntInput("Choose a skill: ", 1, SKILLS.length) - 1;
        String skill = SKILLS[skillIndex];
        System.out.println(SKILL_DESCRIPTIONS[skillIndex]);
        System.out.println("Are you sure you want to focus on " + skill + "? (yes/no)");
        String confirmation = scanner.nextLine();
        if (!confirmation.equalsIgnoreCase("yes")) {
            return null; // Exit skill selection if the player changes their mind
        }
        return skill;
    }

    private static int getIntInput(String prompt, int min, int max) {
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
