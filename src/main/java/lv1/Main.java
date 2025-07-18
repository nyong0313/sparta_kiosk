package lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kiosk kiosk = new Kiosk();

        while(true){
            kiosk.showMenu();
            int choice = sc.nextInt();
            if(choice == 0){
                break;
            }
        }
        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}
