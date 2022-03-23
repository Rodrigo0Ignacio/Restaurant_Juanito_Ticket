package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Consultas;
import modelo.Edicion;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.FlowLayout;
import java.awt.Font;

public class Mesa_Eleccion extends JFrame {

	private JPanel contentPane;
	private JButton btn_cerrar = new JButton("Cerrar");
	private JButton btn_editar = new JButton("Editar");
	public static String opcionEditar = null;
	private Consultas con = new Consultas();
	private Edicion edi = new Edicion();

	public Mesa_Eleccion() {
		setResizable(false);

		propiedades();
		propiedades_btn();
		cerrarVentana();

	}

	protected void propiedades() {
		setType(Type.UTILITY);
		setBounds(100, 100, 635, 159);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/img/cuchilleria.png")).getImage());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(214, 234, 248));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		contentPane.add(btn_cerrar);
		contentPane.add(btn_editar);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				String id_comanda = con.buscar_id_comanda(Mesas.id_mesa_dinamico);
				
				if(con.verificaDatos_comanda_editando(id_comanda)) {
					edi.eliminarDatos_comanda_editando(id_comanda);
				}
							
				
			}

		});
	}

	private void propiedades_btn() {
		btn_cerrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_editar.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btn_cerrar.setBackground(new Color(98, 162, 186));
		btn_editar.setBackground(new Color(98, 162, 186));

		btn_cerrar.setPreferredSize(new Dimension(200, 80));
		btn_editar.setPreferredSize(new Dimension(200, 80));
	}

	public void cerrarVentana() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(false);
		this.dispose();
	}

	public JButton getBtn_cerrar() {
		return btn_cerrar;
	}

	public void setBtn_cerrar(JButton btn_cerrar) {
		this.btn_cerrar = btn_cerrar;
	}

	public JButton getBtn_editar() {
		return btn_editar;
	}

	public void setBtn_editar(JButton btn_editar) {
		this.btn_editar = btn_editar;
	}

}
