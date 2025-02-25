import java.util.List;

public class ShopManager {
    private Shop shop;

    public ShopManager(Shop shop) {
        this.shop = shop;
    }

    public void addProduct(Product product) {
        shop.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return shop.getAllProducts();
    }

    public List<Product> filterProducts(List<ProductFilter> filters) {
        return shop.filterProducts(filters);
    }
}