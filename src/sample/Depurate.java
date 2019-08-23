package sample;

import java.io.*;

public class Depurate {

    public static void clean(File file) {
        int size = 0;
        try {
            String aux = "";
            String oldData = "";
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((aux = bufferedReader.readLine()) != null) {
                System.out.println(aux);
                size++;
                aux = aux.replace("\\s", "");
                System.out.println(aux);

                if (!aux.startsWith("//")) {
                    oldData += size + aux + "\n";
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

}
