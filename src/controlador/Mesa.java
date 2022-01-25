package controlador;

public class Mesa {
	
	private int id_mesa;
	private String estado;
	
	public Mesa(int id_mesa, String estado ){
		this.id_mesa = id_mesa;
		this.estado = estado;
	}
	public Mesa(int id_mesa ){
		this.id_mesa = id_mesa;
	}
	
	public Mesa(){

	}
	

	
	public int getId_mesa() {
		return id_mesa;
	}
	
	public void setId_mesa(int id_mesa) {
		this.id_mesa = id_mesa;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
	

}
