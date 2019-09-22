package cash_language.Generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Compiler {

    private static File file;

    public static void createFile(String data) throws IOException {
        file = new File("sample.cash");
        FileWriter archive = new FileWriter(file);
        archive.append(data);
        archive.close();
    }

    public static String showPath() {
        return file.getAbsolutePath();
    }
}
