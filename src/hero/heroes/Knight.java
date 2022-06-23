package hero.heroes;

import hero.Hero;
import item.Food;
import item.HealthPotion;

public class Knight extends Hero {

    public final static int MAX_STRENGTH = 100;
    private int strength;
    private int force;

    public Knight(String username, int level, int health, int strength, int impactForce) {
        super(username, level, health);
        this.setStrength(strength);
        this.setImpactForce(impactForce);
        System.out.println(this);
    }

    private void setStrength(int strength) throws IllegalArgumentException{
        if ((strength < 1) | (strength > 100)) {
            throw new IllegalArgumentException("Wrong value to knight's strength");
        } else this.strength = strength;
    }

    private void setImpactForce(int impactForce) throws IllegalArgumentException{
        if ((impactForce < 1) | (impactForce > this.strength)) {
            throw new IllegalArgumentException("Wrong value to knight's force");
        } else this.force = impactForce;
    }

    private boolean fight() {
        return strength >= force;
    }

    @Override
    public String action() {
        if (fight()) {
            this.strength -= this.force;
            return username + " fight with force " + (weapon == null ? force : String.format("%.0f", force * weapon.getAbility()) ) + "[" + strength + " strength left]";
        }
        return username + " has no more strength";
    }

    @Override
    public boolean useItem(int inventoryPlace) {
        if ((inventoryPlace > ITEMS) || (inventoryPlace < 1)) {
            System.out.println("Wrong key");
            return false;
        }
        if (items[inventoryPlace -1 ] == null || items[inventoryPlace-1].use() == 0) {
            System.out.println("Empty slot");
            return false;
        }
        if (items[inventoryPlace] instanceof HealthPotion) {
            if ((health + items[inventoryPlace].use()) > MAX_HEALTH) {
                health = MAX_HEALTH;
            } else health += items[inventoryPlace].use();
            System.out.println(username + " use HealthPotion");
            return true;
        } else if (items[inventoryPlace] instanceof Food) {
            if ((strength + items[inventoryPlace].use()) > MAX_STRENGTH) {
                strength = MAX_STRENGTH;
            } else strength += items[inventoryPlace].use();
            System.out.println(username + " use Food");
            return true;
        } else System.out.println(username + " doesn't know how to use "
                + items[inventoryPlace].getClass().getSimpleName());
        return false;
    }

}
