package lv7;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu burgersMenu = createBurgersMenu();
        Menu drinksMenu =  createDrinksMenu();
        Menu dessertsMenu =  createDessertsMenu();

        ShoppingBag shoppingBag = new ShoppingBag();

        Kiosk burgersKiosk = new Kiosk(burgersMenu, shoppingBag);
        Kiosk drinksKiosk = new Kiosk(drinksMenu, shoppingBag);
        Kiosk dessertsKiosk = new Kiosk(dessertsMenu, shoppingBag);

        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                printMainMenu();
                if (!shoppingBag.getShoppingItems().isEmpty()) {
                    printOrderMenu();
                }

                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> burgersKiosk.start();
                    case 2 -> drinksKiosk.start();
                    case 3 -> dessertsKiosk.start();
                    case 4 -> shoppingBag.order();
                    case 5 -> shoppingBag.clear();
                    case 0 -> {
                        System.out.println("프로그램을 종료합니다.");
                        sc.close();
                        return;
                    }
                    default -> throw new IllegalArgumentException("⚠️ 잘못된 입력입니다. 0~5 중에서 선택해주세요.");
                }
            }
            catch (RuntimeException e) {
                System.out.println(e.getMessage());
                sc.nextLine(); // 버퍼 클리어 !!
            }
        }
    }

    private static Menu createBurgersMenu() {
        return new Menu(List.of(
                new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem(4, "Hamburger", 5.4,  "비프패티를 기반으로 야채가 들어간 기본버거")
        ));
    }

    private static Menu createDrinksMenu() {
        return new Menu(List.of(
                new MenuItem(1, "CokaCola", 2.5, "코카콜라"),
                new MenuItem(2, "Pepsi", 2.5, "펩시콜라")
        ));
    }

    private static Menu createDessertsMenu() {
        return new Menu(List.of(
                new MenuItem(1, "FrenchFries", 3.5, "감자튀김"),
                new MenuItem(2, "Cheeseball", 5.0, "치즈볼~~")
        ));
    }

    private static void printMainMenu() {
        System.out.println("\n아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println("[ MAIN MENU ]\n" +
                "1. Burgers\n" +
                "2. Drinks\n" +
                "3. Desserts\n" +
                "0. 종료      | 종료");
    }

    private static void printOrderMenu() {
        System.out.println("\n[ ORDER MENU ]\n" +
                "4. Orders       | 장바구니를 확인 후 주문합니다.\n" +
                "5. Cancel       | 진행중인 주문을 취소합니다.");
    }
}
