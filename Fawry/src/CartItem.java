public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity > product.getAvailableQuantity()) {
            throw new IllegalArgumentException("Cannot add more than available quantity");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {

        return product;
    }

    public int getQuantity() {

        return quantity;
    }

    public double getTotalPrice() {

        return product.getPrice() * quantity;
    }
}