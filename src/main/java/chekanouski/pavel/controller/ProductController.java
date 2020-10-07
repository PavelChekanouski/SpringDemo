package chekanouski.pavel.controller;

import chekanouski.pavel.entity.Product;
import chekanouski.pavel.dto.ProductWithNumbers;

import chekanouski.pavel.entity.User;
import chekanouski.pavel.service.Products.ProductServiceImpl;
import chekanouski.pavel.service.ProductsWithNumbers.ProductWithNumbersServiceImpl;
import chekanouski.pavel.service.Users.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductServiceImpl productService;
    private final ProductWithNumbersServiceImpl productWithNumbersService;

    public ProductController(ProductServiceImpl productService, ProductWithNumbersServiceImpl productWithNumbersService) {
        this.productService = productService;
        this.productWithNumbersService = productWithNumbersService;
    }

    @GetMapping("/getUnique")
    public ResponseEntity<Set<Product>> getUniqueProducts() {
        return new ResponseEntity<>(productService.getSetOfProducts(), HttpStatus.OK);
    }

    @GetMapping("/getUniqueWithNumbers")
    public ResponseEntity<Set<ProductWithNumbers>> getUniqueProductsWithNumbers() {
        return new ResponseEntity<>(productWithNumbersService.getSetOfProductsWithNumbers(), HttpStatus.OK);
    }

}
