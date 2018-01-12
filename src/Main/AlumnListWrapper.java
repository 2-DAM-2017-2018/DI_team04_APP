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
 * Helper class to wrap a list of alumns. This is used for saving the
 list of alumns to XML.
 * 
 * @author Marco Jakob
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