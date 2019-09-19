package heavy_language.Lexicon;

import java.util.ArrayList;
import java.util.Arrays;

public class Tokens {

    private static ArrayList tokens;

    public Tokens() {
        String[] allTokens = {"INT", "STRING", "IF", "ELSE", "FOR", "WHILE", "PRINT", "FUNCTION", "DO", "WHILE", "SCRIPT",
                "FLOAT", "SCANER", ";", ",", ".", "+", "-", "/", "*", "=", "\"", "(", ")", "/", "\\", "<", ">", "=", "<=",
                ">=", "==", "!", "!=", "?"};
        tokens.addAll(Arrays.asList(allTokens));
    }

    public static ArrayList getTokens() {
        return tokens;
    }

    public static void setTokens(ArrayList tokens) {
        Tokens.tokens = tokens;
    }
}
