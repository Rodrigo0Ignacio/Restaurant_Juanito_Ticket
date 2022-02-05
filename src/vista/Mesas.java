package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bouncycastle.jcajce.provider.symmetric.CAST5;

import controlador.Mesa;
import modelo.Consultas;
import modelo.Edicion;

import java.awt.FlowLayout;

public class Mesas extends JFrame {

	private JPanel contentPane;
	private JButton btn_mesas;
	
	private Consultas sql = new Consultas();
	private ArrayList<Mesa> listaMesa = new ArrayList<>();
	private JPanel panel_mesas = new JPanel();
	private JPanel panel_cabecera = new JPanel();
	private String identificador_btn = null;
	private int identificador_Mesa = 0;
	private Mesa_Eleccion eleccion = new Mesa_Eleccion();
	private Edicion edicion = new Edicion();
	private JButton detecta_btn;
	
	private String[] lista_Disponibilidad = {"Disponible","Ocupado"};
	


	public Mesas() {
		propiedades();
		btn_Eventos();
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				
				eleccion.cerrarVentana();
				setVisible(false);

			}
		});
		
	}
	
	private void propiedades() {
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1027, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel_cabecera, BorderLayout.NORTH);
		FlowLayout flowLayout = (FlowLayout) panel_mesas.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setAlignOnBaseline(true);
		contentPane.add(panel_mesas, BorderLayout.CENTER);
		setTitle("Mesas");
	}
	
	public void btn_Eventos() {
		//panel_mesas.removeAll();
		
		listaMesa = sql.listarMesas();
		
		for(Mesa m : listaMesa) {
			
			btn_mesas = new JButton("Mesa: "+m.getId_mesa());
			/*EDITA LOS BOTONES*/
			btn_mesas.setPreferredSize(new Dimension(200, 100));
			btn_mesas.setBackground(new Color(0, 128, 0));
			/*---*/

			btn_mesas.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					identificador_btn = e.getActionCommand();

                    identificador_Mesa = Integer.parseInt(identificador_btn.substring(6,7).trim());
					//edicion.mesa_Disponibilidad(identificador_Mesa, lista_Disponibilidad[0]); 
                    
                      detecta_btn = (JButton) e.getSource();
                      
                      detecta_btn.setBackground(new Color(255,035,001));
                      
                      
                     
                     
                     
					
				}
			});		
			panel_mesas.add(btn_mesas);						
		}
		
		
			
	}
	
	
	
	

}


















