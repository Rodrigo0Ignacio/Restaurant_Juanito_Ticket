package vista;

import javax.swing.JPanel;

import controlador.Ticket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class JP_MenuHerramientas extends JPanel {
	
	JButton imprimir = new JButton("Imprimir");
	JButton borrar = new JButton("Borrar");
	JButton mesa = new JButton("Mesa");
	JButton informeDiario = new JButton("Informe Diario");
	
	
	public JP_MenuHerramientas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{71, 63, 71, 101, 57, 0};
		gridBagLayout.rowHeights = new int[]{23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		GridBagConstraints gbc_borrar = new GridBagConstraints();
		gbc_borrar.anchor = GridBagConstraints.NORTHWEST;
		gbc_borrar.insets = new Insets(0, 0, 0, 5);
		gbc_borrar.gridx = 1;
		gbc_borrar.gridy = 0;
		add(borrar, gbc_borrar);
		
		mesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fr_MenuMesas nros = new Fr_MenuMesas();
				
				
			}
		});
		
		
		informeDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fr_Reporte reporte = new Fr_Reporte();
				reporte.setVisible(true);
				
				
			}
		});
		
		imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ticket tic = new Ticket("1","2","3","4","5","6","7","8","9","10","11","12");
				
				try {
					tic.print();
				} catch(Exception pr) {
					JOptionPane.showMessageDialog(null,"La Impresion se canselo");
					
				}
				
				
		}});
		GridBagConstraints gbc_imprimir = new GridBagConstraints();
		gbc_imprimir.anchor = GridBagConstraints.NORTHWEST;
		gbc_imprimir.insets = new Insets(0, 0, 0, 5);
		gbc_imprimir.gridx = 2;
		gbc_imprimir.gridy = 0;
		add(imprimir, gbc_imprimir);
		GridBagConstraints gbc_informeDiario = new GridBagConstraints();
		gbc_informeDiario.anchor = GridBagConstraints.NORTHWEST;
		gbc_informeDiario.insets = new Insets(0, 0, 0, 5);
		gbc_informeDiario.gridx = 3;
		gbc_informeDiario.gridy = 0;
		add(informeDiario, gbc_informeDiario);
		GridBagConstraints gbc_mesa = new GridBagConstraints();
		gbc_mesa.anchor = GridBagConstraints.NORTHWEST;
		gbc_mesa.gridx = 4;
		gbc_mesa.gridy = 0;
		add(mesa, gbc_mesa);

	}
}
