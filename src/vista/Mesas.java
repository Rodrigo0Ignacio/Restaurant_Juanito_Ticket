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
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi.ecDetDSA512;
import org.bouncycastle.jcajce.provider.symmetric.CAST5;

import controlador.Color_RGB;
import controlador.Mesa;
import groovyjarjarantlr.debug.NewLineEvent;
import modelo.Consultas;
import modelo.Edicion;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.lang.System;

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

	private String[] lista_Disponibilidad = { "Disponible", "Ocupado" };
	private Color_RGB colorRGB = new Color_RGB();
	private int cont_click = 0;
	public static int id_mesa_dinamico = 0;
	private JP_MenuComidas menuComidas;
	private JP_MenuHerramientas meHerramientas = new JP_MenuHerramientas();
	

	public Mesas() {
		propiedades();
		btn_Eventos();
		eventos_Mesa_Eleccion();

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				eleccion.cerrarVentana();
				setVisible(false);

			}
		});

	}

	private void propiedades() {
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1077, 641);
		setLocationRelativeTo(null);
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
		establecerIcono();
	}

	public void btn_Eventos() {

		listaMesa = sql.listarMesas();

		for (Mesa m : listaMesa) {

			btn_mesas = new JButton("Mesa: " + m.getId_mesa());

			/* EDITA LOS BOTONES */
			btn_mesas.setPreferredSize(new Dimension(200, 100));
			/* ESTABLE FUENTES */
			btn_mesas.setFont(new Font("Tahoma", Font.BOLD, 18));
			btn_mesas.setForeground(new Color(255, 255, 255));

			if (m.getEstado().equalsIgnoreCase("Disponible")) {
				btn_mesas.setBackground(colorRGB.rgbColor_verde());

			} else if (m.getEstado().equalsIgnoreCase("Ocupado")) {
				btn_mesas.setBackground(colorRGB.rgbColor_rojo());

			}

			btn_mesas.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					identificador_btn = e.getActionCommand();
					identificador_Mesa = extraerNumeros(e.getActionCommand());
					detecta_btn = (JButton) e.getSource();
					id_mesa_dinamico = m.getId_mesa();

					if (e.getActionCommand().equalsIgnoreCase(identificador_btn)) {

						if (detecta_btn.getBackground().equals(colorRGB.rgbColor_verde())) {
							
							if(JP_Display.grillaProductos.getRowCount() == 0
									&& JP_Display.grillaProductos.getSelectedRow() == -1) {
								
								
							}else{

									estado_Ocupado();
									JP_Display.lbl_nroMesa.setText("N\u00B0 " + identificador_Mesa);
									JP_Display.estados_Pedidos(1);		
							}
							

						} else {
							eleccion.setVisible(true);

						}

					}

				}
			});

			panel_mesas.add(btn_mesas);

		}

	}

	public void establecerIcono() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mesas.class.getResource("/img/cuchilleria.png")));
	}

	public int extraerNumeros(String frase) {
		char[] cadena = frase.toCharArray();
		String nros = "";

		for (int i = 0; i < cadena.length; i++) {
			if (Character.isDigit(cadena[i])) {
				nros += cadena[i];

			}

		}

		return Integer.parseInt(nros);
	}

	public void estado_Ocupado() {

		detecta_btn.setBackground(colorRGB.rgbColor_rojo());
		edicion.mesa_Disponibilidad(id_mesa_dinamico, lista_Disponibilidad[1]);

	}

	public void estado_disponible() {

		detecta_btn.setBackground(colorRGB.rgbColor_verde());
		edicion.mesa_Disponibilidad(id_mesa_dinamico, lista_Disponibilidad[0]);

	}

	/* EVENTOS DE BOTON DE LA CLASE MESA_ELECCION */
	public void eventos_Mesa_Eleccion() {

		eleccion.getBtn_cerrar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				estado_disponible();
				eleccion.setVisible(false);
				JP_Display.lbl_nroMesa.setText("N\u00B0 ");

				/*
				 * IMPRIME BOLETA FINAL . . .
				 */
				
				meHerramientas.resetDisplay();
				

			}
		});
		eleccion.getBtn_editar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

}
