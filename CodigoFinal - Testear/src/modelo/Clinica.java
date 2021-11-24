package modelo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import java.util.Iterator;

import decorators.IMedico;
import excepciones.NoEstaPacienteException;
import excepciones.NoHayConsultaException;
import excepciones.OrdenFechasIncorrectoException;
import excepciones.PacienteYaExisteException;

/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase que representa a la cl�nica.
 */

public class Clinica {
    /**
     * @aggregation composite
     */
    private static Clinica instance = null;
	private String nombre;
	private String direccion;
	private String telefono;
	private String ciudad;

    /**
     * @aggregation shared
     */
    private Paciente salaPrivada;
	private HashMap<String,Paciente> patio = new HashMap<String,Paciente>();

    /**
     * @aggregation shared
     */
    private Queue<Paciente> listaEspera = new LinkedList();
	private HashMap<Long,Paciente> listaAtencion = new HashMap<Long,Paciente>();
	private HashMap<String,Habitacion> habitaciones = new HashMap<String,Habitacion>();
	private HashMap<String,Paciente> pacientesRegistrados = new HashMap<String,Paciente>();
	private HashMap<Long,IMedico> medicos = new HashMap<Long,IMedico>();

    /**
     * @aggregation composite
     */
	private TreeSet<Factura> facturas = new TreeSet<>();
	
	DecimalFormat df = new DecimalFormat("#.00");
	
	/**
	 * Constructor para crear la Cl�nica, con valores ya establecidos.
	 */
	
	private Clinica() {
		this.nombre = "Clinica 1";
		this.direccion = "Col�n 2321";
		this.telefono = "223895648";
		this.ciudad = "Mar del Plata";
		this.salaPrivada = null;
	}
	
	/**
	 * Se aplic� Patr�n Singleton.
	 * Se obtiene (o se crea en caso que no est� creada) la instancia a la cl�nica.
	 */
	
	public static Clinica getInstance() {
		if (Clinica.instance == null) {
			Clinica.instance = new Clinica();
		}
		return instance;
	}
	
	
	public Paciente getSalaPrivada() {
		return salaPrivada;
	}

	/**
	 * Agrega un m�dico al Hashmap de m�dicos, con su n�mero de matr�cula como clave.<br>
	 * <b>Pre: </b> El parametro medico debe ser distinto de null.<br>
	 * <b>Post: </b> Se agrega un medico mas al HashMap de m�dicos.<br>
	 * @param medico: Par�metro que ser� agregado al HashMap de m�dicos.
	 */
	
	public void addMedico(IMedico medico) {
		this.medicos.put(medico.getNroMatricula(), medico);
	}
	
	/**
	 * M�dulo de ingreso de un paciente a la cl�nica.<br>
	 * <b>Pre: </b> El parametro paciente debe ser distinto de null<br>
	 * <b>Post: </b> Si el paciente no estaba registrado, se lo registra con su DNI.<br>
	 * Se agrega al paciente a la lista de espera.<br>
	 * Si la sala privada estaba vac�a o si el paciente entrante tiene prioridad sobre el que ya estaba all�, se lo asigna a la sala privada, si no, se lo manda al patio.
	 * @param paciente: Paciente que ingresa a la cl�nica.
	 */
	
	public void addPaciente(Paciente paciente) throws PacienteYaExisteException{
		if (!pacientesRegistrados.containsKey(paciente.getDni()))
			pacientesRegistrados.put(paciente.getDni(), paciente);
	}
	public void Ingreso(Paciente paciente) {
		if (!pacientesRegistrados.containsKey(paciente.getDni()))
			pacientesRegistrados.put(paciente.getDni(), paciente);
		listaEspera.add(paciente);
		if (this.salaPrivada == null || paciente.prioridad(salaPrivada))
			salaPrivada = paciente;
		else
			patio.put(paciente.getDni(), paciente);
	}
	
	/**
	 * M�dulo que retira al paciente de la espera y lo ubica en la Lista de Pacientes en Atenci�n.<br>
	 * <b>Pre: </b> Debe haber al menos un paciente en la lista de espera.
	 * <b>Post: </b> Se retira al siguiente paciente de la lista de espera y se lo pone en atenci�n.
	 */
	
	public void Atencion() {
		Paciente p = listaEspera.poll();
		listaAtencion.put(p.getNroHistoria(), p);
		if (salaPrivada != null && salaPrivada.equals(p))
			salaPrivada = null;
		else
			patio.remove(p.getDni());
	}
	/**
	 * Borra todas las facturas guardadas.<br>
	 */	
	public void borrarFacturas() {
		this.facturas.clear();
	}
		
	/**
	 * Borra la �ltima de las facturas, si tiene.<br>
	 */	
	public void borrarUltimaFactura() {
		this.facturas.pollLast();
	}
	/**
	 * M�dulo que elige un paciente, lo retira de la lista de atenci�n y realiza la facturaci�n correspondiente.<br>
	 * <b>Pre: </b> El parametro paciente debe ser distinto de null.<br>
	 * <b>Post: </b> Se crea una factura, se la agrega a la lista de facturas de la cl�nica y se retira al paciente de la lista de atenci�n.
	 * @param paciente: Paciente que se retira de atenci�n y al cual se le genera la factura.
	 * @param prestaciones: Prestaciones que recibi� el paciente y que figurar�n en la factura.
	 */
	
	public void EgresoYFacturacion(Paciente paciente, HashMap<String, Prestacion> prestaciones) throws NoEstaPacienteException{
		if (listaAtencion.containsKey(paciente.getNroHistoria())) {
			Factura f = new Factura(paciente, prestaciones);
			this.facturas.add(f);
			f.mostrarFactura();
			listaAtencion.remove(paciente.getNroHistoria());
		}
		else
			throw new NoEstaPacienteException("El paciente no se encuentra en la lista de atenci�n.");
	}
	/**
	 * Devuelve �ltima factura si es que no est� vac�o el treeset de facturas, en caso contrario, lanza excepci�n.<br>
	 */	
	public Factura getUltimaFactura() {
		try {
		return this.facturas.last();
		}catch(NoSuchElementException e) {
			return null;
		}
	}
	public HashMap<String, Habitacion> getHabitaciones() {
		return habitaciones;
	}
	/**
	 * Agrega una Factura al Treeset de facturas.<br>
	 * <b>Pre: </b> Par�metro tipo Factura distinto de null.<br>
	 * <b>Post: </b> Se agrega una factura al Treeset de facturas.<br>
	 * @param factura: Par�metro de tipo Factura que representa factura a agregar.
	 */
	public void addFactura(Factura factura) {
		this.facturas.add(factura);
	}
    /**
   	 * Borra un paciente pasado por par�metro.<br>
   	 * <b>Pre: </b> Par�metro distinto de null.<br>
   	 * <b>Post: </b> Se borra un asociado del Hashmap de pacientes.<br>
   	 * @param asociado: Par�metro que indica el asociado que ser� borrado del HashMap de pacientes.
   	 */	
    public void borrarPaciente(Paciente paciente) {
       	if(this.pacientesRegistrados.containsKey(paciente.getDni()))
       		this.pacientesRegistrados.remove(paciente.getDni());
    }
	/**
	 * M�dulo que reporta la actividad de un m�dico entre dos fechas dadas, enumerando los pacientes atendidos.<br>
	 * <b>Pre: </b> Todos los par�metros deben ser distintos de null.<br>
	 * <b>Post: </b> Se muestran las facturas correspondientes al per�odo dado.<br>
	 * @param medico: M�dico del cual se realice el reporte de actividad.
	 * @param fecha1: Fecha desde la cual se solicita el reporte.
	 * @param fecha2: Fecha hasta la cual se solicita el reporte.
	 */
	
	public void ReporteActividadMedica(IMedico medico, Calendar fecha1, Calendar fecha2) throws NoHayConsultaException, OrdenFechasIncorrectoException {
		if (fecha1.compareTo(fecha2) <= 0) {
			Iterator<Factura> itFacturas = facturas.iterator();
			Factura f1 =  null;
			double total = 0;
			
			boolean condicion = true;
			while (itFacturas.hasNext() && condicion) {
				f1 = itFacturas.next();
				if (f1.getFecha().compareTo(fecha1) >= 0) {
					condicion = false;
				}
			}
			condicion = true;
			
			System.out.println("Paciente \t Cantidad de consultas \t Honorario total \t Fecha");
			while (itFacturas.hasNext() && condicion && f1.getFecha().compareTo(fecha2) < 0) {
				if(f1.getPrestaciones().containsKey(medico.getNombre())) {
					System.out.println(f1.getPaciente().getNombre() + " " + f1.getPaciente().getApellido() + " \t\t " + f1.getPrestaciones().get(medico.getNombre()).getCantidad() + " \t\t " + df.format(f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario()) + " \t\t "+ f1.getFecha().get(Calendar.DATE) + "/" + (f1.getFecha().get(Calendar.MONTH)+1) + "/" + f1.getFecha().get(Calendar.YEAR));
					total += f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario();
				}
				f1 = itFacturas.next();
				if (f1.getFecha().compareTo(fecha2) > 0) {
					condicion = false;
				}
			}
			if(f1 != null && f1.getPrestaciones().containsKey(medico.getNombre()) && f1.getFecha().compareTo(fecha2) < 0) {
				System.out.println(f1.getPaciente().getNombre() + " " + f1.getPaciente().getApellido() + " \t\t " + f1.getPrestaciones().get(medico.getNombre()).getCantidad() + " \t\t " + df.format(f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario()) + " \t\t "+ f1.getFecha().get(Calendar.DATE) + "/" + (f1.getFecha().get(Calendar.MONTH)+1) + "/" + f1.getFecha().get(Calendar.YEAR));
				total += f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario();
			}
			if (total != 0)
				System.out.println("Total= " + total);
			else
				throw new NoHayConsultaException("No hay ninguna consulta entre esas fechas.");
		}
		else
			throw new OrdenFechasIncorrectoException("El orden de las fechas ingresadas es incorrecto.");
	}
	/**
	 * M�dulo que reporta la actividad entre dos fechas dadas, enumerando los pacientes atendidos.<br>
	 * <b>Pre: </b> Todos los par�metros deben ser distintos de null.<br>
	 * <b>Post: </b> Se muestran las facturas correspondientes al per�odo dado.<br>
	 * @param fecha1: Fecha desde la cual se solicita el reporte.
	 * @param fecha2: Fecha hasta la cual se solicita el reporte.
	 */
	public String ReporteActividadMedica(Calendar fecha1, Calendar fecha2) throws  OrdenFechasIncorrectoException {
		if (fecha1.compareTo(fecha2) <= 0) {
			Iterator<Factura> itFacturas = facturas.iterator();
			Factura f1 =  null;
			String respuesta = "";
			
			boolean condicion = true;
			while (itFacturas.hasNext() && condicion) {
				f1 = itFacturas.next();
				if (f1.getFecha().compareTo(fecha1) >= 0) {
					condicion = false;
				}
			}
			condicion = true;
			
			while (itFacturas.hasNext() && condicion && f1.getFecha().compareTo(fecha2) < 0) {
				
					respuesta += f1.mostrarFactura() +"\n";
					

				f1 = itFacturas.next();
				if (f1.getFecha().compareTo(fecha2) > 0) {
					condicion = false;
				}
			}
			if(f1 != null &&f1.getFecha().compareTo(fecha1) >= 0 && f1.getFecha().compareTo(fecha2) < 0) {
				
				respuesta += f1.mostrarFactura() +"\n";
			}
			return respuesta;
		}
		else
			throw new OrdenFechasIncorrectoException("El orden de las fechas ingresadas es incorrecto.");
	}
	


	/**
	 * Devuelve el importe adicional que se le va a cobrar al paciente
	 * <b> Pre: </b> numeroDeFactura > 0
	 * fechaDeSolicitud != null y valido<br>
     * <b> Post: </b> Devuelve el importe adicional a partir de la existencia de la factura, rango etario y la lista de insumos.<br>
	 * <br>
	 * @param numeroDeFactura: numero de factura de la que se va a calcular el importe.
	 * @param fechaDeSolicitud: fecha de solicitud.
	 * @param listaDeInsumos: lista de double con los costes de los insumos utilizados.
	 * */
	public double calculoImporteAdicionales(int numeroDeFactura, Calendar fechaDeSolicitud, ArrayList<Double> listaDeInsumos)
	{
		double importeTotal = 0, importeParcial = 0;
		double A = 0.7 /*Menor a 1*/, B = 0.5/*Menor a 1 y menor a A*/, C = 1.2 /*Entre 1 y 2*/, D = 0.2 /*Menor a 1 y mayor a A*/; 
		Factura factura = null;
				
		Iterator<Factura> it;
		Iterator<Double> itDouble;
		
		it = facturas.iterator();
		while (it.hasNext() && factura == null) {
			factura = it.next();
			if (factura.getNroFactura() != numeroDeFactura)
			{
				factura = null;
			}
		}
		
		if (factura != null)
		{
			if (ChronoUnit.DAYS.between(fechaDeSolicitud.toInstant(), factura.getFecha().toInstant()) < 10)
			{
				importeParcial = factura.getTotal() - (factura.calcularSubTotalImpar() * A);
			}
			else
			{
				importeParcial = factura.getTotal() * B;
			}
			
			if (factura.getPaciente().esMayor())
			{
				importeTotal = importeParcial * C;
			}
			else
			{
				importeTotal = importeParcial * D;
			}
			if (listaDeInsumos != null && Math.random() * 30 + 1 != factura.getFecha().get(Calendar.DAY_OF_MONTH))
			{
				itDouble = listaDeInsumos.iterator();
				while (itDouble.hasNext()) {
					importeTotal += itDouble.next();
				}
			}
		}
		return importeTotal;
	}

	public HashMap<String, Paciente> getPacientesRegistrados() {
		return pacientesRegistrados;
	}
	public HashMap<Long, IMedico> getMedicos() {
		return medicos;
	}

	public TreeSet<Factura> getFacturas() {
		return facturas;
	}
	public Paciente getPaciente(String dni) {
    	return this.pacientesRegistrados.get(dni);
    }
	public void setPacientesRegistrados(HashMap<String, Paciente> pacientesRegistrados) {
		this.pacientesRegistrados = pacientesRegistrados;
	}

	public void setMedicos(HashMap<Long, IMedico> medicos) {
		this.medicos = medicos;
	}

	public void setFacturas(TreeSet<Factura> facturas) {
		this.facturas = facturas;
	}

	public void borrarMedico(IMedico medico) {
		if(this.medicos.containsKey(medico.getNroMatricula()))
       		this.medicos.remove(medico.getNroMatricula());
		
	}

	public void addHabitacion(Habitacion h1) {
		this.habitaciones.put(h1.getNumeroHabitacion(), h1);
		
	}


	
}