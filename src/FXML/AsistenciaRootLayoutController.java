/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Main.MainApp;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author PEPE E ISMAEL
 */
public class AsistenciaRootLayoutController {

    private MainApp mainApp;

    /**
     * Es llamado por la aplicación principal para devolver una referencia a sí mismo.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Crea una archivo vacío
     */
    @FXML
    private void handleNew() {
        mainApp.getAlumnData().clear();
        mainApp.setAlumnFilePath(null);
    }

    /**
     * Abre el archivo seleccionado y lo cargar
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

      
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

    
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

       if (file != null) {
            mainApp.loadAlumnDataFromFile(file);
        }
    }

    /**
     * Guarda el archivo en el archivo  que está abierto actualmente. Si no hay
     * abrir archivo, se muestra el cuadro de diálogo "guardar como".
     */
    @FXML
    private void handleSave() {
        File alumnFile = mainApp.getAlumnFilePath();
        if (alumnFile != null) {
            mainApp.saveAlumnDataToFile(alumnFile);
        } else {
            handleSaveAs();
        }
    }

    /**
     * Abre un FileChooser para permitir que el usuario seleccione un archivo para guardar.
     */
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.saveAlumnDataToFile(file);
        }
    }

    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
//        Dialogs.create()
//            .title("AddressApp")
//            .masthead("About")
//            .message("Author: Marco Jakob\nWebsite: http://code.makery.ch")
//            .showInformation();
    }

    /**
     * Cierra la aplicación
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    
}
