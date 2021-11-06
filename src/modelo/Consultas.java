package modelo;

import controlador.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Consultas extends Conexion {
	public Statement statement;
	public ResultSet rs;
    public String query;
        
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

            
        
      
        
        /* PRUEBA DEL CODIGO
        public static void main(String[] args) {
            Consultas c = new Consultas();

        for(int i = 0 ; i < c.listarProducts().size() ; i++){
            System.out.println(c.listarProducts().get(i).getNombre());
            
        }*/

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
        
        }
        
