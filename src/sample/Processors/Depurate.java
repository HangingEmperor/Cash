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
        String aux = "", data = "";

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((aux = bufferedReader.readLine()) != null) {
            size++;
            aux = aux.replace("\\s", "");
            aux = aux.trim();
            aux = aux.replace(" ", "");

            if (!aux.startsWith("//")) {
                if (!aux.startsWith("/*") && avaible) {
                    data += size + " " + aux + "\n";
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
