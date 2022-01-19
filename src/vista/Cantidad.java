package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.api.SubstanceConstants;
import org.jvnet.substance.shaper.StandardButtonShaper;

import controlador.Calculos;
import controlador.Comida;
import controlador.RoundedBorder;
import modelo.Consultas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.Window.Type;
import javax.swing.border.MatteBorder;

public class Cantidad extends JFrame {

	private JPanel contentPane =  new JPanel();
	private JPanel panel_arriba = new JPanel();
	private  JLabel lbl_textCantidad = new JLabel("Cantidad");
	private JButton btn_mas = new JButton("");
	private JLabel lbl_cantidad = new JLabel("0");
	private JButton btn_menos = new JButton("");
	private JPanel panel_centro = new JPanel();
	private int incremento = 0;
	private final JPanel panel_abajo = new JPanel();
	private final JButton btn_aceptar = new JButton("Aceptar");
	
	private int filaExiste = 0;
	
	Consultas consultas = new Consultas();
	


	public Cantidad() {
		setType(Type.UTILITY);

		
		setBounds(100, 100, 405, 242);
		setLocationRelativeTo(null);
		
		propiedades();
		establecerColorFondo();
		propiedadesBotones();
		Eventos();
		
		
	}
	
	private void propiedades() {
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel_arriba.setBackground(Color.GRAY);
		contentPane.add(panel_arriba, BorderLayout.NORTH);
		lbl_textCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_textCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_arriba.add(lbl_textCantidad);
		panel_centro.setBackground(Color.GRAY);
		contentPane.add(panel_centro, BorderLayout.CENTER);
		panel_centro.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		btn_mas.setFont(new Font("Tahoma", Font.PLAIN, 36));
		panel_centro.add(btn_mas);
		lbl_cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cantidad.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panel_centro.add(lbl_cantidad);	
		btn_menos.setFont(new Font("Tahoma", Font.PLAIN, 36));
		panel_centro.add(btn_menos);

		panel_abajo.setBorder(new MatteBorder(10, 1, 1, 1, (Color) new Color(195, 200, 208)));
		
		contentPane.add(panel_abajo, BorderLayout.SOUTH);
		btn_aceptar.setBackground(new Color(95, 158, 160));
		btn_aceptar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		panel_abajo.add(btn_aceptar);
		
	}
	
	public void Eventos() {
		btn_mas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lbl_cantidad.setText(String.valueOf(incremento +=1));  
				
			}
		});
		
		btn_menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				if(incremento < 1 ) {

				}else {
					String valorCadena = String.valueOf(incremento -=1);
					lbl_cantidad.setText(valorCadena);
				}
				

			}
		});
		
		/*INSERTA UN ELEMENTO*/
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Calculos cal = new Calculos();
				int precio = consultas.buscarPrecio(Fr_Comidas.idBoton);
				int cantidad = obtenerCantidad();
				
				int importe = precio*cantidad;
				
				
				
				if(incremento >= 30) {
					JOptionPane.showInternalMessageDialog(null,"Excede el rango");
				}else {
					
					if(incremento != 0) {
						
						if(!existeProducto(Fr_Comidas.idBoton, 1)) {
							
							Fr_Comidas.cargarTabla(null, incremento,importe);
							
							cerrarVentana();
							resetCantidad();
							cal.establecerValores();
						}else {
							int unidadCelda = Integer.parseInt(JP_Display.grillaProductos.getValueAt(filaExiste, 0).toString());
							int importeCelda = Integer.parseInt(JP_Display.grillaProductos.getValueAt(filaExiste, 3).toString());
							
							incremento += unidadCelda;
							
							if(incremento <= 30) {
							
							JP_Display.grillaProductos.setValueAt(incremento,filaExiste,0);
							
							importe += importeCelda;
							JP_Display.grillaProductos.setValueAt(importe,filaExiste,3);
							
							cerrarVentana();
							resetCantidad();
							cal.establecerValores();
							}else {
								JOptionPane.showInternalMessageDialog(null,"Excede el rango");
							}
						

							
							
						}
						
						
						
					}else {
						JOptionPane.showInternalMessageDialog(null,"Ingrese un numero diferente de 0");
					} 
					
				}
				
				
				
					 

			} 
		}); 
		
		
		
		
	}
	
	
private void propiedadesBotones(){

		btn_mas.setBorderPainted(false);
		btn_mas.setContentAreaFilled(false);
		btn_mas.setOpaque(true);
		btn_mas.setBackground(new Color (195, 200, 208));

		btn_menos.setBorderPainted(false);
		btn_menos.setContentAreaFilled(false);
		btn_menos.setOpaque(true);
		btn_menos.setBackground(new Color (195, 200, 208));
		 //btn_mas.setBounds(20, 20, 30, 25);
		btn_aceptar.setPreferredSize(new Dimension(300, 37));
		
		
		//btn_mas.setBorder(new RoundedBorder(20)); 
		//btn_menos.setBorder(new RoundedBorder(20));
		
		estableceIcono(btn_mas, "src/img/mas.png",100,100,50,50);
		estableceIcono(btn_menos, "src/img/menos.png",100,100,50,50);
		
		
		
		 	

}
	protected void estableceIcono(JButton btn, String url, int x, int y, int width, int height) {
		btn.setBounds(x,y,width,height);
		
		ImageIcon icon = new ImageIcon(url);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(btn.getWidth(),btn.getHeight(),  Image.SCALE_DEFAULT));
		btn.setIcon(icono);
		
	}
	
	public int obtenerCantidad() {
		int cantidad = 0;
		
		cantidad = Integer.parseInt(lbl_cantidad.getText().trim());

		return cantidad;
	}
	
	public void resetCantidad() {
		lbl_cantidad.setText("0");
	}
	
	private void establecerColorFondo() {
		contentPane.setBackground(new Color(195, 200, 208));
		panel_arriba.setBackground(new Color(195, 200, 208));
		panel_centro.setBackground(new Color(195, 200, 208));
		panel_abajo.setBackground(new Color(195, 200, 208));
		
		
	}
	
	public void cerrarVentana() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(false);
		this.dispose();
	}
	
	public boolean existeProducto(String dato, int columna){
		boolean existe = false;
		
		for(int i = 0; i < JP_Display.grillaProductos.getRowCount() ; i++) {
			if(JP_Display.grillaProductos.getValueAt(i, columna).equals(dato)) {			
				existe = true; filaExiste = i;
			}
			
		}
		return existe;
		
	}
	

	
	



}
