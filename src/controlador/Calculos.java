package controlador;

import java.text.NumberFormat;

import vista.JP_Display;

public class Calculos {

	private final double PROPINA = 0.10;
	private NumberFormat formatoImporte = NumberFormat.getCurrencyInstance();
	private NumberFormat formatoPropina = NumberFormat.getCurrencyInstance();
	private NumberFormat formatoTotal = NumberFormat.getCurrencyInstance();

	public Calculos() {
 
	}

	protected double sumarValores() {
		double suma = 0;
		int fila = 0;
		for (int i = 0; i < JP_Display.grillaProductos.getRowCount(); i++) {

			fila = Integer.parseInt(JP_Display.grillaProductos.getValueAt(i, 3).toString());
			suma += fila;

		}
		return suma;
	}

	protected double obtnerpropina() {
		double resultado = 0;
		resultado = sumarValores() * PROPINA;

		return resultado;
	}

	protected double total() {
		double total = 0;
		total = sumarValores() + obtnerpropina();

		return total;
	}

	public String establecerFormato(double moneda) {
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance();
		return formatoMoneda.format(moneda);

	}

	public void establecerValores() {
		JP_Display.lbl_total.setText("" + formatoTotal.format(sumarValores()));
		JP_Display.lbl_propina.setText("" + formatoPropina.format(obtnerpropina()));
		JP_Display.lbl_totalMasPropina.setText("" + formatoImporte.format(total()));
	}

}
