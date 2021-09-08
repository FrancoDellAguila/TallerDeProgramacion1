
public class UI {

	private Negocio negocio;
	private boolean existe;

	private UI() {
		super();
		this.negocio= new Negocio();
	}
	
	/**
	 * <b>POST:<\b> si no se encontro el legajo llega un false el cual es informado a traves del metodo mostrarMensaje.
	 * @param legajo numero de legajo a pedir el certificado
	 */
	public void pedirCertificado(int legajo) {
		this.existe=this.negocio.pedirCertificado(legajo);
		if(this.existe==false) {
			this.mostrarEstado("legajo No existe");
		}
	}
	
	/**
	 * @param mensaje: mensaje que se  tiene  que mostrar por pantalla
	 */
	public void mostrarEstado(String mensaje) {
		System.out.println(mensaje);
	}
	
	/**
	 * <b>PRE:<\b> el legajo debe existir.
	 * 
	 */
	public void MostrarCertificado() {
		if(this.existe) {
			System.out.println(this.negocio.traerApellidoyNombre()+"\n");
			System.out.println(this.negocio.traerEstados("fisica")+": "+this.negocio.traerNota("fisica")+"\n");
			System.out.println(this.negocio.traerEstados("historia")+": "+this.negocio.traerNota("historia")+"\n");
			System.out.println(this.negocio.traerEstados("literatura")+": "+this.negocio.traerNota("literatura")+"\n");
			System.out.println(this.negocio.traerEstados("matematica")+": "+this.negocio.traerNota("matematica")+"\n");
			System.out.println("condicion: "+ this.negocio.traerCondicion());
			}
		}
}
