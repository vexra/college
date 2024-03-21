/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package prak15;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */

public class FormInputController {

    @FXML
    private Button btnTambah;

    @FXML
    private TextArea field_alamat;

    @FXML
    private TextField field_nama;

    @FXML
    private TextField field_npm;

    @FXML
    void sendData(ActionEvent event) throws IOException {
        Mahasiswa mhs = new Mahasiswa(field_npm.getText(), field_nama.getText(), field_alamat.getText());
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Output.fxml"));
        Parent root = loader.load();
        
        OutputController outputController = loader.getController();
        outputController.showValue(mhs);
        
        Stage stage = (Stage) btnTambah.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}

