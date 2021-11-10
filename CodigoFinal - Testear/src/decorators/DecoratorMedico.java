package decorators;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Se utiliza el Patrón Decorator.
 *Clase abstacta padre de todos los decoradores de medico
 */

import java.io.Serializable;

public abstract class DecoratorMedico implements IMedico ,Serializable{

    /**
     * @aggregation shared
     */
    protected IMedico encapsulado;
	/**
	 * Constructor con un parametro para setear el medico a decorar
	 * <br>
	 * @param encapsulado : parametro de tipo IMedico que representa el medico a decorar
	 */
	public DecoratorMedico(IMedico encapsulado) {
		this.encapsulado = encapsulado;
	}
	
	@Override
	public long getNroMatricula() {
		return this.encapsulado.getNroMatricula();
	}
	
	@Override
	public String getNombre() {
		return this.encapsulado.getNombre();
	}

	@Override
	public String toString() {
		return encapsulado.toString();
	}
	
}
