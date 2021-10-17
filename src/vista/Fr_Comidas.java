package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modelo.Conexion;
import modelo.Consultas;

public class Fr_Comidas extends JFrame {

    private JPanel contentPane;
    private Consultas consultas = new Consultas();
    private Conexion conexion = new Conexion();
    private String query = "";
    private Statement statement;
    public ResultSet rs;
    private JButton btn;
    private JPanel panel_central = new JPanel();
    private JPanel panel_acciones = new JPanel();

	
	public Fr_Comidas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		contentPane.add(panel_central, BorderLayout.CENTER);
		
		
		contentPane.add(panel_acciones, BorderLayout.SOUTH);
                
                try{
                    query = "SELECT * FROM comida";
                    statement = (Statement) conexion.conectar().createStatement();
                    rs = statement.executeQuery(query);
                    
                    while(rs.next()){
                        btn = new JButton(rs.getString("nombre"));
                        panel_central.add(btn);
                        
                        if(btn.getText() == "Hamburguesa"){
                            System.out.println("1");
                        if(btn.getText() == "Papas fritas"){
                            System.out.println("2");
                        }
                            
                        }
  
                    }
                    
                }catch(SQLException W){
                    
                }
	}

}
