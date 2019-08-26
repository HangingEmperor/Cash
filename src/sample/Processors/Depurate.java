package sample.Processors;

import java.io.*;

public class Depurate {

    public Depurate(File file) {

    }

    public static void clean(File file) {
        int size = 0;
        try {
            boolean avaible = true;
            String aux = "";
            String oldData = "";
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((aux = bufferedReader.readLine()) != null) {
                size++;
                aux = aux.replace("\\s", "");
                aux = aux.trim();
                aux = aux.replace(" ", "");

                if (!aux.startsWith("//")) {
                    if (!aux.startsWith("/*") && avaible) {
                        oldData += size + " " + aux + "\n";
                    } else {
                        avaible = false;
                        if (aux.startsWith("*/") || aux.endsWith("*/")) {
                            avaible = true;
                        }
                    }
                }
            }

            bufferedReader.close();

            File over = new File("sample.pre");
            System.out.println(over.getAbsolutePath());
            FileWriter archive = new FileWriter(over);
            archive.append(oldData);
            archive.close();
        } catch (IOException | NullPointerException ex) {
            System.err.println("Cierre inesperado.");
        }
    }

    private void removeComments() {

    }

    private void createFile() {

    }

}
