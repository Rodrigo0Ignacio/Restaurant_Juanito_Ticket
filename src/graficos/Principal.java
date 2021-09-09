package graficos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import clases.Fecha;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

public class Principal extends JFrame implements Runnable {
	
	Fecha fhActual = new Fecha();
	/*Hora*/
	String hora, minuto, segundo;
	Thread hilo;
	
	private JPanel contentPane;
	private JTable table;
	private JLabel lbl_nroMesa = new JLabel("");
	private JLabel lbl_horaActual = new JLabel("");
	private JLabel lbl_fechaActual = new JLabel(fhActual.fechaActual());
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		
		hilo = new Thread(this);
		hilo.start();
		setVisible(true);
		
		setTitle("Restaurant Juanito");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(200, 200, 1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel_North = new JPanel();
		contentPane.add(panel_North, BorderLayout.NORTH);
		
		JButton btn_Imprimir = new JButton("Imprimir Ticket");
		btn_Imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//0=yes, 1=no, 2=cancel
				int confirma = JOptionPane.showConfirmDialog(null, "Desea continuar", "Alerta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			}
		});
		btn_Imprimir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_North.add(btn_Imprimir);
		
		/*BOTON BORRAR*/
		JButton btn_borrar = new JButton("Borrar");
		btn_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_nroMesa.setText("");
			}
		});
		btn_borrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_North.add(btn_borrar);
		/*BOTON Y ACCION MESA*/
		JButton btn_mesa = new JButton("Mesa");
		btn_mesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mesas mesa = new Mesas();
				
			}
		});
		btn_mesa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_North.add(btn_mesa);
		
		JButton btn_informeDiario = new JButton("Informe Diario");
		btn_informeDiario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_North.add(btn_informeDiario);
		
		JPanel panel_west = new JPanel();
		panel_west.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		contentPane.add(panel_west, BorderLayout.WEST);
		panel_west.setLayout(new BorderLayout(0, 0));
		
		JPanel JpTitulo = new JPanel();
		panel_west.add(JpTitulo, BorderLayout.NORTH);
		JpTitulo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Restaurant Juanito");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JpTitulo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ticket de pedido");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		JpTitulo.add(lblNewLabel_1);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setEnabled(false);
		JpTitulo.add(lblNewLabel_14);
		
		JPanel JpTotales = new JPanel();
		panel_west.add(JpTotales, BorderLayout.SOUTH);
		JpTotales.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JpTotales.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("$1000");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		JpTotales.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PROPINA:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JpTotales.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("$100");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		JpTotales.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("TOTAL MAS PROPINA:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JpTotales.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("$1100");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		JpTotales.add(lblNewLabel_7);
		
		JPanel JpGrilla = new JPanel();
		panel_west.add(JpGrilla, BorderLayout.CENTER);
		JpGrilla.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"hola", "dasas", "dsadasd"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Unidad", "Descripcion", "Valor"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JpGrilla.add(table);
		
		JPanel panel_fecha = new JPanel();
		JpGrilla.add(panel_fecha, BorderLayout.NORTH);
		panel_fecha.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_9 = new JLabel("Fecha:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_fecha.add(lblNewLabel_9);
		
		
		lbl_fechaActual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_fecha.add(lbl_fechaActual);
		
		JLabel lblNewLabel_12 = new JLabel("Hora:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_fecha.add(lblNewLabel_12);
		
		
		lbl_horaActual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_fecha.add(lbl_horaActual);
		
		JLabel lblNewLabel_11 = new JLabel("Mesa");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_fecha.add(lblNewLabel_11);
		
		
		lbl_nroMesa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_fecha.add(lbl_nroMesa);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setEnabled(false);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_fecha.add(lblNewLabel_13);
		
		JPanel panel_center = new JPanel();
		panel_center.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Carta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_center, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New button");
		
		JButton btnNewButton_2 = new JButton("New button");
		
		JButton btnNewButton_7 = new JButton("New button");
		
		JButton btnNewButton_6 = new JButton("New button");
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_center.setLayout(new GridLayout(0, 4, 3, 3));
		panel_center.add(btnNewButton);
		panel_center.add(btnNewButton_2);
		panel_center.add(btnNewButton_7);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel_center.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_center.add(btnNewButton_4);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel_center.add(btnNewButton_8);
		panel_center.add(btnNewButton_6);
		panel_center.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_center.add(btnNewButton_3);
	}
	
	public void horaActual() {
		Calendar calendario = new GregorianCalendar();
		Date horaActual = new Date();
		calendario.setTime(horaActual);
		
		hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"
		+calendario.get(Calendar.HOUR_OF_DAY);
		
		minuto = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"
				+calendario.get(Calendar.MINUTE);
		
		segundo = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"
				+calendario.get(Calendar.SECOND);
		
	}
	


	public void run() {
		Thread current = Thread.currentThread();
		
		while(current == hilo) {
			
			horaActual();
			
			lbl_horaActual.setText(hora+":"+minuto+":"+segundo);
			
			
		}
		
		
	}

}
