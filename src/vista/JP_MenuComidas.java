package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

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
	private String consulta = null;

	public JP_MenuComidas() {
		setBackground(Color.GRAY);
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Menu", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		
		Btn_entradas.setBackground(new Color(113, 142, 164));
		Btn_principales.setBackground(new Color(113, 142, 164));
		Btn_acompaniamiento.setBackground(new Color(113, 142, 164));
		Btn_bebidas.setBackground(new Color(113, 142, 164));
		Btn_salsas.setBackground(new Color(113, 142, 164));
		Btn_aperitivos.setBackground(new Color(113, 142, 164));
		Btn_postres.setBackground(new Color(113, 142, 164));
		Btn_bCalientes.setBackground(new Color(113, 142, 164));
		Btn_Sandwich.setBackground(new Color(113, 142, 164));
		Btn_empanadas.setBackground(new Color(113, 142, 164));
		
		
		Btn_entradas.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		Btn_entradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta = "Entradas";
				
					subMenuComidas.setVisible(true);
					subMenuComidas.consultas(consulta);
					subMenuComidas.setTitle(consulta);
					subMenuComidas.lbl_titulo.setText(consulta);
					
				
			}
		});
		
		add(Btn_entradas);
		Btn_principales.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_principales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				consulta = "Principales";
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas(consulta);
				subMenuComidas.setTitle(consulta);
				subMenuComidas.lbl_titulo.setText(consulta);
				

			}		
		});
		
		
		add(Btn_principales);
		Btn_acompaniamiento.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_acompaniamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				consulta = "Acompañamiento";
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas(consulta);
				subMenuComidas.setTitle(consulta);
				subMenuComidas.lbl_titulo.setText(consulta);
			}
		});
		
		
		add(Btn_acompaniamiento);
		Btn_bebidas.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_bebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				consulta = "Bebidas";
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas(consulta);
				subMenuComidas.setTitle(consulta);
				subMenuComidas.lbl_titulo.setText(consulta);
			}
		});
		
		
		add(Btn_bebidas);
		Btn_salsas.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_salsas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta = "Salsas";
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas(consulta);
				subMenuComidas.setTitle(consulta);
				subMenuComidas.lbl_titulo.setText(consulta);
				
			}
		});
		add(Btn_salsas);
		Btn_aperitivos.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_aperitivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				consulta = "Aperitivos";
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas(consulta);
				subMenuComidas.setTitle(consulta);
				subMenuComidas.lbl_titulo.setText(consulta);
				
			}
		});
		
		add(Btn_aperitivos);
		Btn_postres.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_postres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta = "Postres";
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas(consulta);
				subMenuComidas.setTitle(consulta);
				subMenuComidas.lbl_titulo.setText(consulta);
			}
		});
		
		add(Btn_postres);
		Btn_bCalientes.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_bCalientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				consulta = "Bebidas Calientes";
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas(consulta);
				subMenuComidas.setTitle(consulta);
				subMenuComidas.lbl_titulo.setText(consulta);
				
			
			}
		});
		
		Btn_Sandwich.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_Sandwich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta = "Sandwich";
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas(consulta);
				subMenuComidas.setTitle(consulta);
				subMenuComidas.lbl_titulo.setText(consulta);
				
			}
		});
		Btn_empanadas.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		Btn_empanadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta = "Empanadas";
				
				subMenuComidas.setVisible(true);
				subMenuComidas.consultas(consulta);
				subMenuComidas.setTitle(consulta);
				subMenuComidas.lbl_titulo.setText(consulta);
				
			}
		});
		
		/*EVENTOS DE MOUSE*/
		
		Btn_entradas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Btn_entradas.setBackground(new Color(170, 77, 57));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_entradas.setBackground(new Color(113, 142, 164));
			}
		});
		
		Btn_principales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Btn_principales.setBackground(new Color(170, 77, 57));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_principales.setBackground(new Color(113, 142, 164));
			}
		});
		
		Btn_acompaniamiento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Btn_acompaniamiento.setBackground(new Color(170, 77, 57));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_acompaniamiento.setBackground(new Color(113, 142, 164));
			}
		});
		
		Btn_bebidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Btn_bebidas.setBackground(new Color(170, 77, 57));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_bebidas.setBackground(new Color(113, 142, 164));
			}
		});
		Btn_aperitivos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Btn_aperitivos.setBackground(new Color(170, 77, 57));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_aperitivos.setBackground(new Color(113, 142, 164));
			}
		});
		
		Btn_postres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Btn_postres.setBackground(new Color(170, 77, 57));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_postres.setBackground(new Color(113, 142, 164));
			}
		});
		
		Btn_bCalientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Btn_bCalientes.setBackground(new Color(170, 77, 57));;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_bCalientes.setBackground(new Color(113, 142, 164));
			}
		});
		
		Btn_salsas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Btn_salsas.setBackground(new Color(170, 77, 57));;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_salsas.setBackground(new Color(113, 142, 164));
			}
		});
		
		Btn_Sandwich.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Btn_Sandwich.setBackground(new Color(170, 77, 57));;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_Sandwich.setBackground(new Color(113, 142, 164));
			}
		});
		
		Btn_empanadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Btn_empanadas.setBackground(new Color(170, 77, 57));;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_empanadas.setBackground(new Color(113, 142, 164));
			}
		});
		
		add(Btn_bCalientes);
		add(Btn_salsas);
		add(Btn_salsas);
		add(Btn_Sandwich);
		add(Btn_empanadas);

		
	}
	
	
		
	

}
