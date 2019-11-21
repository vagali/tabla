/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.IOException;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Sergio
 */
public class Tablas extends Application {
    private static final Logger LOGGER = Logger.getLogger("Tablas");
    @Override
    public void start(Stage stage) throws Exception {
        try{
            FXMLLoader loader = new FXMLLoader(getClass()
            .getResource("FXMLDocument.fxml"));

            Parent root = (Parent) loader.load();

            FXMLDocumentController controller
            = ((FXMLDocumentController) loader.getController());

            controller.initStage(root);
        }catch(IOException e){
            LOGGER.info("Error al cargar la ventana");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    
}
