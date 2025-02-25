import java.util.List;

public class Order {
    private List<Product> items;
    private String customerName;
    private String customerAddress;
    private String orderStatus;

    public Order(List<Product> items, String customerName, String customerAddress) {
        this.items = items;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderStatus = "Принят"; // По умолчанию статус "Принят"
    }

    public List<Product> getItems() {
        return items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}