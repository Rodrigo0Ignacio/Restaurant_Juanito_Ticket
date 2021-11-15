package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import controlador.Comida;
import modelo.Conexion;
import modelo.Consultas;
import java.awt.GridLayout;

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
    private final JButton btnNewButton = new JButton("New button");



	
	public Fr_Comidas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 554, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane); 
		
		
		contentPane.add(panel_central, BorderLayout.CENTER);
		contentPane.add(panel_acciones, BorderLayout.SOUTH);
		
               
	}
	
	public void consultas(String categoria) {

		/*REMUEVE LAS INTANCIAS ANTES COLOCADAS EN EL MARCO*/
		panel_central.removeAll();
		
		 try{
             query = "SELECT DISTINCT * FROM comida WHERE categoria = '"+categoria+"' ";
             statement = (Statement) conexion.conectar().createStatement();
             rs = statement.executeQuery(query);
             
             while(rs.next()){
            	 btn = new JButton(rs.getString("nombre"));
            	// productos.add(rs.getString("nombre"));
            	
                 panel_central.add(btn);
                 
                 /*EVENTO DE BOTONES DINAMICOS*/
                 btn.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				ArrayList<Comida> atributosComida = new ArrayList<Comida>();

            				/*getActionCommand() obtiene la cadena del boton
            				 * le pasamos la cadena del boton precionado*/
            				atributosComida = consultas.comparaBtn(e.getActionCommand());
            				/*POR TERMINAL*/
            				
            			}
            		});

             }
            
             conexion.desconectar();
             
         }catch(SQLException W){
         	JOptionPane.showMessageDialog(null,"Error al ejecutar BD");
             
         }

         panel_central.setLayout(new GridLayout(0, 5, 0, 0));
         

		}
    
		


}
