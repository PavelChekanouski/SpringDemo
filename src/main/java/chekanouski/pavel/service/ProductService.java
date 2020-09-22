package chekanouski.pavel.service;

import chekanouski.pavel.entity.Product;
import chekanouski.pavel.entity.ProductWithNumbers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@Service
public class ProductService {
    public HashSet<ProductWithNumbers> getSetOfWordsWithNumbers(ArrayList<Product> products){

        HashMap<String, ProductWithNumbers> map = new HashMap<>();

        for(Product product: products){
            String name = product.getName();
            if (map.containsKey(name.toLowerCase())) {
                if(name.substring(0, 1).toCharArray()[0] <= 90 && name.substring(0, 1).toCharArray()[0] >= 65) {
                    map.replace(name.toLowerCase(), new ProductWithNumbers(name.toLowerCase(), map.get(name.toLowerCase()).getNumberOfWordsWithCapitalLetter() + 1, map.get(name.toLowerCase ()).getNumberOfWordsWithSmallLetter()));
                }
                else map.replace(name.toLowerCase(), new ProductWithNumbers(name.toLowerCase(), map.get(name.toLowerCase ()).getNumberOfWordsWithCapitalLetter(), map.get(name.toLowerCase ()).getNumberOfWordsWithSmallLetter() + 1));
            }
            else if(name.substring(0, 1).toCharArray()[0] <= 90 && name.substring(0, 1).toCharArray()[0] >= 65){
                map.put(name.toLowerCase(), new ProductWithNumbers(name.toLowerCase(), 1, 0));
            }
            else map.put(name.toLowerCase(), new ProductWithNumbers(name.toLowerCase(), 0, 1));
        }

        return new HashSet<>(map.values());
    }
}
