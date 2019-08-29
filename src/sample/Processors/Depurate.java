package sample.Processors;

import sample.Exceptions.InvalidCommentaryException;

import java.io.*;

public class Depurate {

    private File file;

    public Depurate(File file) throws IOException {
        this.file = file;
        clean();
    }

    private void clean() throws IOException {
        String data = removeMultiLineComments();
        createFile(data);
    }

    private String removeSpaces(String data) {
        return data.replaceAll("\\s", "");
    }

    private String removeMultiLineComments() throws IOException {
        int size = 0;
        String aux = "", data = "";
        int posCommentaryStart = 0;
        int posCommentaryFinal = 0;

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader((fileReader));

        boolean existsMultiComments = false;
        boolean prevAster = false;
        boolean closeComment = true;

        try {
            while ((aux = bufferedReader.readLine()) != null) {
                size++;
                aux += "  ";

                for (int i = 0; i < aux.length(); i++) {
                    String check = aux.substring(i, i + 1);

                    if (check.equals("/") && !existsMultiComments) {
                        if (!aux.substring(i + 1, i + 2).equals("*")) {
                            throw new InvalidCommentaryException("No se cerro un comentario");
                        } else {
                            existsMultiComments = true;
                            prevAster = true;
                            closeComment = false;
                        }
                        posCommentaryStart = aux.indexOf("/");
                        continue;
                    }

                    if (prevAster) {
                        prevAster = false;
                        continue;
                    }

                    if (check.equals("*") && existsMultiComments) {
                        if (!aux.substring(i + 1, i + 2).equals("/")) {
                            throw new InvalidCommentaryException("No se cerro un comentario");
                        } else {
                            existsMultiComments = false;
                            closeComment = true;
                            posCommentaryFinal = aux.lastIndexOf("*");
                            break;
                        }
                    }
                }
                if (closeComment) {
                    if (!existsMultiComments) {
                        data += size + " " + aux.substring(0, posCommentaryStart) + aux.substring(posCommentaryFinal + 2) + "\n";
                    }
                }
            }
            if (closeComment) {
                throw new InvalidCommentaryException("No se cerro un comentario");
            }
        } catch (InvalidCommentaryException e) {
            e.printStackTrace();
        }
        return data;
    }

    private String removeLineComments() throws IOException {
        int size = 0;
        String aux = "", data = "";

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((aux = bufferedReader.readLine()) != null) {
            size++;
            aux += "  ";
            int posCommentary = 0;
            try {
                for (int i = 0; i < aux.length(); i++) {
                    String check = aux.substring(i, i + 1);

                    if (check.equals("/")) {
                        posCommentary = aux.indexOf("/");
                        if (!aux.substring(i + 1, i + 2).equals("/")) {
                            throw new InvalidCommentaryException("No se cerro un comentario");
                        } else {
                            break;
                        }
                    }
                }
            } catch (InvalidCommentaryException |
                    StringIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            data += size + " " + aux.substring(0, posCommentary) + "\n";
        }

        bufferedReader.close();
        return data;
    }

    private void createFile(String data) throws IOException {
        File over = new File("sample.pre");
        FileWriter archive = new FileWriter(over);
        archive.append(data);
        archive.close();
    }

    public String showPath() {
        return file.getAbsolutePath();
    }
}

/* Los comentarios requieres ser de una linea, multilinea, y las consideraciones a hacer son:
    - Los comentarios de una linea deben revisar si estan en el principio o en el final o en medio.
    - Los comentarios multilinea se deben revisar de inicio hasta que se cierra, es decir, se va a revisar desde
    cualquier punto del programa.
    - Ademas si hay un comentario sin cerrar se debe notificar.
 */
