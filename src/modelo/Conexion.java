package modelo;
import java.net.URI;
import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion {
    private Connection conectar = null;
    private final String URI = "";
    private final String USER = "";
    private final String PASSWORD = "";

    public Connection conectar(){
        try{
            /*DRIVER*/
         //   Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(URI, USER, PASSWORD);

        }catch(SQLException s){
            JOptionPane.showMessageDialog(null, "Error en la conexion: "+s);

        }

        return conectar;

    }

    public Connection desconectar(){

        try{
            conectar.close();
        }catch(SQLException s){
            JOptionPane.showMessageDialog(null, "Error al desconectar "+s);

        }
        return conectar;
    }















    
}
