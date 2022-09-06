package lesson19.enums;

public enum ProductCategory {
    MILK(1),
    FRUIT(2),
    VEGETABLES(3),
    DRINKABLES(4),
    FORTEA(5),
    MEAT(6);

    private final int val;

    ProductCategory(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
