package vista;

import decorators.IMedico;
import modelo.Paciente;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Interfaz de uso para la ventana medico
 */
public interface IVistaMedico extends IVista{
	String getNombre();
	String getApellido();
	String getDni();
	String getDomicilio();
	String getCiudad();
	String getTelefono();	
	String getMatricula();
	
	String getEspecialidad();
	String getContratacion();
	String getPosgrado();
	
	IMedico getMedico();
	void error(String mensaje);
	void actulizarLista();
}
