````mermaid

classDiagram
class IVendingMachine {
<<interface>>
+ insertCoin(coin: int): void
+ getBalance(): int
+ purchaseProduct(productId: int): Product
+ returnChange(): int
+ getProducts(): List~Product~
}

    class Product {
        <<abstract>>
        - id: int
        - name: String
        - price: int
        - quantity: int
        + getDescription(): String
    }

    class Snack
    class Beverage
    class Fruit

    class VendingMachineImpl
    class ConsoleUI

    Product <|-- Snack
    Product <|-- Beverage
    Product <|-- Fruit
    IVendingMachine <|.. VendingMachineImpl
    VendingMachineImpl --> Product
    ConsoleUI ..> IVendingMachine
```