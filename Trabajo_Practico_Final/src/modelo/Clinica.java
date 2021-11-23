package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import personas.Paciente;

import infraestructura.SalaDeEspera;
import infraestructura.Factura;
import infraestructura.Prestacion;



/**
 * 
 *<br>
 * Clase que representa una clinica. Contiene la totalidad de los pacientes. Tambien contine un patio, una sala de espera y una lista de facturas correspondientes a los pacientes.
 *
 */
public class Clinica {

	//Atributos
	private static Clinica instance = null;  // aplico patron singleton

    /**
     * @aggregation composite
     */
    private SalaDeEspera salaEspera = new SalaDeEspera();

    /**
     * @aggregation composite
     */
    private ArrayList<Paciente> patio= new ArrayList<Paciente>();

    /**
     * @aggregation composite
     */
    private Queue<Paciente> listaEspera= new LinkedList<Paciente>();

    /**
     * @aggregation composite
     */
    private Queue<Paciente> listaAtencion= new LinkedList<Paciente>();

    /**
     * @aggregation composite
     */
    private ArrayList<Factura> facturas= new ArrayList<>();

    /**
     * @aggregation composite
     */
    private BDdePacientes pacientes = new BDdePacientes();
    private BDdeMedicos medicos = new BDdeMedicos();
	private int nroOrden=0;
	
	
	//Constructores
	/**Constructor de Clinica, se aplica Singleton
	 */
	private Clinica() {}
	
	public static Clinica getInstance() {
		if(Clinica.instance==null) {
			Clinica.instance=new Clinica();		
		}
		return instance;
	}
	
	//Metodos
	
	/**Da de alta a un paciente si no esta dentro de la Base de Datos de la clinica, luego lo deriva al patio o sala de espera de acuerdo a su prioridad.<br>
	 * <b> Pre: El parametro paciente debe ser distinto de null</b>
	 * <b> Post : Se  ingresa el paciente a la clinica. </b>
	 * @param paciente : Parametro de tipo paciente que ingresa a la clinica.
	 */
	public void ingresoPaciente(Paciente paciente) {
		// busca en la lista pacientes y chequea si ya existe para ver si lo agrega 
		
	       if(!this.pacientes.buscarPaciente(paciente)) //this.pacientes.buscarPaciente(paciente)!=true
	    	   this.pacientes.altaDePaciente(paciente);	
	       this.derivarPaciente(paciente);
	}
	
	/**Deriva al paciente a el patio o sala de espera de acuerdo a su prioridad
	 * <b> Pre: El parametro paciente debe ser distinto de null.</b>
	 * <b> Post: Se agrega al paciente al patio o sala de espera segun corresponda.</b>
	 * @param paciente: Parametro de tipo paciente, que es derivado.
	 */
	public void derivarPaciente(Paciente paciente) {
		nroOrden++;
		paciente.setNroOrden(nroOrden);
		this.listaEspera.add(paciente);
		
		if(this.salaEspera.isOcupada()) {
			if(!this.salaEspera.getPaciente().prioridad(paciente)) {//si cumple, entonces entra this.salaEspera.paciente.prioridad(paciente)==false
				this.patio.add(this.salaEspera.getPaciente());
				this.salaEspera.ocupaSalaDeEspera(paciente);
			}
			else
				this.patio.add(paciente);
		}
		else 
			this.salaEspera.ocupaSalaDeEspera(paciente);	
	}
	
	/**Se quita a los pacientes del patio o sala de espera, y los introduce dentro de la lista de atencion.
	 * <b> Pre: El parametro paciente debe ser distinto de null.</b>
	 * <b> Post: Se agrega al paciente a la lista de atencion</b>
	 * @param paciente: Parametro de tipo paciente, que es atendido.
	 */
	public void atenderPaciente(Paciente paciente){
		
		this.listaEspera.remove(paciente);
        
        if(this.patio.contains(paciente)) // si esta en el patio lo elimino
            this.patio.remove(paciente);
        else                                   // esta en la sala privada
            this.salaEspera.desocupar();
        
        this.listaAtencion.add(paciente);                
    }
	
	/**Se toma al primer paciente de la lista de atencion, y se le confecciona la factura correspondiente. Luego , esa factura es mostrada.
	 * <b> Pre: El parametro paciente y factura debe ser distinto de null.</b>
	 * <b> Post: Se elimina al paciente de la lista de atencion y se muestra su factura.</b>
	 * @param paciente: Parametro de tipo paciente.
	 * @param factura: Parametro de tipo factura.
	 */
	public void egreso(Paciente paciente,Factura factura) {
		if(this.listaAtencion.contains(paciente)) {
			this.listaAtencion.remove(paciente);
			System.out.println(factura.toString());
			System.out.println("Nombre        Valor       Cantidad      Subtotal");
			factura.muestraFactura();
			this.facturas.add(factura);
		}
	}
	
	/**Se realiza un reporte de los pacientes atendidos, dentro de un periodo de fechas determinado.
	 * <b> Pre: El parametro medico, fecha1 y fecha2 debe ser distinto de null.</b>
	 * <b> Post:Se muestra el reporte de pacientes del medico introducido.</b>
	 * @param medico:Parametro de tipo medico.
	 * @param fecha1: Parametro de tipo GregorianCalendar.
	 * @param fecha2  Parametro de tipo GregorianCalendar.
	 */
	public void reporteMedico(IMedico medico, GregorianCalendar fecha1,GregorianCalendar fecha2) {
		 double importeTotal = 0;
          Iterator<Factura> it = this.facturas.iterator();
		  
		   while(it.hasNext()) {
			Factura actual = it.next(); // nodo de la lista
		    Iterator<Prestacion> prestaciones = actual.getPrestaciones().iterator();  // sublista
		    while(prestaciones.hasNext()) {
		    	Prestacion prestacionActual = prestaciones.next(); // nodo de sublista
		    	if(actual.getFecha().compareTo(fecha1)>=0 && actual.getFecha().compareTo(fecha2)<=0 && prestacionActual.getPrestacion().equals(medico.getNombre()+" "+medico.getMatricula())) {
		    		System.out.println("Paciente: "+actual.getPaciente().getNombre()+" "+ actual.getPaciente().getApellido()+" -Cantidad: "+prestacionActual.getCantidad()+" -Subtotal: "+prestacionActual.getSubtotal());
		    		importeTotal+=prestacionActual.getSubtotal();
		    	}	
		    }			
		   }
		   System.out.println("Importe Total: "+importeTotal);
	}
	public SalaDeEspera getSalaEspera() {
		return salaEspera;
	}
	public ArrayList<Paciente> getPatio() {
		return patio;
	}
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	public BDdePacientes getPacientes() {
		return pacientes;
	}
	public void setPacientes(BDdePacientes pacientes) {
		this.pacientes = pacientes;
	}
	public BDdeMedicos getMedicos() {
		return medicos;
	}
	public void setMedicos(BDdeMedicos medicos) {
		this.medicos = medicos;
	}
	
	/**cálculo de un importe adicional a la facturación
	 * <b> Pre:los parámetros deben ser distinto de null.</b>
	 * <b> Pre:el formato de fecha ya está validado.</b>
	 * <b> Pre:numeroDeFactura es > 0.</b>
	 * <b> Pre:La listaDeInsumos puede ser null, vacía o con elementos.</b>
	 * @param Pre:numeroDeFactura: Parametro de tipo entero.
	 * @param fechaDeSolicitud: Parametro de tipo Date.
	 * @param listaDeInsumos: Parametro de tipo arrayList de double.
	 */
	
	@SuppressWarnings("deprecation")
	public double calculoImporteAdicionales(int numeroDeFactura, Date fechaDeSolicitud, ArrayList<Double> listaDeInsumos) {
		double A=0.6, B=0.3,C=1.4,D=0.8;
		double importeParcial=0,SubTotalImpar=0,suma=0,importeTotal=0;
		Random random = new Random();
		int aleatorio = random.nextInt(30)+1,resta=0,aux=1;
		boolean encontro=false;
		Prestacion prestActual;
		Factura facturaActual = null;
        
		Iterator<Factura> it = this.facturas.iterator();
		while(it.hasNext() && encontro == false) {
			facturaActual = it.next();
			if (facturaActual.getNroFactura() == numeroDeFactura)
				encontro = true;
		}
		
		Date fechaFactura = facturaActual.getFecha().getTime();
		if (fechaDeSolicitud.getYear() == fechaFactura.getYear()) {
			if (fechaDeSolicitud.getMonth() == fechaFactura.getMonth()) {
				resta = fechaDeSolicitud.getDay() - fechaFactura.getDay();
				resta = Math.abs(resta);
			}else {
				if (Math.abs(fechaDeSolicitud.getMonth() - fechaFactura.getMonth()) == 1) {
					resta = 31-fechaDeSolicitud.getDay()-fechaFactura.getDay();
					resta = Math.abs(resta);
				}else
					resta = 10;
			}
		}else {
			if(Math.abs(fechaDeSolicitud.getYear() - fechaFactura.getYear()) == 11) {
				resta = 31-fechaDeSolicitud.getDay()-fechaFactura.getDay();
				resta = Math.abs(resta);
			}else
				resta = 10;
		}
		
		Iterator<Double> itLista = listaDeInsumos.iterator();
		while (itLista.hasNext()) {
			suma += itLista.next();
		}
			
		Iterator<Prestacion> itPrest = facturaActual.getPrestaciones().iterator();
		while(itPrest.hasNext()) {
			prestActual=itPrest.next();
			if (aux%2 == 1) {
				SubTotalImpar += prestActual.getValor();
			}
		}
		
		if(encontro) {
			if(resta < 10) {
				importeParcial = facturaActual.getImporteTotal() - (SubTotalImpar * A);
			}else {
				importeParcial = facturaActual.getImporteTotal() * B;
			}
			if(facturaActual.getPaciente().getRangoEtario().equals("Mayor")) {
				importeTotal = importeParcial * C;
			}else {
				importeTotal = importeParcial * D;
			}
			if(aleatorio == fechaFactura.getDay()) {
				return importeTotal;
			}else {
				return importeTotal + suma;
			}
		}else {
			return 0;
		}
	}
}