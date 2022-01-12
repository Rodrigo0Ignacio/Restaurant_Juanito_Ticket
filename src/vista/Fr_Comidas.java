package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.table.DefaultTableModel;

import controlador.Calculos;
import controlador.Comida;
import modelo.Conexion;
import modelo.Consultas;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

public class Fr_Comidas extends JFrame {

    private Consultas consultas = new Consultas();
    private Conexion conexion = new Conexion();
    private String query = "";
    private Statement statement;
    public ResultSet rs;
    public static JButton btn;
    public static boolean comprobarBtn = false;
    public static JPanel contentPane = new JPanel();
    
    
    private ArrayList<Comida> atributosComida = new ArrayList<Comida>();
    private ArrayList<String> indice = new ArrayList<String>();
    Calculos cal = new Calculos();
    
    JPanel pn_dinamicos = new JPanel();
    JPanel panel = new JPanel();
    public static JLabel lbl_titulo = new JLabel("");




	
	public Fr_Comidas() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 700, 1081, 715);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/img/cuchilleria.png")).getImage());
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		
		contentPane.setBackground(new Color(109, 146, 160));
		pn_dinamicos.setBackground(new Color(40, 83, 108));
		panel.setBackground(new Color(109, 146, 160));
		
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 36));
		panel.add(lbl_titulo);
		pn_dinamicos.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.BLACK, Color.BLACK));
		
		contentPane.add(pn_dinamicos, BorderLayout.CENTER);
		FlowLayout fl_pn_dinamicos = new FlowLayout(FlowLayout.LEFT, 5, 5);
		fl_pn_dinamicos.setAlignOnBaseline(true);
		pn_dinamicos.setLayout(fl_pn_dinamicos);
		
	    
	    //setResizable(false);
	    

		
		
		
        /*CARGA LOS NOMBRE DE LOS INDICES DE LA TABLA*/
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
		//principal.removeAll();
		pn_dinamicos.removeAll();
		
		 try{
             query = "SELECT DISTINCT * FROM comida WHERE fk_categoria = '"+categoria+"' ";
             statement = (Statement) conexion.conectar().prepareStatement(query);
             rs = statement.executeQuery(query);
             
             /*GENERERA BOTONES DE FORMA DINAMICA Y EXTRAE LOS NOMBRES DE LOS PLATOS DESDE LA BASE DE DATOS*/
             while(rs.next()){
            	 btn = new JButton(rs.getString("nombre"));
            	 btn.setFont(new Font("Tahoma", Font.BOLD, 16));
            	 
            	// principal.add(btn);
            	 pn_dinamicos.add(btn);
            	 
            	 btn.setPreferredSize(new Dimension(250, 150));
            	 btn.setBackground(new Color(114, 140, 166));
            	                  
                 /*EVENTO DE BOTONES DINAMICOS*/
                 btn.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				atributosComida = consultas.comparaBtn(e.getActionCommand());
            				
            				cargarTabla(e, atributosComida);
	

            			}
            		});        	

             }
             
             
            // contentPane.setLayout(new GridLayout(10, 10, 10, 10));
             conexion.desconectar();
             
         }catch(SQLException W){
         	JOptionPane.showMessageDialog(null,"Error al ejecutar BD");
             
         }


		}
	
	

		/*ESTE METODO CARGA LA TABLA SE LE DEBE PASAR UN ActionEvent para identificar el boton
		 * tecleado y se le pasa un ArrayList de tipo comida del cual contiene los datos de cada plato
		 * Nombre, precio, categoria*/
		public void cargarTabla(ActionEvent e, ArrayList<Comida> atributosComida) {
			Comida com = new Comida();
			
			if(e.getActionCommand() != null) {

				for(int z = 0; z < atributosComida.size() ; z++) {
						JP_Display.modelo.addRow(new Object[] {"",atributosComida.get(z).getNombre(),
								atributosComida.get(z).getPrecio()});
				
						/*suma las filas (el total de los precios)*/
						cal.establecerValores();
						

					}
				}
		}
		
		
		

		
		
		
		
		
		}
	
    
