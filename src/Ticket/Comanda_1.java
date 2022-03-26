package Ticket;

import java.io.File;
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

public class Comanda_1 {
	
	
	public static void cargarComanda(String id_comanda, String nro_mesa) throws JRException {

		Consultas consultas = new Consultas();
		Conexion con = new Conexion();
		Calculos calculos = new Calculos();

		Fecha fecha = new Fecha();
		/*
		File dir = new File("C:/Comandas Generadas");
		// E:/Rodrigo/Escritorio/informes diarios
		try {
			dir.mkdir();

		} catch (Exception e) {
			e.printStackTrace();
		}
		*/

			JasperReport archivo = JasperCompileManager.compileReport("src\\Ticket\\Comanda.jrxml");
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("codigo", id_comanda);
			map.put("fecha",fecha.fechaActual());
			map.put("hora", fecha.horaActual());
			map.put("mesa", nro_mesa);

			JasperPrint print = JasperFillManager.fillReport(archivo, map, con.conectar());
			/*IMPRIME 2 COMANDAS*/
			//JasperPrintManager.printReport(print, false);
			JasperPrintManager.printReport(print, false);// impresion
			/*-------------------------------------------------------------*/
			
			/*
			JasperExportManager.exportReportToPdfFile(print, "C:/Comandas Generadas/Comanda - "+id_comanda
					+ fecha.fechaActual_reporte() + " hrs " + fecha.horaActual_reporte() + ".pdf");
					
            */
			JOptionPane.showMessageDialog(null, "Comanda generada exitosamente");


	}
	
	public static void cargarComanda_editar(String id_comanda, String nro_mesa) throws JRException {

		Consultas consultas = new Consultas();
		Conexion con = new Conexion();
		Calculos calculos = new Calculos();
		Fecha fecha = new Fecha();
		
		/*
		File dir = new File("C:/Comandas Generadas");
		// E:/Rodrigo/Escritorio/informes diarios
		try {
			dir.mkdir();

		} catch (Exception e) {
			e.printStackTrace();
		}
		*/

			JasperReport archivo = JasperCompileManager.compileReport("src\\Ticket\\Comanda_editar.jrxml");
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("codigo", id_comanda);
			map.put("fecha",fecha.fechaActual());
			map.put("hora", fecha.horaActual());
			map.put("mesa", nro_mesa);

			JasperPrint print = JasperFillManager.fillReport(archivo, map, con.conectar());
			/*IMPRIME 2 COMANDAS*/
			JasperPrintManager.printReport(print, false);
			//JasperPrintManager.printReport(print, false);// impresion
			/*-------------------------------------------------------------*/
			
			/*
			JasperExportManager.exportReportToPdfFile(print, "C:/Comandas Generadas/Comanda_editada - "+id_comanda
					+ fecha.fechaActual_reporte() + " hrs " + fecha.horaActual_reporte() + ".pdf");
			*/

			JOptionPane.showMessageDialog(null, "Comanda generada exitosamente");


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
