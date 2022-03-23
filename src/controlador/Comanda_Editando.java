package controlador;

public class Comanda_Editando {
	
	private String id = null;
	private int precio_unitario = 0;
	private String fecha_hora = null;
	private String plato = null;
	private int cantidad = 0;
	private int importe = 0;
	private int fk_comida = 0;
	private int fk_mesa = 0;
	
	
	public Comanda_Editando() {
		
	}


	public Comanda_Editando(String id, int precio_unitario, String fecha_hora, String plato, int cantidad, int importe,
			int fk_comida, int fk_mesa) {
		
		this.id = id;
		this.precio_unitario = precio_unitario;
		this.fecha_hora = fecha_hora;
		this.plato = plato;
		this.cantidad = cantidad;
		this.importe = importe;
		this.fk_comida = fk_comida;
		this.fk_mesa = fk_mesa;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getPrecio_unitario() {
		return precio_unitario;
	}


	public void setPrecio_unitario(int precio_unitario) {
		this.precio_unitario = precio_unitario;
	}


	public String getFecha_hora() {
		return fecha_hora;
	}


	public void setFecha_hora(String fecha_hora) {
		this.fecha_hora = fecha_hora;
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


	public int getImporte() {
		return importe;
	}


	public void setImporte(int importe) {
		this.importe = importe;
	}


	public int getFk_comida() {
		return fk_comida;
	}


	public void setFk_comida(int fk_comida) {
		this.fk_comida = fk_comida;
	}


	public int getFk_mesa() {
		return fk_mesa;
	}


	public void setFk_mesa(int fk_mesa) {
		this.fk_mesa = fk_mesa;
	}
	


}
