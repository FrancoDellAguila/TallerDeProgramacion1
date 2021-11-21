package infraestructura;

public class TerapiaIntensiva extends Habitacion {

	//Atributos
	private static double costoExtra=600;
	
	//Constructores
	/**Constructor de HabitacionCompartida
	 * <b> Pre: cantdias debe ser positivo.</b>
	 * @param nroHabitacion: Parametro de tipo entero.
	 * @param cantdias: Parametro de tipo entero.
	 * @param costoAsignacion: Parametro de tipo double.
	 */
	public TerapiaIntensiva(int nroHabitacion,int cantDias,double costoAsignacion) {
		super(nroHabitacion, cantDias,costoAsignacion);
	}

	//Metodos
	/**Se devuelve el costo de la habitacion
	 * <b> Pre: cantdias debe ser positivo.</b>
	 * @param cantdias: Parametro de tipo entero.
	 */
	@Override
	public double costoDeHabitacion(int cantDias) {
		return Math.pow(TerapiaIntensiva.costoExtra, cantDias) +this.getCostoAsignacion();
	}

	
	@Override
	public String toString() {
		return "Terapia Intensiva";
	}

}
