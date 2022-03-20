package controlador;

import java.util.ArrayList;

import modelo.Consultas;
import vista.JP_Display;

public class Ticket_precargado extends Ticket {
	private Fecha fecha = new Fecha();

	private Consultas con = new Consultas();
	private ArrayList<Pre_boleta> lista_boleta = new ArrayList<Pre_boleta>();
	private String producto = "";
	private Calculos cal = new Calculos();
	private int total = 0;
	private int propina = 0;
	private final double IVA = 0.19;
	private double sub_total = 0;
	private final double PROPINA_SUGERIDA = 0.10;
	

	
	public void boleta(String idcomanda) {

		lista_boleta = con.sp_listar(idcomanda);
		
		for (Pre_boleta p : lista_boleta) {
			
			propina = p.getPropina();
			total = p.getTotal();
			producto += "["+cal.establecerFormato((double) p.getPrecio_unitario())+"]"+" X"+p.getCantidad() +" "+ p.getProducto()+"\n";
		}
		}
	
	public String calculaIVA() {
		double iva_calculado = ((total + propina) * IVA);
		return cal.establecerFormato(iva_calculado) ;
	}
	
	public String total() {
		return cal.establecerFormato(total);
	}
	
	public String propina() {
		return cal.establecerFormato(propina);
	}
	public String sub_total() {
		sub_total = (total * PROPINA_SUGERIDA) + total;
		return cal.establecerFormato(sub_total);
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

	public double getSub_total() {
		return sub_total;
	}

	public void setSub_total(double sub_total) {
		this.sub_total = sub_total;
	}

	public String getProducto() {
		return producto;
	}



	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	
	


	
	

		

	

	

	
	
	
	
	
	
}
