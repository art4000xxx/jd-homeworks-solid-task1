import java.util.List;
import java.util.stream.Collectors;

public class KeywordProductFilter implements ProductFilter {
    private String keyword;

    public KeywordProductFilter(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                        product.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}