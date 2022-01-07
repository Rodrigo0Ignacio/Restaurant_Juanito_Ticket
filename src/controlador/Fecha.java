package controlador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {
	private String hora;
	private String minuto;
	private String segundo;

	public String fechaActual() {
		Date fecha = new Date();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");

		return formatoFecha.format(fecha);
	}
	
	

	public String horaActual() {
		Calendar calendario = new GregorianCalendar();
		Date horaActual = new Date();
		calendario.setTime(horaActual);

		hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
				: "0" + calendario.get(Calendar.HOUR_OF_DAY);
		minuto = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
				: "0" + calendario.get(Calendar.MINUTE);
		segundo = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
				: "0" + calendario.get(Calendar.SECOND);

		String hra = hora + ":" + minuto + ":" + segundo;

		return hra;

	}
	
	public String fechaActual_reporte() {
		Date fecha = new Date();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-YYYY");

		return formatoFecha.format(fecha);
	}
	
	public String horaActual_reporte() {
		Calendar calendario = new GregorianCalendar();
		Date horaActual = new Date();
		calendario.setTime(horaActual);

		hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
				: "0" + calendario.get(Calendar.HOUR_OF_DAY);
		minuto = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
				: "0" + calendario.get(Calendar.MINUTE);
		segundo = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
				: "0" + calendario.get(Calendar.SECOND);

		String hra = hora + "-" + minuto + "-" + segundo;

		return hra;

	}

}
