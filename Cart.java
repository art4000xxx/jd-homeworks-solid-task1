import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        this.items.add(product);
    }

    public void removeItem(Product product) {
        this.items.remove(product);
    }

    public List<Product> getItems() {
        return new ArrayList<>(this.items); // Возвращаем копию списка
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}