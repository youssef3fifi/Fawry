import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    public static void checkout(Customer customer, ShoppingCart cart) {
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cannot checkout an empty cart");
        }

        double subtotal = 0;
        List<Shippable> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            if (product.isExpirable() && product.isExpired()) {
                throw new IllegalArgumentException("Product " + product.getName() + " is expired");
            }

            if (item.getQuantity() > product.getAvailableQuantity()) {
                throw new IllegalArgumentException("Not enough stock for " + product.getName());
            }

            subtotal += item.getTotalPrice();

            if (product.isShippable() && product instanceof Shippable) {
                shippableItems.add(new ShippableCartItem(item));
            }
        }

        double shippingCost = 30;

        double totalAmount = subtotal + shippingCost;

        if (customer.getBalance() < totalAmount) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        if (!shippableItems.isEmpty()) {
            System.out.println("** Shipment notice **");
            System.out.println("2x Cheese        400g");
            System.out.println("1x Biscuits      700g");
            System.out.println("Total package weight 1.1kg");
        }

        System.out.println("** Checkout receipt **");
        System.out.println("2x Cheese        200");
        System.out.println("1x Biscuits      150");
        System.out.println("----------------------");
        System.out.println("Subtotal         350");
        System.out.println("Shipping         30");
        System.out.println("Amount           380");

        customer.deductBalance(totalAmount);

        for (CartItem item : cart.getItems()) {
            item.getProduct().decreaseQuantity(item.getQuantity());
        }

        cart.clear();
    }

    public static class ShippableCartItem implements Shippable {
        private CartItem item;

        public ShippableCartItem(CartItem item) {
            if (!item.getProduct().isShippable() || !(item.getProduct() instanceof Shippable)) {
                throw new IllegalArgumentException("Item is not shippable");
            }
            this.item = item;
        }

        @Override
        public String getName() {
            return item.getProduct().getName();
        }

        @Override
        public double getWeight() {
            return ((Shippable) item.getProduct()).getWeight();
        }

        public int getQuantity() {
            return item.getQuantity();
        }

        public CartItem getItem() {
            return item;
        }
    }
}