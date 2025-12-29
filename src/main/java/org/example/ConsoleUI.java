package org.example;

import java.util.Scanner;


public class ConsoleUI {

    private final IVendingMachine machine;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(IVendingMachine machine) {
        this.machine = machine;
    }

    public void start() {
        while (true) {
            System.out.println("\n--- Vending Machine ---");
            System.out.println("1. View products");
            System.out.println("2. Insert coin");
            System.out.println("3. Purchase product");
            System.out.println("4. Return change");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showProducts();
                case 2 -> insertCoin();
                case 3 -> purchase();
                case 4 -> returnChange();
                case 5 -> { return; }
            }
        }
    }

    private void showProducts() {
        for (Product p : machine.getProducts()) {
            System.out.println(p.getId() + ": " + p.getDescription() +
                    " | Price: " + p.getPrice() +
                    " | Qty: " + p.getQuantity());
        }
    }

    private void insertCoin() {
        System.out.print("Insert coin: ");
        machine.insertCoin(scanner.nextInt());
        System.out.println("Balance: " + machine.getBalance());
    }

    private void purchase() {
        System.out.print("Enter product ID: ");
        Product p = machine.purchaseProduct(scanner.nextInt());
        System.out.println(p == null ? "Purchase failed" : "Purchased: " + p.getName());
    }

    private void returnChange() {
        System.out.println("Returned: " + machine.returnChange());
    }
}

