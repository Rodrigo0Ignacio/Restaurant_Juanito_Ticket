package modelo;

import controlador.Color_RGB;
import controlador.Comanda;
import controlador.Comida;
import controlador.Mesa;
import controlador.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Consultas extends Conexion {

	public Statement statement = null;
	public ResultSet rs = null;
	public String query = null;
	public int resultado = 0;

	/* CON ESTE METODO PODEMOS LISTAR LOS PRODUCTOS */
	public ArrayList<Producto> listarProductos() {
		ArrayList<Producto> lista = new ArrayList();
		try {
			query = "SELECT * FROM comida";
			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				lista.add(new Producto(rs.getInt("id_comida"), rs.getString("fk_categoria"), rs.getString("nombre"),
						rs.getInt("precio"), rs.getString("descripcion")));
			}
		} catch (SQLException ex) {
			return null;
		}

		desconectar();
		return lista;

	}

	/* ESTE METODO SE EMPLEA PARA COMPARAR EL BOTON PRECIONADO */
	public ArrayList<Comida> comparaBtn(String nombre) {

		ArrayList<Comida> lista = new ArrayList<Comida>();

		try {
			query = "SELECT * FROM comida WHERE nombre = '" + nombre + "'";
			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				lista.add(new Comida(rs.getInt("id_comida"), rs.getString("fk_categoria"), rs.getString("nombre"),
						rs.getInt("precio"), rs.getString("descripcion")));

			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD");

		}
		return lista;

	}

	public boolean verificaContenido(String parm1, String parm2) {

		try {
			query = "SELECT id_boleta,fecha_hora,total,fk_mesa FROM pre_boleta WHERE fecha_hora BETWEEN '" + parm1
					+ "' AND '" + parm2 + "' ORDER BY fecha_hora DESC";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);
			if (rs.next()) {
				return true;

			} else {
				return false;
			}

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD - verifica contenido");

		}
		desconectar();

		return false;

	}

	public int sub_totales(String parm1, String parm2) {

		int sub_total = 0;

		try {
			query = "SELECT SUM(total) AS 'su_total' FROM pre_boleta WHERE fecha_hora BETWEEN '" + parm1 + "' and '"
					+ parm2 + "' ORDER BY fecha_hora DESC;";
			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				sub_total = rs.getInt("su_total");

			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD - sub totales");

		}
		return sub_total;

	}

	public int contarRegistros(String parm1, String parm2) {

		int registros = 0;

		try {
			query = "SELECT COUNT(*) AS 'total' FROM pre_boleta WHERE fecha_hora BETWEEN '" + parm1 + "' and '" + parm2
					+ "'";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				registros = rs.getInt("total");

			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD - registros");

		}
		return registros;

	}

	public boolean verificarPasswrod(String pass) {

		boolean password = false;

		try {
			query = "select * from admin WHERE password = '" + pass + "'";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				password = true;

			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD");
			password = false;

		}
		return password;

	}

	public int buscarPrecio(String id_btn) {
		int precio = 0;

		try {
			query = "select precio from comida WHERE nombre = '" + id_btn + "'";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				precio = rs.getInt("precio");

			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD");

		}

		return precio;

	}

	public boolean verificarSiExitenPlatos(String parm1) {

		try {
			query = "SELECT DISTINCT * FROM comida WHERE fk_categoria = '" + parm1 + "' ";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);
			if (rs.next()) {
				return true;

			} else {
				return false;
			}

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD");

		}
		desconectar();

		return false;

	}

	public ArrayList<Mesa> listarMesas() {
		ArrayList<Mesa> lista = new ArrayList<Mesa>();

		try {
			query = "SELECT * FROM mesa";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);
			while (rs.next()) {
				lista.add(new Mesa(rs.getInt("id_mesa"), rs.getString("estado")));

			}

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD - listarMesas");

		}
		desconectar();
		return lista;

	}

	public int contrar_mesas(String parm1) {

		int total = 0;

		try {
			query = "SELECT COUNT(*) as total FROM mesa WHERE estado = '" + parm1 + "';";
			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				total = rs.getInt("total");

			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD - sub totales");

		}
		return total;

	}

	public String buscar_id_comanda(int mesa) {

		String id_comanda = null;

		try {
			query = "SELECT * FROM cap_datos where mesa_ref = " + mesa + ";";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				id_comanda = rs.getString("comanda_ref");

			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD");

		}
		return id_comanda;

	}
	
	public boolean buscar_id_comanda_restriccion(int mesa) {

		boolean id_comanda = false;

		try {
			query = "SELECT * FROM cap_datos where mesa_ref = " + mesa + ";";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				id_comanda = rs.next();

			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD");

		}
		return id_comanda;

	}
	
	public String buscar_estado_mesa(int mesa) {

		String estado = null;

		try {
			query = "select estado from mesa WHERE id_mesa = "+mesa+";";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				
				if(rs.getString("estado").equalsIgnoreCase("Disponible")) {
					estado = "Disponible";

				}else if(rs.getString("estado").equalsIgnoreCase("Ocupado")) {
					estado = "Ocupado";
					
				}

			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD");

		}
		return estado;

	}

	public ArrayList<Comanda> buscar_productos(String id_comanda) {
		ArrayList<Comanda> listaComanda = new ArrayList<Comanda>();

		try {
			query = "SELECT * FROM comanda WHERE id_comanda = '" + id_comanda + "';";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				listaComanda.add(new Comanda(rs.getString("id_comanda"), rs.getInt("precio_unitario"),
						rs.getString("plato"), rs.getInt("cantidad"), rs.getInt("importe"), rs.getInt("fk_comida"),
						rs.getInt("fk_mesa")));

			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD");

		}
		return listaComanda;

	}

}
