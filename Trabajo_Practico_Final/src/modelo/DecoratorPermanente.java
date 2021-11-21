package modelo;

import java.util.GregorianCalendar;

import personas.Paciente;

public class DecoratorPermanente extends DecoratorContratacion {

	//Constructores
	/**Constructor de Medico Permanente
	 * <b> Pre: encapsulado debe ser distinto de null.</b>
	 * @param encapsulado: Parametro de tipo IMedico.
	 */
	public DecoratorPermanente(IMedico encapsulado) {
		super(encapsulado);
	}

	//Metodos
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario()*1.1;
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
		// TODO Auto-generated method stub
		return this.encapsulado.getNombre();
	}
	
	@Override
	public String toString() {
		return this.encapsulado.toString()+" Contratacion Permanente";
	}


	
}
