package modelo;

import java.util.GregorianCalendar;

import personas.Paciente;

public class DecoratorMagister extends DecoratorPosgrado {

	//Constructores
	/**Constructor de Medico Magister
	 * <b> Pre: encapsulado debe ser distinto de null.</b>
	 * @param encapsulado: Parametro de tipo IMedico.
	 */
	public DecoratorMagister(IMedico encapsulado) {
		super(encapsulado);
	}

	//Metodos
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario()*1.05;
	}
	@Override
	public String getEspecialidad() {
		return super.getEspecialidad();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.encapsulado.getNombre();
	}

	@Override
	public String toString() {
		return this.encapsulado.toString()+" Magister";
	}

	
}
