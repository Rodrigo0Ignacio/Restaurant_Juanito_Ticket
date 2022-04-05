package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controlador.Categorias;
import controlador.Mesa;
import modelo.Consultas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import javax.swing.border.EmptyBorder;

public class JP_MenuComidas extends JPanel {

	private int indice = 0;
 	private Fr_Comidas subMenuComidas = new Fr_Comidas();;
	private String consulta = null;
	private Consultas con = new Consultas();
	private ArrayList<Categorias> lista = new ArrayList<Categorias>();
	private JButton btn;
	private JPanel botones = new JPanel();

	public JP_MenuComidas() {
		setLayout(new GridLayout(0, 1, 30, 30));
		botones.setBorder(new EmptyBorder(0, 0, 0, 0));
		botones.setOpaque(false);
		
		add(botones);
		botones.setLayout(new GridLayout(0, 4, 5, 5));
		
		//FlowLayout flowLayout = (FlowLayout) subMenuComidas.pn_dinamicos.getLayout();
		//flowLayout.setAlignment(FlowLayout.LEFT);
		
		propiedades();
		botones();
		

	}
	protected void propiedades() {
		setBackground(Color.GRAY);
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Menu", TitledBorder.LEFT, TitledBorder.TOP,
				null, null));
	}
	private void botones() {
		lista = con.datos_Categorias();
		for (Categorias cat : lista) {
			btn = new JButton(""+cat.getCategorias());
			tamanio_btn(150,320);
			propiedades_btn();
			
			botones.add(btn);	
			
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					propiedades_instancia(e.getActionCommand());
					

				}
			});
			
		}

		
	}
	
	private void tamanio_btn(int alto, int ancho) {
		//btn.setMinimumSize(new Dimension(ancho,alto));
		//btn.setMaximumSize(new Dimension(ancho,alto));
		btn.setPreferredSize(new Dimension(ancho,alto));
	}
	private void propiedades_btn() {
		btn.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn.setBackground(new Color(214, 234, 248));
		
	}
	
	
	private void propiedades_instancia(String con) {
		
		//JP_Display.estados_Pedidos(2);
		subMenuComidas.setVisible(true);
		//subMenuComidas.setExtendedState(Frame.MAXIMIZED_BOTH);
		subMenuComidas.consultas(con);
		subMenuComidas.setTitle(con);
		subMenuComidas.lbl_titulo.setText(con);
		subMenuComidas.sub_panel.updateUI();
		
	}
	


}
