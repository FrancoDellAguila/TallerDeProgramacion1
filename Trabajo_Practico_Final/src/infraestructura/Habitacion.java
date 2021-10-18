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
	public Habitacion(int nroHabitacion,int cantdias,double costoAsignacion) {
		super();
		this.nroHabitacion = nroHabitacion;
		this.cantDias=cantdias;
		this.costoAsignacion=costoAsignacion;
	}

	//Metodos
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
