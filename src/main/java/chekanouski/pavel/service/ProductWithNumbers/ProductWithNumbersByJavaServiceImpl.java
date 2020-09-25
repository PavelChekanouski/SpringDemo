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

        ArrayList<ProductWithNumbers> list = new ArrayList<>();

        for(String key: productMap.keySet()) {
            if(Character.isLowerCase(key.charAt(0))) {
                list.add(new ProductWithNumbers(key, 0, productMap.get(key)));
            } else {
                int index = list.indexOf(new ProductWithNumbers(key.toLowerCase()));
                if(index != -1){
                    list.add(new ProductWithNumbers(key.toLowerCase(), productMap.get(key), 0));
                } else {
                    list.add(index, new ProductWithNumbers(key.toLowerCase(), productMap.get(key), productMap.get(key.toLowerCase())));
                }
            }
        }

        return new HashSet(list);
    }
}

