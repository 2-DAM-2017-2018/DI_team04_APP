/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asistenciafxml;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.beans.property.ObjectProperty;

/**
 *
 * @author ITP1DAM
 */
public class Alumno {

    private String nombre;
    private String apellido;
    private String curso;
    private ArrayList<Faltas> faltas;

    public Alumno() {
        this.nombre = "Ejemplo";
        this.apellido = "Ejemplez";
        this.curso = "1A";
    }
    
    public Alumno(String nombre, String apellido, String Curso) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the faltas
     */
    public ArrayList getFaltas() {
        return faltas;
    }

    /**
     * @param faltas the faltas to set
     */
    public void setFaltas(ArrayList faltas) {
        this.faltas = faltas;
    }
    
    
}
