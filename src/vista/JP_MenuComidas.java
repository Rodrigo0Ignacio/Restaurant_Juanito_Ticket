package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JP_MenuComidas extends JPanel {

	private JButton Btn_entradas = new JButton("Entradas");
	private JButton Btn_principales = new JButton("Principales");
	private JButton Btn_acompaniamiento = new JButton("Acompa\u00F1amiento");
	private JButton Btn_bebidas = new JButton("Bebidas");
	private JButton Btn_salsas = new JButton("Salsas");
	private JButton Btn_aperitivos = new JButton("Aperitivos");
	private JButton Btn_postres = new JButton("Postres");
	private JButton Btn_bCalientes = new JButton("Bebidas calientes");
	private int indice = 0;	
	Fr_Comidas subMenuComidas = new Fr_Comidas();


	private JButton Btn_Sandwich = new JButton("Sandwich");
	private JButton Btn_empanadas = new JButton("Empanadas");

	public JP_MenuComidas() {
		setBackground(Color.GRAY);
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Menu", TitledBorder.LEADING, TitledBorder.TOP,null, new Color(0, 0, 0)));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		Btn_entradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					subMenuComidas.setVisible(true);
					subMenuComidas.consultas("Entradas");
					subMenuComidas.setTitle("Entrada");
				
			}
		});
		
		add(Btn_entradas);
		Btn_principales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				subMenuComidas.setVisible(true);
				subMenuComidas.consultas("Principales");
				subMenuComidas.setTitle("Principales");

			}		
		});
		
		
		add(Btn_principales);
		Btn_acompaniamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas("Acompa�amiento");
				subMenuComidas.setTitle("Acompa�amiento"); 
			}
		});
		
		
		add(Btn_acompaniamiento);
		Btn_bebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas("Bebidas");
				subMenuComidas.setTitle("Bebidas");
			}
		});
		
		
		add(Btn_bebidas);
		Btn_salsas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas("Salsas");
				subMenuComidas.setTitle("Salsas");
			}
		});
		add(Btn_salsas);
		Btn_aperitivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas("Aperitivos");
				subMenuComidas.setTitle("Aperitivos");
			}
		});
		
		add(Btn_aperitivos);
		Btn_postres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas("Postres");
				subMenuComidas.setTitle("Postres");
			}
		});
		
		add(Btn_postres);
		Btn_bCalientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas("Bebidas Calientes");
				subMenuComidas.setTitle("Bebidas Calientes");
			}
		});
		
		
		
		Btn_Sandwich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas("Sandwich");
				subMenuComidas.setTitle("Sandwich");
			}
		});
		
		Btn_empanadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas("Empanadas");
				subMenuComidas.setTitle("Empanadas");
			}
		});
		
		add(Btn_bCalientes);
		add(Btn_salsas);
		add(Btn_salsas);
		add(Btn_Sandwich);
		add(Btn_empanadas);

		
	}
	
	
		
	

}
