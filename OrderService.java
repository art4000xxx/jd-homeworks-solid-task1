import java.util.List;

public class OrderService {

    public Order createOrder(List<Product> items, String customerName, String customerAddress) {
        return new Order(items, customerName, customerAddress);
    }
}