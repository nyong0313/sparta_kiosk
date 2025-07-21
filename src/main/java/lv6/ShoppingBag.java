package lv6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingBag {
    private final List<ShoppingItem> shoppingItems = new ArrayList<>();

    public void addShoppingItem(MenuItem menuItem) {
        ShoppingItem shoppingItem = new ShoppingItem(menuItem);
        shoppingItems.stream()
                .filter(item -> item.getMenuItem().equals(menuItem))
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

    public void order(){
        if (shoppingItems.isEmpty()) throw new IllegalStateException("장바구니가 비어 있어 주문을 할 수 없습니다.");

        System.out.println("\n아래와 같이 주문 하시겠습니까?\n\n" +
                "[ Orders ]");
        shoppingItems.stream()
                .forEach(item -> {
                    System.out.printf("%-14s | ₩ %4.1f | %2d(개)\n",
                            item.getMenuItem().getName(),
                            item.getPrice(),
                            item.getQty());});

        System.out.println("\n[ Total ]");
        System.out.printf("₩ %4.1f\n", getTotalPrice());

        System.out.println("\n1. 주문      2. 메뉴판");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1) {
            System.out.printf("주문이 완료되었습니다. 금액은 ₩ %4.1f입니다.\n", getTotalPrice());
            shoppingItems.clear();
        }
    }

    public void clear() {
        if (shoppingItems.isEmpty()) throw new IllegalStateException("장바구니가 비어 있어 주문을 취소할 수 없습니다.");

        shoppingItems.clear();
        System.out.println("모든 주문이 취소되었습니다.");
    }
}
