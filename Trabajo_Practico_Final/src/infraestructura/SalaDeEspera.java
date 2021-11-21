package infraestructura;

import personas.Paciente;

public class SalaDeEspera {

	//Atributos
	private boolean ocupada;
    private Paciente paciente;
	
	//Constructores
	/**Constructor de SalaDeEspera con valores establecidos
	 */
	public SalaDeEspera() {
		this.ocupada = false;
		this.paciente=null;
	}
	
	//Metodos
	/**Pregunta si la sala esta ocupada, devuelve true si esta ocupada o false si esta desocupada
	 */
	public boolean isOcupada() {
		return this.ocupada;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	
	/**Se ocupa la sala de espera
	 * <b> Pre: paciente debe ser distinto de null.</b>
	 * @param paciente: Parametro de tipo Paciente.
	 */
	public void ocupaSalaDeEspera(Paciente paciente) {
		this.paciente=paciente;
		this.ocupada=true;
	}
	
	/**Desocupa la sala de espera
	 */
	public void desocupar() {
		this.ocupada = false;
		this.paciente=null;		
	}
	
	
	
}
