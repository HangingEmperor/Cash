package sample.Processors;

import java.io.*;

public class Depurate {

    private File file;

    public Depurate(File file) throws IOException {
        this.file = file;
        clean();
    }

    private void clean() throws IOException {
        String data = removeComments();
        createFile(data);
    }

    private String removeSpaces(String data) {
        return data.replaceAll("\\s", "");
    }

    private String removeComments() throws IOException {
        int size = 0;
        boolean avaible = true;
        String aux = "", data = "";

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((aux = bufferedReader.readLine()) != null) {
            size++;
            aux = removeSpaces(aux);

            if (!aux.startsWith("//")) {
                if (!aux.startsWith("/*") && avaible) {
                    if (!aux.contains("//")) {
                        data += size + " " + aux + "\n";
                    } else if (aux.contains(";")) {
                        int posCommentary = aux.lastIndexOf("//");
                        int posPointComa = aux.indexOf(";");

                        if (posCommentary - posPointComa == 1) {
                            data += size + " " + aux.substring(0, posCommentary) + "\n";
                        }
                    }
                } else {
                    avaible = aux.startsWith("*/") || aux.endsWith("*/");
                }
            }
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
