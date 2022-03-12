package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private JPanel contentPane;
	JP_MenuHerramientas menuH = new JP_MenuHerramientas();
	JP_MenuComidas menuC = new JP_MenuComidas();
	JP_Display display = new JP_Display();
	public static int cont;
	public static boolean editando = false;

	public static void main(String[] args) {
		try {
			Principal main = new Principal();
			main.setVisible(true);
			main.setIconImage(
					Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/cuchilleria.png")));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al iniciar el programa");
		}

	}

	public Principal() {
		propiedades();


	}
	
	protected void propiedades() {
		cerrarVentana();
		setTitle("Restaurant Juanito");
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);

		contentPane = new JPanel();
		contentPane.repaint(getBounds());
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.setBackground(new Color(40, 83, 108));
		menuC.setBackground(new Color(40, 83, 108));
		menuH.setBackground(new Color(40, 83, 108));

		contentPane.add(menuH, BorderLayout.NORTH);
		contentPane.add(menuC, BorderLayout.CENTER);
		menuC.setLayout(new GridLayout(0, 3, 5, 5));
		display.lbl_propina.setText("$ 0 ");

		contentPane.add(display, BorderLayout.WEST);

	}

	public void cerrarVentana() {
		try {
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					confirmarSalida();
				}
			});
			this.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	protected void confirmarSalida() {
		int valor = JOptionPane.showConfirmDialog(this, "¿Está seguro de cerrar el programa?", "advertencia",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (valor == JOptionPane.YES_OPTION) {
			// JOptionPane.showMessageDialog(null, "Hasta pronto","cerrando
			// programa...",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);

		}

	}

}
