package lesson19;

import lesson19.exceptions.MyException;
import lesson19.models.*;
import lesson19.service.Operation;
import lesson19.service.impl.OperationImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Operation operation = new OperationImpl();

        System.out.println("Добро пожаловать!");
        boolean isAdded = true;
        Details[] details = new Details[10];
        int counter = 0;

        while (true) {

            System.out.println("Выберите категорию продукта");
            operation.getCategories();
            String category = scanner.next();

            Product[] products;

            try {
                products = operation.getProductByCategory(category);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            
            isAdded = true;
            String productName;
            Product product = null;
            
            while (isAdded) {
                for (Product item : products) {
                    if (item != null) {
                        item.getInfo();
                    }
                }

                System.out.print("Выберите продукт: ");
                productName = scanner.next();
                product = operation.getProductByName(productName);

                if (product != null) {
                    isAdded = false;
                    continue;
                }
                System.out.println("\nВыберите продукт правильно");
            }


            System.out.println("\nВведите количество");
            double amount = scanner.nextDouble();

            System.out.println("\nВведите скидку");
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

        isAdded = true;
        String cashier;
        Cashier selectedCashier = null;
        
        while (isAdded) {
            try {
                System.out.println("\nВыберите кассира");
                operation.printExistCashiers();

                cashier = scanner.next();
                selectedCashier = operation.getCashierByName(cashier);

                if (selectedCashier == null) {
                    throw new MyException("\nВыберите кассира из списка");
                }
                
                isAdded = false;
            } catch (MyException e) {
                System.out.println(e.getMessage());                
            }
        }
        
        

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
