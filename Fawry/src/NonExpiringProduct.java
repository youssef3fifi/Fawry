public abstract class NonExpiringProduct extends Product {

    public NonExpiringProduct(String name, double price, int availableQuantity) {
        super(name, price, availableQuantity);
    }

    @Override
    public boolean isExpirable() {
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}   