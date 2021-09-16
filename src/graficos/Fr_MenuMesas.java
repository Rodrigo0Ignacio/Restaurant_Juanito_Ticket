package graficos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class Fr_MenuMesas extends JFrame {

	private JPanel contentPane;

	public Fr_MenuMesas() {
		try {
			setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/cuchilleria.png")));
			
		}catch(Exception e){
			
		}
		setTitle("N\u00B0 Mesas");
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setBounds(100, 100, 812, 539);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel display_numeros = new JPanel();
		display_numeros.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		display_numeros.setBounds(0, 0, 796, 98);
		contentPane.add(display_numeros);
		display_numeros.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel numeros = new JPanel();
		numeros.setBounds(0, 109, 796, 325);
		contentPane.add(numeros);
		numeros.setLayout(new GridLayout(0, 5, 4, 4));
		
		JButton btn_1 = new JButton("1");
		btn_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_2);
		
		JButton btn_3 = new JButton("3");
		btn_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_3);
		
		JButton btn_4 = new JButton("4");
		btn_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_4);
		
		JButton btn_5 = new JButton("5");
		btn_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_5);
		
		JButton btn_6 = new JButton("6");
		btn_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_6);
		
		JButton btn_7 = new JButton("7");
		btn_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_7);
		
		JButton btn_8 = new JButton("8");
		btn_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_8);
		
		JButton btn_9 = new JButton("9");
		btn_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_9);
		
		JButton btn_0 = new JButton("0");
		btn_0.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_0);
		
		JPanel borrar = new JPanel();
		borrar.setBounds(0, 445, 796, 62);
		contentPane.add(borrar);
		borrar.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btn_borrar = new JButton("Borrar");
		borrar.add(btn_borrar);
		btn_borrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lbl_numeros = new JLabel("");
		lbl_numeros.setBounds(10, 0, 782, 96);
		contentPane.add(lbl_numeros);
		lbl_numeros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_numeros.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
