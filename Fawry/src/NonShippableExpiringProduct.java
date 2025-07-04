import java.time.LocalDate;

public class NonShippableExpiringProduct extends ExpiringProduct {

    public NonShippableExpiringProduct(String name, double price, int availableQuantity, LocalDate expiryDate) {
        super(name, price, availableQuantity, expiryDate);
    }

    @Override
    public boolean isShippable() {
        return false;
    }
}