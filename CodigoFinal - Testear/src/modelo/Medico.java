package modelo;

import decorators.IMedico;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase que representa a los medicos se extiende de la clase Persona e implementa la interfaz Imedico
 */
public class Medico extends Persona implements IMedico{
	
	private long nroMatricula;
	private static double honorarioBase;

	/**
	 * Constructor con siete parametros para setear el medico
	 * <br>
	 * @param dni: parametro de tipo String que representa el dni del medico 
	 * @param nombre: parametro de tipo String que representa el nombre del medico 
	 * @param apellido: parametro de tipo String que representa el apellido del medico
	 * @param domicilio: parametro de tipo String que representa la domicilio donde reside el medico
	 * @param ciudad: parametro de tipo String que representa la ciudad donde reside el medico
	 * @param telefono: parametro de tipo String que representa el telefono del medico
	 * @param nroMatricula: parametro de tipo long que representa el numero de Matricula del medico

	 */
	public Medico(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono,long nroMatricula) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono);
		this.nroMatricula = nroMatricula;
	}

	public static void setHonorarioBase(double h) {
		Medico.honorarioBase = h;
	}
	
	@Override
	public long getNroMatricula() {
		return nroMatricula;
	}

	@Override
	public double getHonorario() {
		return honorarioBase;
	}

	@Override
	public String toString() {
		return "Medico [nroMatricula= " + nroMatricula + ", Dni= " + getDni() + ", Nombre= " + getNombre()
				+ ", Apellido= " + getApellido() + ", Domicilio= " + getDomicilio() + ", Ciudad= "
				+ getCiudad() + ", Telefono= " + getTelefono() + "]";
	}
}
