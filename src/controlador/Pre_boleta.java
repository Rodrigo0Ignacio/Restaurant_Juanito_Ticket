package controlador;

public class Pre_boleta {
	private String id;
	private String fecha_Hora;
	private int total;
	private int propina;
	private int mesa;
	private int registro_comanda;
	
	public Pre_boleta(String id, String fecha_Hora, int total, int propina, int mesa, int registro_comanda) {
		this.id = id;
		this.fecha_Hora = fecha_Hora;
		this.total = total;
		this.propina = propina;
		this.mesa = mesa;
		this.registro_comanda = registro_comanda;
	}

	public Pre_boleta() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFecha_Hora() {
		return fecha_Hora;
	}

	public void setFecha_Hora(String fecha_Hora) {
		this.fecha_Hora = fecha_Hora;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPropina() {
		return propina;
	}

	public void setPropina(int propina) {
		this.propina = propina;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public int getRegistro_comanda() {
		return registro_comanda;
	}

	public void setRegistro_comanda(int registro_comanda) {
		this.registro_comanda = registro_comanda;
	}
	

	

}
