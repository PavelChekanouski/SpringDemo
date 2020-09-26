package chekanouski.pavel.service.ProductWithNumbers;

import chekanouski.pavel.dto.ProductWithNumbers;
import chekanouski.pavel.entity.Product;
import chekanouski.pavel.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductWithNumbersByJavaServiceImpl implements ProductWithNumbersService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Set<ProductWithNumbers> getSetOfProductsWithNumbers(){

        ArrayList<Product> products = (ArrayList<Product>) productRepository.findAll();

        Map<String, Long> productMap = products.stream().collect(Collectors.groupingBy(Product::getName, Collectors.counting()));

        HashSet<ProductWithNumbers> set = new HashSet<>();

        for(String key: productMap.keySet()){
            if(Character.isLowerCase(key.charAt(0))) {
                set.add(new ProductWithNumbers(key, productMap.getOrDefault(key.substring(0, 1).toUpperCase() + key.substring(1), 0L), productMap.getOrDefault(key, 0L)));
            } else {
                set.add(new ProductWithNumbers(key.toLowerCase(), productMap.getOrDefault(key, 0L), productMap.getOrDefault(key.toLowerCase(), 0L)));
            }
        }


        return set;
    }
}

