package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import controlador.Calculos;
import controlador.Comida;
import modelo.Conexion;
import modelo.Consultas;
import java.awt.GridLayout;
import java.awt.Toolkit;

public class Fr_Comidas extends JFrame {

    private JPanel contentPane;
    private Consultas consultas = new Consultas();
    private Conexion conexion = new Conexion();
    private String query = "";
    private Statement statement;
    public ResultSet rs;
    public static JButton btn;
    private JPanel panel_central = new JPanel();
    private JPanel panel_acciones = new JPanel();
    private final JButton btnNewButton = new JButton("New button");
    public static boolean comprobarBtn = false;
    
    private ArrayList<Comida> atributosComida = new ArrayList<Comida>();
    private ArrayList<String> indice = new ArrayList<String>();
    Calculos cal = new Calculos();




	
	public Fr_Comidas() {
		//Toolkit.getDefaultToolkit().getImage(Fr_Comidas.class.getResource("/img/cuchilleria.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane); 
		
		
		contentPane.add(panel_central, BorderLayout.CENTER);
		contentPane.add(panel_acciones, BorderLayout.SOUTH);
		

		indice.add("Unidad");
		indice.add("Nombre");
		indice.add("Precio Unitario");
		for(Object in : indice) {
			JP_Display.modelo.addColumn(in);
		}
		JP_Display.grillaProductos.setModel(JP_Display.modelo);
		
               
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
            				atributosComida = consultas.comparaBtn(e.getActionCommand());
            			        
            				if(e.getSource() != null) {
            					for(int z = 0 ; z < atributosComida.size() ; z++) {
            						if(e.getActionCommand().equalsIgnoreCase(atributosComida.get(z).getNombre())) {
            							
                					JP_Display.modelo.addRow(new Object[] {"d",atributosComida.get(z).getNombre(),atributosComida.get(z).getPrecio()});
                					
                				}
            						/*suma las filas (el total de los precios)*/
            						cal.establecerValores();
            					}
            					comprobarBtn = true;

            			}
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
    
