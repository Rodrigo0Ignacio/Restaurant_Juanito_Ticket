package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Ticket;

public class JP_MenuHerramientas extends JPanel {

	private JPanel p_logo = new JPanel();
	private final JPanel p_herramienta = new JPanel();
	private final JButton borrar = new JButton("Borrar");
	private final JButton imprimir = new JButton("Imprimir");
	private final JButton informeDiario = new JButton("Informe Diario");
	private final JButton mesa = new JButton("Mesa");
	private final JLabel lbl_titulo = new JLabel("Restaurant Juanito");
	private final JLabel lbl_icono = new JLabel("");

	public JP_MenuHerramientas() {
		setLayout(new GridLayout(0, 2, 0, 0));

		/* establece el borde */
		p_herramienta.setBackground(Color.GRAY);
		p_herramienta.setBorder(new EmptyBorder(30, 30, 30, 30));
		p_herramienta
				.setBorder(new TitledBorder(null, "Herramientas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		p_logo.setBackground(Color.GRAY);

		add(p_logo);
		p_logo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lbl_titulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_titulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		p_logo.add(lbl_titulo);
		lbl_icono.setIcon(new ImageIcon("src/img/mariscos.png"));

		p_logo.add(lbl_icono);

		add(p_herramienta);
		p_herramienta.setLayout(new GridLayout(1, 1, 5, 0));

		p_herramienta.add(borrar);

		p_herramienta.add(imprimir);

		p_herramienta.add(informeDiario);

		p_herramienta.add(mesa);

		/* Eventos */
		mesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fr_MenuMesas mesas = new Fr_MenuMesas();

			}
		});

		imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ticket ticket = new Ticket("nameLocal", "expedition", "box", "ticket", "caissier", "dateTime", "items",
						"subTotal", "tax", "total", "recibo", "change");
				ticket.print();

			}
		});

		informeDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fr_Reporte informe = new Fr_Reporte();
				informe.setVisible(true);

			}
		});

		/* ESTE BOTON RESBLACE LOS VALORES INICIALES DEL DISPLAY */
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JP_Display.lbl_nroMesa.setText("N\u00B0");

			}
		});

	}

}
