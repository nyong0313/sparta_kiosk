package lv7;

public enum Person {
    VETERAN(1),
    SOLDIER(2),
    STUDENT(3),
    REGULAR(4);

    public final int number;
    Person(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static Person fromPerson(int number) {
        for (Person person : Person.values()) {
            if (person.number == number) return person;
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
