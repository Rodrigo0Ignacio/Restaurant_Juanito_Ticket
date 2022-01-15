package vista;

import com.mysql.cj.x.protobuf.MysqlxExpect;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import report.Reporte;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import modelo.Consultas;

public class Fr_Reporte extends JFrame {

	private JPanel contentPane;
	JDateChooser dateChooser_fecha1 = new JDateChooser(); 
	JDateChooser dateChooser_fecha2 = new JDateChooser();

	public Fr_Reporte() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 308, 477);
		contentPane = new JPanel();
		setBackground(new Color(195, 200, 208));
		contentPane.setBackground(new Color(195, 200, 208));
		contentPane.setBorder(new TitledBorder(null, "Buscar Informes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		setTitle("Informe diario");
		setLocationRelativeTo(null);
		setResizable(false);
                setIconImage(new ImageIcon(getClass().getResource("/img/cuchilleria.png")).getImage());
		
		
		
		dateChooser_fecha1.getCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 16));
		dateChooser_fecha1.setDateFormatString("yyyy-MM-dd HH:mm:ss");
		dateChooser_fecha1.setBounds(30, 151, 239, 35); 
		
		dateChooser_fecha1.setFont(new Font("Tahoma", Font.BOLD, 16));
		dateChooser_fecha2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		contentPane.add(dateChooser_fecha1);
		dateChooser_fecha2.setDateFormatString("yyyy-MM-dd HH:mm:ss");
		dateChooser_fecha2.setBounds(30, 252, 239, 35);
		contentPane.add(dateChooser_fecha2);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.setBackground(new Color(113, 142, 164));
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
				
				try {
					Reporte.cargarReporte(convertirFecha(dateChooser_fecha1),convertirFecha(dateChooser_fecha2));
                                        
					
				} catch (JRException e1) {
					
					JOptionPane.showMessageDialog(null,"Error al generar el archivo");
				}
						
		
			}
		});
		btn_buscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_buscar.setBounds(60, 338, 174, 52);
		contentPane.add(btn_buscar);
		
		JLabel lblNewLabel = new JLabel("Generador de Informes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 272, 83);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Desde:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 105, 71, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hasta:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(30, 206, 61, 35);
		contentPane.add(lblNewLabel_2);
		
		
		
	}
	
	/*COMVIERTE LAS FECHA A TIPO STRING*/
	public String convertirFecha (JDateChooser fecha_inicio) {
		Date fecha1 = null;
		DateFormat f1 = null;
		String fechas1 = null;
		
		try {
	       
	          fecha1 = fecha_inicio.getDate();
	          f1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	          fechas1 = f1.format(fecha1);
	        
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Error al convertir la fecha");
	    }
		
		return fechas1;
	}
	

	
}
