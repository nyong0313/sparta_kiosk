package lv4;

import java.util.Scanner;

public class Kiosk {
    Menu menu;
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
                menu.selectedMenu(choice);
            } catch(IllegalArgumentException e){
                System.out.println("유효하지 않은 입력입니다.");
                break;
            }
        }
    }

}