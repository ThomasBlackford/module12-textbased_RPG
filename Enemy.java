public class Enemy extends Character{
    private int totalHealth, currentHealth, armor, damage;
    private String name, race;

    public Enemy(int totalHealth, int currentHealth, int armor, int damage, String name, String race) {
        this.totalHealth = totalHealth;
        this.currentHealth = currentHealth;
        this.armor = armor;
        this.damage = damage;
        this.name = name;
        this.race = race;
    }

    @Override
    public void info() {
        System.out.println("Enemy name: " + name + " and is a "+ race);
        System.out.println("Current HP: " + currentHealth + "/" + totalHealth);
        System.out.println("Enemies AC: " + armor);
        System.out.println("Enemies Damage: "+ damage);
    }

}
