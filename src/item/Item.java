package item;

public class Item implements Thing{
    protected int count;
    protected boolean flag = false;

    protected Item(int count) {
        this.setCount(count);
    }

    protected void setCount(int count) {
        if (count < 1 | count > 5) {
            throw new IllegalArgumentException("Incorrect value for amount");
        } else this.count = count;
    }


    @Override
    public int use() {
        if(!isUsed()){
            flag = true;
            return count;
        }else {
            return 0;
        }
    }

    @Override
    public boolean isUsed() {
        return flag;
    }
}
