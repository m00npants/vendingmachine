package org.example;

package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for VendingMachineImpl.
 *
 * These tests verify:
 * - Coin validation
 * - Balance updates
 * - Purchase rules
 * - Stock reduction
 * - Change return
 */
public class VendingMachineTests {

    private VendingMachineImpl machine;
    private Product snack;

    @BeforeEach
    void setup() {
        machine = new VendingMachineImpl();
        snack = new Snack(1, "Chips", 20, 3);
        machine.addProduct(snack);
    }

    @Test
    void testInsertValidCoin() {
        machine.insertCoin(10);
        assertEquals(10, machine.getBalance());
    }

    @Test
    void testRejectInvalidCoin() {
        machine.insertCoin(7);
        assertEquals(0, machine.getBalance());
    }

    @Test
    void testPurchaseSuccess() {
        machine.insertCoin(20);
        Product result = machine.purchaseProduct(1);

        assertNotNull(result);
        assertEquals(0, machine.getBalance());
        assertEquals(2, snack.getQuantity());
    }

    @Test
    void testPurchaseInsufficientBalance() {
        machine.insertCoin(10);
        Product result = machine.purchaseProduct(1);

        assertNull(result);
        assertEquals(10, machine.getBalance());
        assertEquals(3, snack.getQuantity());
    }

    @Test
    void testPurchaseOutOfStock() {
        snack.reduceQuantity();
        snack.reduceQuantity();
        snack.reduceQuantity(); // now quantity = 0

        machine.insertCoin(50);
        Product result = machine.purchaseProduct(1);

        assertNull(result);
        assertEquals(50, machine.getBalance());
        assertEquals(0, snack.getQuantity());
    }

    @Test
    void testReturnChange() {
        machine.insertCoin(50);
        int change = machine.returnChange();

        assertEquals(50, change);
        assertEquals(0, machine.getBalance());
    }

    @Test
    void testGetProducts() {
        assertEquals(1, machine.getProducts().size());
    }
}