/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Main.Alumno;
import Main.Faltas;
import Util.DateUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author icc
 */
public class AñadirFaltaController {
    
    @FXML
    private TextField hora;
    
    @FXML
    private CheckBox retraso;
    
    @FXML
    private DatePicker fechapicker;
    
    @FXML
    private ChoiceBox horapick;

    private Stage dialogStage;
    private Faltas falta;
    private boolean okClicked = false;

    @FXML
    private void initialize() { }
    
    
   
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
  /**
   * Metodo con el que se pone una fecha con un data picker
   * Retraso true o false
   * Hora de la falta o retraso
   * @param falta 
   */
    public void setFalta(Faltas falta) {
        this.falta = falta;

        fechapicker.setValue(DateUtil.parse(falta.getFecha()));
        retraso.setSelected(falta.isRetraso());
        horapick.setItems(FXCollections.observableArrayList(1,2,3,4,5,6));
        
    }
    
    /**
     * Devuelve verdadero si el usuario hizo clic en Aceptar, de lo contrario devuelve falso
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
    /**
     * Se llama cuando el usuario hace clic en Aceptar. Guarda una nueva falta.
     * 
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {  
            falta.setFecha(fechapicker.getValue());
            falta.setHora(Integer.parseInt(horapick.getValue().toString()));
            falta.setRetraso(retraso.isSelected());
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Se llama cuando el usuario hace clic en cancelar.
     * Cancela la operación
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * 
     * Valida si todos los campos estan correctos.
     * @return true si los campos son correctos
     */
    private boolean isInputValid() {
        String errorMessage = "";
        
        if (horapick.getValue() == null) {
            errorMessage += "¡Hora invalida!\n";
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

    


