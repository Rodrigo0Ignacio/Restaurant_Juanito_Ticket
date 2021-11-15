package modelo;

import controlador.Comida;
import controlador.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Consultas extends Conexion {
	private Statement statement = null;
	private ResultSet rs = null;
    private String query = null;
        
       /*CON ESTE METODO PODEMOS LISTAR LOS PRODUCTOS*/
        public ArrayList<Producto> listarProductos(){
             ArrayList<Producto> lista = new ArrayList();
            try{
                query = "SELECT * FROM comida";
                statement = (Statement) conectar().createStatement();
                rs = statement.executeQuery(query);
                
                while(rs.next()){
                    lista.add(new Producto(
                    rs.getInt("id_comida"),
                    rs.getString("categoria"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getString("descripcion")));
                }
            } catch(SQLException ex){
                return null;
            }
            
            desconectar();
            return lista;
            
        }
        
        
        /*ESTE METODO SE EMPLEA PARA COMPARAR EL BOTON PRECIONADO*/
    	public ArrayList<Comida> comparaBtn(String nombre) {
    		
    		ArrayList<Comida> lista = new ArrayList<Comida>();
    		
    		 try{
                 query = "SELECT * FROM comida WHERE nombre = '"+nombre+"'";
                 statement = (Statement) conectar().createStatement();
                 rs = statement.executeQuery(query);
                 
                 while(rs.next()){
                	lista.add(new Comida(rs.getInt("id_comida"), rs.getString("categoria"),
                			rs.getString("nombre"), rs.getDouble("precio"),rs.getString("descripcion")));

                 }
                 desconectar();
                 
             }catch(SQLException W){
             	JOptionPane.showMessageDialog(null,"Error al ejecutar BD");
                 
             }
    		 return lista;
              
    }


        
    	
    	
    	
        }
        
