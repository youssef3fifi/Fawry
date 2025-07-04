import java.time.LocalDate;

public class ShippableExpiringProduct extends ExpiringProduct implements Shippable {
    private double weight; // in grams

    public ShippableExpiringProduct(String name, double price, int availableQuantity, LocalDate expiryDate, double weight) {
        super(name, price, availableQuantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}