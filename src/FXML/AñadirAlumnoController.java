/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Main.Alumno;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ITP1DAM
 */
public class AñadirAlumnoController {

    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField curso;

    private Stage dialogStage;
    private Alumno alumn;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the alumn to be edited in the dialog.
     * 
     * @param alumn
     */
    public void setPerson(Alumno alumn) {
        this.alumn = alumn;

        nombre.setText(alumn.getNombre());
        apellidos.setText(alumn.getApellido());
        curso.setText(alumn.getCurso());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
          // alumn.setNombre(nombre.getText());
            alumn.setApellido(apellidos.getText());
            alumn.setCurso(curso.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nombre.getText() == null || nombre.getText().length() == 0) {
            errorMessage += "¡Nombre invalido!\n"; 
        }
        if (apellidos.getText() == null || apellidos.getText().length() == 0) {
            errorMessage += "¡Apellidos invalidos!\n"; 
        }
        if (curso.getText() == null || curso.getText().length() == 0) {
            errorMessage += "¡Curso invalido!\n"; 
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Campo(s) incorrecto(s)");
            alert.setHeaderText("Por favor corrige los datos incorrectos");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
    
}
