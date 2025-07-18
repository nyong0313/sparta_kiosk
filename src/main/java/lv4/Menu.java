package lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuItem> menuItems = new ArrayList<>();

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<MenuItem> getMenuList() {
        return menuItems;
    }

    public void showMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        menuItems.stream()
                .forEach(item -> {
                    System.out.printf("%2d. %-14s | ₩ %4.1f | %s\n",
                            item.getId(),
                            item.getName(),
                            item.getPrice(),
                            item.getDescription());});
        System.out.println(" 0. 뒤로가기");
    };

    public void selectedMenu(int num) {
        menuItems.stream()
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
}
