package controlador;

public class Calculos {
	private double unidad;
	private double total;
	private final double PROPINA = 0.10;
	private double totalMasPropina;

	Calculos() {

	}

	public double getUnidad() {
		return unidad;
	}

	public void setUnidad(double unidad) {
		this.unidad = unidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotalMasPropina() {
		return totalMasPropina;
	}

	public void setTotalMasPropina(double totalMasPropina) {
		this.totalMasPropina = totalMasPropina;
	}

	public double getPROPINA() {
		return PROPINA;
	}

}
