package lv7;

public class ShoppingItem {
    private final MenuItem menuItem;
    private int qty = 0;
    private final double price;

    public ShoppingItem(MenuItem menuItem) {
        this.menuItem = menuItem;
        this.qty += 1;
        this.price = menuItem.getPrice();
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }
    public int getQty() {
        return qty;
    }
    public double getPrice() {
        return price;
    }

    public void plusQty() {
        this.qty += 1;
    }
}
