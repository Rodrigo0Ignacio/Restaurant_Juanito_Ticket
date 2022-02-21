/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

import controlador.Calculos;
import controlador.Fecha;
import modelo.Conexion;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Consultas;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Rodrigo
 */
public class Reporte {

	public static void cargarReporte(String parm1, String parm2) throws JRException {

		Consultas consultas = new Consultas();
		Conexion con = new Conexion();
		Calculos calculos = new Calculos();

		Fecha fecha = new Fecha();
		File dir = new File("C:/informes diarios");
		// E:/Rodrigo/Escritorio/informes diarios
		try {
			dir.mkdir();

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (consultas.verificaContenido(parm1, parm2) == true) {

			int sub_total = consultas.sub_totales(parm1, parm2);
			int cantidad_registros = consultas.contarRegistros(parm1, parm2);
			System.out.print(cantidad_registros);

			double totalpropina = sub_total * 0.10;

			JasperReport archivo = JasperCompileManager.compileReport("src\\report\\informe_ventas.jrxml");
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("fecha1", Reporte.convierte_fechas(parm1));
			map.put("fecha2", Reporte.convierte_fechas(parm2));
			map.put("total", calculos.establecerFormato(sub_total));
			map.put("registros", String.valueOf(cantidad_registros));
			map.put("propina", calculos.establecerFormato(totalpropina));

			JasperPrint print = JasperFillManager.fillReport(archivo, map, con.conectar());
			JasperExportManager.exportReportToPdfFile(print, "C:/informes diarios/reporte "
					+ fecha.fechaActual_reporte() + " hrs " + fecha.horaActual_reporte() + ".pdf");

			JOptionPane.showMessageDialog(null, "Informe Generado exitosamente");

		} else {
			JOptionPane.showMessageDialog(null, "Este Rango de fechas no existe");

		}

	}

	/* CONVIERTE UN STRING A TIMESTAMP */
	public static Timestamp convierte_fechas(String parm1) {
		Timestamp timestamp = Timestamp.valueOf(parm1);

		return timestamp;
	}
}
