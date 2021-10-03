package vista;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class JP_MenuComidas extends JPanel {
	
	private JButton Btn_entradas = new JButton("Entradas");
	private JButton Btn_principales = new JButton("Principales");
	private JButton Btn_acompaniamiento = new JButton("Acompañamientos");
	private JButton Btn_bebidas = new JButton("Bebidas");
	private JButton Btn_salsas = new JButton("Salsas");
	private JButton Btn_aperitivos = new JButton("Aperitivos");
	private JButton Btn_postres = new JButton("Postres");
	private JButton Btn_bCalientes = new JButton("Bebidas calientes");
	private JButton Btn_Dsayunos = new JButton("Desayunos");
	
	private JButton Btn_1_5 = new JButton("Prueba");
	private JButton Btn_1_6 = new JButton("Prueba");
	private JButton Btn_1_7 = new JButton("Prueba");

	public JP_MenuComidas() {
		setBackground(Color.GRAY);
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setLayout(new GridLayout(0, 1, 0, 0));

		add(Btn_entradas);
		add(Btn_principales);
		add(Btn_acompaniamiento);
		add(Btn_bebidas);
		add(Btn_salsas);
		add(Btn_aperitivos);
		add(Btn_postres);
		add(Btn_bCalientes);
		add(Btn_Dsayunos);
		add(Btn_1_6);
		add(Btn_1_7);
		add(Btn_1_5);

	}

}
