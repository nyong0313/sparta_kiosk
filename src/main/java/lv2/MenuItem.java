package lv2;

public class MenuItem {
    int id;
    String name;
    double price;
    String description;

    public MenuItem(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    int getId() {
        return id;
    }
    String getName() {
        return name;
    }
    double getPrice() {
        return price;
    }
    String getDescription() {
        return description;
    }
}
