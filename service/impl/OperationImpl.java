package lesson19.service.impl;

import lesson19.service.Operation;
import lesson19.enums.Measure;
import lesson19.enums.ProductCategory;
import lesson19.models.*;

public class OperationImpl implements Operation {

    Product sugar = new Sugar("Сахар", 45, Measure.KG, ProductCategory.FORTEA);
    Product milk = new Milk("Молоко", 65, Measure.LITER, ProductCategory.MILK);

    Product[] products = {sugar, milk};

    Cashier ludmila = new Cashier("Людмила", "user1", 18);
    Cashier galina = new Cashier("Галина", "user2", 23);

    Cashier[] cashiers = {ludmila, galina};

    @Override
    public void getCategories(){
        for (ProductCategory item : ProductCategory.values()) {
            System.out.println(item);
        }
    }

    @Override
    public Product[] getProductByCategory(String productCategory){
        Product[] result = new Product[100];
        int i = 0;

        for (Product product : products) {
            if (product.getProductCategory().equals(ProductCategory.valueOf(productCategory))) {
                result[i] = product;
                i++;
            }
        }
        return result;
    }

    @Override
    public Product getProductByName(String productName) {

        for (Product product : products) {
            if (product == null) break;

            if (product.getName().equals(productName)){
                return product;
            }
        }
        return null;
    }

    @Override
    public Cashier getCashierByName(String name) {
        for (Cashier cashier : cashiers) {
            if (cashier.getName().equals(name)) {
                return  cashier;
            }
        }
        return null;
    }

    @Override
    public Receipt getReceipt(Order order) {

        ReceiptDetails[] receiptDetails = new ReceiptDetails[10];
        double totalSum = 0;
        double totalDiscount = 0;
        int i = 0;

        Details[] details = order.getDetails();
        for (Details item : details) {
            if (item != null) {
                receiptDetails[i] = new ReceiptDetails(item.getName().getName(), item.getName().getCost());
                totalSum = item.getName().getCost() * item.getAmount();
                totalDiscount += item.getDiscount();
                i++;
            }

        }

        return new Receipt(totalSum, totalDiscount, receiptDetails);
    }


}

