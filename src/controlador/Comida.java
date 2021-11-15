package controlador;

public class Comida {
	private int id_comida;
	private String categoria;
	private String nombre;
	private double precio;
	private String descripcion;
	
	public Comida() {}
	
	public Comida(int id_comida, String categoria, String nombre, double precio, String descripcion) {
		this.id_comida = id_comida;
		this.categoria = categoria;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public Comida(int id_comida, String categoria, String nombre, double precio) {
		this.id_comida = id_comida;
		this.categoria = categoria;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getId_comida() {
		return id_comida;
	}

	public void setId_comida(int id_comida) {
		this.id_comida = id_comida;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
