import java.util.List;
import java.util.ArrayList;

public class Shop implements ShopInterface {
    private List<Product> products;

    public Shop() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(this.products);
    }

    public List<Product> filterProducts(List<ProductFilter> filters) {
        List<Product> filteredProducts = new ArrayList<>(this.products);
        for (ProductFilter filter : filters) {
            filteredProducts = filter.filter(filteredProducts);
        }
        return filteredProducts;
    }
}