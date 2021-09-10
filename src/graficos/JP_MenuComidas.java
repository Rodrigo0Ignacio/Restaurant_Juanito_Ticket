package graficos;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JP_MenuComidas extends JPanel {
	
	JButton Btn_1 = new JButton("Prueba");
	JButton Btn_2 = new JButton("Prueba");
	JButton Btn_3 = new JButton("Prueba");
	JButton Btn_4 = new JButton("Prueba");
	JButton Btn_5 = new JButton("Prueba");

	public JP_MenuComidas() {
		Btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Probando");
			}
		});
		add(Btn_1);
		add(Btn_2);
		add(Btn_3);
		add(Btn_4);
		add(Btn_5);

	}

}
