package excepciones;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase que representa una excepción cuando no se encontro ninguna consulta.
 */
public class OrdenFechasIncorrectoException extends Exception {
	/**
	 * Constructor con un parametro para setear la excepción
	 * <br>
	 * @param message: parametro de tipo String que representa el mensaje de la excepción
	 */
	public OrdenFechasIncorrectoException (String message) {
		super(message);
	}
}
