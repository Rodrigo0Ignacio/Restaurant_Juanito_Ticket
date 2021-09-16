package graficos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;
	JP_MenuHerramientas menuH = new JP_MenuHerramientas();
	JP_MenuComidas menuC = new JP_MenuComidas();
	JP_Display display = new JP_Display();
	
	private final JLabel lblNewLabel = new JLabel("kvsdniisdv");
	private final JButton btnNewButton = new JButton("New button");

	public static void main(String[] args) {
		try {
			Principal frame = new Principal();
			frame.setVisible(true);	
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al iniciar el programa");
			
		}
							
	}

	public Principal() {
		try {
			setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/cuchilleria.png")));
			
		}catch(Exception e){
			
		}
		
		setTitle("Restaurant Juanito");
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(menuH, BorderLayout.NORTH);

		menuH.add(btnNewButton);
		contentPane.add(menuC, BorderLayout.CENTER);
		menuC.setLayout(new GridLayout(0, 3, 5, 5));
		
		contentPane.add(display, BorderLayout.WEST);

	}

	
}
	
