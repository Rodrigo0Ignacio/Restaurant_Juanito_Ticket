package controlador;

public class Registro_Comanda {

	private int id;
	private String id_comanda;

	public Registro_Comanda(int id, String id_comanda) {
		this.id = id;
		this.id_comanda = id_comanda;
	}

	public Registro_Comanda() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_comanda() {
		return id_comanda;
	}

	public void setId_comanda(String id_comanda) {
		this.id_comanda = id_comanda;
	}

}
