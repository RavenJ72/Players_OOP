package hero;

import item.Item;

public interface Inventory {
    public final int ITEMS = 5;
    public boolean put(Item item, int place);
    public boolean useItem(int place);
}
