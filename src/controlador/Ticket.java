package controlador;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;

public class Ticket {

	// Ticket attribute content
	public String contentTicket ="RESTAURANT JUANITO\n"
			+ "DOMICILIO : GREGORIO MIRA 69.\n" 
			+ "RUT       : 013886707-2\n"
			+ "=============================\n"
			+ "Ticket : {{nro_ticket}}\n"
			+ "Mesa   : {{mesa}}\n"
			+ "Fecha  : {{fecha}}\n" 
			+ "Hora   : {{hora}}\n"
			+ "=============================\n" 
            + "Productos :        \n{{items}}"
			+ "=============================\n"
			+ "PROPINA  : {{propina}}\n" 
			+ "IVA      : {{iva}}\n" 
			+ "SUBTOTAL : {{total}}\n\n"
            + "=============================\n" 
            + "GRACIAS POR SU PREFERENCIA...\n";

	// El constructor que setea los valores a la instancia
	public Ticket(String nro_ticket,String mesa,
			String fecha,String hora,String items, String propina,
			String iva, String total){
		
		this.contentTicket = this.contentTicket.replace("{{nro_ticket}}", nro_ticket);
		this.contentTicket = this.contentTicket.replace("{{mesa}}", mesa);
		this.contentTicket = this.contentTicket.replace("{{fecha}}", fecha);
		this.contentTicket = this.contentTicket.replace("{{hora}}", hora);
		this.contentTicket = this.contentTicket.replace("{{items}}", items);
		this.contentTicket = this.contentTicket.replace("{{propina}}", propina);
		this.contentTicket = this.contentTicket.replace("{{iva}}", iva);
		this.contentTicket = this.contentTicket.replace("{{total}}", total);

	}
	
	
	public Ticket() {

	}

	public void print() {
		// Especificamos el tipo de dato a imprimir
		// Tipo: bytes; Subtipo: autodetectado
		DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

		// Aca obtenemos el servicio de impresion por defatul
		// Si no quieres ver el dialogo de seleccionar impresora usa esto
		// PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();

		// Con esto mostramos el dialogo para seleccionar impresora
		// Si quieres ver el dialogo de seleccionar impresora usalo
		// Solo mostrara las impresoras que soporte arreglo de bits
		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
		PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
		PrintService service = ServiceUI.printDialog(null, 700, 200, printService, defaultService, flavor, pras);

		// Creamos un arreglo de tipo byte
		byte[] bytes;

		// Aca convertimos el string(cuerpo del ticket) a bytes tal como
		// lo maneja la impresora(mas bien ticketera :p)
		bytes = this.contentTicket.getBytes();

		// Creamos un documento a imprimir, a el se le appendeara
		// el arreglo de bytes
		Doc doc = new SimpleDoc(bytes, flavor, null);

		// Creamos un trabajo de impresion
		DocPrintJob job = service.createPrintJob();

		// Imprimimos dentro de un try de a huevo
		try {
			// El metodo print imprime
			job.print(doc, null);
		} catch (Exception er) {
			JOptionPane.showMessageDialog(null, "Error al imprimir: " + er.getMessage());
		}
	}

}