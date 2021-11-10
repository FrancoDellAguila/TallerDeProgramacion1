package excepciones;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase que representa una excepci�n que no se encontro ninguna consulta.
 */
public class NoHayConsultaException extends Exception{
	/**
	 * Constructor con un parametro para setear la excepci�n.
	 * <br>
	 * @param message: parametro de tipo String que representa el mensaje de la excepci�n.
	 */
	public NoHayConsultaException(String message) {
		super(message);
	}
}
