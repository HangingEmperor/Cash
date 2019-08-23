package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.Optional;

public class Controller {

    @FXML
    private Label title;
    @FXML
    private TextArea textArea;

    private File file;
    private File after;
    private boolean isSave;

    @FXML
    void open() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
        Stage primaryStage = new Stage();
        file = fileChooser.showOpenDialog(primaryStage);

        try {
            String aux = "";
            String oldData = "";
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((aux = bufferedReader.readLine()) != null) {
                oldData += aux + "\n";
            }
            bufferedReader.close();
            textArea.setText(oldData);
            isSave = true;
        } catch (IOException | NullPointerException ex) {
            System.err.println("Cierre inesperado.");
        }
    }

    @FXML
    void save() {
        if (!isSave) {
            saveAs();
        } else {
            try {
                FileWriter archive = new FileWriter(file);
                archive.append(textArea.getText());
                archive.close();
            } catch (IOException | NullPointerException ex) {
                System.err.println("Cierre inesperado.");
            }
        }
    }

    @FXML
    void saveAs() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.setInitialFileName("sample.txt");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
        Stage primaryStage = new Stage();
        try {
            file = fileChooser.showSaveDialog(primaryStage);

            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException | NullPointerException ex) {
            System.err.println("Cierre inesperado.");
        }

        try {
            FileWriter archive = new FileWriter(file);
            archive.append(textArea.getText());
            archive.close();
            isSave = true;
        } catch (IOException | NullPointerException ex) {
            System.err.println("Cierre inesperado.");
        }
    }


    @FXML
    void make(ActionEvent event) {
        Depurate.clean(file);
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        System.out.println(isSave);
        if (isSave) {
            save();
            System.exit(0);
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Do you want to exit without save?");
            alert.initStyle(StageStyle.UTILITY);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.exit(0);
            }
        }

    }

}
