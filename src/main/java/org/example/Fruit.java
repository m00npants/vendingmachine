package org.example;

/**
 * Represents a fruit product
 */

public class Fruit extends Product {
    public Fruit(int id, String name, int price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    public String getDescription() {
        return "Fruit: " + getName() + ", Price: " + getPrice() + ", Quantity: " + getQuantity();
    }
}

