/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author Fredy Vargas
 * @author Nadir Essadi
 * @author Lorena Cáceres
 * @author Moroni
 */
public class Cliente implements Serializable {
    
    private long id_cli;
    private String nombre_cli;
    private String apellido1_cli;
    private String apellido2_cli;
    private String calle;
    private String ciudad;
    private String estado;
    private int cp;
    private long telefono_cli;
    private String correo_cli;
    
//Constructores
    
    public Cliente(long id_cli, String nombre_cli, String apellido1_cli, String apellido2_cli, String calle, String ciudad, String estado, int cp, long telefono_cli, String correo_cli) {
        this.id_cli = id_cli;
        this.nombre_cli = nombre_cli;
        this.apellido1_cli = apellido1_cli;
        this.apellido2_cli = apellido2_cli;
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.cp = cp;
        this.telefono_cli = telefono_cli;
        this.correo_cli = correo_cli;
    }
    
     public Cliente() {
      
    }
    
    //getters and setters
     
     public void setDatos(){
          //System.out.println("ID: " + id_cli);
           System.out.println("Ciudad");
           ciudad=utilidades.Utilidades.introducirCadena();
           System.out.println("Email");
           correo_cli=utilidades.Utilidades.introducirCadena();
           System.out.println("Nombre");
           nombre_cli=utilidades.Utilidades.introducirCadena();
           System.out.println("Primer apellido");
           apellido1_cli=utilidades.Utilidades.introducirCadena();
           System.out.println("Segundo apellido");
           apellido2_cli=utilidades.Utilidades.introducirCadena();
           System.out.println("Telefono");
           telefono_cli=utilidades.Utilidades.leerLong();
           System.out.println("Estado");
           estado=utilidades.Utilidades.introducirCadena();
           System.out.println("Calle");
           calle=utilidades.Utilidades.introducirCadena();
           System.out.println("Codigo postal");
           cp=utilidades.Utilidades.leerInt();
         
         
     }

    public long getId_cli() {
        return id_cli;
    }

    public void setId_cli(long id_cli) {
        this.id_cli = id_cli;
    }

    public String getNombre_cli() {
        return nombre_cli;
    }

    public void setNombre_cli(String nombre_cli) {
        this.nombre_cli = nombre_cli;
    }

    public String getApellido1_cli() {
        return apellido1_cli;
    }

    public void setApellido1_cli(String apellido1_cli) {
        this.apellido1_cli = apellido1_cli;
    }

    public String getApellido2_cli() {
        return apellido2_cli;
    }

    public void setApellido2_cli(String apellido2_cli) {
        this.apellido2_cli = apellido2_cli;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public long getTelefono_cli() {
        return telefono_cli;
    }

    public void setTelefono_cli(long telefono_cli) {
        this.telefono_cli = telefono_cli;
    }

    public String getCorreo_cli() {
        return correo_cli;
    }

    public void setCorreo_cli(String correo_cli) {
        this.correo_cli = correo_cli;
    }

    public void getApellido2_cli(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cli=" + id_cli + ", nombre_cli=" + nombre_cli + ", apellido1_cli=" + apellido1_cli + ", apellido2_cli=" + apellido2_cli + ", calle=" + calle + ", ciudad=" + ciudad + ", estado=" + estado + ", cp=" + cp + ", telefono_cli=" + telefono_cli + ", correo_cli=" + correo_cli + '}';
    }
     
     
    
    
}
