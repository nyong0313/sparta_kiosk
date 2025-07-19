package lv6;

import java.util.Scanner;

public class Kiosk {
    private final Menu menu;
    private final ShoppingBag shoppingBag = new ShoppingBag();
    public Kiosk(Menu menu) {
        this.menu = menu;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while(true){
            menu.showMenu();
            int choice = sc.nextInt();
            try{
                if(choice == 0) break;
                MenuItem menuItem = menu.selectedMenu(choice);
                System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                        "1. 확인        2. 취소");

                choice = sc.nextInt();
                if(choice == 1) {
                    shoppingBag.addShoppingItem(menuItem);
                }
            } catch(IllegalArgumentException e){
                System.out.println("유효하지 않은 입력입니다.");
                break;
            }
        }
    }

}