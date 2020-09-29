package chekanouski.pavel.controller;

import chekanouski.pavel.entity.Product;
import chekanouski.pavel.dto.ProductWithNumbers;

import chekanouski.pavel.service.Product.ProductServiceImpl;
import chekanouski.pavel.service.ProductWithNumbers.ProductWithNumbersByJavaServiceImpl;
import chekanouski.pavel.service.ProductWithNumbers.ProductWithNumbersBySQLServiceImpl;
import chekanouski.pavel.service.ProductWithNumbers.ProductWithNumbersServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductServiceImpl productService;
    private final ProductWithNumbersServiceImpl productWithNumbersService;
    private final ProductWithNumbersByJavaServiceImpl productWithNumbersByJavaService;
    private final ProductWithNumbersBySQLServiceImpl productWithNumbersBySQLService;

    public ProductController(ProductServiceImpl productService, ProductWithNumbersServiceImpl productWithNumbersService, ProductWithNumbersByJavaServiceImpl productWithNumbersByJavaService, ProductWithNumbersBySQLServiceImpl productWithNumbersBySQLService) {
        this.productService = productService;
        this.productWithNumbersService = productWithNumbersService;
        this.productWithNumbersByJavaService = productWithNumbersByJavaService;
        this.productWithNumbersBySQLService = productWithNumbersBySQLService;
    }

    @GetMapping("/start")
    public ResponseEntity<String> showStatus() {
        return new ResponseEntity<>("Connected to the server", HttpStatus.OK);
    }


    @GetMapping("/getUnique/{value}")
    public ResponseEntity<Set<Product>> getUniqueProducts(@PathVariable(value = "value") byte value) {
        return new ResponseEntity<>(productService.getSetOfProducts(value), HttpStatus.OK);
    }

    @GetMapping("/getUniqueWithNumbers/{value}")
    public ResponseEntity<Set<ProductWithNumbers>> getUniqueProductsWithNumbers(@PathVariable(value = "value") byte value) {
        switch (value){

            case (1) : return new ResponseEntity<>(productWithNumbersByJavaService.getSetOfProductsWithNumbers(), HttpStatus.OK);

            case (2) : return new ResponseEntity<>(productWithNumbersBySQLService.getSetOfProductsWithNumbers(), HttpStatus.OK);

            default : return new ResponseEntity<>(productWithNumbersService.getSetOfProductsWithNumbers(), HttpStatus.OK);
        }

    }

}
