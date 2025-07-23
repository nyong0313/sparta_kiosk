package lv7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingBag {
    private final List<ShoppingItem> shoppingItems = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    // 해당 아이템을 장바구니에 추가
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
    // 장바구니 목록 반환
    public List<ShoppingItem> getShoppingItems() {
        return shoppingItems;
    }
    // 장바구니 내 모든 아이템 가격 총합
    public double getTotalPrice() {
        return shoppingItems.stream()
                .mapToDouble(item -> item.getQty() * item.getPrice())
                .sum();
    }
    // 주문
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
        double totalPrice = getTotalPrice();
        System.out.printf("₩ %4.1f\n", totalPrice);

        System.out.println("\n1. 주문      2. 메뉴판");
        int choice = sc.nextInt();
        if(choice == 1) {
            double finalPrice = applyDiscount(totalPrice);
            System.out.printf("주문이 완료되었습니다. 금액은 ₩ %4.1f입니다.\n", finalPrice);
            shoppingItems.clear();
        }
        else if(choice == 2) return;
        else throw new IllegalArgumentException("잘못된 입력입니다.");
    }
    // 주문 취소
    public void clear() {
        if (shoppingItems.isEmpty()) throw new IllegalStateException("장바구니가 비어 있어 주문을 취소할 수 없습니다.");

        shoppingItems.clear();
        System.out.println("모든 주문이 취소되었습니다.");
    }
    // 할인
    public double applyDiscount(double price) {
        System.out.println("할인 정보를 입력해주세요.\n" +
                "1. 국가유공자 : 10% \n" +
                "2. 군인     :  5%\n" +
                "3. 학생     :  3%\n" +
                "4. 일반     :  0%");
        int choice = sc.nextInt();
        Person person = Person.fromPerson(choice);
        return price * person.getDiscountRate();
    }
}
