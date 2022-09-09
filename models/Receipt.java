package lesson19.models;

public class Receipt {
    private double totalSum;
    private double totalDiscount;
    private ReceiptDetails[] receiptDetails;

    public Receipt(double totalSum, double totalDiscount, ReceiptDetails[] receiptDetails) {
        this.totalSum = totalSum;
        this.totalDiscount = totalDiscount;
        this.receiptDetails = receiptDetails;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public ReceiptDetails[] getReceiptDetails() {
        return receiptDetails;
    }

    public void setReceiptDetails(ReceiptDetails[] receiptDetails) {
        this.receiptDetails = receiptDetails;
    }
}
