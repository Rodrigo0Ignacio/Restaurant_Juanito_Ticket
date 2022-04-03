package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import Ticket.Comanda_1;
import controlador.Calculos;
import controlador.Codigo_Aleatorio;
import controlador.Color_RGB;
import controlador.Comanda;
import controlador.Comida;
import controlador.Fecha;
import controlador.Ticket;
import modelo.Consultas;
import modelo.Edicion;
import net.sf.jasperreports.engine.JRException;
import report.Reporte;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class JP_MenuHerramientas extends JPanel {

	private JPanel p_logo = new JPanel();
	private JPanel p_herramienta = new JPanel();
	private JButton borrar = new JButton("<html> <center> Borrar tabla </html>");
	private JButton imprimir = new JButton("<html> <center> Comandar orden </html>");
	private JButton informeDiario = new JButton("Informe");
	private JButton mesa = new JButton("Mesas");
	private JLabel lbl_titulo = new JLabel("Restaurant Juanito");
	private JLabel lbl_icono = new JLabel("");
	private ArrayList<String> indice = new ArrayList<String>();
	private Edicion edicionsql = new Edicion();
	private Fecha fecha = new Fecha();

	private int unidad = 0;
	private String plato = null;
	private int precio_u = 0;
	private int total = 0;
	private int id_mesa = 0;
	private Consultas sql = new Consultas();
	private JButton cancelar = new JButton("<html> <center>Cancelar orden </html>");
	private Consultas consultassql = new Consultas();
	private Mesa_Eleccion meleccion = new Mesa_Eleccion();
	private Ticket tikectTicket;

	public JP_MenuHerramientas() {
		setBorder(new EmptyBorder(15, 0, 15, 0));

		propiedades();
		eventos();

	}

	protected void propiedades() {
		setBackground(Color.GRAY);
		/* DESABILITAR BOTON DE IMPRESION */
		imprimir.setFont(new Font("Tahoma", Font.BOLD, 18));
		setLayout(new GridLayout(0, 2, 20, 20));

		/* establece el borde */
		p_herramienta.setForeground(Color.BLACK);
		p_herramienta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		p_herramienta.setBackground(Color.GRAY);
		// p_logo.setBackground(Color.GRAY);

		/* establece color botones */
		borrar.setBackground(new Color(113, 142, 164));
		imprimir.setBackground(new Color(113, 142, 164));
		informeDiario.setBackground(new Color(113, 142, 164));
		mesa.setBackground(new Color(113, 142, 164));
		cancelar.setBackground(new Color(113, 142, 164));

		p_logo.setBackground(new Color(40, 83, 108));
		p_herramienta.setBackground(new Color(40, 83, 108));

		add(p_logo);
		p_logo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lbl_titulo.setForeground(Color.WHITE);
		lbl_titulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_titulo.setFont(new Font("Times New Roman", Font.BOLD, 40));

		p_logo.add(lbl_titulo);
		lbl_icono.setIcon(new ImageIcon("src/img/mariscos.png"));

		p_logo.add(lbl_icono);

		add(p_herramienta);
		p_herramienta.setLayout(new GridLayout(1, 1, 6, 20));

		cancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
		p_herramienta.add(cancelar);
		borrar.setFont(new Font("Tahoma", Font.BOLD, 18));

		p_herramienta.add(borrar);

		p_herramienta.add(imprimir);
		informeDiario.setFont(new Font("Tahoma", Font.BOLD, 18));

		p_herramienta.add(informeDiario);
		mesa.setFont(new Font("Tahoma", Font.BOLD, 18));

		p_herramienta.add(mesa);

	}

	private void eventos() {
		mesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mesas mesas = new Mesas();

				if (JP_Display.lbl_estadoMesa.getText().equalsIgnoreCase("Editando")) {
					JOptionPane.showMessageDialog(null, "La mesa "
							+ mesas.extraerNumeros(JP_Display.lbl_nroMesa.getText()) + " Esta siendo editada");

				}

				else {
					mesas.setVisible(true);
				}

			}
		});

		imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JP_Display.grillaProductos.getRowCount() == 0
						&& JP_Display.grillaProductos.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Ingrese al menos un producto");

				} else if (JP_Display.lbl_nroMesa.getText().equalsIgnoreCase("N\u00B0 ")) {
					JOptionPane.showMessageDialog(null, "Ingrese una mesa");

				} else {

					if (JP_Display.lbl_estadoMesa.getText().equalsIgnoreCase("Editando")) {
						
						String id_comanda = sql.buscar_id_comanda(Mesas.id_mesa_dinamico);

						unidad = 0;
						plato = null;
						precio_u = 0;
						total = 0;
						id_mesa = 0;

						/* captura los datos de la edicion */
						for (int i = 0; i < JP_Display.grillaProductos.getRowCount(); i++) {

							unidad = (int) JP_Display.grillaProductos.getValueAt(i, 0);
							plato = (String) JP_Display.grillaProductos.getValueAt(i, 1);
							precio_u = (int) JP_Display.grillaProductos.getValueAt(i, 2);
							total = (int) JP_Display.grillaProductos.getValueAt(i, 3);
							id_mesa = (int) JP_Display.grillaProductos.getValueAt(i, 4);

							/* llenamos la tabla comanda */
							edicionsql.insertar_comanda(id_comanda, precio_u, fecha.fechaHora_formato2(), plato, unidad,
									total, id_mesa, Mesas.identificador_Mesa);
							
							/*llenamos una tabla auxiliar */
							edicionsql.insertar_Comanda_editando(id_comanda, precio_u, fecha.fechaHora_formato2(), plato, unidad,
									total, id_mesa, Mesas.identificador_Mesa);

						}
						
						try {
							Comanda_1.cargarComanda_editar(id_comanda, String.valueOf(Mesas.identificador_Mesa));
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						/*elimina datos antiguos de la tabla de referencia*/
						edicionsql.eliminarDatos_comanda_editando(id_comanda);
	
						Principal.editando = false;
						resetDisplay();

					} else if(JP_Display.lbl_estadoMesa.getText().equalsIgnoreCase("Agregando Mesa")) {
						try {
							// JP_Display.estados_Pedidos(3);
							/*
							 * GUARDAR EN LA BASE DE DATOS guarda la comanda en la bd
							 */
							String codigoUnico = Codigo_Aleatorio.codigo_alfanumerico_caracter();

							for (int i = 0; i < JP_Display.grillaProductos.getRowCount(); i++) {

								unidad = (int) JP_Display.grillaProductos.getValueAt(i, 0);
								plato = (String) JP_Display.grillaProductos.getValueAt(i, 1);
								precio_u = (int) JP_Display.grillaProductos.getValueAt(i, 2);
								total = (int) JP_Display.grillaProductos.getValueAt(i, 3);
								id_mesa = (int) JP_Display.grillaProductos.getValueAt(i, 4);

								/* llenamos la tabla comanda */
								edicionsql.insertar_comanda(codigoUnico, precio_u, fecha.fechaHora_formato2(), plato,
										unidad, total, id_mesa, Mesas.identificador_Mesa);

							}
							/* llenamos cap_datos TABLA DE REFERENCIA */
							edicionsql.insertar_cap_datos(codigoUnico, Mesas.identificador_Mesa);
							
							/*llenamos la tabla carga boleta*/
							edicionsql.insertar_cargaTabla_boleta(codigoUnico);
							
							/*A QUI SE DEBE INSERTAR CODIGO DEL TIKECT*/
							Comanda_1.cargarComanda(codigoUnico, String.valueOf(Mesas.identificador_Mesa));


							Principal.cont = 0;
							Mesas.identificador_Mesa = 0;
							resetDisplay();
							JP_Display.estados_Pedidos(0);

						} catch (NullPointerException q) {
							System.out.print(q);
						} catch (JRException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				}

			}
		});

		informeDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login login = new Login();
				login.setVisible(true);

			}
		});
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JP_Display.grillaProductos.getRowCount() == 0
						&& JP_Display.grillaProductos.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "La tabla esta vacia");

				} else {
					resetDisplay_borrar();
				}

			}
		});
		
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JP_Display.lbl_estadoMesa.getText().equalsIgnoreCase("Editando")) {
					resetDisplay_cancelar();
					JOptionPane.showMessageDialog(null, "Estado editando cancelado");
					
				}else if(JP_Display.lbl_estadoMesa.getText().equalsIgnoreCase("Agregando Mesa")
						|| JP_Display.estadoMesas.getText().equalsIgnoreCase("Agregando Mesa")) {
					
					JP_Display.estadoMesas.setText("");
					resetDisplay_cancelar();
					edicionsql.mesa_Disponibilidad(Mesas.identificador_Mesa,"Disponible");
					JOptionPane.showMessageDialog(null, "orden cancelada");
					
					
				}
	
				
			}
		});

	}

	public void resetDisplay() {
		JP_Display.lbl_nroMesa.setText("N\u00B0 ");
		JP_Display.lbl_total.setText("$ 0 ");
		JP_Display.lbl_propina.setText("$ 0 ");
		JP_Display.lbl_totalMasPropina.setText("$ 0 ");
		JP_Display.lbl_estadoMesa.setText("");
		// Fr_MenuMesas.txt_displayNumeros.setText("");
		JP_Display.estados_Pedidos(0);

		limpiarTabla();

	}
	public void resetDisplay_cancelar() {
		JP_Display.lbl_nroMesa.setText("N\u00B0 ");
		JP_Display.lbl_total.setText("$ 0 ");
		JP_Display.lbl_propina.setText("$ 0 ");
		JP_Display.lbl_totalMasPropina.setText("$ 0 ");
		JP_Display.lbl_estadoMesa.setText("");
		JP_Display.estados_Pedidos(0);

		limpiarTabla();

	}

	public void resetDisplay_borrar() {
		JP_Display.lbl_total.setText("$ 0 ");
		JP_Display.lbl_propina.setText("$ 0 ");
		JP_Display.lbl_totalMasPropina.setText("$ 0 ");

		limpiarTabla();

	}

	public void limpiarTabla() {
		/* Elimina las columnas agregadas */
		for (int i = JP_Display.modelo.getRowCount() - 1; i >= 0; i--) {
			JP_Display.modelo.removeRow(i);
		}
	}

	public JButton getMesa() {
		return mesa;
	}

	public void setMesa(JButton mesa) {
		this.mesa = mesa;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}
	
	

}
