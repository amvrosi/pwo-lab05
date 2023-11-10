package pwo.seq;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FibonacciGenerator extends Generator {

    private List<BigDecimal> terms;

    public FibonacciGenerator() {
        terms = new ArrayList<>();
        terms.add(new BigDecimal(0));
        terms.add(new BigDecimal(1));
        current = new BigDecimal(1);
    }

    @Override
    public void reset() {
        super.reset();
        terms.clear();
        terms.add(new BigDecimal(0));
        terms.add(new BigDecimal(1));
        current = new BigDecimal(1);
    }

    @Override
    public BigDecimal nextTerm() {
        current = terms.get(lastIndex);
        terms.add(current);
        lastIndex++;
        return current;
    }

    public BigDecimal previousTerm() {
        if (lastIndex > 0) {
            current = terms.get(lastIndex - 1);
            lastIndex--;
            return current;
        } else {
            return null; // or throw an exception to indicate no more previous terms
        }
    }
}
