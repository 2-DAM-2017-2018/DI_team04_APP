/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

//import FXML.makery.address.model.PersonListWrapper;
import FXML.AñadirAlumnoController;
import FXML.ListaAlumnosController;
import FXML.AsistenciaRootLayoutController;
import FXML.AñadirFaltaController;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author franciscogonzalezdelvalle
 */
public class MainApp extends Application {
  
    private Stage primaryStage;
    private BorderPane rootLayout;
    

    /**
     * The data as an observable list of Persons.
     */
    
    private ObservableList<Alumno> alumnData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Listado de alumnos");
        
        // set the application icon
        /*this.primaryStage.getIcons().add(new Image("file:resources/images/MailIcon.png"));*/

        initRootLayout();

        showAlumnOverview();
    }

    /**
     * Constructor
     */
    public MainApp() {
        //Add some sample data
       alumnData.add(new Alumno("Hans", "Muster", "1A",2016,11,11,2));
       alumnData.add(new Alumno("Ruth", "Mueller", "1A",2016,12,11,3));
       alumnData.add(new Alumno("Heinz", "Kurz", "1B",2016,1,11,4));
       alumnData.add(new Alumno("Cornelia", "Meier", "1B",2016,3,11,5));
       alumnData.add(new Alumno("Werner", "Meyer", "2A",2016,6,11,6));
       alumnData.add(new Alumno("Lydia", "Kunz", "2A",2016,8,11,7));
       alumnData.add(new Alumno("Anna", "Best", "2B",2016,5,11,8));
       alumnData.add(new Alumno("Stefan", "Meier", "2B",2016,11,11,9));
    }

    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    public ObservableList<Alumno> getAlumnData() {
        return alumnData;
    }
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
             // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getClassLoader().getResource("FXML/AsistenciaRootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            AsistenciaRootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Try to load last opened person file.
        File file = getAlumnFilePath();
        if (file != null) {
            loadAlumnDataFromFile(file);
        }
    }
    /**
     * Shows the person overview inside the root layout.
     */
    public void showAlumnOverview() {
        try {
        // Load person overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getClassLoader().getResource("FXML/ListaAlumnos.fxml"));
        AnchorPane listaAlumnos = (AnchorPane) loader.load();

        // Set person overview into the center of root layout.
        rootLayout.setCenter(listaAlumnos);

        // Give the controller access to the main app.
        ListaAlumnosController controller = loader.getController();
        controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     * 
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showAlumnEditDialog(Alumno alumn) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getClassLoader().getResource("FXML/AñadirAlumno.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editar alumno");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AñadirAlumnoController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(alumn);

            // Set the dialog icon.
    //        dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Returns the person file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     * 
     * @return
     */
    public File getAlumnFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     * 
     * @param file the file or null to remove the path
     */
    public void setAlumnFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("AddressApp");
        }
    } 

    /**
    * Loads person data from the specified file. The current person data will
    * be replaced.
    * 
    * @param file
    */
   public void loadAlumnDataFromFile(File file) {
       try {
           JAXBContext context = JAXBContext.newInstance(AlumnListWrapper.class);
           Unmarshaller um = context.createUnmarshaller();

           // Reading XML from the file and unmarshalling.
           AlumnListWrapper wrapper = (AlumnListWrapper) um.unmarshal(file);

           alumnData.clear();
           alumnData.addAll(wrapper.getAlumns());

           // Save the file path to the registry.
           setAlumnFilePath(file);

       } catch (Exception e) { // catches ANY exception
   //        Dialogs.create()
   //                .title("Error")
   //                .masthead("Could not load data from file:\n" + file.getPath())
   //                .showException(e);
       }
    }

    /**
     * Saves the current person data to the specified file.
     * 
     * @param file
     */
    public void saveAlumnDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(AlumnListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            AlumnListWrapper wrapper = new AlumnListWrapper();
            wrapper.setAlumns(alumnData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setAlumnFilePath(file);
        } catch (Exception e) { // catches ANY exception
    //                Dialogs.create().title("Error")
    //                .masthead("Could not save data to file:\n" + file.getPath())
    //                .showException(e);
        }
    }
     public boolean showFaltasEditDialog(Faltas falta) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getClassLoader().getResource("FXML/AñadirFalta.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nueva falta");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AñadirFaltaController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(falta);

            // Set the dialog icon.
    //        dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
