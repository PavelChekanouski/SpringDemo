package chekanouski.pavel.service.ProductsWithNumbers;

import chekanouski.pavel.entity.Product;
import chekanouski.pavel.dto.ProductWithNumbers;
import chekanouski.pavel.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProductWithNumbersServiceImpl implements ProductWithNumbersService {

    private final ProductRepository productRepository;

    public ProductWithNumbersServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Set<ProductWithNumbers> getSetOfProductsWithNumbers() {

        ArrayList<Product> products = (ArrayList<Product>) productRepository.findAll();

        HashMap<String, ProductWithNumbers> map = new HashMap<>();

        for (Product product : products) {
            String name = product.getName();
            if (map.containsKey(name.toLowerCase())) {
                if (Character.isLowerCase(name.charAt(0))) {
                    map.replace(name.toLowerCase(), new ProductWithNumbers(name.toLowerCase(), map.get(name.toLowerCase()).getNumberOfWordsWithCapitalLetter() + 1, map.get(name.toLowerCase()).getNumberOfWordsWithSmallLetter()));
                } else
                    map.replace(name.toLowerCase(), new ProductWithNumbers(name.toLowerCase(), map.get(name.toLowerCase()).getNumberOfWordsWithCapitalLetter(), map.get(name.toLowerCase()).getNumberOfWordsWithSmallLetter() + 1));
            } else if (Character.isLowerCase(name.charAt(0))) {
                map.put(name.toLowerCase(), new ProductWithNumbers(name.toLowerCase(), 1, 0));
            } else map.put(name.toLowerCase(), new ProductWithNumbers(name.toLowerCase(), 0, 1));
        }

        return new HashSet<>(map.values());
    }
}
