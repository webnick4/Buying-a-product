package lesson19.enums;

public enum Measure {
    KG("Килограмм", 1),
    LITER("Литр", 2),
    UNIT("Единиц", 3);

    private final String name;
    private final int number;

    Measure(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
