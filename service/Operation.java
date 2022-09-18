package lesson19.service;

import lesson19.exceptions.MyException;
import lesson19.models.Cashier;
import lesson19.models.Order;
import lesson19.models.Product;
import lesson19.models.Receipt;

public interface Operation {
    Receipt getReceipt(Order order);

    void printExistCashiers();

    Cashier getCashierByName(String name);

    Product[] getProductByCategory(String productCategory);

    void getCategories();

    Product getProductByName(String productName);
}
