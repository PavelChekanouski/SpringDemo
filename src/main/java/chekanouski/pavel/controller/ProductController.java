package chekanouski.pavel.controller;

import chekanouski.pavel.entity.Product;
import chekanouski.pavel.entity.ProductWithNumbers;
import chekanouski.pavel.repository.ProductRepository;
import chekanouski.pavel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @Autowired
    private ProductService service;

    @GetMapping("/getUniqueWithNumbers")
    public Response getUniqueProductsWithNumbers() {
        ArrayList<Product> products = (ArrayList<Product>) productRepository.findAll();

        HashSet<ProductWithNumbers> productsWithNumbers = service.getSetOfWordsWithNumbers(products);

        if (!products.isEmpty()) {
            return new ProductResponse(SUCCESS_STATUS, CODE_SUCCESS, productsWithNumbers);
        } else {
            return new Response(ERROR_STATUS, AUTH_FAILURE);
        }

    }

}
