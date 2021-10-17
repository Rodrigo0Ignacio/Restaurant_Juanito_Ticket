package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JP_MenuComidas extends JPanel {

	private JButton Btn_entradas = new JButton("Entradas");
	private JButton Btn_principales = new JButton("Principales");
	private JButton Btn_acompaniamiento = new JButton("Acompa�amiento");
	private JButton Btn_bebidas = new JButton("Bebidas");
	private JButton Btn_salsas = new JButton("Salsas");
	private JButton Btn_aperitivos = new JButton("Aperitivos");
	private JButton Btn_postres = new JButton("Postres");
	private JButton Btn_bCalientes = new JButton("Bebidas calientes");
	private JButton Btn_Dsayunos = new JButton("Desayunos");
        private Fr_Comidas comidas = new Fr_Comidas();


	private JButton Btn_1_5 = new JButton("Prueba");
	private JButton Btn_1_6 = new JButton("Prueba");
	private JButton Btn_1_7 = new JButton("Prueba");

	public JP_MenuComidas() {
		setBackground(Color.GRAY);
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Menu", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));

		setLayout(new GridLayout(0, 1, 0, 0));
		Btn_entradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                           comidas.setVisible(true);
                            
			}
		});

		add(Btn_entradas);
		Btn_principales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(Btn_principales);
		Btn_acompaniamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(Btn_acompaniamiento);
		Btn_bebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(Btn_bebidas);
		Btn_salsas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(Btn_salsas);
		Btn_aperitivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(Btn_aperitivos);
		Btn_postres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(Btn_postres);
		Btn_bCalientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(Btn_bCalientes);
		Btn_Dsayunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(Btn_Dsayunos);
		add(Btn_1_6);
		add(Btn_1_7);
		add(Btn_1_5);

	}

}
