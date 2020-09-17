package chekanouski.pavel.controller;

import org.springframework.web.bind.annotation.*;
import chekanouski.pavel.service.ProductResponse;

@RestController
@RequestMapping("/")
public class ProductController {

    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    public ProductResponse showStatus() {
        return new ProductResponse(SUCCESS_STATUS, 1);
    }

    @GetMapping("/get")
    public ProductResponse pay(@RequestParam String name) {

        final ProductResponse response;

        if (name != null) {
            response = new ProductResponse(name, CODE_SUCCESS);
        } else {
            response = new ProductResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        return response;
    }

}
