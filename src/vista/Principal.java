package vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private JPanel contentPane;
	JP_MenuHerramientas menuH = new JP_MenuHerramientas();
	JP_MenuComidas menuC = new JP_MenuComidas();
	JP_Display display = new JP_Display();

	public static void main(String[] args) {
		try {
			Principal main = new Principal();
			main.setVisible(true);
			main.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/cuchilleria.png")));
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al iniciar el programa");
			
		}
							
	}

	public Principal() {
		
		setTitle("Restaurant Juanito");
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(menuH, BorderLayout.NORTH);


		contentPane.add(menuC, BorderLayout.CENTER);
		menuC.setLayout(new GridLayout(0, 3, 5, 5));
		
		contentPane.add(display, BorderLayout.WEST);

	}

	
}
	
