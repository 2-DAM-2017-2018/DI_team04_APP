/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Main.Alumno;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

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
   
}
