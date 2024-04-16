public class SteelSword extends Weapon{

    public SteelSword(String name, int damage, int value) {
        super(name,damage,value);
    }

    @Override
    public String description() {
        return "Steel Sword: " + getName() + "\nDamage: " + getDamage() + "\nA sturdy steel sword forged by skilled blacksmiths. Its finely crafted blade allows for swift strikes and reliable performance in combat.";
    }


}
