package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import decorators.IMedico;
import excepciones.NoEstaPacienteException;
import excepciones.NoHayConsultaException;
import excepciones.OrdenFechasIncorrectoException;
import excepciones.PacienteYaExisteException;
import modelo.Clinica;
import modelo.ConsultaMedica;
import modelo.Factura;
import modelo.Internacion;
import modelo.Medico;
import modelo.Paciente;
import modelo.Prestacion;

public class TestClinicaConDatos {

	Paciente p1;
	IMedico m1;
	HashMap<Long, IMedico> medicos= new HashMap<Long, IMedico>();
	HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
	@Before
	public void setUp() throws Exception {
		p1 = new Paciente("19999999", "aaa", "bbb", "ccc", "ddd", "19999999", 1);
		m1 = new Medico("19999999", "aaa", "bbb", "ccc", "ddd", "19999999", 1);
		medicos.put(m1.getNroMatricula(), m1);
		pacientes.put(p1.getDni(), p1);
		Clinica.getInstance().setMedicos(medicos);;
		Clinica.getInstance().setPacientesRegistrados(pacientes);
	}

	@After
	public void tearDown() throws Exception{
		Clinica.getInstance().borrarPaciente(p1);
	}
	
	@Test 
	public void testAddPacienteExistente() {
		try {
			
			Clinica.getInstance().addPaciente(p1);
			Assert.fail("deberia haber lanzado la excepcion");
		} catch (PacienteYaExisteException e) {
			
		}
		
	}
	
	@Test
	public void testAddPacienteNuevo() {
		try {
			Paciente p2 = new Paciente("29999999", "aaa", "bbb", "ccc", "ddd", "29999999", 1);
			Clinica.getInstance().addPaciente(p2);
			Paciente p3 = Clinica.getInstance().getPaciente("29999999");
			assertEquals(p3, p2);
		} catch (PacienteYaExisteException e) {
			Assert.fail("No deberia haber lanzado la excepcion");
		}
	}

	@Test
	public void testAddMedico() {
		long aux = 2;
		IMedico m2 = new Medico("29999999", "aaa", "bbb", "ccc", "ddd", "19999999", aux);
		Clinica.getInstance().addMedico(m2);
		HashMap<Long, IMedico> h= Clinica.getInstance().getMedicos();
		assertEquals(h.get(aux),m2);
	}
	
	
	@Test 
	public void testIngresoPacienteYaRegistradoVaAPrivada() {
		Clinica.getInstance().Ingreso(p1);
		HashMap<String, Paciente> p = Clinica.getInstance().getPacientesRegistrados();
		assertEquals(p.get(p1.getDni()), p1);
		assertEquals(Clinica.getInstance().getSalaPrivada(), p1);
		
	}
	
	@Test 
	public void testIngresoPacienteNoRegistradoVaAPrivada() {
		Paciente p2 = new Paciente("29999999", "aaa", "bbb", "ccc", "ddd", "29999999", 9);
		Clinica.getInstance().Ingreso(p2);
		HashMap<String, Paciente> p = Clinica.getInstance().getPacientesRegistrados();
		assertEquals(p.get("29999999"), p2);
		assertEquals(Clinica.getInstance().getSalaPrivada(), p2);
	}
	
	@Test 
	public void testAtencion() {
		Paciente p2 = new Paciente("29999999", "aaa", "bbb", "ccc", "ddd", "29999999", 9);
		Clinica.getInstance().Ingreso(p2);
		Clinica.getInstance().Atencion();
		assertNull(Clinica.getInstance().getSalaPrivada());
	}
	
	@Test
	public void testEgresoYFacturacionNoEstaElPaciente() {
		try {
			Clinica.getInstance().EgresoYFacturacion(p1, null);
			Assert.fail();
		} catch (NoEstaPacienteException e) {
			
		}
	}
	
	@Test
	public void testEgresoYFacturacionSiEstaElPaciente() {
		try {
			Internacion pr1 = mock(Internacion.class);
			when(pr1.getSubtotal()).thenReturn(100.0);
			ConsultaMedica pr2 = mock(ConsultaMedica.class);
			when(pr2.getSubtotal()).thenReturn(200.0);
			HashMap<String, Prestacion> prestaciones= new HashMap<String, Prestacion>();
			prestaciones.put("p1", pr1);
			prestaciones.put("p2", pr2);
			Clinica.getInstance().EgresoYFacturacion(p1, prestaciones);
			TreeSet<Factura> f = Clinica.getInstance().getFacturas();
			assertEquals(f.first().getPaciente(),p1); //verifico que la unica factura que se cargo tenga como paciente asignado a p1
			
		} catch (NoEstaPacienteException e) {
			Assert.fail("no deberia haber lanzado la excepcion");
		}
	}
	
	@Test 
	public void testBorrarPaciente() {
		Clinica.getInstance().borrarPaciente(p1);
		HashMap<String, Paciente> pac = Clinica.getInstance().getPacientesRegistrados();
		Assert.assertFalse(pac.containsKey(p1.getDni()));
	}
	
	
	@Test
	public void testReporteActividadMedicaSinMedicoConFechasMal() {
		Calendar fecha1= new GregorianCalendar(2021,10,10);
		Calendar fecha2= new GregorianCalendar(2020,10,10);
		try {
			Clinica.getInstance().ReporteActividadMedica(fecha1, fecha2);
			Assert.fail();
		} catch (OrdenFechasIncorrectoException e) {
			
		}
	}
	
	@Test
	public void testReporteActividadMedicaConMedicoConFechasMal() {
		Calendar fecha1= new GregorianCalendar(2021,10,10);
		Calendar fecha2= new GregorianCalendar(2020,10,10);
		try {
			Clinica.getInstance().ReporteActividadMedica(m1, fecha1, fecha2);
			Assert.fail();
		} catch (OrdenFechasIncorrectoException e) {
			
		} catch (NoHayConsultaException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testReporteActividadMedicoConMedicoSinConsultas(){
		Calendar fecha1= new GregorianCalendar(2020,10,10);
		Calendar fecha2= new GregorianCalendar(2021,10,10);
		try {
			Clinica.getInstance().ReporteActividadMedica(m1, fecha1, fecha2);
			Assert.fail();
		} catch (OrdenFechasIncorrectoException e) {
			Assert.fail();
		} catch (NoHayConsultaException e) {
			
		}
	}
	
	@Test
	public void testReporteActividadMedicoConMedicoConConsultas(){
		Calendar fecha1= new GregorianCalendar(2020,10,10);
		Calendar fecha2= new GregorianCalendar(2022,10,10);
		IMedico medico = mock(IMedico.class);
		when(medico.getNombre()).thenReturn("aa");
		when(medico.getHonorario()).thenReturn(10.0);
		ConsultaMedica c1 = mock(ConsultaMedica.class);
		when(c1.getCantidad()).thenReturn(2);
		HashMap<String, Prestacion> prestaciones = new HashMap<String, Prestacion>();
		prestaciones.put("aa", c1);
		Factura f1 = new Factura(p1, prestaciones);
		TreeSet<Factura> facturas = new TreeSet<Factura>();
		facturas.add(f1);
		Clinica.getInstance().setFacturas(facturas);
		try {
			Clinica.getInstance().ReporteActividadMedica(medico, fecha1, fecha2);
			
		} catch (OrdenFechasIncorrectoException e) {
			Assert.fail();
		} catch (NoHayConsultaException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testReporteActividadMedicaSinMedicoSinConsultas() {
		Calendar fecha1= new GregorianCalendar(2020,10,10);
		Calendar fecha2= new GregorianCalendar(2021,10,10);
		try {
			String rta = Clinica.getInstance().ReporteActividadMedica(fecha1, fecha2);
			assertEquals("", rta);
		} catch (OrdenFechasIncorrectoException e) {
			Assert.fail();
		}
	}
}
