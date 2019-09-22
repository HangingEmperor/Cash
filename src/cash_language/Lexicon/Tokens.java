package cash_language.Lexicon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Tokens {

    private static ArrayList<String> tokens = new ArrayList<>();
    private static ArrayList<String> delimiters = new ArrayList<>();
    private static Hashtable<String, Integer> tokensTable = new Hashtable<>();

    public Tokens() {
        String[] allKeywords = {"AND", "AS", "BRAK", "CLASS", "CONTINUE", "DEF", "ELIF", "ELSE", "IF", "FINALLY", "FOR",
                "FROM", "GLOBAL", "IMPORT", "IN", "IS", "NOT", "OR", "PASS", "PRINT", "RETURN", "TRY", "WHILE", "FALSE",
                "TRUE", "NONE", "VAR", "INT", "FLOAT", "STRING", "DOUBLE", "CHAR", "BOOLEAN", "CASH"};
        String[] allDelimiters = {"(", ")", "[", "]", "{", "}", ",", ".", ":", ";", "\"", "=", "+", "-", "*", "/"};

        delimiters.addAll(Arrays.asList(allDelimiters));
        tokens.addAll(Arrays.asList(allKeywords));

        for (int i = 0; i < allKeywords.length; i++)
            tokensTable.put(allKeywords[i], i);

        for (int i = 0; i < allDelimiters.length; i++)
            tokensTable.put(allDelimiters[i], allKeywords.length + i);
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

    public static Hashtable<String, Integer> getTokensTable() {
        return tokensTable;
    }

    public static void setTokensTable(Hashtable<String, Integer> tokensTable) {
        Tokens.tokensTable = tokensTable;
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
