package pwo.utils;

import java.math.BigDecimal;

public interface SequenceGenerator {

    void reset();

    BigDecimal nextTerm();
    BigDecimal previousTerm();

    BigDecimal getTerm(int i);
}
