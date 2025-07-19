package lv6;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBag {
    private final List<ShoppingItem> shoppingItems = new ArrayList<>();

    public void addShoppingItem(MenuItem menuItem) {
        ShoppingItem shoppingItem = new ShoppingItem(menuItem);
        shoppingItems.stream()
                .filter(item -> item.getMenuItem().getId() == menuItem.getId())
                .findFirst()
                .ifPresentOrElse(
                        item -> item.plusQty(),
                        () -> shoppingItems.add(shoppingItem)
                );
        System.out.println(menuItem.getName() + "이 장바구니에 추가되었습니다.");
    }

    public List<ShoppingItem> getShoppingItems() {
        return shoppingItems;
    }

    public double getTotalPrice() {
        return shoppingItems.stream()
                .mapToDouble(item -> item.getQty() * item.getPrice())
                .sum();
    }
}
