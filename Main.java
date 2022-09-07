package lesson19;

import lesson19.models.Cashier;
import lesson19.models.Details;
import lesson19.models.Order;
import lesson19.models.Product;
import lesson19.service.Operation;
import lesson19.service.impl.OperationImpl;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Operation operation = new OperationImpl();

        System.out.println("Добро пожаловать!");
        Details[] details = new Details[100];
        int counter = 0;

        while (true) {

            System.out.println("Выберите категорию продукта");
            operation.getCategories();
            String category = scanner.next();

            Product[] products = operation.getProductByCategory(category);
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product.getName());
                }
            }

            System.out.println("Введите продукт");
            String productName = scanner.next();

            System.out.println("Введите количество продукта");
            double amount = scanner.nextDouble();

            System.out.println("Введите скидку");
            double discount = scanner.nextDouble();


            for (Product product : products) {
                if (product == null) break;

                if (product.getName().equals(productName)){
                     details[counter] = new Details(product,amount, discount);
                }
            }


            System.out.println(Arrays.toString(details));


            counter++;

            System.out.println("Продолжить покупку? Y/N");
            String answer = scanner.next();
            if (answer.toUpperCase().equals("NO") || answer.toUpperCase().equals("N")) break;

            System.out.println();
        }


//        Cashier cashier = new Cashier();
//        operation.getReceipt(new Order(cashier, details));

    }
}
