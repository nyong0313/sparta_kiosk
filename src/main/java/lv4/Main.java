package lv4;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu burgersMenu = new Menu(List.of(
                new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem(4, "Hamburger", 5.4,  "비프패티를 기반으로 야채가 들어간 기본버거")
        ));
        Menu drinksMenu = new Menu(List.of(
                new MenuItem(1, "CokaCola", 2.5, "코카콜라"),
                new MenuItem(2, "Pepsi", 2.5, "펩시콜라")
        ));
        Menu dessertsMenu = new Menu(List.of(
                new MenuItem(1, "FrenchFries", 3.5, "감자튀김"),
                new MenuItem(2, "Cheeseball", 5.0, "치즈볼~~")
        ));

        Kiosk bugersKiosk = new Kiosk(burgersMenu);
        Kiosk drinksKiosk = new Kiosk(drinksMenu);
        Kiosk dessertsKiosk = new Kiosk(dessertsMenu);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("[ MAIN MENU ]\n" +
                    "1. Burgers\n" +
                    "2. Drinks\n" +
                    "3. Desserts\n" +
                    "0. 종료      | 종료");
            int choice = sc.nextInt();
            if (choice == 1) {
                bugersKiosk.start();
            }
            else if (choice == 2) {
                drinksKiosk.start();
            }
            else if (choice == 3) {
                dessertsKiosk.start();
            }
            else {
                break;
            }
        }

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}
