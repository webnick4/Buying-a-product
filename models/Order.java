package lesson19.models;

public class Order {
    private Cashier cashier;
    private Details[] details;

    public Order(Cashier cashier, Details[] details) {
        this.cashier = cashier;
        this.details = details;
    }
}
