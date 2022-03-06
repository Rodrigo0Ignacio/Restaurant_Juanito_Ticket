package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import controlador.Calculos;
import controlador.Codigo_Aleatorio;
import controlador.Color_RGB;
import controlador.Comida;
import controlador.Ticket;
import modelo.Edicion;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class JP_MenuHerramientas extends JPanel {

	private JPanel p_logo = new JPanel();
	private  JPanel p_herramienta = new JPanel();
	private JButton borrar = new JButton("Borrar");
	private JButton imprimir = new JButton("Comandar");
	private JButton informeDiario = new JButton("Informe");
	private JButton mesa = new JButton("Mesa");
	private JLabel lbl_titulo = new JLabel("Restaurant Juanito");
	private JLabel lbl_icono = new JLabel("");
	private ArrayList<String> indice = new ArrayList<String>();
	private Edicion edicionsql = new Edicion();
	
	private int unidad = 0;
	private String plato = null;
	private int precio_u = 0;
	private int total = 0;
	private int id_mesa = 0;

	


	public JP_MenuHerramientas() {
		
		propiedades();
		eventos();
		
		
	}
	
	protected void propiedades() {
		setBackground(Color.GRAY);
		/* DESABILITAR BOTON DE IMPRESION */
		imprimir.setFont(new Font("Tahoma", Font.BOLD, 18));
		setLayout(new GridLayout(0, 2, 5, 5));


		/* establece el borde */
		p_herramienta.setForeground(Color.BLACK);
		p_herramienta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		p_herramienta.setBackground(Color.GRAY);
		// p_logo.setBackground(Color.GRAY);

		/* establece color botones */
		borrar.setBackground(new Color(113, 142, 164));
		imprimir.setBackground(new Color(113, 142, 164));
		informeDiario.setBackground(new Color(113, 142, 164));
		mesa.setBackground(new Color(113, 142, 164));

		p_logo.setBackground(new Color(40, 83, 108));
		p_herramienta.setBackground(new Color(40, 83, 108));

		add(p_logo);
		p_logo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lbl_titulo.setForeground(Color.WHITE);
		lbl_titulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_titulo.setFont(new Font("Times New Roman", Font.BOLD, 38));

		p_logo.add(lbl_titulo);
		lbl_icono.setIcon(new ImageIcon("src/img/mariscos.png"));

		p_logo.add(lbl_icono);

		add(p_herramienta);
		p_herramienta.setLayout(new GridLayout(1, 1, 6, 6));
		borrar.setFont(new Font("Tahoma", Font.BOLD, 18));

		p_herramienta.add(borrar);

		p_herramienta.add(imprimir);
		informeDiario.setFont(new Font("Tahoma", Font.BOLD, 18));

		p_herramienta.add(informeDiario);
		mesa.setFont(new Font("Tahoma", Font.BOLD, 18));

		p_herramienta.add(mesa);
		

	}
	
	private void eventos() {
		mesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mesas mesas = new Mesas();
				mesas.setVisible(true);
	

			}
		});

		imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JP_Display.grillaProductos.getRowCount() == 0
						&& JP_Display.grillaProductos.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Ingrese al menos un producto");

				} else if (JP_Display.lbl_nroMesa.getText().equalsIgnoreCase("N\u00B0 ")) {
					JOptionPane.showMessageDialog(null, "Ingrese una mesa");

				} else {
					try {
						JP_Display.estados_Pedidos(3);
						/*GUARDAR EN LA BASE DE DATOS
						 * guarda la comanda en la bd*/
						String codigoUnico = Codigo_Aleatorio.codigo_alfanumerico_caracter();
			
						
						for(int i = 0 ; i < JP_Display.grillaProductos.getRowCount(); i++) {
							
						 unidad = (int) JP_Display.grillaProductos.getValueAt(i, 0);
						 plato = (String) JP_Display.grillaProductos.getValueAt(i, 1);
						 precio_u = (int) JP_Display.grillaProductos.getValueAt(i, 2);
						 total = (int) JP_Display.grillaProductos.getValueAt(i, 3);
						 id_mesa = (int) JP_Display.grillaProductos.getValueAt(i, 4);
						 
						 edicionsql.insertar_comanda(codigoUnico,
								 precio_u,plato, unidad, id_mesa,Mesas.identificador_Mesa);
						
						}					
						

						Ticket ticket = new Ticket("nameLocal", "expedition", "box", "ticket", "caissier", "dateTime",
								"items", "subTotal", "tax", "total", "recibo", "change");
						ticket.print();
 
						resetDisplay();

					} catch (NullPointerException q) {
						System.out.print(q);
					}

				}

			}
		});

		informeDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login login = new Login();
				login.setVisible(true);

			}
		});
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limpiaGUI();
			
				
			}
		});
		
	
	}
	
	public void limpiaGUI() {
		resetDisplay();
		/*restablecela mesa*/
		Edicion edicion = new Edicion();
		edicion.mesa_Disponibilidad(Mesas.id_mesa_dinamico, Mesas.lista_Disponibilidad[0]);
		
	}
	
	



	public void resetDisplay() {
		JP_Display.lbl_nroMesa.setText("N\u00B0 ");
		JP_Display.lbl_total.setText("$ 0");
		JP_Display.lbl_propina.setText("$ 0");
		JP_Display.lbl_totalMasPropina.setText("$ 0");
		JP_Display.lbl_estadoMesa.setText("");
		Fr_MenuMesas.txt_displayNumeros.setText("");
		JP_Display.estados_Pedidos(0);
		
			/* Elimina las columnas agregadas */
			for (int i = JP_Display.modelo.getRowCount() - 1; i >= 0; i--) {
				JP_Display.modelo.removeRow(i);
			}
		
		
	}
	

	public JButton getMesa() {
		return mesa;
	}

	public void setMesa(JButton mesa) {
		this.mesa = mesa;
	}

	
	
	
	

}



















