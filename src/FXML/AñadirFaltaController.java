/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Main.Alumno;
import Main.Faltas;
import Util.DateUtil;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author icc
 */
public class AñadirFaltaController {

    @FXML
    private TextField fecha;
    
    @FXML
    private TextField hora;
    
  
    
    @FXML
    private CheckBox retraso;

    private Stage dialogStage;
    
    private Faltas falta;
    private boolean okClicked = false;


  
    
    

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
          // alumn.setNombre(nombre.getText());
            falta.setFecha(DateUtil.parse(fecha.getText()));  
            falta.setHora(Integer.parseInt(hora.getText()));
            falta.setRetraso(retraso.isSelected());

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

        if (fecha.getText() == null || fecha.getText().length() == 0) {
            errorMessage += "¡Fecha invalida!\n"; 
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
     public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
     
     public void setPerson(Faltas falta) {
        this.falta = falta;

        //nombre.setText(alumn.getNombre());
        //apellidos.setText(alumn.getApellido());
        //curso.setText(alumn.getCurso());
    }
     public boolean isOkClicked() {
        return okClicked;
    }
}

    


