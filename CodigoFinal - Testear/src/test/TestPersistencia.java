package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Paciente;
import persistencia.IPersistencia;
import persistencia.Persistencia;

public class TestPersistencia {

	private IPersistencia idao = new Persistencia();
	private HashMap<String,Paciente> pacientesRegistrados;
	@Before
	public void setUp() throws Exception {
		pacientesRegistrados = new HashMap<String,Paciente>();
		File archivo = new File("pacientes.dat");
		if(archivo.exists()) {
			archivo.delete();
		}
	}

	@Test
	public void testCrearArchivo() {
		try {
			idao.abrirOutput("pacientes.dat");
			idao.cerrarOutput();
			File archivo = new File("pacientes.dat");
			Assert.assertTrue("Deberia existir el archivo", archivo.exists());
		} catch (IOException e) {
			Assert.fail("No deberia lanzar excepcion " + e.getMessage());
		}
		
	}
	
	@Test
	public void testPacientesVacio() {
		try {
			idao.abrirOutput("pacientes.dat");
			idao.escribir(pacientesRegistrados);
			idao.cerrarOutput();
			idao.abrirInput("pacientes.dat");
			HashMap<String,Paciente> pacientesRegistrados2 = (HashMap<String, Paciente>) idao.leer();
			idao.cerrarInput();
			Assert.assertEquals(pacientesRegistrados, pacientesRegistrados2);
		} catch (IOException | ClassNotFoundException e) {
			Assert.fail("No deberia lanzar excepcion "+ e.getMessage());
		}
		
	}
	
	@Test
	public void testPacientesConRegistro() {
		this.cargarPacientes(pacientesRegistrados);
		try {
			idao.abrirOutput("pacientes.dat");
			idao.escribir(pacientesRegistrados);
			idao.cerrarOutput();
			idao.abrirInput("pacientes.dat");
			HashMap<String,Paciente> pacientesRegistrados2 = (HashMap<String, Paciente>) idao.leer();
			Assert.assertEquals(pacientesRegistrados, pacientesRegistrados2);
			idao.cerrarInput();
		} catch (IOException | ClassNotFoundException e) {
			Assert.fail("No deberia lanzar excepcion "+ e.getMessage());
		}
	}
	
	@Test
	public void testDespersistirSinArchivo() {
		try {
			idao.abrirInput("pacientes.dat");
			HashMap<String,Paciente> pacientesRegistrados2 = (HashMap<String, Paciente>) idao.leer();
			Assert.fail("deberia haber lanzado una excepcion");
		} catch (IOException | ClassNotFoundException e) {
			
		}
		
	}
	private void cargarPacientes(HashMap<String,Paciente> registro) {
		Paciente p1 = new Paciente("42111111", "tobias", "andrade", "aaa 111", "mdp", "12121212", 1);
		Paciente p2 = new Paciente("40111110", "franco", "abcd", "bbb 222", "mdp", "21252325", 2);
		Paciente p3 = new Paciente("39201214", "lucas", "assd", "ccc 333", "mdp", "15462325", 3);
		
		registro.put(p1.getDni(), p1);
		registro.put(p2.getDni(), p2);
		registro.put(p3.getDni(), p3);
	}
	

}
