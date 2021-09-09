package clases;

import java.util.*;
import java.text.*;

public class Fecha {
	
	
	public String fechaActual() {
		Date fecha = new Date();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
		
		return formatoFecha.format(fecha);
	}

	

}
