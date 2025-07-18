package lv1;

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

}