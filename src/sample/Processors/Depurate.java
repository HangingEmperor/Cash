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

    private String removeComments() throws IOException {
        int size = 0;
        boolean avaible = true;
        boolean isPrint = true;
        String aux = "", data = "";
        Pila<String> pila = new Pila<>();

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((aux = bufferedReader.readLine()) != null) {
            size++;
            aux = aux.replace("\\s", "");
            aux = aux.replace(" ", "");
            aux = aux.replace("\t", "");
            aux = aux.trim();
            System.out.println(aux);

            if (!aux.startsWith("//")) {
                if (!aux.startsWith("/*") && avaible) {
                    if (!aux.contains("//")) {
                        data += size + " " + aux + "\n";
                    } else if (aux.contains(";")) {
                        int posCommentary = aux.lastIndexOf("//");
                        int posPointComa = aux.indexOf(";");
                        System.out.println(posCommentary - posPointComa);
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

    /*
        private String removeExternalComments(String data) throws FileNotFoundException {
            Pila<String> pila = new Pila<>();

            String aux = "";

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((aux = bufferedReader.readLine()) != null) {

            }

            return "";
        }
    */
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
