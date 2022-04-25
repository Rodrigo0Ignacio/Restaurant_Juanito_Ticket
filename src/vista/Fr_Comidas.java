package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.table.DefaultTableModel;

import controlador.Calculos;
import controlador.Comida;
import controlador.Producto;
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.BoxLayout;

public class Fr_Comidas extends JFrame {

	private Consultas consultas = new Consultas();
	private Conexion conexion = new Conexion();
	private String query = "";
	private Statement statement;
	public ResultSet rs;
	public static JButton btn;
	public static boolean comprobarBtn = false;
	public static JPanel contentPane = new JPanel();

	public static ArrayList<Comida> atributosComida = new ArrayList<Comida>();
	private ArrayList<String> indice = new ArrayList<String>();

	public JPanel pn_dinamicos = new JPanel();
	JPanel panel = new JPanel();
	public static JLabel lbl_titulo = new JLabel("");

	Cantidad cantidad = new Cantidad();
	public static String idBoton = null;
	private JScrollPane ScrollPane ;
	public JPanel sub_panel = new JPanel();
	

	public Fr_Comidas() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 700, 1200, 780);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/img/cuchilleria.png")).getImage());
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));

		contentPane.setBackground(new Color(214, 234, 248));
		FlowLayout flowLayout = (FlowLayout) pn_dinamicos.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		pn_dinamicos.setBackground(new Color(40, 83, 108));
		panel.setBackground(new Color(214, 234, 248));

		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 36));
		panel.add(lbl_titulo);
		
		pn_dinamicos.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.BLACK, Color.BLACK));
		JScrollPane scrollPane = new JScrollPane(pn_dinamicos);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		sub_panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		sub_panel.setOpaque(false);
		pn_dinamicos.add(sub_panel);
		sub_panel.setLayout(new GridLayout(0, 5, 5, 5));

		indice.add("Unidad");
		indice.add("Nombre");
		indice.add("Precio Unitario");
		indice.add("Importe");
		indice.add("id");

		for (Object in : indice) {
			JP_Display.modelo.addColumn(in);
		}
		JP_Display.grillaProductos.setModel(JP_Display.modelo);

		/* EVENTO DE CIERRE */
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				cantidad.cerrarVentana();
	
				if (JP_Display.lbl_estadoMesa.getText().equalsIgnoreCase("Editando")) {
					JP_Display.estados_Pedidos(4);
				}

			}
		});

	}

	public void consultas(String categoria) {

		/* REMUEVE LAS INTANCIAS ANTES COLOCADAS EN EL MARCO */
		// principal.removeAll();
		
		sub_panel.removeAll();
		Consultas consultas = new Consultas();

		if (consultas.verificarSiExitenPlatos(categoria)) { // verifica si exiten platos

			try {
				query = "SELECT DISTINCT * FROM comida WHERE fk_categoria = '" + categoria + "' ";
				statement = (Statement) conexion.conectar().prepareStatement(query);
				rs = statement.executeQuery(query);

				/*
				 * GENERERA BOTONES DE FORMA DINAMICA Y EXTRAE LOS NOMBRES DE LOS PLATOS DESDE
				 * LA BASE DE DATOS
				 */
				while (rs.next()) {

					btn = new JButton(rs.getString("nombre"));
					btn.setFont(new Font("Tahoma", Font.BOLD, 14));

					sub_panel.add(btn);

					btn.setPreferredSize(new Dimension(250, 150));
					btn.setBackground(new Color(154, 176, 211));

					/* EVENTO DE BOTONES DINAMICOS */
					btn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							atributosComida = consultas.comparaBtn(e.getActionCommand());
							idBoton = e.getActionCommand();

							cantidad = new Cantidad();
							cantidad.setTitle(idBoton);				
							cantidad.setVisible(true);

						}
					});
				}

				// contentPane.setLayout(new GridLayout(10, 10, 10, 10));
				conexion.desconectar();

			} catch (SQLException W) {
				JOptionPane.showMessageDialog(null, "Error al ejecutar BD");

			}
		} else {

			JOptionPane.showMessageDialog(null, "No existen platos");
			this.setVisible(false);
		}
		

	}

	/*
	 * ESTE METODO CARGA LA TABLA SE LE DEBE PASAR UN ActionEvent para identificar
	 * el boton tecleado y se le pasa un ArrayList de tipo comida del cual contiene
	 * los datos de cada plato Nombre, precio, categoria
	 */
	public static void cargarTabla(String e, int cantidad, int importe) {

		for (int z = 0; z < atributosComida.size(); z++) {
			JP_Display.modelo.addRow(new Object[] { cantidad, atributosComida.get(z).getNombre(),
					atributosComida.get(z).getPrecio(), importe, atributosComida.get(z).getId_comida() });

		}

	}

}
