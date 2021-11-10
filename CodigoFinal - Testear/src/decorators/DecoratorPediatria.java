package decorators;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase decoradora que representa la especialidad en pediatria
 */
public class DecoratorPediatria extends DecoratorMedico {
	
	/**
	 * Constructor con un parametro para setear el medico a decorar
	 * <br>
	 * @param encapsulado : parametro de tipo IMedico que representa el medico a decorar
	 */
	public DecoratorPediatria(IMedico encapsulado)
	{
		super(encapsulado);
	}
	/**
	 * Devuelve el honorario del m�dico con un aumento del 7% por su especialidad en pediatria
	 * @return el honorario del medico m�s el 7% 
	 */
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() *1.07;
	}
}
