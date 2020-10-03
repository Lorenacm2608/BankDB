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
public class Cliente_cuenta implements Serializable{
    
    private long id_cli;
    private long id_cta;

    public Cliente_cuenta(long id_cli, long id_cta) {
        this.id_cli = id_cli;
        this.id_cta = id_cta;
    }
    
    public Cliente_cuenta() {
       
    }

    public long getId_cli() {
        return id_cli;
    }

    public void setId_cli(long id_cli) {
        this.id_cli = id_cli;
    }

    public long getId_cta() {
        return id_cta;
    }

    public void setId_cta(long id_cta) {
        this.id_cta = id_cta;
    }
       
       
    
}
