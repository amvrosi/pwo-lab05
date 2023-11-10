package pwo.seq;

import java.math.BigDecimal;

public class TribonacciGenerator extends FibonacciGenerator {

    private BigDecimal f_3;

    public TribonacciGenerator() {
        reset();
    }

    @Override
    public void reset() {
        super.reset();
        f_3 = BigDecimal.ZERO;
    }

    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else {
            current = BigDecimal.valueOf(lastIndex > 0 ? 1 : 0);
        }
        lastIndex++;
        return current;
    }

    public BigDecimal previousTerm() {
        if (lastIndex > 2) {
            return f_3;
        } else if (lastIndex == 2) {
            return f_2;
        } else {
            return BigDecimal.ZERO;
        }
    }
}
