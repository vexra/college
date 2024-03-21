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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class OutputController {

    @FXML
    private Button btnNew;

    @FXML
    private Label labelAlamat;

    @FXML
    private Label labelNama;

    @FXML
    private Label labelNpm;

    @FXML
    void openForm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FormInput.fxml"));
        
        Stage stage = (Stage) btnNew.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void showValue(Mahasiswa mhs) {
        labelNpm.setText(mhs.getNpm());
        labelNama.setText(mhs.getNama());
        labelAlamat.setText(mhs.getAlamat());
    }
}
