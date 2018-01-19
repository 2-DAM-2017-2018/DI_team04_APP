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
    public void setFalta(Faltas falta) {
        this.falta = falta;

        fechapicker.setValue(DateUtil.parse(falta.getFecha()));
        retraso.setSelected(falta.isRetraso());
        horapick.setItems(FXCollections.observableArrayList(1,2,3,4,5,6));
        
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
            falta.setFecha(fechapicker.getValue());
            falta.setHora(Integer.parseInt(horapick.getValue().toString()));
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
        
        if (horapick.getValue() == null) {
            errorMessage += "¡Hora invalida!\n";
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

    


