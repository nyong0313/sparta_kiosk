package lv7;

public enum Person {
    VETERAN(0.90),
    SOLDIER(0.95),
    STUDENT(0.97),
    REGULAR(1.00);

    public final double discountRate;
    Person(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public static Person fromPerson(int choice) {
        return switch (choice) {
            case 1 -> VETERAN;
            case 2 -> SOLDIER;
            case 3 -> STUDENT;
            case 4 -> REGULAR;
            default -> throw new IllegalArgumentException("잘못된 할인 유형입니다.");
        };
    }
}
