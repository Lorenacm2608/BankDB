/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import clases.Cliente;
import clases.Cuenta;
import clases.Movimiento;
import control.DAO;
import java.util.ArrayList;

/**
 *
 * @author Fredy Vargas
 * @author Moroni Collazos
 * @author Nadir Essadi
 * @author Lorena Cáceres
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc;
		do {
			opc=menu();
			switch(opc) {
			case 1:
				alta();
				break;
			case 2:
				consultarDatosCliente();
				break;
			case 3:
				consultarCuentaCliente();
				break;
			case 4:
				crearCuentaCliente();
				break;
			case 5:
                                añadirClienteCuenta();
				break;
                        case 6:
                            consultarCuenta();
				break;
                        case 7:
                            realizarMovimiento();
				break;
                        case 8:
                            consultarMovimiento();
				break;
                        case 9:
                           System.out.println("Hasta luego!"); 
				break;
			}
		}while(opc!=9);
    }
    private static int menu() {
                int opc;
		System.out.println("//////MENU///////");
		System.out.println("1.- Crear cliente");
		System.out.println("2.- Consultar datos de un cliente");
		System.out.println("3.- Consultar cuentas de un cliente");
		System.out.println("4.- Crear cuenta para cliente");
		System.out.println("5.- Agregar cliente a cuenta");
                System.out.println("6.- Consultar datos de una cuenta ");
		System.out.println("7.- Realizar movimiento (movement) sobre una cuenta");
                System.out.println("8.- Consultar movimientos de una cuenta");
                System.out.println("9.- Salir.");
                opc=utilidades.Utilidades.leerInt();
		return opc;
	}
    
    //Metodo 1 --> Crear cliente 
    private static void alta(){ 
        int opc;
        System.out.println("¿Deseas introducir un nuevo cliente? (1-S/2-N)");
        opc=utilidades.Utilidades.leerInt(1,2);
        DAO dao = new DAO();
        if(opc==1){
            Cliente cli = new Cliente();
            cli.setDatos();
            dao.setCliente(cli); 
    
        }else{
            System.out.println("Cancelar");
        }
    }
    //Metodo 2 --> Consultar datos de un cliente
    private static void consultarDatosCliente() {
       DAO dao = new DAO();
       Cliente cli = new Cliente();
       String nom, apel1;
       
       System.out.println("NOMBRE CLIENTE:");
       nom=utilidades.Utilidades.introducirCadena();
       System.out.println("PRIMER APELLIDO:");
       apel1=utilidades.Utilidades.introducirCadena();
       cli = dao.ConsultaCliente(nom, apel1);
       if(cli!=null){
        System.out.println("--CLIENTE ENCONTRADO-- ");
        System.out.println(cli.toString());
    }
    }
     //Metodo 3 --> Consultar cuentas de un cliente
      public static void consultarCuentaCliente(){     
       DAO dao = new DAO();
       ArrayList <Cuenta> cuentas = new ArrayList <Cuenta>();
       String nom, apel1;
            
       System.out.println("NOMBRE CLIENTE:");
       nom=utilidades.Utilidades.introducirCadena();
       System.out.println("PRIMER APELLIDO:");
       apel1=utilidades.Utilidades.introducirCadena();
       cuentas = dao.ConsultarCuentaCliente(nom, apel1);
       if(cuentas.size()>0){
            System.out.println("--CUENTA ENCONTRADA DEL CLIENTE: " + nom + " " + apel1 + " --");
           for(Cuenta c : cuentas){
             System.out.println(c.toString()); 
           }
        }else{
           System.out.println("No se han encontrado cuentas");
       }
      }
      
    //Metodo 4 --> Crear cuenta para cliente
    private static void crearCuentaCliente() {
       DAO dao = new DAO();
       Cuenta cta = new Cuenta();
       Cliente cli = new Cliente();
       String nom, apel1;   
       
       System.out.println("NOMBRE CLIENTE:");
       nom=utilidades.Utilidades.introducirCadena();
       System.out.println("PRIMER APELLIDO:");
       apel1=utilidades.Utilidades.introducirCadena();
      
       cli = dao.ConsultaCliente(nom, apel1);
       if(cli!=null){
           System.out.println("--NUEVA CUENTA--");
           cta.setDatos();
           dao.crearCuenta(cta);
           
           Long wIDcli, wIDcta;
           cli = dao.ConsultaCliente(nom, apel1);
           cta = dao.ultimaCuenta();
           wIDcta=cta.getId_cta();
           wIDcli = cli.getId_cli();
           
       }
       
    }
    //Metodo 5 --> Agregar cliente a cuenta
    private static void añadirClienteCuenta() {
       DAO dao = new DAO();
       Cuenta cta = new Cuenta();
       Cliente cli = new Cliente();
       Long wIDcta, wIDcli; 
       int resp;
      
           System.out.println("NOMBRE CLIENTE: ");
           String nom=utilidades.Utilidades.introducirCadena();
           System.out.println("PRIMER APELLIDO: ");
           String apel=utilidades.Utilidades.introducirCadena();
           cli=dao.ConsultaCliente(nom, apel);
           if(cli!=null){
               System.out.println("--CLIENTE ENCONTRADO--");
               System.out.println("¿Desea introducir una nueva cuenta? (1-S/2-N)");
               resp=utilidades.Utilidades.leerInt(1,2);
                if(resp==1){
                   cta.setDatos();
                   dao.crearCuenta(cta);
                   
                     cli = dao.ConsultaCliente(nom, apel);
                     cta = dao.ultimaCuenta();
                     wIDcli = cli.getId_cli();
                }else{
                    System.out.println("CANCELAR");
                }    
           }else{
              System.out.println("Si quieres registrarte como NUEVO CLIENTE. Pulse 1 - SI/ 2-NO " );
              resp=utilidades.Utilidades.leerInt(1,2);
                if(resp==1){
                    alta();
                }else{
                    System.out.println("Hasta luego");
                }
           }
   }
    
     //Metodo 6 --> Consultar datos de una cuenta
    private static void consultarCuenta() {
        long wID; 
        Cuenta cta = new Cuenta();
        DAO dao = new DAO();
        System.out.println("Introduce el ID de la cuenta: ");
        wID=utilidades.Utilidades.leerLong();
        cta = dao.getCuenta(wID);
        if(cta!=null){
        System.out.println("--CUENTA ENCONTRADA-- ");
        System.out.println(cta.toString());
       }
    }
    
    //Metodo 7 --> Realizar movimiento (movement) sobre una cuenta
    private static void realizarMovimiento() {
       long wIDcta;
       int resp;
       DAO dao = new DAO();
       System.out.println("ID DE LA CUENTA: ");
       wIDcta=utilidades.Utilidades.leerLong();
       Cuenta cta = dao.getCuenta(wIDcta);
       System.out.println("--CUENTA ENCONTRADA-- ");
       System.out.println(cta.toString());
       System.out.println("--¿ES ESTA LA CUENTA EN LA QUE QUIERES REALIZAR MOVIMIENTOS?(1-SI/2-NO)-- ");
       resp=utilidades.Utilidades.leerInt(1,2);
        if(resp==1){
            do{
            System.out.println("¿REALIZAR MOVIMIENTOS? (1-SI/2-NO)");
            resp=utilidades.Utilidades.leerInt(1,2);
                if(resp!=2){
                  Movimiento mov = new Movimiento();
                  mov.setDatos();
                  dao.setMovimiento(cta, mov);
                  
               }
        }while(resp==1);
       }else{
            System.out.println("CANCELAR");
        }
       
    }
    //Metodo 8 --> Consultar movimientos de una cuenta
    private static void consultarMovimiento() {
        Long wID;
        int opc;
        DAO dao = new DAO();
        ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
        System.out.println("ID DE LA CUENTA: ");
        wID = utilidades.Utilidades.leerLong();
        movimientos = dao.getMovimiento(wID);
        if (movimientos.size() > 0) {
            System.out.println("MOVIMIENTOS ENCONTRADOS DE LA CUENTA: " + wID);
            for (Movimiento m : movimientos) {
                System.out.println(m.toString());
            }
        } else {
            System.out.println("No se han encontrado movimientos");
        }

    }
}



