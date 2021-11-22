package controlador;

import vista.JP_Display;

public class Calculos {
	
	private final double propina = 0.10;
	private int totalPropina = 0;
	
	
	public Calculos() {

	}
	public int sumaColumnas() {
		int fila = 0;
		int total = 0;
		
		for(int i = 0; i < JP_Display.grillaProductos.getRowCount(); i++) {
			fila = Integer.parseInt(JP_Display.grillaProductos.getValueAt(i,2).toString());
			total += fila;
		}
		return total;		
	}
	
	public int propina() {
		totalPropina = (int) (propina*sumaColumnas());
		
		return totalPropina;			
	}
	
	public int totalConPropina() {
		int total = (sumaColumnas()+propina()); 
		
		return total;
	}
	
	
	public void establecerValores() {
		JP_Display.lbl_total.setText("$ "+sumaColumnas());
		JP_Display.lbl_propina.setText("$ "+propina());
		JP_Display.lbl_totalMasPropina.setText("$ "+totalConPropina());
	}
	
	

	
	

}
