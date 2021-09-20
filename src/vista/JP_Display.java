package vista;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Fecha;

import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class JP_Display extends JPanel implements Runnable {
	
	private JTable Grilla_Pedidos;
	private Thread hilo;
	private String mesa = null ;
	private JLabel lbl_titulo = new JLabel("Restaurant Juantio");
	private JLabel lbl_subtitulo = new JLabel("Ticket de pedido");
	private JPanel titulo = new JPanel();
	private JPanel subTitulo = new JPanel();
	private JPanel Fecha_y_Hora = new JPanel();
	private JLabel lbl_hra = new JLabel("00:00:00");
	private Fecha fecha = new Fecha();
	private JLabel lblNewLabel_2 = new JLabel("Fecha:");
	private JLabel lbl_fecha = new JLabel("DD/MM/YYYY");
	private JLabel lblNewLabel_5 = new JLabel("Hora:");
	private JLabel lblNewLabel_4 = new JLabel("Mesa:");
	private JPanel grilla = new JPanel();
	private JLabel lblNewLabel_8 = new JLabel("TOTAL:");
	private JLabel lblNewLabel_9 = new JLabel("PROPINA:");
	private JLabel lblNewLabel_11 = new JLabel("TOTAL MAS PROPINA");
	private JPanel totales = new JPanel();
	
	public static JLabel lbl_nroMesa = new JLabel("N°");
	public static JLabel lbl_propina = new JLabel("$ 1500");
	public static JLabel lbl_total = new JLabel("$ 15000");
	public static JLabel lbl_totalMasPropina = new JLabel("$ 16500");
	
	
	
	public JP_Display() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		hilo = new Thread(this);
		hilo.start();
		setVisible(true);

		setBackground(Color.WHITE);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		add(titulo);
		titulo.setLayout(new GridLayout(0, 1, 0, 0));

		titulo.add(subTitulo);
		subTitulo.setLayout(new GridLayout(0, 1, 0, 0));
		
		lbl_titulo.setFont(new Font("Dialog", Font.PLAIN, 16));
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		subTitulo.add(lbl_titulo);
		
		
		lbl_subtitulo.setFont(new Font("Dialog", Font.PLAIN, 16));
		lbl_subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subTitulo.add(lbl_subtitulo);
		
		
		titulo.add(Fecha_y_Hora);
		Fecha_y_Hora.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		Fecha_y_Hora.add(lblNewLabel_2);
		
		
		lbl_fecha.setFont(new Font("Dialog", Font.PLAIN, 16));
		// ESTABLECE FECHA ACTUAL
		lbl_fecha.setText(fecha.fechaActual());
		Fecha_y_Hora.add(lbl_fecha);
		
		
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 16));
		Fecha_y_Hora.add(lblNewLabel_5);
		lbl_hra.setFont(new Font("Dialog", Font.PLAIN, 16));
		Fecha_y_Hora.add(lbl_hra);
		
		
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 16));
		Fecha_y_Hora.add(lblNewLabel_4);
		
		lbl_nroMesa.setFont(new Font("Dialog", Font.PLAIN, 16));
		Fecha_y_Hora.add(lbl_nroMesa);
		
		add(grilla);
		grilla.setLayout(new GridLayout(1, 0, 0, 0));
		
		Grilla_Pedidos = new JTable();
		Grilla_Pedidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		grilla.add(Grilla_Pedidos);
		
		totales.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(totales);
		totales.setLayout(new GridLayout(0, 2, -10, -10));
		
		
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 16));
		totales.add(lblNewLabel_8);
		
		
		lbl_total.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_total.setFont(new Font("Dialog", Font.PLAIN, 16));
		totales.add(lbl_total);
		
		
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 16));
		totales.add(lblNewLabel_9);
		
		
		lbl_propina.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_propina.setFont(new Font("Dialog", Font.PLAIN, 16));
		totales.add(lbl_propina);
		
		
		lblNewLabel_11.setFont(new Font("Dialog", Font.PLAIN, 16));
		totales.add(lblNewLabel_11);
		
		
		lbl_totalMasPropina.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_totalMasPropina.setFont(new Font("Dialog", Font.PLAIN, 16));
		totales.add(lbl_totalMasPropina);


	}
	
	
	@Override
	public void run() {
		Thread current = Thread.currentThread();
		Fecha hora = new Fecha();
		
		while(current == hilo) {
			
			lbl_hra.setText(hora.horaActual());
			
			
		}
		
	}




}
