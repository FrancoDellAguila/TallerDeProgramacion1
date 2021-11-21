package infraestructura;

public class HabitacionCompartida extends Habitacion {

	private static double costoExtra=200;//PREGUNTAR
	
	//Constructores
	/**Constructor de HabitacionCompartida
	 * <b> Pre: cantdias debe ser positivo.</b>
	 * @param nroHabitacion: Parametro de tipo entero.
	 * @param cantdias: Parametro de tipo entero.
	 * @param costoAsignacion: Parametro de tipo double
	 */
	public HabitacionCompartida(int nroHabitacion,int cantDias,double costoAsignacion) {
		super(nroHabitacion,cantDias,costoAsignacion);
	}

	//Metodos
	@Override
	/**Se devuelve el costo de la habitacion
	 * <b> Pre: cantdias debe ser positivo.</b>
	 * @param cantdias: Parametro de tipo entero.
	 */
	public double costoDeHabitacion(int cantDias) {
		return (this.getCantDias() * HabitacionCompartida.costoExtra)+this.getCostoAsignacion();
	}

	@Override
	public String toString() {
		return "Habitacion Compartida";
	}

}
