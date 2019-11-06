package cash_language.Lexicon;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Tokens {

    private static ArrayList<String> tokens = new ArrayList<>();
    private static ArrayList<String> delimiters = new ArrayList<>();
    public static Hashtable<String, Integer> tokensTable = new Hashtable<>();
    
    /* Agregar un vector que tenga un vector como identificadores, done almacenara todo lo que el programa no conoce
    para si mismo, es decir un identificador, */

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

    public static void replaceWithTokens(File file) throws IOException {
        String aux;
        String data = "";
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader((fileReader));

        while ((aux = bufferedReader.readLine()) != null) {
            data += "" + aux + "\n";

        }
    }

    public static Boolean isCorrectTokens(String data) {
        String[] words = data.split("\\s+");
        String[] auxWords;

        try {
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].replaceAll("[^\\w]", "");
                for (int j = 0; j < words[i].length(); j++) {
                    if (words[i].substring(j, j + 1).matches("[A-Z]")) {
                        for (int k = 0; k < tokens.size(); k++) {
                            if (words[i].substring(j, j + 1).equals(tokens.get(k).substring(j, j + 1))) {
                                for (int l = 0; l < tokens.get(k).length(); l++) {
                                    if (words[i].substring(l, l + 1).equals(tokens.get(k).substring(l, l + 1))) {
                                        if (l == tokens.get(k).length() - 1) {
                                            return true;
                                        }
                                    } else {
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
        } catch (StringIndexOutOfBoundsException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
        return false;
    }


    public Boolean isCorrectDelimiters() {

        return false;
    }
}
