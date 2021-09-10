package graficos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		try {
			Principal frame = new Principal();
			frame.setVisible(true);	
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al iniciar el programa");
			
		}
							
	}

	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/cuchilleria.png")));
		setTitle("Restaurant Juanito");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		/*LAMINAS*/
		JP_Display display = new JP_Display();
		contentPane.add(display, BorderLayout.WEST);
		
		JP_MenuHerramientas menuH = new JP_MenuHerramientas();
		contentPane.add(menuH, BorderLayout.NORTH);
		
		JP_MenuComidas menuC = new JP_MenuComidas();
		contentPane.add(menuC, BorderLayout.CENTER);
		menuC.setLayout(new GridLayout(1, 0, 0, 0));
		
		

	}

}
