package Ticket;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument.TotalDigits;

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
		String codigo_Generado = Codigo_Aleatorio.codigo_alfanumerico_numero();

		Fecha fecha = new Fecha();
		File dir = new File("C:/Boletas Generadas");
		try {
			dir.mkdir();

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*CALCULO DE TOTALES*/
		int neto = consultas.sub_total_preBoleta(id_comanda);
		int propina = (int) (neto * Calculos.PROPINA);
		int total = (neto + propina);
		/*-------------------*/
		

			JasperReport archivo = JasperCompileManager.compileReport("src\\Ticket\\Boleta_1.jrxml");
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("fecha", fecha.fechaActual());
			map.put("hora",fecha.horaActual());
			map.put("codigo", codigo_Generado);
			map.put("mesa", nro_mesa);
			map.put("neto", calculos.establecerFormato(neto));
			map.put("propina", calculos.establecerFormato(propina));
			map.put("total", calculos.establecerFormato(total));
			map.put("idComanda", id_comanda);

			JasperPrint print = JasperFillManager.fillReport(archivo, map, con.conectar());
			JasperPrintManager.printReport(print, false); // impresion
			JasperExportManager.exportReportToPdfFile(print, "C:/Boletas Generadas/boleta - "+codigo_Generado+
					"_fecha "+ fecha.fechaActual_reporte()+".pdf");

			JOptionPane.showMessageDialog(null, "Boleta generada exitosamente");


	}
	


	

	
	
}


	
	
