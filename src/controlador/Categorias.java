package controlador;

public class Categorias {
	private int id_cat = 0;
	private String categorias = null;
	
	
	public Categorias(int id_cat, String categorias) {

		this.id_cat = id_cat;
		this.categorias = categorias;
	}
	
	public int getId_cat() {
		return id_cat;
	}
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}
	public String getCategorias() {
		return categorias;
	}
	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}
	
	

}
