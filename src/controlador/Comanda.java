package controlador;

public class Comanda {

	private String id;
	private int precio;
	private String plato;
	private int cantidad;
	private int importe;
	private int id_comida;
	private int mesa;

	public Comanda(String id, int precio, String plato, int cantidad, int importe, int id_comida, int mesa) {
		this.id = id;
		this.precio = precio;
		this.plato = plato;
		this.cantidad = cantidad;
		this.importe = importe;
		this.id_comida = id_comida;
		this.mesa = mesa;
	}

	public Comanda() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getPlato() {
		return plato;
	}

	public void setPlato(String plato) {
		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId_comida() {
		return id_comida;
	}

	public void setId_comida(int id_comida) {
		this.id_comida = id_comida;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

}
