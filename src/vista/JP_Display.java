package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

//import org.jfree.chart.block.CenterArrangement;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import controlador.Calculos;
import controlador.Comida;
import controlador.Fecha;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JProgressBar;

public class JP_Display extends JPanel implements Runnable {
	private Thread hilo;
	private String mesa = null;
	private JLabel lbl_subtitulo = new JLabel("Ticket de pedido");
	private JPanel titulo = new JPanel();
	private JPanel subTitulo = new JPanel();
	private JPanel Fecha_y_Hora = new JPanel();
	public static JLabel lbl_hra = new JLabel("00:00:00"); 
	private Fecha fecha = new Fecha();
	private JLabel lblNewLabel_2 = new JLabel("Fecha:");
	public static JLabel lbl_fecha = new JLabel("DD/MM/YYYY");
	private JLabel lblNewLabel_5 = new JLabel("Hora:");
	private JLabel lblNewLabel_4 = new JLabel("Mesa:"); 
	private JPanel grilla = new JPanel();
	private JLabel lblNewLabel_8 = new JLabel("TOTAL VENTA:");
	private JLabel lblNewLabel_9 = new JLabel("PROPINA 10%:");
	private JLabel lblNewLabel_11 = new JLabel("TOTAL:");
	
	public static JLabel lbl_verificar = new JLabel("");
	
	private JPanel totales = new JPanel();

	public static JLabel lbl_nroMesa = new JLabel("N\u00B0 ");

	public static JLabel lbl_propina = new JLabel();
	public static JLabel lbl_total = new JLabel("$ 0");
	public static JLabel lbl_totalMasPropina = new JLabel("$ 0");

	private final JScrollPane scrollPane = new JScrollPane();
	public static JTable grillaProductos = new JTable();
	/* MODELO DE LA TABLA */
	public static DefaultTableModel modelo = new DefaultTableModel() {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	private final JLabel lblNewLabel = new JLabel("Estado");
	public static JLabel lbl_estadoMesa = new JLabel("");

	public JP_Display() {

		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		hilo = new Thread(this);
		hilo.start();
		setVisible(true);

		setBackground(new Color(195, 200, 208));
		setLayout(new GridLayout(0, 1, 6, 0));
		/*
		 * titulo.setBackground(new Color(43, 76, 111)); grilla.setBackground(new
		 * Color(43, 76, 111)); totales.setBackground(new Color(43, 76, 111));
		 */
		centrar_datos(0);
		centrar_datos(2);
		centrar_datos(3);
		establece_anchoColumnas();
		establecerDisenoTabla();

		titulo.setBackground(new Color(195, 200, 208));

		add(titulo);
		titulo.setLayout(new GridLayout(0, 1, 0, 0));
		subTitulo.setBackground(new Color(195, 200, 208));

		titulo.add(subTitulo);
		subTitulo.setLayout(new GridLayout(0, 1, 0, 0));
		lbl_subtitulo.setBackground(Color.LIGHT_GRAY);

		lbl_subtitulo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lbl_subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subTitulo.add(lbl_subtitulo);
		Fecha_y_Hora.setBackground(new Color(195, 200, 208));
		Fecha_y_Hora.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));

		titulo.add(Fecha_y_Hora);
		Fecha_y_Hora.setLayout(new GridLayout(0, 2, 6, 6));

		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		Fecha_y_Hora.add(lblNewLabel_2);

		lbl_fecha.setFont(new Font("Dialog", Font.PLAIN, 18));
		// ESTABLECE FECHA ACTUAL
		lbl_fecha.setText(fecha.fechaActual());
		Fecha_y_Hora.add(lbl_fecha);

		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 18));
		Fecha_y_Hora.add(lblNewLabel_5);
		lbl_hra.setFont(new Font("Dialog", Font.PLAIN, 18));
		Fecha_y_Hora.add(lbl_hra);

		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		Fecha_y_Hora.add(lblNewLabel_4);

		lbl_nroMesa.setFont(new Font("Dialog", Font.PLAIN, 18));
		Fecha_y_Hora.add(lbl_nroMesa);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

		Fecha_y_Hora.add(lblNewLabel);
		lbl_estadoMesa.setFont(new Font("Dialog", Font.PLAIN, 18));

		Fecha_y_Hora.add(lbl_estadoMesa);
		Fecha_y_Hora.updateUI();

		grilla.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		grilla.setBackground(Color.LIGHT_GRAY);

		add(grilla);
		grilla.setLayout(new GridLayout(1, 0, 0, 0));
		grilla.add(scrollPane);

		scrollPane.setViewportView(grillaProductos);
		totales.setBackground(new Color(195, 200, 208));
		totales.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));

		totales.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(totales);
		totales.setLayout(new GridLayout(0, 2, -10, -10));

		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		totales.add(lblNewLabel_8);

		lbl_total.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_total.setFont(new Font("Dialog", Font.PLAIN, 20));
		totales.add(lbl_total);

		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 20));
		totales.add(lblNewLabel_9);
		lbl_propina.setText("$ 0");

		lbl_propina.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_propina.setFont(new Font("Dialog", Font.PLAIN, 20));
		totales.add(lbl_propina);

		lblNewLabel_11.setFont(new Font("Dialog", Font.PLAIN, 20));
		totales.add(lblNewLabel_11);

		lbl_totalMasPropina.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_totalMasPropina.setFont(new Font("Dialog", Font.PLAIN, 20));
		totales.add(lbl_totalMasPropina);

	}

	@Override
	public void run() {
		Thread current = Thread.currentThread();
		Fecha hora = new Fecha();

		while (current == hilo) {

			lbl_hra.setText(hora.horaActual());

		}

	}

	private void establecerDisenoTabla() {
		/* establece el color, ancho y algo de las cabeseras de la tabla */
		grillaProductos.getTableHeader().setPreferredSize(new Dimension(30, 30));
		grillaProductos.getTableHeader().setBackground(new Color(171, 174, 180));
		grillaProductos.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 13));

		scrollPane.getViewport().setBackground(new Color(195, 200, 208));
		grillaProductos.setBackground(new Color(195, 200, 208));
	}

	protected void establece_anchoColumnas() {

		grillaProductos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		grillaProductos.getColumnModel().getColumn(0).setPreferredWidth(5);
		grillaProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
		grillaProductos.getColumnModel().getColumn(2).setPreferredWidth(25);
		grillaProductos.getColumnModel().getColumn(3).setPreferredWidth(10);
		
		/*mantiene "oculto" el id*/
		grillaProductos.getColumnModel().getColumn(4).setMaxWidth(0);
		grillaProductos.getColumnModel().getColumn(4).setMinWidth(0);
		grillaProductos.getColumnModel().getColumn(4).setPreferredWidth(0);

	} 

	public void centrar_datos(int col) {
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
		modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
		grillaProductos.getColumnModel().getColumn(col).setCellRenderer(modelocentrar);

	}

	public static void estados_Pedidos(int index) {
		String[] estados = { "", "Agregando Mesa", "Agregando Productos", "Finalizado","Editando" };
		JP_Display.lbl_estadoMesa.setText(estados[index]);

	}

}