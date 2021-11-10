package modelo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase que representa una factura realizada a un paciente ya atendido. Implementa Comparable y Serializable.
 */
public class Factura implements Comparable , Serializable{

	private static int siguienteNumero = 0;
	private int nroFactura;
	private Calendar fecha = new GregorianCalendar();
	DecimalFormat df = new DecimalFormat("#.00");
    /**
     * @aggregation shared
     */
    private Paciente paciente;
	private HashMap<String, Prestacion> prestaciones = new HashMap<String, Prestacion>();
	private double total;
	
	/**
     * Constructor con dos parametros para setear el paciente al que se le adjudica la factura y su lista de prestaciones.<br>
     * <b> Pre: </b> El par�metro paciente debe ser distinto de null.<br>
     * <b> Post: </b> el atributo est�tico siguienteNumero se incrementa en 1.<br>
     * @param paciente : par�metro de tipo Paciente que representa al paciente al que se le realiza la facturaci�n.
     * @param prestaciones : par�metro de tipo HashMap que representa un listado de las prestaciones pertenecientes al paciente.
     */
	public Factura(Paciente paciente, HashMap<String, Prestacion> prestaciones) {
		Factura.siguienteNumero++;
		this.nroFactura = Factura.siguienteNumero;
		this.fecha = fecha.getInstance();
		this.paciente = paciente;
		this.prestaciones = prestaciones;
		this.calculaTotal();
	}
	
	
	/**
     * Constructor con un parametro para setear el paciente al que se le adjudica la factura.<br>
     * <b> Pre: </b> El par�metro paciente debe ser distinto de null.<br>
     * <b> Post: </b> el atributo est�tico siguienteNumero se incrementa en 1.<br>
     * @param paciente : par�metro de tipo Paciente que representa al paciente al que se le realiza la facturaci�n.
     */
	public Factura(Paciente paciente) {
		Factura.siguienteNumero++;
		this.nroFactura = Factura.siguienteNumero;
		this.fecha = fecha.getInstance();
		this.paciente = paciente;
		this.total=0;
		
	}

	
	/**
	 * M�todo para agregar una nueva prestaci�n a la factura.
	 * <b> Pre: </b> El par�metro prestacion debe ser distinto de null.
	 * El par�metro key no debe ser un String vac�o<br>
     * <b> Post: </b> el atributo est�tico siguienteNumero se incrementa en 1.<br>
	 * <br>
	 * @param key: parametro de tipo String que representa el n�mero de habitaci�n o el nombre del m�dico.
	 * @param prestacion: parametro de tipo Prestacion que representa la prestaci�n que se agregar�.
	 * */
	public void addPrestacion(String key,Prestacion prestacion) {
		
		this.prestaciones.put(key, prestacion);
	}
	
	
	public int getNroFactura() {
		return nroFactura;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public double getTotal() {
		return this.total;
	}
	
	public HashMap<String, Prestacion> getPrestaciones() {
		return prestaciones;
	}

	/**
     *Se calcula el total a abonar por las prestaciones tomadas.<br>
     *<b>Post: </b> Se guarda en la variable total la suma de los subtotales de cada prestaci�n. <br>
     *@param prestaciones : par�metro de tipo HashMap que representa un listado de las prestaciones efectuadas por el paciente.
     */
	public void calculaTotal() {
		this.total = 0;
		for (Prestacion p : this.prestaciones.values()) {
			this.total += p.getSubtotal();
		}
	}
	
	/**
     *Se compara la factura actual con otra por su fecha y, en el caso de que coincidan, por su n�mero de factura.<br>
     *@param o : par�metro de tipo Object que representa un objeto que ser� casteado para su comparaci�n.
     *@return int con el valor que determina el resultado de la comparaci�n.
     */
	@Override
	public int compareTo(Object o) {
		Factura f = (Factura) o;
		if(this.fecha.compareTo(f.getFecha()) > 0) {
			return 1;
		}
		else if (this.fecha.compareTo(f.getFecha()) < 0){
			return -1;
		}
		else {
			return (f.getNroFactura() - this.nroFactura);
		}
	}
	
	/**
     *Se imprime la factura mostrando en cada l�nea: tipo, valor, cantidad y subtotal de cada prestaci�n.
     */
	public String mostrarFactura() {
		
		String respuesta;
		
		respuesta=("Factura:" +this.paciente.getNombre()+" "+this.paciente.getApellido() +this.getFecha().get(Calendar.DATE)+"/"+(this.getFecha().get(Calendar.MONTH)+1)+"/"+this.getFecha().get(Calendar.YEAR)+"\n"+ "prestacion \t valor \t cantidad \t subtotal\n\n");
		for (Prestacion p : prestaciones.values()) {
			respuesta += (p+"\n");
		}
		if(this.total>0)
			respuesta += ("\t\t TOTAL:  " + df.format(this.total) + "\n");
		
		return respuesta;
	}

	public static int getSiguienteNumero() {
		return siguienteNumero;
	}

	public static void setSiguienteNumero(int siguienteNumero) {
		Factura.siguienteNumero = siguienteNumero;
	}

	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setPrestaciones(HashMap<String, Prestacion> prestaciones) {
		this.prestaciones = prestaciones;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Factura [nroFactura=" + nroFactura + ", fecha=" + fecha + ", paciente=" + paciente + ", prestaciones="
				+ prestaciones + ", total=" + total + "]";
	}
	
}
