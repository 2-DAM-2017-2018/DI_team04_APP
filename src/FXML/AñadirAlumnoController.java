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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PEPE E ISMAEL
 */
public class AñadirAlumnoController {

    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private ChoiceBox cursochoice;

    private Stage dialogStage;
    private Alumno alumn;
    private boolean okClicked = false;

    /**
     * Inicializa la clase de controlador. Este método se llama automáticamente
     * después de que el archivo fxml haya sido cargado.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Establece el escenario de este diálogo.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Establece el alumno que se editará en el cuadro de diálogo.
     * 
     * @param alumn
     */
    public void setPerson(Alumno alumn) {
        this.alumn = alumn;

        nombre.setText(alumn.getNombre());
        apellidos.setText(alumn.getApellido());
        cursochoice.setItems(FXCollections.observableArrayList("1A","1B","1C","2A","2B","2C"));
    }

    /**
     * Returns verdadero si el usuario hizo clic en Aceptar, de lo contrario, en falso.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Se llama cuando el usuario hace clic en Aceptar.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            alumn.setFirstName(nombre.getText());
            alumn.setApellido(apellidos.getText());
            alumn.setCurso(cursochoice.getValue().toString());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Se llama cuando el usuario hace clic en cancelar.
     * Cierra el escenario.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     *Valida la entrada del usuario en los campos de texto.
     * 
     * @return true si la entrada es válida
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nombre.getText() == null || nombre.getText().length() == 0) {
            errorMessage += "¡Nombre invalido!\n"; 
        }
        if (apellidos.getText() == null || apellidos.getText().length() == 0) {
            errorMessage += "¡Apellidos invalidos!\n"; 
        }
        if (cursochoice.getValue() == null) {
            errorMessage += "¡Curso invalido!\n"; 
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
           
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
