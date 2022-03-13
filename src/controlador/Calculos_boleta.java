package controlador;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Conexion;
import modelo.Consultas;

public class Calculos_boleta extends Consultas {
	private int importe_total = 0;
	private int propina = 0;
	private final double PROPINA = 0.10;
	
	public int total(String id) {
		 importe_total = 0;
		try {
			query = "SELECT SUM(importe) as 'importe' FROM comanda WHERE id_comanda = '"+id+"';";
			statement = (Statement) conectar().prepareStatement(query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				importe_total = rs.getInt("importe");	
			}
		} catch (SQLException ex) {

		}
		desconectar();
		return importe_total;

	}
	
	public int calcular_propina() {
		int resultadoq ;
		resultadoq = (int) (importe_total * PROPINA);

		return resultadoq;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	

}
