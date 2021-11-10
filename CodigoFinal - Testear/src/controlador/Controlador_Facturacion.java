package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;

import javax.swing.JOptionPane;

import excepciones.OrdenFechasIncorrectoException;
import modelo.Clinica;
import modelo.ConsultaMedica;
import modelo.Factura;
import modelo.Internacion;
import persistencia.IPersistencia;
import persistencia.Persistencia;
import vista.IVista;
import vista.IVistaFacturacion;
import vista.Ventana_Facturacion;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Controlador para la ventana de facturacion
 */
public class Controlador_Facturacion implements ActionListener,WindowListener{

	private IVistaFacturacion vista = null;
	private boolean isnuevafactura;
	private boolean MostrarTodas = true;
	/**
	 * Constructor sin parametros, al momento de crear el controlador crea la ventana<br>
	 *
	 */
	public Controlador_Facturacion()
	{
		this.vista = new Ventana_Facturacion();
		this.vista.addActionListener(this);
		this.vista.addWindowListener(this);
		this.isnuevafactura=true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Factura factura;
		if(e.getActionCommand().equals("Agregar habitacion")) {
			this.MostrarTodas = true;
			Internacion internacion= new Internacion(this.vista.getCantDias(),this.vista.getHabitacion());
			if(isnuevafactura) { 
				factura = new Factura(this.vista.getPaciente());
				Clinica.getInstance().addFactura(factura);
				this.isnuevafactura = false;
				this.vista.setEnablebtnFacturar(true);
			}else {
				factura = Clinica.getInstance().getUltimaFactura();
			}
			factura.addPrestacion(internacion.getHabitacion().getNumeroHabitacion(), internacion);


		}else if(e.getActionCommand().equals("Agregar consultas")) {
			this.MostrarTodas = true;
			ConsultaMedica consultamedica= new ConsultaMedica(this.vista.getCantConsultas(),this.vista.getMedico());
			if(isnuevafactura) { 
				factura = new Factura(this.vista.getPaciente());
				Clinica.getInstance().addFactura(factura);
				this.isnuevafactura = false;
				this.vista.setEnablebtnFacturar(true);
			}else {
				factura = Clinica.getInstance().getUltimaFactura();
			}
			factura.addPrestacion(consultamedica.getMedico().getNombre(), consultamedica);
		}else if(e.getActionCommand().equals("Facturar")) {
			factura = Clinica.getInstance().getUltimaFactura();
			factura.calculaTotal();
			this.isnuevafactura = true;
			this.vista.setEnablebtnFacturar(false);
		}else if(e.getActionCommand().equals("Borrar ultima")) {
			this.MostrarTodas = true;
			Clinica.getInstance().borrarUltimaFactura();
		}else if(e.getActionCommand().equals("Borrar todo")) {
			this.MostrarTodas = true;
			Clinica.getInstance().borrarFacturas();
		}else if(e.getActionCommand().equals("MostrarFacturasFecha")) {
			try {
				
				
				String facturas = Clinica.getInstance().ReporteActividadMedica(this.vista.getFechaInicio(), this.vista.getFechaFin());
				this.vista.mostrarFacturas(facturas);
				this.MostrarTodas = false;
			} catch (OrdenFechasIncorrectoException e1) {
				JOptionPane.showMessageDialog(null, "Orden de Fechas incorrectas", "ERROR!", JOptionPane.WARNING_MESSAGE);
			}

		}else if(e.getActionCommand().equals("MostrarFacturas")) {
			this.MostrarTodas = true;
		}
		if(MostrarTodas)
			this.vista.actualizar();
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if(Clinica.getInstance().getUltimaFactura()!=null && Clinica.getInstance().getUltimaFactura().getTotal()==0) {
			Clinica.getInstance().borrarUltimaFactura();
		}
		Controlador_Menu controlador_menu = new Controlador_Menu();
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

}
