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
public class Movimiento implements Serializable{
    
    private long id_mov;
    private double cantidad_mov;
    private Timestamp duracion_mov;
    private double balance_mov;
    private String descripcion_mov;
    private long id_cta;

    public Movimiento(long id_mov, double cantidad_mov, Timestamp duracion_mov, double balance_mov, String descripcion_mov, long id_cta) {
        this.id_mov = id_mov;
        this.cantidad_mov = cantidad_mov;
        this.duracion_mov = duracion_mov;
        this.balance_mov = balance_mov;
        this.descripcion_mov = descripcion_mov;
        this.id_cta = id_cta;
    }
    
        public Movimiento() {
      
    }

    public void setDatos(){
        System.out.println("CANTIDAD: ");
        cantidad_mov=utilidades.Utilidades.leerDouble();
        //DURACION
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp =  Timestamp.valueOf(now);
        duracion_mov=timestamp;
        System.out.println("BALANCE: ");
        balance_mov=utilidades.Utilidades.leerDouble();
        System.out.println("DESCRIPCION: ");
        descripcion_mov=utilidades.Utilidades.introducirCadena();
    }
    public long getId_mov() {
        return id_mov;
    }

    public void setId_mov(int id_mov) {
        this.id_mov = id_mov;
    }

    public double getCantidad_mov() {
        return cantidad_mov;
    }

    public void setCantidad_mov(float cantidad_mov) {
        this.cantidad_mov = cantidad_mov;
    }

    public Timestamp getDuracion_mov() {
        return duracion_mov;
    }

    public void setDuracion_mov(Timestamp duracion_mov) {
        this.duracion_mov = duracion_mov;
    }

    public double getBalance_mov() {
        return balance_mov;
    }

    public void setBalance_mov(float balance_mov) {
        this.balance_mov = balance_mov;
    }

    public String getDescripcion_mov() {
        return descripcion_mov;
    }

    public void setDescripcion_mov(String descripcion_mov) {
        this.descripcion_mov = descripcion_mov;
    }

    public long getId_cta() {
        return id_cta;
    }

    public void setId_cta(int id_cta) {
        this.id_cta = id_cta;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "id_mov=" + id_mov + ", cantidad_mov=" + cantidad_mov + ", duracion_mov=" + duracion_mov + ", balance_mov=" + balance_mov + ", descripcion_mov=" + descripcion_mov + '}';
    }
      
}

