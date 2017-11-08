/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;

/**
 *
 * @author ITP1DAM
 */
public class Faltas {
    private ObjectProperty<LocalDate> fecha;
    private boolean retraso;

    public Faltas(ObjectProperty<LocalDate> fecha, boolean retraso) {
        this.fecha = fecha;
        this.retraso = retraso;
    }
    
    public ObjectProperty<LocalDate> getFecha() {
        return fecha;
    }

    public void setFecha(ObjectProperty<LocalDate> fecha) {
        this.fecha = fecha;
    }

    public boolean isRetraso() {
        return retraso;
    }

    public void setRetraso(boolean retraso) {
        this.retraso = retraso;
    }
    
    
}
