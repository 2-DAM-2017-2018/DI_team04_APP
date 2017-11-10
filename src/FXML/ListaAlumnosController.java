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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javax.swing.Action;

/**
 * FXML Controller class
 *
 * @author icc
 */
public class ListaAlumnosController {

   @FXML
    private ListView<Alumno> lista;
   
   @FXML
    private TableView<Alumno> tablaAsistencia;
   
   @FXML
   private Button AñadirFalta;
   
   @FXML
   private Button BorrarFalta;
   
   @FXML
   private Button Retraso;
   
   @FXML
   private Button Quitarretraso;
   
   
   ObservableList<Alumno> alumno;
   
   private int posicionAlumnoTabla;
   
   private int faltas;
   private int retrasos;
   
   private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
            
    }
    
    @FXML
    private void añadirFalta(ActionEvent event)
            
           
    {
        
    }
     @FXML
    private void borrarFalta(ActionEvent event)
    {
        
    }
     @FXML
    private void añadirRetraso(ActionEvent event)
    {
        
    }
    
     @FXML
    private void borrarRetraso(ActionEvent event)
    {
        
    }
}
