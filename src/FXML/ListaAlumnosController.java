/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Main.Alumno;
import Main.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.Action;

/**
 * FXML Controller class
 *
 * @author icc
 */
public class ListaAlumnosController {

    @FXML
    private TableView<Alumno> lista;
    /*@FXML
    private TableView<Alumno> tablaAsistencia;*/
    

    @FXML
    private TableColumn<Alumno,String> nombreC;
    @FXML
    private TableColumn<Alumno,String> apellidosC;
    @FXML
    private TableColumn<Alumno,String> cursoC;
    /*@FXML
    private TableColumn retrasos;
    @FXML
    private TableColumn faltas;
    
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
        // Initialize the person table with the two columns.
        nombreC.setCellValueFactory(cellData -> cellData.getValue().getNombreProperty());
        apellidosC.setCellValueFactory(cellData -> cellData.getValue().getApellidoProperty());
        cursoC.setCellValueFactory(cellData -> cellData.getValue().getCursoProperty());
    
        // Clear person details.
        //showPersonDetails(null);
        lista.setItems(null);
        // Listen for selection changes and show the person details when changed.
        //lista.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));

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
}
