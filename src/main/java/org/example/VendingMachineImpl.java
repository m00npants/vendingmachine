package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VendingMachineImpl implements IVendingMachine {

    private final List<Product> products = new ArrayList<>();
    private int balance = 0;

    private static final Set<Integer> VALID_COINS = Set.of(1, 2, 5, 10, 20, 50);

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void insertCoin(int coin) {
        if (VALID_COINS.contains(coin)) {
            balance += coin;
        }
    }

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

    @Override
    public int returnChange() {
        int change = balance;
        balance = 0;
        return change;
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}



