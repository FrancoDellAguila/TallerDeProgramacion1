package modelo;

import java.util.GregorianCalendar;

import personas.Paciente;

public class DecoratorTemporario extends DecoratorContratacion{

	//Construcores
	/**Constructor de Medico Temporario
	 * <b> Pre: encapsulado debe ser distinto de null.</b>
	 * @param encapsulado: Parametro de tipo IMedico.
	 */
	public DecoratorTemporario(IMedico encapsulado) {
		super(encapsulado);
	}
	
	//Metodos
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario()*1.05;
	}
	@Override
	public String getMatricula() {
		return this.encapsulado.getMatricula();
	}
	@Override
	public String getEspecialidad() {
		return this.encapsulado.getEspecialidad();
	}

	@Override
	public String getNombre() {
		return this.encapsulado.getNombre();
	}

	@Override
	public String toString() {
		return this.encapsulado.toString()+" Contratacion Temporario";
	}

	
}