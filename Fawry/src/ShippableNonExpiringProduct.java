public class ShippableNonExpiringProduct extends NonExpiringProduct implements Shippable {
    private double weight; // in grams

    public ShippableNonExpiringProduct(String name, double price, int availableQuantity,double weight) {
        super(name, price, availableQuantity);
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