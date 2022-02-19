package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	private Connection conectar = null;
	private final String URI = "jdbc:mysql://localhost:3306/juanito";
	private final String USER = "root";
	private final String PASSWORD = "";

	public Connection conectar() {
		try {
			/* DRIVER */
			Class.forName("com.mysql.cj.jdbc.Driver");
			conectar = DriverManager.getConnection(URI, USER, PASSWORD);

		} catch (SQLException | ClassNotFoundException s) {
			JOptionPane.showMessageDialog(null, "Error en la conexion: " + s);
		}
		return conectar;

	}

	public Connection desconectar() {

		try {
			conectar.close();
		} catch (SQLException s) {
			JOptionPane.showMessageDialog(null, "Error al desconectar " + s);

		}
		return conectar;
	}

}
