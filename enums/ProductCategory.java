package lesson19.enums;

public enum ProductCategory {
    MILK("Молочные продукты", 1),
    FRUIT("Фрукты", 2),
    VEGETABLES("Овощи", 3),
    DRINKABLES("Напитки", 4),
    FORTEA("К чаю", 5),
    MEAT("Мясное", 6);

    private final String name;
    private final int number;

    ProductCategory(String name, int number) {
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
