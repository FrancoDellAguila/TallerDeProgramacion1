package excepciones;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase que representa una excepci�n cuando no se encontro ninguna consulta.
 */
public class OrdenFechasIncorrectoException extends Exception {
	/**
	 * Constructor con un parametro para setear la excepci�n
	 * <br>
	 * @param message: parametro de tipo String que representa el mensaje de la excepci�n
	 */
	public OrdenFechasIncorrectoException (String message) {
		super(message);
	}
}
