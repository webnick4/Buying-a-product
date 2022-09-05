package lesson19.models;

import lesson19.enums.Measure;
import lesson19.enums.ProductCategory;

public class Sugar extends Product {
    public Sugar(String name, double cost, Measure measure, ProductCategory productCategory) {
        super(name, cost, measure, productCategory);
    }
}
