package graficos;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JP_Display extends JPanel implements Printable {
	private JTable table;


	public JP_Display() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel titulo = new JPanel();
		add(titulo);
		titulo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.add(lblNewLabel_4);
		
		JPanel subP_Fecha = new JPanel();
		titulo.add(subP_Fecha);
		subP_Fecha.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		subP_Fecha.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		subP_Fecha.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		subP_Fecha.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		subP_Fecha.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		subP_Fecha.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		subP_Fecha.add(lblNewLabel_7);
		
		JPanel grilla = new JPanel();
		add(grilla);
		grilla.setLayout(new GridLayout(1, 0, 0, 0));
		
		table = new JTable();
		grilla.add(table);
		
		JPanel totales = new JPanel();
		add(totales);
		totales.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		totales.add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		totales.add(lblNewLabel_10);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		totales.add(lblNewLabel_9);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		totales.add(lblNewLabel_12);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		totales.add(lblNewLabel_11);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		totales.add(lblNewLabel_13);
		this.setVisible(true);

	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		
		return 0;
	}

}
