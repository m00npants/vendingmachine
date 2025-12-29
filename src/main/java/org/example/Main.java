package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
     static void main() {

        VendingMachineImpl machine = new VendingMachineImpl();

        machine.addProduct(new Snack(1, "Chips", 20, 5));
        machine.addProduct(new Beverage(2, "Cola", 15, 4));
        machine.addProduct(new Fruit(3, "Apple", 10, 6));

        ConsoleUI ui = new ConsoleUI(machine);
        ui.start();
    }
}

