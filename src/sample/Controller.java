package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    @FXML
    private Label title;
    @FXML
    private TextArea textArea;
    private boolean isSave;

    @FXML
    void open() {

    }

    @FXML
    void save() {
        if (!isSave) {
            saveAs();
            isSave = true;
        } else {

        }
    }

    @FXML
    void saveAs() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.setInitialFileName("sample.txt");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
        Stage primaryStage = new Stage();
        File file = fileChooser.showSaveDialog(primaryStage);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            FileWriter archive = new FileWriter(file);
            archive.append(textArea.getText());
            archive.close();
        } catch (IOException ex) {
            System.out.println("Hubo un error");
        }
        isSave = true;
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        if (isSave) {
            save();
        } else {
            saveAs();
        }
        System.exit(0);
    }

}
