package modelo;

import controlador.Categorias;
import controlador.Color_RGB;
import controlador.Comanda;
import controlador.Comanda_Editando;
import controlador.Comida;
import controlador.Mesa;
import controlador.Pre_boleta;
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
			query = "SELECT id_pre_boleta,fecha_hora,total,fk_mesa FROM pre_boleta WHERE fecha_hora BETWEEN '" + parm1
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
	
	public int sub_total_preBoleta(String id_boleta) {
		int total = 0;

		try {
			query = "select total from pre_boleta WHERE fk_comanda_cargar = '"+id_boleta+"';";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				total = rs.getInt("total");
			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar BD");

		}
		return total;

	}
	
	public ArrayList<Pre_boleta> listar_boleta() {
		ArrayList<Pre_boleta> lista = new ArrayList<Pre_boleta>();

		try {
			query = "select * from pre_boleta;";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				lista.add(new Pre_boleta(
						rs.getString("id_pre_boleta"),
						rs.getString("fecha_hora"),
						rs.getInt("propina"),
						rs.getInt("total"),
						rs.getInt("fk_mesa"),
						rs.getString("fk_comanda")
						));

			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar pre_boleta leer");

		}
		return lista;

	}
	
	public ArrayList<Pre_boleta> sp_listar(String id_comanda) {
		ArrayList<Pre_boleta> lista = new ArrayList<Pre_boleta>();

		try {
			query = "CALL `listar_boleta`('"+id_comanda+"');";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				lista.add(new Pre_boleta(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getInt(9)
						));

			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento");

		}
		return lista;

	}
	
	/*clase Comanda_editando*/
	
	public ArrayList<Comanda_Editando> capturarDatos_comanda_editando() {
		ArrayList<Comanda_Editando> lista = new ArrayList<Comanda_Editando>();

		try {
			query = "select * from comanda_edicion;";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				lista.add(new Comanda_Editando(
						rs.getString(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)
						));

			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar el comanda_editando");

		}
		return lista;

	}
	
	public boolean verificaDatos_comanda_editando(String id_comanda) {

		try {
			query = "SELECT * FROM comanda_edicion WHERE id = '"+id_comanda+"';";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

				if(rs.next()) {
					return true;
				}else {
					return false;
				}

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar el comanda_editando verificar datos");

		}
		return false;


	}
	
	public void eliminarDatos_comanda_editando(String id_comanda) {

		try {
			query = "CALL eliminar_datos_comanda_edicion('"+id_comanda+"');";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al eliminar datos - comanda_editando");

		}

	}
	
	public ArrayList<Categorias> datos_Categorias() {
		ArrayList<Categorias> lista = new ArrayList<Categorias>();

		try {
			query = "SELECT * FROM categoria;";

			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
					lista.add(new Categorias(
							rs.getInt(1),
							rs.getString(2)
							));	
			}
			desconectar();

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar el dato_categorias");

		}
		return lista;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
