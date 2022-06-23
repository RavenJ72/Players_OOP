package hero.heroes;

import hero.Hero;
import item.HealthPotion;
import item.ManaPotion;

public class Elf extends Hero {
    private int arrowsCount;

    public Elf(String username, int level, int health,int arrowsCount) {
        super(username, level, health);
        setArrows(arrowsCount);
        System.out.println(this);
    }

    private void setArrows(int arrowsCount) throws IllegalArgumentException {
        if ((arrowsCount < 1) | (arrowsCount > 100)) {
            throw new IllegalArgumentException("Wrong value to elf's arrows count");
        } else this.arrowsCount = arrowsCount;
    }


    private boolean shootArrow(){
        if(arrowsCount-1 >= 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String action() {
        if (shootArrow()) {
            this.arrowsCount--;
            return username + " shoot arrow[" + arrowsCount + " arrows left]";
        }
        return username + " has no more arrows";
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


        if (items[inventoryPlace-1] instanceof HealthPotion) {
            if ((health + items[inventoryPlace-1].use()) > MAX_HEALTH) {
                health = MAX_HEALTH;
            } else health += items[inventoryPlace-1].use();
            System.out.println(username + " use HealthPotion");
            return true;
        } else System.out.println(username + " doesn't know how to use "
                + items[inventoryPlace-1].getClass().getSimpleName());
        return false;
    }




}
