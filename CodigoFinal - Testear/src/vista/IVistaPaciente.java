package vista;


import modelo.Paciente;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Interfaz de uso para la ventana de asociado
 */
public interface IVistaPaciente extends IVista{
	String getNombre();
	String getApellido();
	String getDni();
	String getDomicilio();
	String getCiudad();
	String getTelefono();
	Paciente getPaciente();
	void error(String mensaje);
	void actulizarLista();
}
