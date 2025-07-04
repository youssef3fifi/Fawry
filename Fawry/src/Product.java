public abstract class Product {
    private String name;
    private double price;
    private int availableQuantity;

    public Product(String name, double price, int availableQuantity) {
        this.name = name;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void decreaseQuantity(int quantity) {
        if (quantity > availableQuantity) {
            throw new IllegalArgumentException("Not enough quantity available");
        }
        availableQuantity -= quantity;
    }

    public abstract boolean isShippable();

    public abstract boolean isExpirable();

    public abstract boolean isExpired();
}