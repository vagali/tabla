/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Sergio
 */
public class PersonaBeans {

    private SimpleStringProperty nombre;
    private SimpleStringProperty apellido;
    private SimpleIntegerProperty edad;


    public PersonaBeans(String nombre,String apellido,Integer edad){
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.edad = new SimpleIntegerProperty(edad);
    }

    public String getNombre(){
        return this.nombre.get();
    }
     public String getApellido(){
        return this.apellido.get();
    }
      public int getEdad(){
        return this.edad.get();
    }

}
