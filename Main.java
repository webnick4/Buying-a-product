package lesson19;

import lesson19.models.*;
import lesson19.service.Operation;
import lesson19.service.impl.OperationImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Operation operation = new OperationImpl();

        System.out.println("Добро пожаловать!");
        Details[] details = new Details[10];
        int counter = 0;

        while (true) {

            System.out.println("Выберите категорию продукта");
            operation.getCategories();
            String category = scanner.next();

            Product[] products = operation.getProductByCategory(category);
            for (Product product : products) {
                if (product != null) {
                    product.getInfo();
                }
            }

            System.out.println("Введите продукт");
            String productName = scanner.next();
            Product product = operation.getProductByName(productName);

            System.out.println("Введите количество продукта");
            double amount = scanner.nextDouble();

            System.out.println("Введите скидку");
            double discount = scanner.nextDouble();

            details[counter] = new Details(product, amount, discount);


            counter++;

            System.out.println("Продолжить покупку? Y/N");
            String answer = scanner.next();
            if (answer.toUpperCase().equals("NO") || answer.toUpperCase().equals("N")) break;

            System.out.println();
        }

        System.out.println("Выбрали продукты:");
        for (Details item : details) {
            if (item != null) {
                System.out.println(item.getName().getName());
            }
        }

        System.out.println("\nВыберите кассира");
        String cashier = scanner.next();
        Cashier selectedCashier = operation.getCashierByName(cashier);

        Order order = new Order();
        order.setDetails(details);
        order.setCashier(selectedCashier);

        System.out.println();
        System.out.println("Ваш кассир: " + order.getCashier().getName());
        System.out.println("---------------------------------------");
        System.out.println("Продукт                      Цена      ");
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
        Receipt receipt = operation.getReceipt(order);
        for (ReceiptDetails item : receipt.getReceiptDetails()) {
            if (item != null) {
                System.out.println(item.getProductName() + "                       " + item.getSum());
            }
        }

        System.out.println("---------------------------------------");
        System.out.println("Общая сумма :                " + receipt.getTotalSum());
        System.out.println("Скидка :                     " + receipt.getTotalDiscount());
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
        System.out.println("Сумма к оплате :             " + (receipt.getTotalSum() - receipt.getTotalDiscount()));

    }
}
