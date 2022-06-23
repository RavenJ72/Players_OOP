package hero;

import clothes.Clothes;
import weapon.Weapon;

public interface Armed {

    public final int CLOTHES = 3;
    public boolean change(Weapon weapon);
    public boolean dress(Clothes clothes,int place);
    public String action();
}
