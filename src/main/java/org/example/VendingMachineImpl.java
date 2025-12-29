package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VendingMachineImpl implements IVendingMachine {

    private final List<Product> products = new ArrayList<>();

    /** Current balance inserted by the user */
    private int balance = 0;

    private static final Set<Integer> VALID_COINS = Set.of(1, 2, 5, 10, 20, 50);

 /** Adds a product to the vending machine.*/
    public void addProduct(Product product) {
        products.add(product);
    }
    /**
     * Inserts a coin into the vending machine.
     */
    @Override
    public void insertCoin(int coin) {
        if (VALID_COINS.contains(coin)) {
            balance += coin;
        }
    }
    /**
     * Returns the current balance.
     */
    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public Product purchaseProduct(int productId) {
        for (Product p : products) {
            if (p.getId() == productId) {

                if (p.getQuantity() <= 0) return null;
                if (balance < p.getPrice()) return null;

                balance -= p.getPrice();
                p.reduceQuantity();
                return p;
            }
        }
        return null;
    }
/**returns the remaining balance as change and resets the balance to zero.*/
    @Override
    public int returnChange() {
        int change = balance;
        balance = 0;
        return change;
    }
/**returns a list of all products in the vending machine.*/
    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}



