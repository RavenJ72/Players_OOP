package hero;

import clothes.Clothes;
import hero.heroes.Elf;
import hero.heroes.Knight;
import hero.heroes.Wizard;
import hero.player.Player;
import item.Item;
import weapon.Bow;
import weapon.Staff;
import weapon.Sword;
import weapon.Weapon;

import java.util.Arrays;

public class Hero extends Player implements Healthy,Armed,Inventory{

    protected int health;
    protected Weapon weapon;
    protected Clothes[] clothes = new Clothes[CLOTHES];
    protected Item[] items = new Item[ITEMS];

    public Hero(String username, int level,int health) {
        super(username, level);
        setHealth(health);
    }

    protected void setHealth(int health) {
        if ((health < 1) | (health > 100)) {
            throw new IllegalArgumentException("Wrong value to hero's health");
        } else this.health = health;
    }

    @Override
    public boolean change(Weapon weapon) {
        if(weapon != null){
            if(weapon instanceof Sword & this instanceof Knight
            | weapon instanceof Bow & this instanceof Elf
            | weapon instanceof Staff & this instanceof Wizard){
                this.weapon = weapon;
                System.out.println(username + " change weapon");
                return true;
            }else{
                System.out.println("Wrong weapon");
                return false;
            }
        }else{
            System.out.println("Wrong weapon");
            return false;
        }
    }

    @Override
    public boolean dress(Clothes clothes,int place) {

        if ((place > CLOTHES) | (place < 1)) {
            System.out.println("Wrong key");
            return false;
        }else{
            String[] slots = {"Helmet","Dress","Boots"};
            if(this.clothes[place-1] == null){
                if(clothes.getClass().getSimpleName().equalsIgnoreCase(slots[place-1])){
                    this.clothes[place-1] = clothes;
                    System.out.println(username + " put on " + clothes.getClass().getSimpleName());
                    return true;
                }else{
                    System.out.println("Wrong place for the " + clothes.getClass().getSimpleName() );
                    return false;
                }

            }else{
                System.out.println("No more then one" + clothes.getClass().getSimpleName());
                return false;
            }
        }

    }

    @Override
    public String action() {
        return null;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void recoverHealth(int health) {
        this.health += health;

    }

    @Override
    public boolean put(Item item, int place) {
        if(place > ITEMS){
            System.out.println("Wrong key");
            return false;
        }else if(items[place-1] == null){
            items[place-1] = item;
            System.out.println(username + " put " + item.getClass().getSimpleName());
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean useItem(int place) {
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " "  + username + "[" + level + " level," + health + " health] is online";
    }

}
