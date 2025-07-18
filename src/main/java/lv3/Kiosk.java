package lv3;

import java.util.Optional;
import java.util.Scanner;

public class Kiosk {
    Menu menu =  new Menu();

    public void showMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        menu.getMenuList()
                .stream()
                .forEach(item -> {
                    System.out.printf("%2d. %-14s | ₩ %4.1f | %s\n",
                            item.getId(),
                            item.getName(),
                            item.getPrice(),
                            item.getDescription());});
        System.out.println(" 0. 종료            | 종료");
    };

    public void selectedMenu(int num) {
        menu.getMenuList()
                .stream()
                .filter(item -> item.getId() == num)
                .findFirst()
                .ifPresentOrElse(
                        item -> System.out.printf("%2d. %-14s | ₩ %4.1f | %s\n",
                                item.getId(),
                                item.getName(),
                                item.getPrice(),
                                item.getDescription()),
                        () -> {
                            throw new IllegalArgumentException();
                        }
                );
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while(true){
            showMenu();
            int choice = sc.nextInt();
            try{
                selectedMenu(choice);
            } catch(IllegalArgumentException e){
                System.out.println("유효하지 않은 입력입니다.");
                break;
            }
        }

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }

}