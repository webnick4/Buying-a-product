package lesson19.service;

import lesson19.enums.ProductCategory;
import lesson19.models.Cashier;
import lesson19.models.Order;
import lesson19.models.Product;
import lesson19.models.Receipt;

public interface Operation {
    Receipt getReceipt(Order order);

    Cashier getCashier(String name);

    Product[] getProductByCategory(ProductCategory productCategory);

    ProductCategory[] getCategories();
}
