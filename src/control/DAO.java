/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clases.Cliente;
import clases.Cuenta;
import clases.Movimiento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 
 * @author Fredy Vargas
 * @author Nadir Essadi
 * @author Lorena Cáceres
 * @author Moroni Collazos
 */
public class DAO {
    
        private Connection con;
        private Statement stmt;
        private ResourceBundle rb = ResourceBundle.getBundle("control.config");
        
        //Método que nos conecta con la BD
        public void openConnection() throws ClassNotFoundException, SQLException{
            
          try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties connectionProps = new Properties();
            connectionProps.put("user", rb.getString("DBUser"));
            connectionProps.put("password", rb.getString("DBPass"));
            this.con = DriverManager.getConnection(rb.getString("Conn"), connectionProps);
            
        } catch (SQLException | ClassNotFoundException ex) {
              System.out.println("ERROR para conectar con la BD");
        }
          
        }
        
        //Método que nos desconecta con la BD
        public void closeConnection() throws SQLException{
            con.close();
        }
    
        //Método de CrearCliente
        public void setCliente(Cliente cli){
            try{
                PreparedStatement ps;
                String query;
                query = "INSERT INTO customer(city,email,firstName,lastName,middleInitial,phone,state,street,zip)VALUES(?,?,?,?,?,?,?,?,?)";
                openConnection();
                try{
                    ps = con.prepareStatement(query);
                    ps.setString(2,cli.getCiudad());
                    ps.setString(3, cli.getCorreo_cli());
                    ps.setString(4, cli.getNombre_cli());
                    ps.setString(5, cli.getApellido1_cli());
                    ps.setString(6, cli.getApellido2_cli());
                    ps.setLong(7, cli.getTelefono_cli());
                    ps.setString(8, cli.getEstado());
                    ps.setString(9, cli.getCalle());
                    ps.setInt(10, cli.getCp());
                    ps.execute();
                    ps.close();
                    closeConnection();
                }catch(SQLException e){
                    System.out.println("ERROR");
                }
            }catch(ClassNotFoundException | SQLException ex){
                System.out.println("ERROR en abrir la Conexion");
            }
        }
        //Método para ConsultarUnCliente
        public Cliente ConsultaCliente(String nombre, String apel1){
            Cliente cli=null;
            try {
                openConnection();
                stmt = con.createStatement();
                String query = "SELECT * FROM CUSTOMER WHERE firstName = '" + nombre + "' and lastName = '" + apel1 + "'";
                ResultSet rs = stmt.executeQuery(query);
                if(rs.next()){
                    cli = new Cliente();
                    cli.setId_cli(rs.getLong("id"));
                    cli.setCiudad(rs.getString("city"));
                    cli.setCorreo_cli(rs.getString("email"));
                    cli.setNombre_cli(rs.getString("firstName"));
                    cli.setApellido1_cli(rs.getString("lastName"));
                    cli.setApellido2_cli(rs.getString("middleInitial"));
                    cli.setTelefono_cli(rs.getLong("phone"));
                    cli.setEstado(rs.getString("state"));
                    cli.setCalle(rs.getString("street"));
                    cli.setCp(rs.getInt("zip"));
                   rs.close();
                   closeConnection();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                 System.out.println("ERROR");
            }
            return cli;
           
            }
        //Metodo para consultar cuentas de un cliente pasandole el nombre y apellido del cliente
        public ArrayList <Cuenta> ConsultarCuentaCliente(String nom, String apel1){
            Cuenta cta=null;
            ArrayList <Cuenta> cuentas = new ArrayList <Cuenta>();
            try {
                openConnection();
                stmt = con.createStatement();
                String query = "SELECT * FROM account a, customer c, customer_account ca where a.id=ca.accounts_id and c.id=ca.customers_id and firstName = '" + nom +"' and lastName = '" + apel1 +"'";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    cta = new Cuenta();
                    cta.setId_cta(rs.getLong("id"));
                    cta.setBalance_cta(rs.getDouble("balance"));
                    cta.setEquilibrio_cta(rs.getDouble("beginBalance"));
                    //cta.setDuracion(rs.getDate("beginBalanceTimestamp"));
                    cta.setLinea_cred_cta(rs.getDouble("creditLine"));
                    cta.setDescripcion_cta(rs.getString("description"));
                    cuentas.add(cta);
                }
                 rs.close();
                 closeConnection();
            } catch (ClassNotFoundException | SQLException ex) {
                 System.out.println("ERROR");
            }
            return cuentas;
           
        }
        //Metodo para crear una cuenta
        public void crearCuenta(Cuenta cuenta){
             try{
                PreparedStatement ps;
                String query;
                query = "INSERT INTO account(balance,beginBalance,beginBalanceTimestamp,creditLine,description)VALUES(?,?,?,?,?)";
                openConnection();
                try{
                    ps = con.prepareStatement(query);
                    ps.setDouble(2, cuenta.getBalance_cta());
                    ps.setDouble(3, cuenta.getEquilibrio_cta());
                    //ps.setDate(4, cuenta.getDuracion());
                    ps.setDouble(5, cuenta.getLinea_cred_cta());
                    ps.setString(6,cuenta.getDescripcion_cta());
                    ps.execute();
                    ps.close();
                    closeConnection();
                }catch(SQLException e){
                    System.out.println("ERROR");
                }
            }catch(ClassNotFoundException | SQLException ex){
                System.out.println("ERROR en abrir la Conexion");
            }
            
        }
        
        //Metodo para buscar una Cuenta
        public Cuenta getCuenta(long buscarID){
            Cuenta cta=null;
            try {
                openConnection();
                stmt = con.createStatement();
                String query = "SELECT * FROM account WHERE id= " + buscarID;
                ResultSet rs = stmt.executeQuery(query);
                if(rs.next()){
                    cta = new Cuenta();
                    cta.setId_cta(rs.getLong("id"));
                    cta.setBalance_cta(rs.getDouble("balance"));
                    cta.setEquilibrio_cta(rs.getDouble("beginBalance"));
                    //Timestamp timestamp = Timestamp.valueOf(rs.getDuracion());
                    //cta.setDuracion(rs.getDate("beginBalanceTimestamp"));
                    cta.setLinea_cred_cta(rs.getDouble("creditLine"));
                    cta.setDescripcion_cta(rs.getString("description"));
                   rs.close();
                   closeConnection();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                 System.out.println("ERROR");
            }
            return cta;
        }
        //Metodo para añadir un Movimiento
        public boolean setMovimiento(Cuenta cta, Movimiento mov){
            PreparedStatement ps;
            String query; 
            query = "INSERT INTO movement(amount,balance,description,timestamp) VALUES(?,?,?,?)";
            try {
                openConnection();
                ps = con.prepareStatement(query);
                ps.setDouble(2,mov.getCantidad_mov());
                ps.setDouble(3, mov.getBalance_mov());
                ps.setString(4, mov.getDescripcion_mov());
                Date date = java.sql.Date.valueOf(mov.getDuracion_mov()); //Pasamos el LocalDate a Date
                ps.setDate(5, date);
                ps.execute();
                ps.close();
                closeConnection();
                return true;
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("ERROR en abrir la Conexion");
            }
            return false;
        }
        //Metodo que nos recoja el último ID de la tabla Cuenta
        public Cuenta ultimaCuenta(){
            Cuenta cta=null;
            try {
                openConnection();
                stmt = con.createStatement();
                String query = "SELECT MAX(id) FROM account";
                ResultSet rs = stmt.executeQuery(query);
                if(rs.next()){
                    cta = new Cuenta();
                    cta.setId_cta(rs.getLong("id"));
                    cta.setBalance_cta(rs.getDouble("balance"));
                    cta.setEquilibrio_cta(rs.getDouble("beginBalance"));
                    //cta.setDuracion(rs.getDate("beginBalanceTimestamp"));
                    cta.setLinea_cred_cta(rs.getDouble("creditLine"));
                    cta.setDescripcion_cta(rs.getString("description"));
                   rs.close();
                   closeConnection();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                 System.out.println("ERROR");
            }
            return cta;
        }
        //Metodo para insertar IDs en customer_account
        public boolean setMovimiento(Long wIDcli, Long wIDcta){
            PreparedStatement ps;
            String query; 
            query = "INSERT INTO customers_account VALUES (?,?)";
            try {
                openConnection();
                ps = con.prepareStatement(query);
                ps.setLong(1,wIDcli);
                ps.setLong(2,wIDcta);
                ps.execute();
                ps.close();
                closeConnection();
                return true;
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("ERROR en abrir la Conexion");
            }
            return false;
        }
        //Metodo para buscar un Movimiento por su id
        public ArrayList<Movimiento> getMovimiento(long id) {
            Movimiento m=null;
            ArrayList <Movimiento> mov = new ArrayList();
        try {
            openConnection();
            stmt = con.createStatement();
            String query ="select * from movement where movement.account_id =  "+id;
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                m = new Movimiento();
                m.setId_mov(rs.getInt("id"));
                m.setCantidad_mov(rs.getFloat("amount"));
                m.setDescripcion_mov(rs.getString("description"));
                //m.setDuracion_mov(rs.getTimestamp("timestamp"));
                m.setId_cta(rs.getInt("account_id"));
                mov.add(m);
            }
            rs.close();
            closeConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR");
        }
        return mov;
    }
}