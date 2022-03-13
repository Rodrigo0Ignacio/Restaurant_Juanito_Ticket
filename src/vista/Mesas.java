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
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

//import org.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi.ecDetDSA512;
//import org.bouncycastle.jcajce.provider.symmetric.CAST5;

import controlador.Calculos;
import controlador.Calculos_boleta;
import controlador.Codigo_Aleatorio;
import controlador.Color_RGB;
import controlador.Comanda;
import controlador.Comida;
import controlador.Fecha;
import controlador.Mesa;
//import groovyjarjarantlr.debug.NewLineEvent;
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
	public static int identificador_Mesa = 0;
	private Mesa_Eleccion eleccion = new Mesa_Eleccion();
	private Edicion edicion = new Edicion();
	private JButton detecta_btn;

	public static String[] lista_Disponibilidad = { "Disponible", "Ocupado" };
	private Color_RGB colorRGB = new Color_RGB();
	public static int id_mesa_dinamico = 0;
	private JP_MenuComidas menuComidas;
	private JP_MenuHerramientas meHerramientas;
	private int contadorVentana = 0;
	private Edicion edicionsql = new Edicion();
	public boolean estadobtn = false;
	private String editando2 = null;
	private Fecha fecha = new Fecha();
	private Calculos_boleta boleta = new Calculos_boleta();
	private Calculos cal = new Calculos();

	public Mesas() {
		propiedades();
		btn_Eventos();
		eventos_Mesa_Eleccion();
		meHerramientas = new JP_MenuHerramientas();

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				contadorVentana += 1;

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				eleccion.cerrarVentana();
				setVisible(false);
				JP_Display.lbl_verificar.setText("");

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	protected void propiedades() {
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1077, 641);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		/* pintar paneles */
		this.setBackground(new Color(214, 234, 248));
		contentPane.setBackground(new Color(214, 234, 248));
		panel_cabecera.setBackground(new Color(214, 234, 248));
		panel_mesas.setBackground(new Color(214, 234, 248));
		/* =================================================== */
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

				if (!JP_Display.lbl_nroMesa.getText().equalsIgnoreCase("N\u00B0 ")) {
					btn_mesas.setEnabled(false);
					estadobtn = true;
				}

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

					if (detecta_btn.getBackground().equals(colorRGB.rgbColor_verde())) {

						if (JP_Display.grillaProductos.getRowCount() == 0
								&& JP_Display.grillaProductos.getSelectedRow() == -1) {

							JOptionPane.showMessageDialog(null, "Ingrese almenos un producto");

						} else if (JP_Display.lbl_verificar.getText().equalsIgnoreCase("")) {

							estado_Ocupado();
							JP_Display.lbl_nroMesa.setText("N\u00B0 " + identificador_Mesa);
							JP_Display.estados_Pedidos(1);
							JP_Display.estadoMesas.setText("Agregando Mesa");
							
							cerrarVentana_mesas();
							JP_Display.lbl_verificar.setText("0");

						}

					} else {
						if (estadobtn) {
							JOptionPane.showMessageDialog(null, "Por favor finalice la orden ");

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

	public static int extraerNumeros(String frase) {
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
				
				cerrarVentana();
				int propina = (int) (boleta.total(edicionsql.buscar_id_comanda(identificador_Mesa)) * cal.getPROPINA());

				/*insertamos los parametros de la boleta*/
				edicionsql.insertar_boleta(
						Codigo_Aleatorio.codigo_alfanumerico_numero()
						,fecha.fechaHora_formato2()
						,propina
						, boleta.total(edicionsql.buscar_id_comanda(identificador_Mesa))
						,identificador_Mesa
						, edicionsql.buscar_id_comanda(identificador_Mesa));
			
				/*
				 * borramos los datos almacenados temporalmente de la bd de la tabla cap_datos
				 */
				edicionsql.eliminar_cap_datos(identificador_Mesa);

				/*
				 * IMPRIME BOLETA FINAL . . .
				 */
				meHerramientas.resetDisplay();
				identificador_Mesa = 0;

			}
		});
		eleccion.getBtn_editar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Comanda> listaComanda = new ArrayList<Comanda>();
				Calculos cal = new Calculos();
				Principal.editando = true;
				 editando2 = e.getActionCommand();
				
				String id_comanda = sql.buscar_id_comanda(id_mesa_dinamico);
				listaComanda = sql.buscar_productos(id_comanda);
				int nroMesa = 0;
				Mesa_Eleccion.opcionEditar = "Editando";
				JP_Display.estados_Pedidos(4);

				meHerramientas.resetDisplay_borrar();
				
				/*Editando mesa*/
					JP_Display.lbl_nroMesa.setText("N\u00B0 " + identificador_Mesa);
					cal.establecerValores();
					eleccion.cerrarVentana();
					cerrarVentana();

			}
		});

	}

	public void cerrarVentana() {
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public int getIdentificador_Mesa() {
		return identificador_Mesa;
	}

	public void setIdentificador_Mesa(int identificador_Mesa) {
		this.identificador_Mesa = identificador_Mesa;
	}

	public void cerrarVentana_mesas() {
		this.setVisible(false);

	}

	public int getContadorVentana() {
		return contadorVentana;
	}

	public void setContadorVentana(int contadorVentana) {
		this.contadorVentana = contadorVentana;
	}

	public String getEditando2() {
		return editando2;
	}

	public void setEditando2(String editando2) {
		this.editando2 = editando2;
	}
	
	

}
