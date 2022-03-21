package Ticket;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import controlador.Calculos;
import controlador.Codigo_Aleatorio;
import controlador.Fecha;
import modelo.Conexion;
import modelo.Consultas;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import report.Reporte;

public class Pre_Boleta {
	
	public static void cargarBoleta(String id_comanda, String nro_mesa) throws JRException {

		Consultas consultas = new Consultas();
		Conexion con = new Conexion();
		Calculos calculos = new Calculos();

		Fecha fecha = new Fecha();
		File dir = new File("C:/Boletas Generadas");
		// E:/Rodrigo/Escritorio/informes diarios
		try {
			dir.mkdir();

		} catch (Exception e) {
			e.printStackTrace();
		}

			JasperReport archivo = JasperCompileManager.compileReport("src\\Ticket\\Boleta_1.jrxml");
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("fecha", fecha.fechaActual());
			map.put("codigo", Codigo_Aleatorio.codigo_alfanumerico_numero());
			map.put("mesa", nro_mesa);
			map.put("neto", "8");
			map.put("iva", "8");
			map.put("propina", "8");
			map.put("total", "8");
			map.put("idComanda", id_comanda);

			JasperPrint print = JasperFillManager.fillReport(archivo, map, con.conectar());
			JasperPrintManager.printReport(print, false); // impresion
			JasperExportManager.exportReportToPdfFile(print, "C:/Boletas Generadas/boleta "
					+ fecha.fechaActual_reporte() + " hrs " + fecha.horaActual_reporte() + ".pdf");

			JOptionPane.showMessageDialog(null, "Informe Generado exitosamente");


	}

	/* CONVIERTE UN STRING A TIMESTAMP */
	public static Timestamp convierte_fechas(String parm1) {
		Timestamp timestamp = Timestamp.valueOf(parm1);

		return timestamp;
	}
}
	
	
