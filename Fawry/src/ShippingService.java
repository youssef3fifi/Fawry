import java.util.List;

public class ShippingService {
    private static final double SHIPPING_RATE_PER_KG = 30.0;

    public static void shipItems(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (Shippable item : items) {
            if (item instanceof CartItem) {
                CartItem cartItem = (CartItem) item;
                System.out.printf("%dx %-15s %dg%n",
                        cartItem.getQuantity(),
                        cartItem.getProduct().getName(),
                        (int)(((Shippable)cartItem.getProduct()).getWeight() * cartItem.getQuantity()));
                totalWeight += ((Shippable)cartItem.getProduct()).getWeight() * cartItem.getQuantity();
            }
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeight / 1000.0);
    }

    public static double calculateShippingCost(List<Shippable> items) {
        double totalWeight = 0;
        for (Shippable item : items) {
            if (item instanceof CartItem) {
                CartItem cartItem = (CartItem) item;
                totalWeight += ((Shippable)cartItem.getProduct()).getWeight() * cartItem.getQuantity();
            }
        }

        return Math.ceil(totalWeight / 1000.0) * SHIPPING_RATE_PER_KG;
    }
}