/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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
    private final ArrayList<Faltas> faltas;

    public Alumno(String  nombre, String apellido, String curso) {
        this.nombre =new SimpleStringProperty (nombre);
        this.apellido = new SimpleStringProperty (apellido);
        this.curso = new SimpleStringProperty (curso);
        this.faltas= new ArrayList();
    }
    public Alumno(String  nombre, String apellido, String curso, int anno, int mes, int dia) {
        this.nombre =new SimpleStringProperty (nombre);
        this.apellido = new SimpleStringProperty (apellido);
        this.curso = new SimpleStringProperty (curso);
        this.faltas= new ArrayList();
        this.faltas.add(new Faltas(anno,mes,dia,true));
        this.faltas.add(new Faltas(anno,mes,dia,false));
    }

    public Alumno() {
        this.nombre=new SimpleStringProperty ("");
        this.apellido=new SimpleStringProperty ("");
        this.curso=new SimpleStringProperty ("");
        this.faltas= new ArrayList();
    }
    
    public ArrayList<Faltas> getFaltas() {
        return faltas;
    }

    public StringProperty getNombreProperty() {
        return nombre;
    }

    public StringProperty getApellidoProperty() {
        return apellido;
    }

    public StringProperty getCursoProperty() {
        return curso;
    }

    public String getNombre() {
        return nombre.get();
    }

     public String getApellido() {
        return apellido.get();
    }

      public String getCurso() {
        return curso.get();
    }

    /*public void setFaltas(int anno,int dia,int mes, boolean retraso) {
        this.faltas.add(anno,dia,mes,retraso);
    }*/
    
    public void setFirstName(String nombre) {
        this.nombre.set(nombre);
    }
    
    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }
    
    public void setCurso(String curso) {
        this.curso.set(curso);
    }
    
}
