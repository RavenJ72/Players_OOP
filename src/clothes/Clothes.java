package clothes;



public class Clothes implements Armor {

    protected int durability;

    protected Clothes(int durability){
        setDurability(durability);
    }

    protected void setDurability(int durability) {
        if (durability < 1 | durability > 5) {
            throw new IllegalArgumentException("Incorrect value for durability");
        } else {
            this.durability = durability;
        }
    }


    @Override
    public int destroy(int damage){
        if(!isBroken()){
            durability -= damage;
        }
        return durability;
    }


    @Override
    public boolean isBroken(){
        return durability <= 0;
    }
}
