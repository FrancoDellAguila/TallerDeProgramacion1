package modelo;

import java.io.Serializable;

public abstract class DecoratorContratacion implements IMedico, Serializable {
protected IMedico encapsulado;

	//Constructores
	/**Constructor de contratacion
	 * <b> Pre: encapsulado debe ser distinto de null.</b>
	 * @param encapsulado: Parametro de tipo IMedico.
	 */
	public DecoratorContratacion(IMedico encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}

	//Metodos
	@Override
	public String getMatricula() {
		return this.encapsulado.getMatricula();
	}
	@Override
	public String getEspecialidad() {
		return this.encapsulado.getEspecialidad();
	}

}
