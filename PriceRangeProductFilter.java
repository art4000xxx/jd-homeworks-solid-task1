import java.util.List;
import java.util.stream.Collectors;

public class PriceRangeProductFilter implements ProductFilter {
    private double minPrice;
    private double maxPrice;

    public PriceRangeProductFilter(double minPrice, double maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        return products.stream()
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}