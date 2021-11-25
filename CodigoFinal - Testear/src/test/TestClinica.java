package test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import decorators.IMedico;
import excepciones.PacienteYaExisteException;
import modelo.Clinica;
import modelo.Medico;
import modelo.Paciente;

public class TestClinica {

	Paciente p1;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Paciente("19999999", "aaa", "bbb", "ccc", "ddd", "19999999", 1);
		
		Clinica.getInstance().addPaciente(p1);
	}

	@After
	public void tearDown() throws Exception{
		Clinica.getInstance().borrarPaciente(p1);
	}
	
	@Test 
	public void testAddPacienteExistente() {
		/*esc1.agregarPacientes();
		Paciente p1 = esc1.getP1();*/
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
			Assert.fail("deberia haber lanzado la excepcion");
		}
	}

	
	
	@Test 
	public void testIngreso() {
		
	}
	@Test 
	public void testAtencion() {
		
	}
	
	@Test 
	public void testBorrarPaciente() {
		
	}
	
}
