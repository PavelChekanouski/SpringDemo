package chekanouski.pavel.service;

import chekanouski.pavel.entity.Product;

import java.util.HashSet;

public class ProductResponse {

    private final String status;
    private final Integer code;
    private final HashSet<Product> set;

    public ProductResponse(String status, Integer code, HashSet<Product> set) {
        this.status = status;
        this.code = code;
        this.set = set;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public HashSet<Product> getSet() {return set;}
}
