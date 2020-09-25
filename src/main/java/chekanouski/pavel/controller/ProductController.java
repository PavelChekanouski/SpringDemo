package chekanouski.pavel.controller;

import chekanouski.pavel.entity.Product;
import chekanouski.pavel.dto.ProductWithNumbers;

import chekanouski.pavel.service.Product.ProductServiceImpl;
import chekanouski.pavel.service.ProductWithNumbers.ProductWithNumbersByJavaServiceImpl;
import chekanouski.pavel.service.ProductWithNumbers.ProductWithNumbersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/")
public class ProductController {

    @GetMapping
    public ResponseEntity<String> showStatus() {
        return new ResponseEntity<>("Connected to the server", HttpStatus.OK);
    }

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/getUnique")
    public ResponseEntity<Set<Product>> getUniqueProducts() {
        return new ResponseEntity<>(productService.getSetOfProducts(), HttpStatus.OK);
    }

    @Autowired
    private ProductWithNumbersServiceImpl productWithNumbersService;

    @Autowired
    private ProductWithNumbersByJavaServiceImpl productWithNumbersByJavaService;

    @GetMapping("/getUniqueWithNumbers")
    public ResponseEntity<Set<ProductWithNumbers>> getUniqueProductsWithNumbers() {

        return new ResponseEntity<>(productWithNumbersByJavaService.getSetOfProductsWithNumbers(), HttpStatus.OK);
        //return new ResponseEntity<>(productWithNumbersService.getSetOfProductsWithNumbers(), HttpStatus.OK);

    }

}
