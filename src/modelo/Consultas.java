package modelo;

import controlador.Comida;
import controlador.Mesa;
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
                statement = (Statement) conectar().prepareStatement(query);
                rs = statement.executeQuery(query);
                
                while(rs.next()){
                    lista.add(new Producto(
                    rs.getInt("id_comida"),
                    rs.getString("fk_categoria"),
                    rs.getString("nombre"),
                    rs.getInt("precio"),
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
                 statement = (Statement) conectar().prepareStatement(query);
                 rs = statement.executeQuery(query);
                 
                 while(rs.next()){
                	lista.add(new Comida(rs.getInt("id_comida"), rs.getString("fk_categoria"),
                			rs.getString("nombre"), rs.getInt("precio"),rs.getString("descripcion")));

                 }
                 desconectar();
                 
             }catch(SQLException W){
             	JOptionPane.showMessageDialog(null,"Error al ejecutar BD");
                 
             }
    		 return lista;
              
    }
        
        public boolean verificaContenido(String parm1, String parm2) {
    		
    		 try{
                     query = "SELECT fecha_hora , id_ticket, nro_mesa, valor_total FROM ticket"
                             + " WHERE fecha_hora BETWEEN '"+parm1+"' and '"+parm2+"'"
                             + " ORDER BY fecha_hora DESC";
                    
                 statement = (Statement) conectar().prepareStatement(query);
                 rs = statement.executeQuery(query);
                 if(rs.next()){
                     return true;
                         
                     
                 }else{
                     return false;
                 }
                 
                 
             }catch(SQLException W){
             	JOptionPane.showMessageDialog(null,"Error al ejecutar BD");
                 
             }
                 desconectar();
                 
                 return false;
    		 
              
    }
        
        public int sub_totales(String parm1, String parm2) {
            
            int sub_total = 0;

    		 try{
                 query = "SELECT fecha_hora , id_ticket, nro_mesa, valor_total, SUM(valor_total) AS 'su_total' FROM ticket"
                             + " WHERE fecha_hora BETWEEN '"+parm1+"' and '"+parm2+"'"
                             + " ORDER BY fecha_hora DESC";
                 statement = (Statement) conectar().prepareStatement(query);
                 rs = statement.executeQuery(query);
                 
                 while(rs.next()){
                     sub_total = rs.getInt("su_total");
                	
                 }
                 desconectar();
                 
             }catch(SQLException W){
             	JOptionPane.showMessageDialog(null,"Error al ejecutar BD");
                 
             }
    		 return sub_total;
              
    }
        
           public int contarRegistros(String parm1, String parm2) {
            
            int registros = 0;

    		 try{
                 query = "SELECT COUNT(*) AS 'total' FROM ticket WHERE fecha_hora BETWEEN '"+parm1+"' and '"+parm2+"'";
                         
                 statement = (Statement) conectar().prepareStatement(query);
                 rs = statement.executeQuery(query);
                 
                 while(rs.next()){
                     registros = rs.getInt("total");
                	
                 }
                 desconectar();
                 
             }catch(SQLException W){
             	JOptionPane.showMessageDialog(null,"Error al ejecutar BD");
                 
             }
    		 return registros;
              
    }
           
           public boolean verificarPasswrod(String pass) {
               
               boolean password = false;

       		 try{
                    query = "select * from admin WHERE password = '"+pass+"'";
                            
                    statement = (Statement) conectar().prepareStatement(query);
                    rs = statement.executeQuery(query);
                    
                    while(rs.next()){
                    	password = true;
                   	
                    }
                    desconectar();
                    
                }catch(SQLException W){
                	JOptionPane.showMessageDialog(null,"Error al ejecutar BD");
                	password = false;
                    
                }
       		 return password;
                 
       }
           
           public int buscarPrecio(String id_btn) {
        	   int precio = 0;
        	   

         		 try{
                      query = "select precio from comida WHERE nombre = '"+id_btn+"'";
                              
                      statement = (Statement) conectar().prepareStatement(query);
                      rs = statement.executeQuery(query);
                      
                      while(rs.next()){
                      precio = rs.getInt("precio");
                     	
                      }
                      desconectar();
                      
                  }catch(SQLException W){
                  	JOptionPane.showMessageDialog(null,"Error al ejecutar BD");
                      
                  }
         		 
         		 return precio;
         				 
        	   
           }
           
           public boolean verificarSiExitenPlatos(String parm1) {
       		
      		 try{
                       query = "SELECT DISTINCT * FROM comida WHERE fk_categoria = '"+parm1+"' ";
                      
                   statement = (Statement) conectar().prepareStatement(query);
                   rs = statement.executeQuery(query);
                   if(rs.next()){
                       return true;
                           
                       
                   }else{
                       return false;
                   }
                   
                   
               }catch(SQLException W){
               	JOptionPane.showMessageDialog(null,"Error al ejecutar BD");
                   
               }
                   desconectar();
                   
                   return false;
      		 
                
      }
           
           public ArrayList<Mesa> listarMesas() {
        	   ArrayList<Mesa> lista = new ArrayList<Mesa>();
          		
        		 try{
                         query = "SELECT id_mesa FROM mesa";
                        
                     statement = (Statement) conectar().prepareStatement(query);
                     rs = statement.executeQuery(query);
                     while(rs.next()){
                    	 lista.add(new Mesa(rs.getInt(1)));
   
                     }
                     
                 }catch(SQLException W){
                 	JOptionPane.showMessageDialog(null,"Error al ejecutar BD");
                     
                 }
                     desconectar();
					return lista;
                                      
        }
           
           public ArrayList<Mesa> obtenerMesa() {
        	   ArrayList<Mesa> lista = new ArrayList<Mesa>();
          		
        		 try{
                         query = "SELECT * FROM mesa";
                        
                     statement = (Statement) conectar().prepareStatement(query);
                     rs = statement.executeQuery(query);
                     while(rs.next()){
                    	 lista.add(new Mesa(rs.getInt(1),rs.getString(2)));
   
                     }
                     
                 }catch(SQLException W){
                 	JOptionPane.showMessageDialog(null,"Error al ejecutar BD");
                     
                 }
                     desconectar();
					return lista;
                                      
        }


        
    	
    	
    	
        }
        
