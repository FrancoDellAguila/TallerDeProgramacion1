package modelo;

import java.io.Serializable;
import java.util.GregorianCalendar;

import personas.Paciente;

public class DecoratorDoctorado extends DecoratorPosgrado {

	//Constructores
	/**Constructor de Medico Doctorado
	 * <b> Pre: encapsulado debe ser distinto de null.</b>
	 * @param encapsulado: Parametro de tipo IMedico.
	 */
	public DecoratorDoctorado(IMedico encapsulado) {
		super(encapsulado);
	}
	
	//Metodos
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario()*1.1;
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
		return this.encapsulado.toString()+" Doctorado";
	}

	
	
	
}
