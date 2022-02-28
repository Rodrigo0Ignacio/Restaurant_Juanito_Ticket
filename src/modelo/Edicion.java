package modelo;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Edicion extends Consultas {

	public boolean mesa_Disponibilidad(int id, String disponibilidad) {

		try {
			super.query = "UPDATE mesa SET estado = '" + disponibilidad + "' WHERE id_mesa =" + id;

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
	
	public boolean insertar_comanda(String codigo, int precio_u, String plato, int cantidad,
			int id_comida, int nro_mesa) {

		try {
			super.query = "INSERT INTO comanda VALUES('"+codigo+"',"+precio_u+",'"+plato+"',"+cantidad+","+id_comida+","+nro_mesa+");";

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
