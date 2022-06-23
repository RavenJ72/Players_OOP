import clothes.Helmet;
import hero.Hero;
import hero.heroes.Elf;
import hero.heroes.Knight;
import hero.heroes.Wizard;
import item.HealthPotion;
import weapon.Sword;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List <Hero> players = new ArrayList<>();

        Hero legolas = new Elf("Legolas",1,70,1);
        Hero merlin = new Wizard("Merlin",100,70,100,80);
        Hero arthur = new Knight("Arthur",35,70,100,12);

        legolas.put(new HealthPotion(5), 1);
        legolas.useItem(1);
        legolas.useItem(1);
        legolas.dress(new Helmet(2),2);

        System.out.println(legolas.toString());
        arthur.change(new Sword(2.5));
        merlin.change(new Sword(2.5));

        merlin.levelUp();

        players.add(legolas);
        players.add(arthur);
        players.add(merlin);



        for (Hero hero: players){
            System.out.println(hero.action());
            System.out.println(hero.action());
        }

    }
}
