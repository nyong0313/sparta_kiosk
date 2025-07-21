package lv7;

import java.util.List;

public class Menu {
    private final List<MenuItem> menuItems;

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

    public MenuItem selectedMenu(int num) {
        MenuItem menuItem = menuItems.stream()
                .filter(item -> item.getId() == num)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 메뉴가 없습니다."));

        System.out.printf("선택한 메뉴: %-14s | ₩ %4.1f | %s\n",
                menuItem.getName(),
                menuItem.getPrice(),
                menuItem.getDescription());

        return menuItem;
    }
}
