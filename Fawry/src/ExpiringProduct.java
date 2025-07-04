import java.time.LocalDate;

public abstract class ExpiringProduct extends Product {
    private LocalDate expiryDate;

    public ExpiringProduct(String name, double price, int availableQuantity, LocalDate expiryDate) {
        super(name, price, availableQuantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpirable() {
        return true;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}