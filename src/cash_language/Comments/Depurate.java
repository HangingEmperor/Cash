package cash_language.Comments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Depurate {

    private File file;
    private final String regex =
            "\\G"                                         // Anclar a \\A o fin de coincidencia previa
                    + "("                                           // GRUPO 1: capturar todo lo que no es comentario en $1:
                    + "  [^\"'/\\\\]*"                              //   caracteres sin significado especial
                    + "  (?:"                                       //   estructuras especiales:
                    + "    (?: \\\\."                               //       a. barra escapando caracter
                    + "      | /(?![*/])"                           //       b. una / que no está seguida de / o *
                    + "      | \"[^\"\\\\]*(?:\\\\.[^\"\\\\]*)*\""  //       c. texto entre comillas dobles
                    + "      | '[^'\\\\]*(?:\\\\.[^'\\\\]*)*'"      //       d. texo entre comillas simples
                    + "    )"                                       //
                    + "    [^\"'/\\\\]*"                            //     seguido de más caracteres sin significado
                    + "  )*+"                                       //   (estructuras especiales repetidas 0 a inf)
                    + ")"                                           // fin de Grupo 1
                    + "(?:"                                         // COMENTARIOS (no está dentro de $1)
                    + "   //.*"                                     //   a. // hasta el final de la linea
                    + "|  /\\*[^*]*(?:\\*(?!/)[^*]*)*\\*/"          //   b. /* hasta el siguiente */
                    + ")";

    public Depurate(File file) throws IOException {
        this.file = file;
    }

    public String clean() throws IOException {
        return removeComments();
    }

    private String removeComments() throws IOException {
        String aux;
        String data = "";
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader((fileReader));
        int line = 0;

        while ((aux = bufferedReader.readLine()) != null) {
            data += "" + line + " " + aux + "\n";
            line++;
        }
        final String reempl = "$1";
        final Pattern pattern = Pattern.compile(regex, Pattern.COMMENTS);
        final Matcher matcher = pattern.matcher(data);
        return matcher.replaceAll(reempl);
    }

    public String isEmptyLine(String text) throws IOException {
        String aux;
        String data = "";
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader((fileReader));

        while ((aux = bufferedReader.readLine()) != null) {
            if (!aux.matches("^+[\\d]\\p{Space}+")) {
                data += aux + "\n";
            }
        }
        return data;
    }
}