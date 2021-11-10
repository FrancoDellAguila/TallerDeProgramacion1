package modelo;

/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase que representa a un ni�o. Se extiene de Paciente.
 */

public class Ni�o extends Paciente {

	public Ni�o(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono, long nroHistoria) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono, nroHistoria);
	}

	/**
	 * Se sobreescribe el m�todo que decide qui�n tiene prioridad para quedarse en la sala privada de la cl�nica, si el paciente que ya estaba all� o el que reci�n llega.
	 * <br>
	 * <b>Pre: </b> El par�metro otro debe ser distinto de null.<br>
	 * @param otro: par�metro de tipo Persona, contra el que se decidir� la prioridad.
	 * @return devuelve si el paciente que reci�n llega tiene prioridad contra un ni�o.
	 */
	
	public boolean prioridad(Paciente otro) {
		return otro.prioridadNi�o();
	}
	
	/**
	 * Se sobreescribe m�todo que decide si el paciente que ya est� en la sala privada tiene prioridad de quedarse all�, contra un ni�o que reci�n ingresa a la cl�nica.
	 * @return falso. No se tiene prioridad contra un ni�o.
	 */
	
	@Override
	public boolean prioridadNi�o() {
		return false;
	}

	/**
	 * Se sobreescribe m�todo que decide si el paciente que ya est� en la sala privada tiene prioridad de quedarse all�, contra un joven que reci�n ingresa a la cl�nica.
	 * @return falso. No se tiene prioridad contra un joven.
	 */
	
	@Override
	public boolean prioridadJoven() {
		return false;
	}

	/**
	 * Se sobreescribe m�todo que decide si el paciente que ya est� en la sala privada tiene prioridad de quedarse all�, contra un mayor que reci�n ingresa a la cl�nica.
	 * @return verdadero. Se tiene prioridad contra un mayor.
	 */
	
	@Override
	public boolean prioridadMayor() {
		return true;
	}
}

	
