package org.example;

public interface IVendingMachine {
    void insertCoin(int coin);
    int getBalance();
    Product purchaseProduct(int productId);
    int returnChange();
    List<Product> getProducts();
}

