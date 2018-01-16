/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Main.Alumno;
import Main.MainApp;
import Main.Faltas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.Action;
import Util.DateUtil;
import javafx.beans.property.StringProperty;

/**
 * FXML Controller class
 *
 * @author icc
 */
public class ListaAlumnosController {

    @FXML
    private TableView<Alumno> tablaAlumnos;
    @FXML
    private TableView<Faltas> tablaAsistencia;

    @FXML
    private TableColumn<Alumno, String> nombreC;
    @FXML
    private TableColumn<Alumno, String> apellidosC;
    @FXML
    private TableColumn<Alumno, String> cursoC;
    @FXML
    private TableColumn<Faltas, String> retrasos;
    @FXML
    private TableColumn<Faltas, String> fechafalta;
    @FXML
    private TableColumn<Faltas, String> hora;

    private MainApp mainApp;

    @FXML
    private void initialize() {
        // Initialize the alumn table
        nombreC.setCellValueFactory(cellData -> cellData.getValue().getNombreProperty());
        apellidosC.setCellValueFactory(cellData -> cellData.getValue().getApellidoProperty());
        cursoC.setCellValueFactory(cellData -> cellData.getValue().getCursoProperty());
        // Clear person details.
        //showFaltas(null);
        tablaAlumnos.setItems(null);
        // Listen for selection changes and show the person details when changed.
        tablaAlumnos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showFaltas(newValue));

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        tablaAlumnos.setItems(mainApp.getAlumnData());
    }

    @FXML
    private void handleNewAlumno() {
        Alumno tempAlumn = new Alumno("Nombre", "Apellido", "Curso");
        boolean okClicked = mainApp.showAlumnEditDialog(tempAlumn);
        if (okClicked) {
            mainApp.getAlumnData().add(tempAlumn);
        }
    }

    @FXML
    private void handleDeleteAlumno() {
        int selectedIndex = tablaAlumnos.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tablaAlumnos.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No seleccionado");
            alert.setHeaderText("Alumno no seleccionada");
            alert.setContentText("Selecciona un alumno de la tabla");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewFalta(ActionEvent event) {
        int selectedIndexAlumno = tablaAlumnos.getSelectionModel().getSelectedIndex();
        Faltas tempFalta = new Faltas();
        boolean okClicked = mainApp.showFaltasEditDialog(tempFalta);
        if (okClicked) {
            mainApp.getAlumnData().get(selectedIndexAlumno).addFalta(tempFalta);
        }
        showFaltas(mainApp.getAlumnData().get(selectedIndexAlumno));
    }

    @FXML
    private void handleCambiarRetraso(ActionEvent event) {
        int selectedIndex = tablaAsistencia.getSelectionModel().getSelectedIndex();
        int selectedIndexAlumno = tablaAlumnos.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            boolean valor = !tablaAlumnos.getSelectionModel().selectedItemProperty().get().getFalta(selectedIndex).isRetraso();
            tablaAsistencia.getItems().get(selectedIndex).setRetraso(valor);
            tablaAlumnos.getSelectionModel().selectedItemProperty().get().getFalta(selectedIndex).setRetraso(valor);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No seleccionado");
            alert.setHeaderText("Falta/retraso no seleccionado");
            alert.setContentText("Selecciona una falta/retraso de la tabla");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleDeleteFalta(ActionEvent event) {
        int selectedIndex = tablaAsistencia.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tablaAsistencia.getItems().remove(selectedIndex);
            tablaAlumnos.getSelectionModel().selectedItemProperty().get().borrarFalta(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No seleccionado");
            alert.setHeaderText("Falta/retraso no seleccionado");
            alert.setContentText("Selecciona una falta/retraso de la tabla");

            alert.showAndWait();
        }
    }

    private void showFaltas(Alumno alumn) {

        ObservableList<Faltas> datos2 = FXCollections.observableArrayList();

        for (int i = 0; i < alumn.getFaltas().size(); i++) {
            datos2.add(alumn.getFaltas().get(i));
        }

        tablaAsistencia.setItems(datos2);

        if (alumn != null) {
            fechafalta.setCellValueFactory(cellData -> cellData.getValue().getFechaProperty().asString());
            retrasos.setCellValueFactory(cellData -> cellData.getValue().isRetrasoProperty().asString());
            hora.setCellValueFactory(cellData -> cellData.getValue().getHoraProperty().asString());
        } else {
            // Person is null, remove all the text.
            retrasos.setCellValueFactory(null);
            fechafalta.setCellValueFactory(null);
        }
    }
}
