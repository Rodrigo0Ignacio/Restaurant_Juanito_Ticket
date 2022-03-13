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

import controlador.Mesa;
import modelo.Consultas;

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
	Fr_Comidas subMenuComidas;

	private JButton Btn_Sandwich = new JButton("Sandwich");
	private JButton Btn_empanadas = new JButton("Empanadas");
	private String consulta = null;

	public JP_MenuComidas() {
		subMenuComidas = new Fr_Comidas();
		
		propiedades();
		propiedades_elementos();
		eventos_botones();
		eventos_raton();

		add(Btn_bCalientes);
		add(Btn_salsas);
		add(Btn_Sandwich);
		add(Btn_empanadas);
		add(Btn_entradas);
		add(Btn_principales);
		add(Btn_acompaniamiento);
		add(Btn_bebidas);
		add(Btn_aperitivos);
		add(Btn_postres);

	}
	protected void propiedades() {
		setBackground(Color.GRAY);
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Menu", TitledBorder.LEFT, TitledBorder.TOP,
				null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
	}
	
	private void eventos_botones() {
		Btn_entradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				propiedades_instancia("Entradas");

			}
		});

		
		
		Btn_principales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				propiedades_instancia("Principales");
				
			}
		});

		
		
		Btn_acompaniamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				propiedades_instancia("Acompañamiento");

			}
		});

		
		
		Btn_bebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                
				propiedades_instancia("Bebidas");

			}
		});

		
		
		Btn_salsas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				propiedades_instancia("Salsas");

			}
		});
		
		
		Btn_aperitivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				propiedades_instancia("Aperitivos");

			}
		});

		
		
		Btn_postres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				propiedades_instancia("Postres");

			}
		});

		
		
		Btn_bCalientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				propiedades_instancia("Bebidas Calientes");

			}
		});

		
		Btn_Sandwich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				propiedades_instancia("Sandwich");

			}
		});
		

		Btn_empanadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				propiedades_instancia("Empanadas");

			}
		});

		/* EVENTOS DE MOUSE */

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

	}

	
    private void eventos_raton() {
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

				Btn_bCalientes.setBackground(new Color(170, 77, 57));
				;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Btn_bCalientes.setBackground(new Color(113, 142, 164));
			}
		});

		Btn_salsas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Btn_salsas.setBackground(new Color(170, 77, 57));
				;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Btn_salsas.setBackground(new Color(113, 142, 164));
			}
		});

		Btn_Sandwich.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Btn_Sandwich.setBackground(new Color(170, 77, 57));
				;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Btn_Sandwich.setBackground(new Color(113, 142, 164));
			}
		});

		Btn_empanadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				Btn_empanadas.setBackground(new Color(170, 77, 57));
				;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Btn_empanadas.setBackground(new Color(113, 142, 164));
			}
		});
	}

	public void estado_botones(boolean activa) {
		Btn_entradas.setEnabled(activa);
		Btn_principales.setEnabled(activa);
		Btn_acompaniamiento.setEnabled(activa);
		Btn_bebidas.setEnabled(activa);
		Btn_salsas.setEnabled(activa);
		Btn_aperitivos.setEnabled(activa);
		Btn_postres.setEnabled(activa);
		Btn_bCalientes.setEnabled(activa);
		Btn_Sandwich.setEnabled(activa);
		Btn_empanadas.setEnabled(activa);
	}
	
	private void propiedades_instancia(String con) {
		subMenuComidas.pn_dinamicos.updateUI();
		subMenuComidas.pn_dinamicos.removeAll();
		//JP_Display.estados_Pedidos(2);
		subMenuComidas.setVisible(true);
		subMenuComidas.consultas(con);
		subMenuComidas.setTitle(con);
		subMenuComidas.lbl_titulo.setText(con);
	}
	
	private void propiedades_elementos() {
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
		Btn_principales.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_acompaniamiento.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_bebidas.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_salsas.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_aperitivos.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_postres.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_bCalientes.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_Sandwich.setFont(new Font("Tahoma", Font.BOLD, 24));
		Btn_empanadas.setFont(new Font("Tahoma", Font.BOLD, 24));
		
	}

}
