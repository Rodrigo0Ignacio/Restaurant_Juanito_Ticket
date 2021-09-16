package graficos;

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

import clases.Fecha;

import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class JP_Display extends JPanel implements Runnable {
	
	private JTable Grilla_Pedidos;
	private Thread hilo;
	
	JPanel titulo = new JPanel();
	JPanel subTitulo = new JPanel();
	JLabel lblNewLabel = new JLabel("Restaurant Juantio");
	JLabel lblNewLabel_1 = new JLabel("Ticket de pedido");
	JPanel Fecha_y_Hora = new JPanel();
	JLabel lbl_hra = new JLabel("00:00:00");
	Fecha fecha = new Fecha();
	
	
	
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
		
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		subTitulo.add(lblNewLabel);
		
		
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		subTitulo.add(lblNewLabel_1);
		
		
		titulo.add(Fecha_y_Hora);
		Fecha_y_Hora.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Fecha:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		Fecha_y_Hora.add(lblNewLabel_2);
		
		JLabel lbl_fecha = new JLabel("DD/MM/YYYY");
		lbl_fecha.setFont(new Font("Dialog", Font.PLAIN, 16));
		// ESTABLECE FECHA ACTUAL
		lbl_fecha.setText(fecha.fechaActual());
		
		Fecha_y_Hora.add(lbl_fecha);
		
		JLabel lblNewLabel_5 = new JLabel("Hora:");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 16));
		Fecha_y_Hora.add(lblNewLabel_5);
		lbl_hra.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		
		Fecha_y_Hora.add(lbl_hra);
		
		JLabel lblNewLabel_4 = new JLabel("Mesa:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 16));
		Fecha_y_Hora.add(lblNewLabel_4);
		
		JLabel lbl_nroMesa = new JLabel("N\u00B0");
		lbl_nroMesa.setFont(new Font("Dialog", Font.PLAIN, 16));
		Fecha_y_Hora.add(lbl_nroMesa);
		
		JPanel grilla = new JPanel();
		add(grilla);
		grilla.setLayout(new GridLayout(1, 0, 0, 0));
		
		Grilla_Pedidos = new JTable();
		Grilla_Pedidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		grilla.add(Grilla_Pedidos);
		
		JPanel totales = new JPanel();
		totales.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(totales);
		totales.setLayout(new GridLayout(0, 2, -10, -10));
		
		JLabel lblNewLabel_8 = new JLabel("TOTAL:");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 16));
		totales.add(lblNewLabel_8);
		
		JLabel lbl_total = new JLabel("$ 15000");
		lbl_total.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_total.setFont(new Font("Dialog", Font.PLAIN, 16));
		totales.add(lbl_total);
		
		JLabel lblNewLabel_9 = new JLabel("PROPINA:");
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 16));
		totales.add(lblNewLabel_9);
		
		JLabel lblNewLabel_12 = new JLabel("$ 1500");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setFont(new Font("Dialog", Font.PLAIN, 16));
		totales.add(lblNewLabel_12);
		
		JLabel lblNewLabel_11 = new JLabel("TOTAL MAS PROPINA");
		lblNewLabel_11.setFont(new Font("Dialog", Font.PLAIN, 16));
		totales.add(lblNewLabel_11);
		
		JLabel lblNewLabel_13 = new JLabel("$ 16500");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setFont(new Font("Dialog", Font.PLAIN, 16));
		totales.add(lblNewLabel_13);
		this.setVisible(true);

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
