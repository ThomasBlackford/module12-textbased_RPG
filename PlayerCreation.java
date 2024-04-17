import java.util.*;

public class PlayerCreation {
    private static Scanner scanner = new Scanner(System.in);

    public static final String[] SKILLS = {"One-Handed", "Two-Handed", "Archery", "Block", "Smithing", "Heavy Armor", "Light Armor", "Pickpocket", "Lockpicking", "Sneak", "Alchemy", "Speech", "Illusion", "Conjuration", "Destruction", "Restoration", "Alteration", "Enchanting"};
    public static final String[] RACES = {"Imperial", "High Elf", "Orc", "Khajiit", "Argonian", "Nord", "Breton", "Redguard", "Dunmer"};
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
            "Morrowind is a volcanic land inhabited by the Dunmer, known for the island of Vvardenfell and the imposing Red Mountain.",
            "High Rock is a province in northwestern Tamriel. Most of the province is inhabited by the Bretons, who have divided the province into multiple Breton city states and minor kingdoms. High Rock has also historically contained Orsinium, the City-State of the Orcs.",
            "Hammerfell, once known as Hegathe, the Deathland (or Deathlands), and Volenfell, is a province and republic in the west of Tamriel, bordering Skyrim, Cyrodiil, and High Rock. This province is made up of beaches, jungles, grasslands, mountains, with the northwest corner taken up by the Alik'r desert. It is inhabited by the human race of Redguards, who fled to Tamriel after their home, Yokuda, was partly sunken.",
            "Summerset (also referred to as Summerset Isle, the Eternal Isle, and Blessed Isle) is a large island to the southwest of Tamriel's mainland. It is the largest of the three main islands in the Summerset Isles, which encompasses over a dozen more smaller islands. This is where the Altmer hail from.",
            "Valenwood is a densely forested, sub-tropical region that encompasses the southwestern coastal plain of Tamriel. In the words of A Pocket Guide to the Empire, Valenwood is a sea of endless green, a maze of foliage with half-hidden cities growing like blooms from a flower, the home of the Bosmer is Tamriel's garden. Alongside the Wood Elves, races like the Wood Orcs, Imga, and Centaur also call the forest their home.",
            "Elsweyr is a region that lies on the southern coast of Tamriel, and is home to the feline Khajiit. It is divided into two major climates: savannahs, badlands and dry plains in the north, and fertile lands of jungle and rainforests in the south.",
            "Black Marsh is a dense swampland region of southeastern Tamriel, home to the reptilian humanoid race of Argonians and a race of sapient trees known as the Hist. Mer refer to the region as Argonia."
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



    private static String selectSkill() {
        String skill;
        boolean skillSelect = false;
        while (!skillSelect) {
            for (int i = 0; i < SKILLS.length; i++) {
                System.out.println((i + 1) + ". " + SKILLS[i]);
            }

            int skillIndex = getIntInput("Choose a skill: ", 1, SKILLS.length) - 1;
            skill = SKILLS[skillIndex];
            System.out.println(SKILL_DESCRIPTIONS[skillIndex]);
            System.out.println("Are you sure you want to focus on " + skill + "? (yes/no)");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
                skillSelect = true;
                return skill;
            }
            else {
                System.out.println("Okay, try again.\n");
            }
        } while (true);
    }

    public static int getPrioSkill(List<String> skills) {
        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i).endsWith(": 20")) {
                return i;
            }
        }
        return -1;
    }

    public static Player createCharacter() {
        System.out.println("Welcome to the character creator!");

        System.out.print("Enter character name: ");
        String name = scanner.nextLine();

        // Race selection
        System.out.println("Available races:");
        for (int i = 0; i < RACES.length; i++) {
            System.out.println((i + 1) + ". " + RACES[i]);
        }

        boolean raceSelect = false;
        String race = null;
        while (!raceSelect) {
            int raceIndex = getIntInput("Choose character race: ", 1, RACES.length) - 1;
            race = RACES[raceIndex];
            System.out.println(RACE_DESCRIPTIONS[raceIndex]);
            System.out.println("Are you sure you want to be a " + race + "? (yes/no)");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
                raceSelect = true;
            } else {
                System.out.println("Okay, try again.\n");
            }
        }

        // Country selection
        System.out.println("Select a country to start in:");
        for (int i = 0; i < COUNTRIES.length; i++) {
            System.out.println((i + 1) + ". " + COUNTRIES[i]);
        }

        boolean countryConfirm = false;
        String country = null;
        while (!countryConfirm) {
            int countryIndex = getIntInput("Choose a country: ", 1, COUNTRIES.length) - 1;
            country = COUNTRIES[countryIndex];
            System.out.println(COUNTRY_DESCRIPTIONS[countryIndex]);
            System.out.println("Are you sure you want to start in " + country + "? (yes/no)");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
                countryConfirm = true;
            } else {
                System.out.println("Okay, please try again.\n");
            }
        }

        List<String> skills = createPlayerSkills();
        int prioSkill = getPrioSkill(skills);
        if (prioSkill == -1) {
            return null;
        }

        if (skills == null) {
            return null;
        }

        int armor = 0;
        int damage = 0;

        return new Player(armor, damage, name, race, skills, country);
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
