/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ITP1DAM
 */
public class Alumno {

    private final StringProperty nombre;
    private final StringProperty apellido;
    private final StringProperty curso;
    private ArrayList<Faltas> faltas;

    public Alumno(String  nombre, String apellido, String curso) {
        this.nombre =new SimpleStringProperty (nombre);
        this.apellido = new SimpleStringProperty (apellido);
        this.curso = new SimpleStringProperty (curso);
    }

  

   

  

   

    public ArrayList<Faltas> getFaltas() {
        return faltas;
    }

    public void setFaltas(ArrayList<Faltas> faltas) {
        this.faltas = faltas;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setFirstName(String nombre) {
        this.nombre.set(nombre);
    }
     public String getApellido() {
        return apellido.get();
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }
    
      public String getCurso() {
        return curso.get();
    }

    public void setCurso(String curso) {
        this.curso.set(curso);
    }
}
