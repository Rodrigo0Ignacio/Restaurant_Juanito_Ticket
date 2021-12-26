package report;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class Informe_diario implements JRDataSource {
	
	private int index = 0;
	private Object [][] lista;

	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean next() throws JRException {
		index++;
		return (index < lista.length);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
