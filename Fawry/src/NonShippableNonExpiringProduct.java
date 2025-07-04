public class NonShippableNonExpiringProduct extends NonExpiringProduct {

    public NonShippableNonExpiringProduct(String name, double price, int availableQuantity) {
        super(name, price, availableQuantity);
    }

    @Override
    public boolean isShippable() {
        return false;
    }
}