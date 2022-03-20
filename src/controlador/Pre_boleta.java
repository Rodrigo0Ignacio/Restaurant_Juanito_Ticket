package controlador;

public class Pre_boleta {
	private String id = null;
	private String fecha_Hora = null;
	private int propina = 0;
	private int total = 0;
	private int mesa = 0;
	private String id_comanda = null;
	private String producto = null;
	private int cantidad = 0;
	private int precio_unitario = 0;
	

	public Pre_boleta(String id, String fecha_Hora, int propina, int total, int mesa, String id_comanda) {
		super();
		this.id = id;
		this.fecha_Hora = fecha_Hora;
		this.propina = propina;
		this.total = total;
		this.mesa = mesa;
		this.id_comanda = id_comanda;
	}
	public Pre_boleta(String id, String fecha_Hora,String id_comanda, 
			String producto, int cantidad, int precio_unitario, int mesa,
			int propina, int total) {
		
		this.id = id;
		this.fecha_Hora = fecha_Hora;
		this.id_comanda = id_comanda;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio_unitario = precio_unitario;
		this.mesa = mesa;
		this.propina = propina;
		this.total = total;

		
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

	public int getPropina() {
		return propina;
	}

	public void setPropina(int propina) {
		this.propina = propina;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public String getId_comanda() {
		return id_comanda;
	}

	public void setId_comanda(String id_comanda) {
		this.id_comanda = id_comanda;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecio_unitario() {
		return precio_unitario;
	}
	public void setPrecio_unitario(int precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	
	
	
	

	

}
