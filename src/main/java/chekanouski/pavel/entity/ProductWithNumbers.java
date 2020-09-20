package chekanouski.pavel.entity;

import java.util.HashSet;

public class ProductWithNumbers extends Product{
    private int id;
    private String name;
    private int numberOfWordsWithCapitalLetter;
    private int numberOfWordsWithSmallLetter;

    public ProductWithNumbers(Product product, int numberOfWordsWithCapitalLetter, int numberOfWordsWithSmallLetter) {
        this.id = product.getId();
        this.name = product.getName();
        this.numberOfWordsWithCapitalLetter = numberOfWordsWithCapitalLetter;
        this.numberOfWordsWithSmallLetter = numberOfWordsWithSmallLetter;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfWordsWithCapitalLetter() {
        return numberOfWordsWithCapitalLetter;
    }

    public void setNumberOfWordsWithCapitalLetter(int numberOfWordsWithCapitalLetter) {
        this.numberOfWordsWithCapitalLetter = numberOfWordsWithCapitalLetter;
    }

    public int getNumberOfWordsWithSmallLetter() {
        return numberOfWordsWithSmallLetter;
    }

    public void setNumberOfWordsWithSmallLetter(int numberOfWordsWithSmallLetter) {
        this.numberOfWordsWithSmallLetter = numberOfWordsWithSmallLetter;
    }
}
