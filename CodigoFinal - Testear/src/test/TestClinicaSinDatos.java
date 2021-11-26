package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

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
import modelo.Medico;
import modelo.Paciente;

public class TestClinicaSinDatos {

	@Before
	public void setUp() throws Exception {
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
	public void testIngresoPacienteNoRegistradoVaAPrivada() {
		Paciente p2 = new Paciente("29999999", "aaa", "bbb", "ccc", "ddd", "29999999", 9);
		Clinica.getInstance().Ingreso(p2);
		HashMap<String, Paciente> p = Clinica.getInstance().getPacientesRegistrados();
		assertEquals(p.get("29999999"), p2);
		assertEquals(Clinica.getInstance().getSalaPrivada(), p2);
	}
	
	@Test
	public void testEgresoYFacturacionNoEstaElPaciente() {
		try {
			Paciente p1 = new Paciente("19999999", "aaa", "bbb", "ccc", "ddd", "19999999", 1);
			Clinica.getInstance().EgresoYFacturacion(p1, null);
			Assert.fail();
		} catch (NoEstaPacienteException e) {
			
		}
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
		IMedico m1 = new Medico("19999999", "aaa", "bbb", "ccc", "ddd", "19999999", 1);
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
		IMedico m1 = new Medico("19999999", "aaa", "bbb", "ccc", "ddd", "19999999", 1);

		try {
			Clinica.getInstance().ReporteActividadMedica(m1, fecha1, fecha2);
			Assert.fail();
		} catch (OrdenFechasIncorrectoException e) {
			Assert.fail();
		} catch (NoHayConsultaException e) {
			
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
