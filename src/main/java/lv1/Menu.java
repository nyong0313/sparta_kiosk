package lv1;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuItem> menuItems = new ArrayList<>();

    MenuItem menuItem1 = new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
    MenuItem menuItem2 = new MenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
    MenuItem menuItem3 = new MenuItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
    MenuItem menuItem4 = new MenuItem(4, "Hamburger", 5.4,  "비프패티를 기반으로 야채가 들어간 기본버거");

    public Menu() {
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        menuItems.add(menuItem3);
        menuItems.add(menuItem4);
    }

    public List<MenuItem> getMenuList() {
        return menuItems;
    }
}
