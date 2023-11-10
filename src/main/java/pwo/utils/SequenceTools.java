package pwo.utils;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class SequenceTools {

    private static String getTerms(SequenceGenerator sg, int from, int to, String sep) {
        if (from > to) {
            throw new IllegalArgumentException("Invalid range: 'from' should be less than or equal to 'to'");
        }

        int step = from > to ? -1 : 1;
        StringBuilder termsBuilder = new StringBuilder();

        for (int i = from; i != to; i += step) {
            termsBuilder.append(sg.getTerm(i)).append(sep);
        }

        termsBuilder.append(sg.getTerm(to));  // Append the last term
        return termsBuilder.toString().trim();
    }

    public static String getTermsAsColumn(SequenceGenerator sg, int from, int to) {
        return getTerms(sg, from, to, "\n");
    }

    public static String getTermsAsLine(SequenceGenerator sg, int from, int to) {
        return getTerms(sg, from, to, " ");
    }

    public static boolean writeToFile(SequenceGenerator sg, int from, int to, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(getTermsAsColumn(sg, from, to));
        } catch (IOException ex) {
            ex.printStackTrace();  // Handle the exception appropriately
            return false;
        }

        return true;
    }
}
