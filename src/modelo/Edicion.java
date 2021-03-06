package modelo;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import controlador.Fecha;
import report.Reporte;

public class Edicion extends Consultas {
	private Reporte reporte = new Reporte();
	private Fecha fecha = new Fecha();
	private boolean error;
	
	
	public boolean mesa_Disponibilidad(int id, String disponibilidad) {

		try {
			super.query = "UPDATE mesa SET estado = '" + disponibilidad + "' WHERE id_mesa =" + id;

			super.statement = conectar().createStatement();
			super.resultado = super.statement.executeUpdate(query);

		} catch (SQLException W) {
			error = true;
			JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta mesa_disponibilidad");
			

		}

		if (super.resultado == 1) {
			return true;

		} else {
			return false;
		}

	}

	public boolean insertar_cap_datos(String id_comanda, int mesa) throws SQLException {

		
			super.query = "INSERT INTO cap_datos VALUES(NULL,'" + id_comanda + "'," + mesa + ")";

			super.statement = conectar().createStatement();
			super.resultado = super.statement.executeUpdate(query);


		if (super.resultado == 1) {
			return true;

		} else {
			return false;
		}

	}

	public boolean eliminar_cap_datos(int mesa) {

		try {
			super.query = "DELETE FROM cap_datos WHERE mesa_ref = " + mesa + ";";

			super.statement = conectar().createStatement();
			super.resultado = super.statement.executeUpdate(query);

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta mesa delete cap_datos");

		}

		if (super.resultado == 1) {
			return true;

		} else {
			return false;
		}

	}

	public boolean insertar_comanda(String codigo, int precio_u, String fecha_hora, String plato, int cantidad,
			int importe, int id_comida, int nro_mesa) {
		
		 if (revisar_comanda_platos(codigo,plato) == 1) {
			 
			 incremento_comanda(codigo, plato,
					 (contar_comanda(codigo, plato)+cantidad),
					 (precio_comanda(codigo, plato)+importe));
			 
			 return true;
		 }else {

		try {
			super.query = "INSERT INTO comanda VALUES(NULL,'" + codigo + "'," + precio_u + ",'" + fecha_hora + "','" + plato
					+ "'," + cantidad + "," + importe + "," + id_comida + "," + nro_mesa + ");";

			super.statement = conectar().createStatement();
			super.resultado = super.statement.executeUpdate(query);

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta mesa");

		}

		if (super.resultado == 1) {
			return true;

		} else {
			return false;
		}
		 }

	}
	public void insertar_cargaTabla_boleta(String codigo) {

		try {
			super.query = "INSERT INTO carga_boleta VALUES(NULL,'"+codigo+"');";

			super.statement = conectar().createStatement();
			super.resultado = super.statement.executeUpdate(query);

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta carga_tabla");

		}
	}
	
	public boolean insertar_boleta(String id, String fecha_hora, int propina, int total,
			int mesa, String id_comanda) {

		try {
			super.query = "INSERT INTO pre_boleta VALUES('"+id+"','"+fecha_hora+"',"+propina+","+total+","+mesa+",'"+id_comanda+"');";

			super.statement = conectar().createStatement();
			super.resultado = super.statement.executeUpdate(query);

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta inserta_boleta");

		}

		if (super.resultado == 1) {
			return true;

		} else {
			return false;
		}

	}
	
	public boolean insertar_Comanda_editando(String id_comanda, int precio_unitario, String fecha_hora, String plato,
			int cantidad, int importe, int fk_comida, int fk_mesa) {

		try {
			super.query = "INSERT INTO comanda_edicion VALUES('"+id_comanda+"',"+precio_unitario+",'"+fecha_hora+"','"+plato+"',"+cantidad+","+importe+","+fk_comida+","+fk_mesa+");";

			super.statement = conectar().createStatement();
			super.resultado = super.statement.executeUpdate(query);

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error insertar_comanda_E");

		}

		if (super.resultado == 1) {
			return true;

		} else {
			return false;
		}
	}
	
	public void incremento_comanda(String id, String plato, int incremento, int importe) {

		try {
			super.query = "UPDATE comanda SET cantidad = "+incremento+" , importe = "+importe+"  WHERE id_comanda = '"+id+"' AND plato = '"+plato+"';";

			super.statement = conectar().createStatement();
			super.resultado = super.statement.executeUpdate(query);

		} catch (SQLException W) {
			JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta incremento_comanda");
			

		}

	}
	


	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
	

}
	

