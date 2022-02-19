
package controlador;

public class Producto {
	private int id;
	private String categoria;
	private String nombre;
	private int precio;
	private String descripcion;

	public Producto(int id, String categoria, String nombre, int precio, String descripcion) {
		this.id = id;
		this.categoria = categoria;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
