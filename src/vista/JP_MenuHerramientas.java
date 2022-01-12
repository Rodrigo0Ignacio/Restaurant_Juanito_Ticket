package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Calculos;
import controlador.Ticket;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class JP_MenuHerramientas extends JPanel {

	private JPanel p_logo = new JPanel();
	private final JPanel p_herramienta = new JPanel();
	private final JButton borrar = new JButton("Borrar");
	private final JButton imprimir = new JButton("Imprimir");
	private final JButton informeDiario = new JButton("Informe Diario");
	private final JButton mesa = new JButton("Mesa");
	private final JLabel lbl_titulo = new JLabel("Restaurant Juanito");
	private final JLabel lbl_icono = new JLabel("");
	private ArrayList<String> indice = new ArrayList<String>();

	public JP_MenuHerramientas() {
		setBackground(Color.GRAY);
		/*DESABILITAR BOTON DE IMPRESION*/
		imprimir.setFont(new Font("Tahoma", Font.BOLD, 18));
		imprimir.setEnabled(false);
		setLayout(new GridLayout(0, 2, 5, 5));

		/* establece el borde */
		p_herramienta.setForeground(Color.BLACK);
		p_herramienta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		p_herramienta.setBackground(Color.GRAY);
		//p_logo.setBackground(Color.GRAY);
		
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

		/* Eventos */
		mesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fr_MenuMesas mesas = new Fr_MenuMesas();

			}
		});

		imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*por terminal*/
				if(Fr_Comidas.comprobarBtn == true) {
					
					Ticket ticket = new Ticket("nameLocal", "expedition", "box", "ticket", "caissier", "dateTime", "items",
							"subTotal", "tax", "total", "recibo", "change");
					ticket.print();
					
				}
				

			}
		});

		informeDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Fr_Reporte informe = new Fr_Reporte();
				Login login = new Login();
				login.setVisible(true);


			}
		});
		

		/* ESTE BOTON RESBLACE LOS VALORES INICIALES DEL DISPLAY */
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				JP_Display.lbl_nroMesa.setText("N\u00B0");
				JP_Display.lbl_total.setText("$ 0");
				JP_Display.lbl_propina.setText("$ 0");
				JP_Display.lbl_totalMasPropina.setText("$ 0");
				
				/*Elimina las columnas agregadas*/
				for(int i = JP_Display.modelo.getRowCount() - 1 ; i >= 0 ; i-- ) {
					JP_Display.modelo.removeRow(i);	
				}
				

			}
		});

	}

}
