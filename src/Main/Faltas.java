/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Util.DateUtil;
import Util.LocalDateAdapter;
import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import static javafx.beans.property.BooleanProperty.booleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author ITP1DAM
 */
public class Faltas {
    private final ObjectProperty<LocalDate> fecha;
    private final BooleanProperty retraso;
    private final IntegerProperty hora;

    public Faltas(int anno,int dia,int mes, boolean retraso,int hora) {
        this.fecha = new SimpleObjectProperty<LocalDate>(LocalDate.of(anno,dia,mes));
        this.retraso = new SimpleBooleanProperty (retraso);
        this.hora = new SimpleIntegerProperty(hora);
    }
    
    public Faltas(){
        fecha = new SimpleObjectProperty<LocalDate>(LocalDate.now());
        retraso =  new SimpleBooleanProperty (true);
        hora =  new SimpleIntegerProperty(5);
    }
    
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public String getFecha() {
        return DateUtil.format(fecha.get());
    }
    
    public ObjectProperty<LocalDate> getFechaProperty(){
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha.set(fecha);
    }

    public boolean isRetraso() {
        return retraso.get();
    }
    
    public BooleanProperty isRetrasoProperty() {
        return retraso;
    }

    public void setRetraso(boolean retraso) {
        this.retraso.set(retraso);
    }
    
    public int getHora(){
        return this.hora.get();
    }
    
    public void setHora(int hora)
    {
        this.hora.set(hora);
    }
    public IntegerProperty getHoraProperty(){
        return hora;
    }

 
    
    
}
