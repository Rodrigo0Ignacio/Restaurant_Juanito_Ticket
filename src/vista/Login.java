package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;

import modelo.Conexion;
import modelo.Consultas;

import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	public Login() {
		setTitle("Administrador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/cuchilleria.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 389, 184);
		setLocationRelativeTo(null);
		setBackground(new Color(195, 200, 208));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(195, 200, 208));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_cntral = new JPanel();
		panel_cntral.setBackground(new Color(195, 200, 208));
		contentPane.add(panel_cntral, BorderLayout.CENTER);
		panel_cntral.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(103, 11, 166, 23);
		panel_cntral.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(103, 45, 166, 23);
		passwordField.setColumns(20);
		panel_cntral.add(passwordField);

		JButton btn_entrar = new JButton("Acceder");
		btn_entrar.setBackground(new Color(113, 142, 164));
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Consultas consultas = new Consultas();

				if (consultas.verificarPasswrod(passwordField.getText())) {
					Fr_Reporte report = new Fr_Reporte();
					report.setVisible(true);
					setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
					passwordField.setText("");
					passwordField.requestFocus();
				}

			}
		});
		btn_entrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_entrar.setBounds(103, 79, 166, 44);
		panel_cntral.add(btn_entrar);
	}

}
