package chekanouski.pavel.service.ProductWithNumbers;

import chekanouski.pavel.dto.ProductWithNumbers;
import chekanouski.pavel.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductWithNumbersBySQLServiceImpl implements ProductWithNumbersService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Set<ProductWithNumbers> getSetOfProductsWithNumbers(){

        List<Object[]> products = productRepository.getDistinctWithNumber();

        Map<String, Long> productMap = new HashMap<>();

        Set<ProductWithNumbers> set = new HashSet<>();

        for (Object[] row : products){
            productMap.put((String) row[0], (Long) row[1]);
        }

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
