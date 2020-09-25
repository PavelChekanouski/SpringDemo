package chekanouski.pavel.dto;

import java.util.Objects;

public class ProductWithNumbers{

    private String name;
    private long numberOfWordsWithCapitalLetter;
    private long numberOfWordsWithSmallLetter;

    public ProductWithNumbers( String name, long numberOfWordsWithCapitalLetter, long numberOfWordsWithSmallLetter) {
        this.name = name;
        this.numberOfWordsWithCapitalLetter = numberOfWordsWithCapitalLetter;
        this.numberOfWordsWithSmallLetter = numberOfWordsWithSmallLetter;
    }

    public ProductWithNumbers(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfWordsWithCapitalLetter() {
        return numberOfWordsWithCapitalLetter;
    }

    public void setNumberOfWordsWithCapitalLetter(long numberOfWordsWithCapitalLetter) {
        this.numberOfWordsWithCapitalLetter = numberOfWordsWithCapitalLetter;
    }

    public long getNumberOfWordsWithSmallLetter() {
        return numberOfWordsWithSmallLetter;
    }

    public void setNumberOfWordsWithSmallLetter(long numberOfWordsWithSmallLetter) {
        this.numberOfWordsWithSmallLetter = numberOfWordsWithSmallLetter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductWithNumbers that = (ProductWithNumbers) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
