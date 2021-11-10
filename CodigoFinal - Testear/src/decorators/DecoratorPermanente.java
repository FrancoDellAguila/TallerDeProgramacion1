package decorators;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase decoradora que representa la contrataci�n permanente
 */
public class DecoratorPermanente extends DecoratorMedico {
	/**
	 * Constructor con un parametro para setear el medico a decorar
	 * <br>
	 * @param encapsulado : parametro de tipo IMedico que representa el medico a decorar
	 */
	public DecoratorPermanente(IMedico encapsulado) {
		super(encapsulado);

	}
	/**
	 * Devuelve el honorario del m�dico con un aumento del 10% por su contrataci�n permanente
	 * @return el honorario del medico m�s el 10% 
	 */
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() * 1.1;
	}
	
}
