package chekanouski.pavel.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter @EqualsAndHashCode @AllArgsConstructor
public class ProductWithNumbers{
    private final String name;
    private final long numberOfWordsWithCapitalLetter;
    private final long numberOfWordsWithSmallLetter;
}