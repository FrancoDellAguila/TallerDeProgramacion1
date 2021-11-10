package modelo;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase representa una habitacion de terapia intensiva, extiende de habitacion.
 */
public class TerapiaIntensiva extends Habitacion {

	private static double costoTerapiaIntensiva = 0;
	/**
	 * Constructor con un parametro para setear la habitacion de terapia intensiva.
	 * <br>
	 * @param numeroHabitacion: parametro de tipo int que representa el numero de la habitacion. 
	 * 
	 */
	public TerapiaIntensiva(String numeroHabitacion) {
		super(numeroHabitacion);
	}
	
	public static void setCostoTerapiaIntensiva(double costo) {
		TerapiaIntensiva.costoTerapiaIntensiva = costo;
	}
	
	@Override
	public double getCostoHabitacion() {
		return costoTerapiaIntensiva;
	}
	/**
	 * Modulo que devuelve el costo de una habitacion de terapia intensiva segun los dias m�s el costo de asginaci�n.
	 * <br>
	 * <b> Pre: </b> El par�metro dias debe ser positivo.
	 * @param dias: parametro de tipo int que representa los dias que estuvo el paciente. 
	 * @return devuelve costo de la habitacion compartida elevado por la cantidad de dias m�s el costo de asiganci�n.
	 * 
	 */	
	@Override
	public double getCosto(int dias) {
		return Habitacion.costoAsignacion + Math.pow(costoTerapiaIntensiva, dias);
	}

}
