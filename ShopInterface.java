import java.util.List;

public interface ShopInterface {
    void addProduct(Product product);
    List<Product> getAllProducts();
    List<Product> filterProducts(List<ProductFilter> filters);
}