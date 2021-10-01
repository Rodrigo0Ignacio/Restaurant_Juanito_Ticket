package vista;

import javax.swing.JPanel;

import controlador.Ticket;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class JP_MenuHerramientas extends JPanel {
	
	private JPanel p_logo = new JPanel();
	private final JPanel p_herramienta = new JPanel();
	private final JButton borrar = new JButton("Borrar");
	private final JButton imprimir = new JButton("Imprimir");
	private final JButton informeDiario = new JButton("Informe Diario");
	private final JButton mesa = new JButton("Mesa");
	private final JLabel lbl_titulo = new JLabel("Restaurant Juanito");
	private final JLabel lbl_icono = new JLabel("");
	
	
	public JP_MenuHerramientas() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		/*establece el borde*/
		p_herramienta.setBackground(Color.GRAY);
		p_herramienta.setBorder(new EmptyBorder(30, 30, 30, 30));
		p_herramienta.setBorder(new TitledBorder(null, "Herramientas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		p_logo.setBackground(Color.GRAY);
		
		add(p_logo);
		p_logo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lbl_titulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_titulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		p_logo.add(lbl_titulo);
		lbl_icono.setIcon(new ImageIcon("C:\\Users\\Rodrigo\\eclipse-workspace\\Restaurant_Juanito_Automatizacion\\src\\img\\mariscos.png"));
		
		p_logo.add(lbl_icono);
		
		add(p_herramienta);
		p_herramienta.setLayout(new GridLayout(1, 1, 5, 0));
		
		p_herramienta.add(borrar);
		
		p_herramienta.add(imprimir);
		
		p_herramienta.add(informeDiario);
		
		p_herramienta.add(mesa);
		

	}

	/*sub clase que establece la imagen*/
	/*
	private class P_logo extends JPanel{
		private Image imagen;
		
		@Override
		public void paint(Graphics g) {
			imagen = new ImageIcon(getClass().getResource("/img/Junatio.png")).getImage();
			g.drawImage(imagen,0,0,getWidth(),getHeight(), this);
			setOpaque(false);
			super.paint(g);
			
		}
		
	}
	*/
	
	
	
	
	
}
