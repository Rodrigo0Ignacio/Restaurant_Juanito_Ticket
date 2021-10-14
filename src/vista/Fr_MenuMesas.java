package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Fr_MenuMesas extends JFrame {

	private JPanel contentPane;
	private JTextField txt_displayNumeros = new JTextField();
	JButton btn_1 = new JButton("1");
	

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
		setBounds(100, 100, 812, 550);
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
		txt_displayNumeros.setEditable(false);
		
		
		txt_displayNumeros.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_displayNumeros.setHorizontalAlignment(SwingConstants.CENTER);
		display_numeros.add(txt_displayNumeros);
		txt_displayNumeros.setColumns(10);
		
		JPanel numeros = new JPanel();
		numeros.setBounds(0, 109, 796, 325);
		contentPane.add(numeros);
		numeros.setLayout(new GridLayout(0, 5, 4, 4));
		
		
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_displayNumeros.setText(txt_displayNumeros.getText()+"1");
				
			}
		});
		btn_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_displayNumeros.setText(txt_displayNumeros.getText()+"2");
			}
		});
		btn_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_2);
		
		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_displayNumeros.setText(txt_displayNumeros.getText()+"3");
			}
		});
		btn_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_3);
		
		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_displayNumeros.setText(txt_displayNumeros.getText()+"4");
			}
		});
		btn_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_4);
		
		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_displayNumeros.setText(txt_displayNumeros.getText()+"5");
			}
		});
		btn_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_5);
		
		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_displayNumeros.setText(txt_displayNumeros.getText()+"6");
			}
		});
		btn_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_6);
		
		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_displayNumeros.setText(txt_displayNumeros.getText()+"7");
			}
		});
		btn_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_7);
		
		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_displayNumeros.setText(txt_displayNumeros.getText()+"8");
			}
		});
		btn_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_8);
		
		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_displayNumeros.setText(txt_displayNumeros.getText()+"9");
			}
		});
		btn_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_9);
		
		JButton btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_displayNumeros.setText(txt_displayNumeros.getText()+"0");
			}
		});
		btn_0.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numeros.add(btn_0);
		
		JPanel borrar = new JPanel();
		borrar.setBounds(0, 445, 796, 62);
		contentPane.add(borrar);
		borrar.setLayout(new GridLayout(1, 0, 5, 5));
		
		JButton btn_borrar = new JButton("Borrar");
		btn_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_displayNumeros.setText("");
				
			}
		});
		borrar.add(btn_borrar);
		btn_borrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btn_aceptar = new JButton("Aceptar");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txt_displayNumeros.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ingrese un numero");
				}else {
					JP_Display.lbl_nroMesa.setText("N\u00B0 "+txt_displayNumeros.getText());
					setVisible(false);
				}
				
				
				

			}
		});
		borrar.add(btn_aceptar);
		
		
	}
	
	
	


	
}
