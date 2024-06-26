public abstract class Weapon extends Item{

    private int damage;

    public Weapon(String name, int damage, int value) {
        super(name,value);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public abstract String description();

}
