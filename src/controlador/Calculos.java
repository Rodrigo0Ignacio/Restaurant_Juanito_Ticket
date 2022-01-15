package controlador;

import vista.JP_Display;

public class Calculos {
	
	private final double propina = 0.10;
	private int totalPropina = 0;
	
	
	public Calculos() {

	}
	
	protected int sumarValores() {
		int suma = 0 ;
		int fila = 0;
		for(int i = 0 ; i < JP_Display.grillaProductos.getRowCount() ; i++ ) {
			
			fila = Integer.parseInt(JP_Display.grillaProductos.getValueAt(i, 3).toString());
			suma += fila;
			
		}
		return suma;
	}
	
	protected int obtnerpropina() {
		int resultado = 0;
		resultado = (int) (sumarValores()*propina);
		
		
		return resultado;
	}
	
	protected int total() {
		int total = 0;
		total = sumarValores()+obtnerpropina();
		
		return total;
	}
	

	
	
	public void establecerValores() {
		JP_Display.lbl_total.setText("$ "+sumarValores());
		JP_Display.lbl_propina.setText("$ "+obtnerpropina());
		JP_Display.lbl_totalMasPropina.setText("$ "+total());
	}
	
	

	
	

}
