package hero.heroes;

import hero.Hero;
import item.HealthPotion;
import item.ManaPotion;

public class Wizard extends Hero {

    public final static int MAX_MANA = 100;
    private int mana;
    private int spell;

    public Wizard(String username, int level, int health, int mana, int spell) {
        super(username, level, health);
        this.setMana(mana);
        this.setSpell(spell);
        System.out.println(this);
    }

    private void setMana(int mana) throws IllegalArgumentException {
        if ((mana < 1) | (mana > 100)) {
            throw new IllegalArgumentException("Wrong value to wizard's mana");
        } else this.mana = mana;
    }

    private void setSpell(int spell) throws IllegalArgumentException {
        if ((spell < 1) | (spell > this.mana)) {
            throw new IllegalArgumentException("Wrong value to wizard's spell power");
        } else this.spell = spell;
    }

    private boolean spell() {
        return (this.mana >= this.spell);
    }

    @Override
    public String action() {
        if (spell()) {
            mana -= spell;
            return username + " spell with the power " + (weapon == null ? spell : String.format("%.0f", spell * weapon.getAbility()))  + "[" + mana + " mana left]";
        }else {
            return username + " has no more mana";
        }

    }

    @Override
    public boolean useItem(int inventoryPlace) {
        if ((inventoryPlace > ITEMS) || (inventoryPlace < 1)) {
            System.out.println("Wrong key");
            return false;
        }
        if (items[inventoryPlace-1] == null || items[inventoryPlace-1].use() == 0) {
            System.out.println("Empty slot");
            return false;
        }
        if (items[inventoryPlace] instanceof HealthPotion) {
            if ((health + items[inventoryPlace].use()) > MAX_HEALTH) {
                health = MAX_HEALTH;
            } else health += items[inventoryPlace].use();
            System.out.println(username + " use HealthPotion");
            return true;
        } else if (items[inventoryPlace] instanceof ManaPotion) {
            if ((mana + items[inventoryPlace].use()) > MAX_MANA) {
                mana = MAX_MANA;
            } else mana += items[inventoryPlace].use();
            System.out.println(username + " use ManaPotion");
            return true;
        } else System.out.println(username + " doesn't know how to use "
                + items[inventoryPlace].getClass().getSimpleName());
        return false;
    }

}
