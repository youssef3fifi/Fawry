import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (quantity > product.getAvailableQuantity()) {
            throw new IllegalArgumentException("Not enough quantity available for " + product.getName());
        }

        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}