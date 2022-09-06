package lesson19;

import lesson19.models.Product;
import lesson19.service.impl.OperationImpl;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        OperationImpl operation = new OperationImpl();

        System.out.println("Добро пожаловать!");
        System.out.println("Выберите категорию продукта");

        operation.getCategories();

        String category = scanner.next();

        Product[] products = operation.getProductByCategory(category);
        System.out.println(Arrays.toString(products));


    }
}
