package vista;

import java.util.Calendar;

import decorators.IMedico;
import modelo.Habitacion;
import modelo.Medico;
import modelo.Paciente;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Interfaz de uso para la ventana de facturacion
 */
public interface IVistaFacturacion extends IVista {
	Habitacion getHabitacion();
	int getCantDias();
	Paciente getPaciente();
	public int getCantConsultas();
	public IMedico getMedico();
	public void setEnablebtnFacturar(boolean bool);
	
	Calendar getFechaInicio();
	Calendar getFechaFin();
	
	void actualizar();
	void mostrarFacturas(String facturas);
}