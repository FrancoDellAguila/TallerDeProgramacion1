package excepciones;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase que representa una excepción que el paciente no se encuentra.
 */
public class NoEstaPacienteException extends Exception{
	/**
	 * Constructor con un parametro para setear la excepción.
	 * <br>
	 * @param message: parametro de tipo String que representa el mensaje de la excepción.
	 */
	public NoEstaPacienteException(String message) {
		super(message);
	}

}
