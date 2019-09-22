package cash_language.Lexicon;

import java.util.ArrayList;
import java.util.Arrays;

public class Tokens {

    private static ArrayList tokens;

    public Tokens() {

        String[] allKeywords = {"AND", "AS", "BRAK", "CLASS", "CONTINUE", "DEF", "ELIF", "ELSE", "IF", "FINALLY", "FOR",
                "FROM", "GLOBAL", "IMPORT", "IN", "IS", "NOT", "OR", "PASS", "PRINT", "RETURN", "TRY", "WHILE", "FALSE",
                "TRUE", "NONE", "VAR", "INT", "FLOAT", "STRING", "DOUBLE", "CHAR"};
        String[] allDelimiters = {"(", ")", "[", "]", "{", "}", ",", ".", ":", ";", "\"", "=", "+", "-", "*", "/"};
        tokens.addAll(Arrays.asList(allDelimiters));
        tokens.addAll(Arrays.asList(allKeywords));
    }

    public static ArrayList getTokens() {
        return tokens;
    }

    public static void setTokens(ArrayList tokens) {
        Tokens.tokens = tokens;
    }

}
