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
	
	JButton Btn_1 = new JButton("Prueba");
	JButton Btn_2 = new JButton("Prueba");
	JButton Btn_3 = new JButton("Prueba");
	JButton Btn_4 = new JButton("Prueba");
	JButton Btn_5 = new JButton("Prueba");
	private final JButton Btn_1_1 = new JButton("Prueba");
	private final JButton Btn_1_2 = new JButton("Prueba");
	private final JButton Btn_1_3 = new JButton("Prueba");
	private final JButton Btn_1_4 = new JButton("Prueba");
	private final JButton Btn_1_5 = new JButton("Prueba");
	private final JButton Btn_1_6 = new JButton("Prueba");
	private final JButton Btn_1_7 = new JButton("Prueba");

	public JP_MenuComidas() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Probando");
			}
		});
		setLayout(new GridLayout(0, 1, 0, 0));
		add(Btn_1);
		
		add(Btn_1_2);
		
		add(Btn_1_1);
		add(Btn_2);
		add(Btn_3);
		add(Btn_4);
		add(Btn_1_6);
		
		add(Btn_1_7);
		
		add(Btn_1_5);
		
		add(Btn_1_4);
		
		add(Btn_1_3);
		add(Btn_5);

	}

}
