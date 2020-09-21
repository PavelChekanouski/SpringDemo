package chekanouski.pavel.controller;

import chekanouski.pavel.entity.Product;
import chekanouski.pavel.entity.ProductWithNumbers;
import chekanouski.pavel.repository.ProductRepository;
import chekanouski.pavel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    private final String SUCCESS_STATUS = "success";
    private final int CODE_SUCCESS = 100;
    private static final String ERROR_STATUS = "error";
    private static final int AUTH_FAILURE = 102;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Response showStatus() {
        return new Response(SUCCESS_STATUS, CODE_SUCCESS);
    }

    @GetMapping("/getUnique")
    public Response getUniqueProducts() {

        HashSet<Product> products = new HashSet<>((List<Product>) productRepository.findAll());

        if (!products.isEmpty()) {
            return new ProductResponse(SUCCESS_STATUS, CODE_SUCCESS, products);
        } else {
            return new Response(ERROR_STATUS, AUTH_FAILURE);
        }

    }

    @GetMapping("/getUniqueWithNumbers")
    public Response getUniqueProductsWithNumbers() {
        HashMap<String, ProductWithNumbers> map = new HashMap<>();

        ArrayList<Product> products = (ArrayList<Product>) productRepository.findAll();

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

        HashSet<ProductWithNumbers> productsWithNumbers = new HashSet<>(map.values());

        if (!products.isEmpty()) {
            return new ProductResponse(SUCCESS_STATUS, CODE_SUCCESS, productsWithNumbers);
        } else {
            return new Response(ERROR_STATUS, AUTH_FAILURE);
        }

    }

}
