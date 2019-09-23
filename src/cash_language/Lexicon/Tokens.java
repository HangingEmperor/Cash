package cash_language.Lexicon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Tokens {

    private static ArrayList<String> tokens = new ArrayList<>();
    private static ArrayList<String> delimiters = new ArrayList<>();
    private static Hashtable<String, Integer> tokensTable = new Hashtable<>();

    public Tokens() {
        String[] allKeywords = {"AND", "AS", "BREAK", "CLASS", "CONTINUE", "DEF", "ELIF", "ELSE", "IF", "FINALLY", "FOR",
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

    public static Boolean isCorrectTokens(String data) {
        String[] words = data.split("\\s+");
        String[] auxWords;

        for (int i = 0; i < words.length; i++) {
            System.out.println(1);
            words[i] = words[i].replaceAll("[^\\w]", "");
            for (int j = 0; j < words[i].length(); j++) {
                System.out.println(2);
                System.out.println(words[i]);
                System.out.println(words[i].substring(j, j + 1));
                System.out.println(words[i].substring(j, j + 1).matches("[A-Z]"));
                if (words[i].substring(j, j + 1).matches("[A-Z]")) {
                    System.out.println(3);
                    for (int k = 0; k < tokens.size(); k++) {
                        System.out.println(4);
                        if (words[i].substring(j, j + 1).equals(tokens.get(k).substring(j, j + 1))) {
                            System.out.println(5);
                            for (int l = 0; l < tokens.get(k).length(); l++) {
                                System.out.println(6);
                                if (words[i].substring(l, l + 1).equals(tokens.get(k).substring(l, l + 1))) {
                                    System.out.println(7);
                                    if (l == tokens.get(k).length() - 1) {
                                        System.out.println(8);
                                        return true;
                                    }
                                } else {
                                    System.out.println(9);
                                    break;
                                }
                            }
                        }
                    }
                } else if (words[i].substring(j, j + 1).matches("[a-z]")) {
                    break;
                }
            }
        }
        return false;
    }

    public Boolean isCorrectDelimiters() {

        return false;
    }
}
