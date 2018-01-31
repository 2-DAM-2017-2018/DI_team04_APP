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
 * @author PEPE E ISMAEL
 */
public class MainApp extends Application {
  
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Alumno> alumnData = FXCollections.observableArrayList();

    
    /**
     * Llama al escenario principal
     * @param primaryStage 
     */
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
     * Constructor por defecto 
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
     * Devuelve los datos como un ObservableList de Alumnos.
     * @return
     */
    public ObservableList<Alumno> getAlumnData() {
        return alumnData;
    }
    /**
     * Inicializa el root layout.
     */
    public void initRootLayout() {
        try {
             // Carga el root layout del archivo fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getClassLoader().getResource("FXML/AsistenciaRootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

          
            //Muestra la escena que contiene el root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            //Da acceso al controlador a la aplicación principal
            AsistenciaRootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Intenta cargar el último archivo de alumnos abiero.
        File file = getAlumnFilePath();
        if (file != null) {
            loadAlumnDataFromFile(file);
        }
    }
    /**
     *Muestra la vista general de la persona dentro del root layout
     */
    public void showAlumnOverview() {
        try {
        // Carga el alumno overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getClassLoader().getResource("FXML/ListaAlumnos.fxml"));
        AnchorPane listaAlumnos = (AnchorPane) loader.load();

        
        rootLayout.setCenter(listaAlumnos);

        // Da acceso al controlador a la aplicación principal
        ListaAlumnosController controller = loader.getController();
        controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /**
    * Abre un cuadro de diálogo para editar los detalles del alumno especificado. 
    * Si el usuario hace clic en Aceptar, los cambios se guardan en el objeto 
    * de alumno proporcionado y se devuelve verdadero.
    * @param alumn el alumno que será editado
    * @return Devuelve true si el usuario hace clic en OK o fase si es al contrario
    */
   
    public boolean showAlumnEditDialog(Alumno alumn) {
        try {
             
            // Carga el archivo fxml y crea un nuevo escenario.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getClassLoader().getResource("FXML/AñadirAlumno.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Crea el dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editar alumno");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set del alumno en el controlador controller.
            AñadirAlumnoController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(alumn);

            // Muestra el diolog y espera hasta que el usuario lo cierra
            
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Devuelve el escenario principal.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Devuelve el ultimo archivo abierto.
     * Lee el preferences del registro específico del sistema operativo, 
     * si no se puede encontrar dicha preferencia devuelve null.
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
     * Establece la ruta de archivo del archivo cargado actualmente. 
     * La ruta se conserva en el registro específico del sistema operativo.
     * 
     * @param file el archivo o null para eliminar la ruta
     */
    public void setAlumnFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("AsistenciaFxml - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("AsistenciaFxml");
        }
    } 

    /**
    * Carga datos de personas del archivo especificado. La información actual de la persona
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
     * Guarda los datos de la persona actual en el archivo especificado.
     * 
     * @param file
     */
    public void saveAlumnDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(AlumnListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            AlumnListWrapper wrapper = new AlumnListWrapper();
            wrapper.setAlumns(alumnData);

            m.marshal(wrapper, file);

            setAlumnFilePath(file);
        } catch (Exception e) { // catches ANY exception
    //                Dialogs.create().title("Error")
    //                .masthead("Could not save data to file:\n" + file.getPath())
    //                .showException(e);
        }
    }
    /**
     * Carga el archivo xml y crea un nuevo escenario. 
     * Establecer al alumno en el controlador.
     * Muestra el dialog y espera hasta que el usuario lo cierra.
     * @param falta
     * @return 
     */
    public boolean showFaltasEditDialog(Faltas falta) {
        try {
           
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getClassLoader().getResource("FXML/AñadirFalta.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nueva falta");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            
            AñadirFaltaController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFalta(falta);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
