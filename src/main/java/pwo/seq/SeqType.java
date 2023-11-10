package pwo.seq;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public enum SeqType {
    FIB(FibonacciGenerator::new),
    LUC(LucasGenerator::new),
    TRI(TribonacciGenerator::new);

    private static final String FIX_SEQTYPE = "Problem in " + SeqType.class.getName();
    private static final Map<String, SeqType> TYPE_MAP;

    static {
        TYPE_MAP = Arrays.stream(SeqType.values())
                .collect(Collectors.toMap(type -> type.toString(), Function.identity()));

        if (Arrays.stream(SeqType.values()).anyMatch(t -> t.toString().length() != 3)) {
            throw new IllegalStateException(FIX_SEQTYPE);
        }
    }

    private final Supplier<Generator> generatorSupplier;

    SeqType(Supplier<Generator> generatorSupplier) {
        this.generatorSupplier = generatorSupplier;
    }

    public static SeqType fromString(String type) {
        return TYPE_MAP.get(type.trim().toUpperCase());
    }

    public Generator getGenerator() {
        return generatorSupplier.get();
    }
}
