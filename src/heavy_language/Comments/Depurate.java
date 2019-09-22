package heavy_language.Comments;

import heavy_language.Exceptions.InvalidCommentaryException;
import heavy_language.Exceptions.InvalidQuotationMarkException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Depurate {

    public File file;

    public Depurate(File file) throws IOException {
        this.file = file;
    }

    public String clean() throws IOException {
        return removeMultiLineComments();
    }

    private String removeMultiLineComments() throws IOException {
        int size = 0;
        String aux, data = "";
        int posCommentaryStart;
        int posCommentaryFinal = 0;

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader((fileReader));

        boolean existsMultiComments = false;
        boolean prevAster = false;
        boolean closeComment = true;
        boolean isLineComment = false;
        boolean isPrintText = false;
        boolean closePrintText = true;

        try {
            while ((aux = bufferedReader.readLine()) != null) {
                size++;
                aux += "  ";
                posCommentaryStart = 0;

                for (int i = 0; i < aux.length(); i++) {
                    String check = aux.substring(i, i + 1);

                    if (!check.equals("\"") && !isPrintText) {
                        if (check.equals("/") && !existsMultiComments) {
                            posCommentaryStart = i;
                            if (!aux.substring(i + 1, i + 2).equals("*")) {
                                if (!aux.substring(i + 1, i + 2).equals("/"))
                                    throw new InvalidCommentaryException("No se cerro un comentario");
                                else {
                                    isLineComment = true;
                                    break;
                                }
                            } else {
                                existsMultiComments = true;
                                prevAster = true;
                                closeComment = false;
                            }
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
                    } else {
                        if (check.equals("\"") && isPrintText) {
                            isPrintText = false;
                            closePrintText = false;
                        } else {
                            closePrintText = true;
                            isPrintText = true;
                        }
                    }
                }
                if (!isLineComment) {
                    if (closeComment) {
                        if (existsMultiComments) {
                            System.out.println(2);
                            data += size + " " + aux.substring(0, posCommentaryStart) +
                                    aux.substring(posCommentaryFinal + 2) + "\n";
                        } else {
                            if (aux.contains("*/")) {
                                if (aux.contains("/*")) {
                                    System.out.println(3);

                                    data += size + " " + aux.substring(0, posCommentaryStart) +
                                            aux.substring(posCommentaryFinal + 2) + "\n";
                                } else if (!aux.substring(aux.indexOf("/") + 1).trim().isEmpty())
                                    data += size + " " + aux.substring(aux.indexOf("/") + 1) + "\n";
                            } else {
                                data += size + " " + aux + "\n";
                            }
                        }
                    } else {
                        if (!(aux.substring(0, posCommentaryStart).length() == 0))
                            data += size + " " + aux.substring(0, posCommentaryStart) + "\n";
                    }
                } else {
                    data += size + " " + aux.substring(0, posCommentaryStart) + "\n";
                    isLineComment = false;
                }
            }
            if (!closeComment) {
                throw new InvalidCommentaryException("No se cerro un comentario");
            } else if (!closePrintText) {
                throw new InvalidQuotationMarkException("No se cerraron las comillas");
            }
        } catch (InvalidCommentaryException | InvalidQuotationMarkException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
        return data;
    }
}