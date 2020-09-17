package chekanouski.pavel.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int id;

    private String name;

    private int numberOfProductsWithCapitalLetter;

    private int numberOfProductsWithSmallLetter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
