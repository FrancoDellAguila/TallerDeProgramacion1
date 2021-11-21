package infraestructura;

public abstract class Habitacion {
//aplicar Factory para las habitaciones
	
	//Atributos
	private int nroHabitacion, cantDias;//VERIFICAR nroHabitacion
    /**
     * @aggregation shared
     */
	private double costoAsignacion;//El de cada habitacion particular

	
	//Constructores
	/**Constructor de Habitacion
	 * <b> Pre: cantdias debe ser positivo.</b>
	 * @param nroHabitacion: Parametro de tipo entero.
	 * @param cantdias: Parametro de tipo entero.
	 * @param costoAsignacion: Parametro de tipo double
	 */
	public Habitacion(int nroHabitacion,int cantdias,double costoAsignacion) {
		super();
		this.nroHabitacion = nroHabitacion;
		this.cantDias = cantdias;
		this.costoAsignacion = costoAsignacion;
	}

	//Metodos
	/**Se devuelve el costo de la habitacion
	 * <b> Pre: cantdias debe ser positivo.</b>
	 * @param cantdias: Parametro de tipo entero.
	 */
	public abstract double costoDeHabitacion(int cantDias);
	
	public int getNroHabitacion() {
		return nroHabitacion;
	}
	public int getCantDias() {
		return cantDias;
	}

	public double getCostoAsignacion() {
		return costoAsignacion;
	}

	@Override
	public String toString() {
		return "Habitacion nroHabitaci=" + nroHabitacion;
	}
	
	
}
