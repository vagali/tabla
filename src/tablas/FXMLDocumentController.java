/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import javafx.stage.Stage;
import javafx.stage.WindowEvent;


/**
 *
 * @author Sergio
 */
public class FXMLDocumentController{
    private static final Logger LOGGER = Logger.getLogger("ControladorTabla");
    private Stage stage;
    ObservableList<PersonaBeans> personas;
    @FXML TextField txtNombre;
    @FXML TextField txtApellido;
    @FXML TextField txtEdad;
    @FXML private TableColumn columna1;
    @FXML private TableColumn columna2;
    @FXML private TableColumn columna3;
    @FXML private TableView<PersonaBeans> tabla;
    int indiceFilaSeleccionada;
    
    public void initStage(Parent root){
        Scene scene = new Scene(root);
        stage=new Stage();
        stage.setOnShowing(this::HandleWindowShowing);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Tabla");
        
        columna1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columna2.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columna3.setCellValueFactory(new PropertyValueFactory<>("edad"));
        personas = FXCollections.observableArrayList();
        tabla.setItems(personas);
        stage.show();
    }
               
    private void HandleWindowShowing(WindowEvent e){

        
    }
    @FXML
    private void borrarFila(){
        LOGGER.info("he clicado borrar");
        tabla.getItems().remove(tabla.getSelectionModel().getSelectedItem());
        tabla.refresh();
    }
    @FXML
    private void añadirFila(){
        String nombre=txtNombre.getText() ;
        String apellido = txtApellido.getText();
        int edad;
        
        LOGGER.info("he clicado añadir");
        if(txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty()
                || txtEdad.getText().isEmpty())
            LOGGER.info("Vaya parece q no has rellenado todos los datos");
        else{
            edad = Integer.parseInt(txtEdad.getText());
            PersonaBeans persona = new PersonaBeans(nombre,apellido,edad);
            personas.add(persona);
        }
    }
    @FXML
    private void rempFila(){
        LOGGER.info("he clicado remplazar fila");
        String nombre=txtNombre.getText() ;
        String apellido = txtApellido.getText();
        int edad= Integer.parseInt(txtEdad.getText());
        
        PersonaBeans personaModificada = new PersonaBeans(nombre, apellido, edad);
        indiceFilaSeleccionada = tabla.getSelectionModel().getSelectedIndex();
        LOGGER.info("----------NUMERO/INIDICE:"+Integer.toString(indiceFilaSeleccionada));
        personas.set(indiceFilaSeleccionada, personaModificada);
        
        
        int nPersonas = personas.size();
        LOGGER.info("----------NUMERO DE PERSONAS"+Integer.toString(nPersonas));
        for(int i=0;i<nPersonas;i++){
            LOGGER.info("----------pERSONA Nº:"+i+" "+personas.get(i).getNombre());
        } 
    }
}
