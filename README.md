# Fawry
# E-Commerce System

**Author:** youssef3fifi  
**Date:** 2025-07-04

## Overview

This e-commerce system is a Java implementation that allows users to manage products, shopping carts, and checkout processes. It features a robust product hierarchy with support for expiring and non-expiring products, as well as shippable and non-shippable items.

## Features

- **Product Management**:
  - Define products with name, price, and quantity
  - Support for products that expire (e.g., Cheese, Biscuits)
  - Support for products that don't expire (e.g., TV, Mobile)
  - Support for products that require shipping with weight tracking
  - Support for products that don't require shipping (e.g., Scratch Cards)

- **Shopping Cart**:
  - Add products to cart with quantity validation
  - Prevent adding more than available stock

- **Checkout Process**:
  - Calculate order subtotal (sum of all items' prices)
  - Calculate shipping fees based on item weights
  - Calculate total paid amount (subtotal + shipping fees)
  - Track customer balance after payment
  - Handle shipping for products that require it

- **Error Handling**:
  - Empty cart validation
  - Insufficient balance checking
  - Product expiration validation
  - Out-of-stock validation

## System Architecture

### Class Hierarchy

```
Product (abstract)
├── ExpiringProduct (abstract)
│   ├── ShippableExpiringProduct
│   └── NonShippableExpiringProduct
└── NonExpiringProduct (abstract)
    ├── ShippableNonExpiringProduct
    └── NonShippableNonExpiringProduct

Shippable (interface)
├── ShippableExpiringProduct
└── ShippableNonExpiringProduct
```

### Component Overview

- **Product Classes**: Base and specialized classes for different product types
- **Customer**: Manages customer information and balance
- **CartItem**: Associates a product with a quantity in the cart
- **ShoppingCart**: Manages a collection of cart items
- **ShippingService**: Handles shipping calculations and notifications
- **CheckoutService**: Processes the entire checkout workflow

## Setup and Usage

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, etc.) or command-line compiler

### Compilation

To compile the project from the command line:

```bash
javac *.java
```

### Running the Demo

```bash
java ECommerceDemo
```

### Example Usage

```java
// Create products
ShippableExpiringProduct cheese = new ShippableExpiringProduct(
    "Cheese", 100, 10, LocalDate.now().plusDays(30), 200); // 200g per unit
    
ShippableExpiringProduct biscuits = new ShippableExpiringProduct(
    "Biscuits", 150, 20, LocalDate.now().plusDays(90), 700); // 700g per unit
    
ShippableNonExpiringProduct tv = new ShippableNonExpiringProduct(
    "TV", 5000, 5, 8000); // 8kg per unit
    
NonShippableNonExpiringProduct scratchCard = new NonShippableNonExpiringProduct(
    "Scratch Card", 50, 100);

// Create a customer with balance
Customer customer = new Customer("John", 1000);

// Create shopping cart
ShoppingCart cart = new ShoppingCart();

// Add items to cart
cart.add(cheese, 2); 
cart.add(biscuits, 1);
cart.add(scratchCard, 1);

// Checkout
checkout(customer, cart);
```

### Expected Output

```
** Shipment notice **
2x Cheese        400g
1x Biscuits      700g
Total package weight 1.1kg
** Checkout receipt **
2x Cheese        200
1x Biscuits      150
----------------------
Subtotal         350
Shipping         30
Amount           380
```

## Design Decisions and Assumptions

1. **Product Hierarchy**: Used inheritance to model different product types, with abstract classes defining common behaviors.

2. **Shippable Interface**: Created a separate interface for shippable products to support the shipping service requirements.

3. **Error Handling**: Used exceptions to handle error conditions like insufficient stock, expired products, and insufficient balance.

4. **Shipping Calculations**: 
   - Weight is stored in grams for precision
   - Shipping cost is calculated at a rate of 30 per kilogram
   - Total weight is converted to kilograms for shipping notice display

5. **Date Handling**: Used Java's LocalDate for managing expiry dates and determining if products are expired.

## Extensions and Future Work

1. **Persistence**: Add database integration for storing products, customers, and orders.

2. **User Interface**: Create a graphical or web-based interface for the system.

3. **Authentication**: Add user authentication and authorization.

4. **Order History**: Implement tracking of past orders for customers.

5. **Discounts and Promotions**: Add support for various pricing strategies.

6. **Advanced Shipping**: Implement more sophisticated shipping calculations based on distance, zones, etc.

7. **Product Search**: Add functionality to search and filter products.

## License

This project is available for educational purposes.
