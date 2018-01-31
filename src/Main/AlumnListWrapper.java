/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Esto se usa para guardar la lista de los alumnos en un XML
 * 
 * 
 * @author PEPE E ISMAEL
 */
@XmlRootElement(name = "alumns")
public class AlumnListWrapper {

    private List<Alumno> alumns;
    
    @XmlElement(name = "alumn")
    public List<Alumno> getAlumns() {
        return alumns;
    }

    public void setAlumns(List<Alumno> alumns) {
        this.alumns = alumns;
    }
}