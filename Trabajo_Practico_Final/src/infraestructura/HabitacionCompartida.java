package infraestructura;

public class HabitacionCompartida extends Habitacion {

	private static double costoExtra=200;//PREGUNTAR
	
	//Constructores
	public HabitacionCompartida(int nroHabitacion,int cantDias,double costoAsignacion) {
		super(nroHabitacion,cantDias,costoAsignacion);
		
	}

	//Metodos
	@Override
	public double costoDeHabitacion(int cantDias) {
		return (this.getCantDias() * HabitacionCompartida.costoExtra)+this.getCostoAsignacion();
	}

	@Override
	public String toString() {
		return "Habitacion Compartida";
	}

}
