
import java.time.LocalDate;

public class ECommerceDemo {
    public static void main(String[] args) {
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

        try {
            // Match the requested input exactly
            cart.add(cheese, 2);
            // We need to add biscuits instead of TV to match the expected output
            cart.add(biscuits, 1);
            cart.add(scratchCard, 1);

            // Process checkout - using the static method
            checkout(customer, cart);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Adding a static checkout method to match the requested method call
    public static void checkout(Customer customer, ShoppingCart cart) {
        CheckoutService.checkout(customer, cart);
    }
}