package graficos;

import javax.swing.JPanel;

import clases.Ticket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;

public class JP_MenuHerramientas extends JPanel {
	
	JButton imprimir = new JButton("Imprimir");
	JButton borrar = new JButton("Borrar");
	JButton mesa = new JButton("Mesa");
	JButton informeDiario = new JButton("Informe Diario");
	
	
	public JP_MenuHerramientas() {
		
		imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ticket tic = new Ticket("1","2","3","4","5","6","7","8","9","10","11","12");
				
				try {
					tic.print();
				} catch(Exception pr) {
					JOptionPane.showMessageDialog(null,"La Impresion se canselo");
					
				}
				
				
		}});
		
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		mesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fr_MenuMesas nros = new Fr_MenuMesas();
				
				
			}
		});
		
		
		informeDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(borrar);
		add(imprimir);
		add(informeDiario);
		add(mesa);

	}

}
