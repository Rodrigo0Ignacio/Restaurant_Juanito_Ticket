package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.Font;

public class Mesa_Eleccion extends JFrame {

	private JPanel contentPane;
	private JButton btn_cerrar = new JButton("Cerrar");
	private JButton btn_editar = new JButton("Editar");

	public Mesa_Eleccion() {

		propiedades();
		propiedades_btn();
		cerrarVentana();

	}

	protected void propiedades() {
		setType(Type.UTILITY);
		setResizable(false);
		setBounds(100, 100, 635, 159);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		contentPane.add(btn_cerrar);
		contentPane.add(btn_editar);
	}

	private void propiedades_btn() {
		btn_cerrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_editar.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btn_cerrar.setPreferredSize(new Dimension(200, 80));
		btn_editar.setPreferredSize(new Dimension(200, 80));
	}

	public void cerrarVentana() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(false);
		this.dispose();
	}

}
