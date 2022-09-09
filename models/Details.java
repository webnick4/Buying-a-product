package lesson19.models;

public class Details {
    private Product name;
    private double amount;
    private double discount;

    public Details(Product name, double amount, double discount){
        this.name = name;
        this.amount = amount;
        this.discount = discount;
    }

    public Product getName() {
        return name;
    }

    public void setName(Product name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
