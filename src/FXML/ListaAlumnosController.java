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
    private TableView<Alumno> lista;
    @FXML
    private TableView<Faltas> tablaAsistencia;
    

    @FXML
    private TableColumn<Alumno,String> nombreC;
    @FXML
    private TableColumn<Alumno,String> apellidosC;
    @FXML
    private TableColumn<Alumno,String> cursoC;
    @FXML
    private TableColumn<Faltas,String> retrasos;
    @FXML
    private TableColumn<Faltas,String> faltas;
    /*
    @FXML
    private Button AnnadirFalta;

    @FXML
    private Button BorrarFalta;

    @FXML
    private Button Retraso;

    @FXML
    private Button Quitarretraso;

   

    private int faltas2;
    private int retrasos2;*/
    private MainApp mainApp;

    @FXML
    private void initialize() {
        // Initialize the alumn table
        nombreC.setCellValueFactory(cellData -> cellData.getValue().getNombreProperty());
        apellidosC.setCellValueFactory(cellData -> cellData.getValue().getApellidoProperty());
        cursoC.setCellValueFactory(cellData -> cellData.getValue().getCursoProperty());
        // Clear person details.
        //showFaltas(null);
        lista.setItems(null);
        // Listen for selection changes and show the person details when changed.
        lista.getSelectionModel().selectedItemProperty().addListener(
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
        System.out.println(mainApp.getAlumnData().toString());
        lista.setItems(mainApp.getAlumnData());
    }
    @FXML
    private void handleNewAlumno() {
        Alumno tempAlumn = new Alumno("Nombre","Apellido","Curso");
        boolean okClicked = mainApp.showAlumnEditDialog(tempAlumn);
        if (okClicked) {
            mainApp.getAlumnData().add(tempAlumn);
        }
    }
    @FXML
    private void handleDeleteAlumno() {
        int selectedIndex = lista.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            lista.getItems().remove(selectedIndex);
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
    
/*
    @FXML
    private void añadirFalta(ActionEvent event) {
        
        faltas2 = faltas2 + 1;
    }

    @FXML
    private void borrarFalta(ActionEvent event) {
        faltas2 = faltas2 - 1;
    }

    @FXML
    private void añadirRetraso(ActionEvent event) {
        retrasos2 = retrasos2 + 1;
    }

    @FXML
    private void borrarRetraso(ActionEvent event) {
       
      retrasos2 = retrasos2 - 1;
      
    }
 */

    private void showFaltas(Alumno alumn) {
        
        ObservableList<Faltas> datos2 = FXCollections.observableArrayList();

        for(int i=0;i<alumn.getFaltas().size();i++){
            datos2.add(alumn.getFaltas().get(i));
            faltas.setCellValueFactory(cellData -> alumn.getFaltas().get(0).getFechaProperty().asString());
            //retrasos.setCellValueFactory(cellData -> new ObservableValue());
        }
        
        tablaAsistencia.setItems(datos2);
        
        if (alumn != null) {
            //for(int i=0;i<alumn.getFaltas().size();i++){
                //1faltas.setCellValueFactory(cellData -> cellData.getValue().getFaltas().get(0).getFechaProperty().asString());
            //}
        } else {
            // Person is null, remove all the text.
            retrasos.setCellValueFactory(null);
            faltas.setCellValueFactory(null);
        }
    }
}
