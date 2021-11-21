package modelo;

import java.io.Serializable;

public abstract class DecoratorPosgrado implements IMedico, Serializable {
protected IMedico encapsulado;

	//Constructores
	/**Constructor de Medico Posgrado
	 * <b> Pre: encapsulado debe ser distinto de null.</b>
	 * @param encapsulado: Parametro de tipo IMedico.
	 */
	public DecoratorPosgrado(IMedico encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}

	//Metodos
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario();
	}
	@Override
	public String getMatricula() {
		return this.encapsulado.getMatricula();
	}
	@Override
	public String getEspecialidad() {
		return this.encapsulado.getEspecialidad();
	}

}
