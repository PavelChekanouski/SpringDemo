package chekanouski.pavel.entity;

public class ProductRequest {
    private String name;
    private int numberOfProductsWithCapitalLetter;
    private int numberOfProductsWithSmallLetter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfProductsWithCapitalLetter() {
        return numberOfProductsWithCapitalLetter;
    }

    public void setNumberOfProductsWithCapitalLetter(int numberOfProductsWithCapitalLetter) {
        this.numberOfProductsWithCapitalLetter = numberOfProductsWithCapitalLetter;
    }

    public int getNumberOfProductsWithSmallLetter() {
        return numberOfProductsWithSmallLetter;
    }

    public void setNumberOfProductsWithSmallLetter(int numberOfProductsWithSmallLetter) {
        this.numberOfProductsWithSmallLetter = numberOfProductsWithSmallLetter;
    }
}
