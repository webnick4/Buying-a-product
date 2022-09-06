package lesson19.service.impl;

import lesson19.service.Operation;
import lesson19.enums.Measure;
import lesson19.enums.ProductCategory;
import lesson19.models.*;

public class OperationImpl implements Operation {

    Sugar sugar = new Sugar("Сахар", 45, Measure.KG, ProductCategory.FORTEA);
    Milk milk = new Milk("Молоко", 65, Measure.LITER, ProductCategory.MILK);

    Product[] products = {sugar, milk};

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
    public Cashier getCashier(String name) {
        return null;
    }

    @Override
    public Receipt getReceipt(Order order) {
        return null;
    }
}
