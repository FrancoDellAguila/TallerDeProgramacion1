package modelo;

import java.io.Serializable;

/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase abstracta que representa una habitacion
 */
public abstract class Habitacion implements Serializable{
	
	protected static double costoAsignacion;
	private String numeroHabitacion;
	/**
	 * Constructor con un parametro para setear la habitacion<br>
	 * <b> Pre: </b> El parámetro numeroHabitacion debe ser un número entero positivo.
	 * @param numeroHabitacion: parametro de tipo int que representa el numero de la habitacion. 
	 * 
	 */
	public Habitacion(String numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public static void setCostoAsignacion(double costo) {
			Habitacion.costoAsignacion = costo;
	}
	
	public static double getCostoasignacion() {
		return costoAsignacion;
	}

	public String getNumeroHabitacion() {
		return numeroHabitacion;
	}
	
	public abstract double getCostoHabitacion();
	
	public abstract double getCosto(int dias);
	
	
}
