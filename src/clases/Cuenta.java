/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Fredy Vargas
 * @author Nadir Essadi
 * @author Lorena Cáceres
 * @author Moroni
 * 
 */
public class Cuenta implements Serializable {
    
    private long id_cta;
    private String descripcion_cta;
    private double balance_cta;
    private double linea_cred_cta;
    private Timestamp duracion;
    private double equilibrio_cta;

    public Cuenta(long id_cta, String descripcion_cta, double balance_cta, double linea_cred_cta, Timestamp duracion, double equilibrio_cta) {
        this.id_cta = id_cta;
        this.descripcion_cta = descripcion_cta;
        this.balance_cta = balance_cta;
        this.linea_cred_cta = linea_cred_cta;
        this.duracion = duracion;
        this.equilibrio_cta = equilibrio_cta;
    }
    
    
      public Cuenta() {
       
    }
      
     public void setDatos(){
         System.out.println("DESCRIPCION: ");
         descripcion_cta=utilidades.Utilidades.introducirCadena();
         System.out.println("BALANCE: ");
         balance_cta=utilidades.Utilidades.leerDouble();
         System.out.println("LINEA DE CREDITO: ");
         linea_cred_cta=utilidades.Utilidades.leerDouble();
         //DURACION
         LocalDateTime now = LocalDateTime.now();
         Timestamp timestamp =  Timestamp.valueOf(now);
         duracion=timestamp;
         System.out.println("EQUILIBRIO: ");
         equilibrio_cta=utilidades.Utilidades.leerDouble();
     }
      

    public long getId_cta() {
        return id_cta;
    }

    public void setId_cta(long id_cta) {
        this.id_cta = id_cta;
    }

    public String getDescripcion_cta() {
        return descripcion_cta;
    }

    public void setDescripcion_cta(String descripcion_cta) {
        this.descripcion_cta = descripcion_cta;
    }

    public double getBalance_cta() {
        return balance_cta;
    }

    public void setBalance_cta(double balance_cta) {
        this.balance_cta = balance_cta;
    }

    public double getLinea_cred_cta() {
        return linea_cred_cta;
    }

    public void setLinea_cred_cta(double linea_cred_cta) {
        this.linea_cred_cta = linea_cred_cta;
    }

    public Timestamp getDuracion() {
        return duracion;
    }

    public void setDuracion(Timestamp duracion) {
        this.duracion = duracion;
    }

    public double getEquilibrio_cta() {
        return equilibrio_cta;
    }

    public void setEquilibrio_cta(double equilibrio_cta) {
        this.equilibrio_cta = equilibrio_cta;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id_cta=" + id_cta + ", descripcion_cta=" + descripcion_cta + ", balance_cta=" + balance_cta + ", linea_cred_cta=" + linea_cred_cta + ", duracion=" + duracion + ", equilibrio_cta=" + equilibrio_cta + '}';
    }
    
      
    
}
