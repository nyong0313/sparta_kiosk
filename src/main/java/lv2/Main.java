package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(4, "Hamburger", 5.4,  "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("[ SHAKESHACK MENU ]");
            for(MenuItem item : menuItems){
                System.out.printf("%2d. %-14s | ₩ %4.1f | %s\n",
                        item.getId(),
                        item.getName(),
                        item.getPrice(),
                        item.getDescription());
            }
            System.out.println(" 0. 종료            | 종료");

            int choice = sc.nextInt();
            Optional<MenuItem> choiceItem = menuItems.stream()
                    .filter(item -> item.getId() == choice)
                    .findFirst();
            if(choiceItem.isEmpty()) break;
            System.out.printf("%2d. %-14s | ₩ %4.1f | %s\n",
                    choiceItem.get().getId(),
                    choiceItem.get().getName(),
                    choiceItem.get().getPrice(),
                    choiceItem.get().getDescription());
        }
        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}
