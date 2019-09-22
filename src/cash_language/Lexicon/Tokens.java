package cash_language.Lexicon;

import java.util.ArrayList;
import java.util.Arrays;

public class Tokens {

    private static ArrayList<String> tokens;
    private static ArrayList<String> delimiters;

    public Tokens() {

        String[] allKeywords = {"AND", "AS", "BRAK", "CLASS", "CONTINUE", "DEF", "ELIF", "ELSE", "IF", "FINALLY", "FOR",
                "FROM", "GLOBAL", "IMPORT", "IN", "IS", "NOT", "OR", "PASS", "PRINT", "RETURN", "TRY", "WHILE", "FALSE",
                "TRUE", "NONE", "VAR", "INT", "FLOAT", "STRING", "DOUBLE", "CHAR", "CASH"};
        String[] allDelimiters = {"(", ")", "[", "]", "{", "}", ",", ".", ":", ";", "\"", "=", "+", "-", "*", "/"};
        delimiters.addAll(Arrays.asList(allDelimiters));
        tokens.addAll(Arrays.asList(allKeywords));
    }

    public static ArrayList getTokens() {
        return tokens;
    }

    public static void setTokens(ArrayList<String> tokens) {
        Tokens.tokens = tokens;
    }

    public static ArrayList<String> getDelimiters() {
        return delimiters;
    }

    public static void setDelimiters(ArrayList<String> delimiters) {
        Tokens.delimiters = delimiters;
    }

    public Boolean isCorrectTokens(String data) {
        for (int i = 0; i < tokens.size(); i++) {
            //tokens.contains();
        }
        return false;
    }

    public Boolean isCorrectDelimiters() {

        return false;
    }
}
