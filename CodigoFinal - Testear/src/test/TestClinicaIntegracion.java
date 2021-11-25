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

public class TestClinicaIntegracion {

	Paciente p1;
	IMedico m2;
	private EscenarioClinicaConDatos esc1;
	@Before
	public void setUp() throws Exception {
		p1 = new Paciente("19999999", "aaa", "bbb", "ccc", "ddd", "19999999", 1);
		m2= new Medico("2000000", "aaa","bbb", "ccc", "ddd", "19999999", 1);
		Clinica.getInstance().addPaciente(p1);
	}

	@After
	public void tearDown() throws Exception{
		Clinica.getInstance().borrarPaciente(p1);
	}
	


	@Test 
	public void testAddMedicoExistente() {
		
			Clinica.getInHashMap<K, V>).addMedico(m2);
			HashMap<Long,IMedico> medicos = Clinica.getInstance().getMedicos();
			IMedico m3 = medicos.get(m2.get)
			assertEquals(, esc1);
		
		
	}
	
	@Test
	public void testAddMedicoNuevo() {
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
	public void testEgresoYFacturacionConDatos() {
		
	}

	/* Hay que testear EgresoYfacturacion con datos (si se encuentra el paciente y si no) y sin datos, ver que si creamos dos clase o hacemos los tests aca */
	@Test
	public void testEgresoYFacturacionSinDatos() {
		
	}
	
	//revisar que hay dos metodos (uno void y otro string) ademas lanza dos excepciones

	@Test
	public void testReporteActividadMedica() {
		
	}
}
