package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Medico;
import modelo.Paciente;
import modelo.Persona;

public class TestPersona {

	@Before
	public void setUp() throws Exception {
	}

	//se testean medico y pacientes que se extienden de persona, ya que persona es abstracta.
	@Test
	public void testConstructorMedico() {
		String dni = "421577777";
		String nombre= "aaa";
		String apellido = "bbb";
		String domicilio = "ccc";
		String ciudad = "ddd";
		String telefono = "22345678";
		long matricula = 1;
		Medico p1 = new Medico(dni, nombre, apellido, domicilio, ciudad, telefono, matricula);
		assertEquals(dni, p1.getDni());
		assertEquals(nombre, p1.getNombre());
		assertEquals(apellido, p1.getApellido());
		assertEquals(domicilio, p1.getDomicilio());
		assertEquals(ciudad, p1.getCiudad());
		assertEquals(telefono, p1.getTelefono());
		assertEquals(matricula, p1.getNroMatricula(), 0);
	}

	public void testConstructorPacienteConNroHistoria() {
		String dni = "421577777";
		String nombre= "aaa";
		String apellido = "bbb";
		String domicilio = "ccc";
		String ciudad = "ddd";
		String telefono = "22345678";
		long nroHistoria = 1;
		Paciente p1 = new Paciente(dni, nombre, apellido, domicilio, ciudad, telefono, nroHistoria);
		assertEquals(dni, p1.getDni());
		assertEquals(nombre, p1.getNombre());
		assertEquals(apellido, p1.getApellido());
		assertEquals(domicilio, p1.getDomicilio());
		assertEquals(ciudad, p1.getCiudad());
		assertEquals(telefono, p1.getTelefono());
		assertEquals(nroHistoria, p1.getNroHistoria(), 0);
	}
	
	public void testConstructorPacienteSinNroHistoria() {
		Paciente aux = new Paciente("20000000", "aa", "bb", "cc", "dd", "212523142");
		long nroHistoria = aux.getNroHistoria();
		
		String dni = "421577777";
		String nombre= "aaa";
		String apellido = "bbb";
		String domicilio = "ccc";
		String ciudad = "ddd";
		String telefono = "22345678";
		Paciente p1 = new Paciente(dni, nombre, apellido, domicilio, ciudad, telefono);
		
		assertEquals(dni, p1.getDni());
		assertEquals(nombre, p1.getNombre());
		assertEquals(apellido, p1.getApellido());
		assertEquals(domicilio, p1.getDomicilio());
		assertEquals(ciudad, p1.getCiudad());
		assertEquals(telefono, p1.getTelefono());
		assertEquals(p1.getNroHistoria(), (nroHistoria+1), 0);
	}
}
