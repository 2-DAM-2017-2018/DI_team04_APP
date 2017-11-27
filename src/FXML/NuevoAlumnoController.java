/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Main.Alumno;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author icc
 */
public class NuevoAlumnoController {

    @FXML
    private TextField nombre;

    @FXML
    private TextField apellidos;

    @FXML
    private TextField curso;

    private Stage dialogStage;
    private Alumno alumno;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(Alumno alumno) {
        this.alumno = alumno;

        nombre.setText(alumno.getNombre());
        apellidos.setText(alumno.getApellido());
        curso.setText(alumno.getCurso());

    }

    public boolean isOkClicked() {
        return okClicked;
    }

    private void handleOk() {
        alumno.setFirstName(nombre.getText());
        alumno.setApellido(apellidos.getText());
        alumno.setCurso(curso.getText());

        okClicked = true;
        dialogStage.close();

    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
