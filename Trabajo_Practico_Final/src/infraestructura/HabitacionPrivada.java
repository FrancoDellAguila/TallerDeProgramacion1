package infraestructura;

public class HabitacionPrivada extends Habitacion {

	//Atributos
	private static double costoExtra=100;
	
	//Constructores
	/**Constructor de HabitacionPrivada
	 * <b> Pre: cantDias debe ser positivo.</b>
	 * @param nroHabitacion: Parametro de tipo entero.
	 * @param cantdias: Parametro de tipo entero.
	 * @param costoAsignacion: Parametro de tipo double
	 */
	public HabitacionPrivada(int nroHabitacion,int cantDias,double costoAsignacion) {
		super(nroHabitacion,cantDias,costoAsignacion);
	}

	//Metodos
	/**Se devuelve el costo de la habitacion
	 * <b> Pre: cantdias debe ser positivo.</b>
	 * @param cantdias: Parametro de tipo entero.
	 */
	@Override
	public double costoDeHabitacion(int cantDias) {
		double auxiliar=0;
		if(cantDias == 1)
			auxiliar = HabitacionPrivada.costoExtra;
		else
			if(cantDias>=2 && cantDias<=5)
				auxiliar = HabitacionPrivada.costoExtra*1.3;
			else
				if(cantDias>=6)
					auxiliar = HabitacionPrivada.costoExtra*2;
		return auxiliar + this.getCostoAsignacion();
	}

	@Override
	public String toString() {
		return "Habitacion Privada";
	}

}
