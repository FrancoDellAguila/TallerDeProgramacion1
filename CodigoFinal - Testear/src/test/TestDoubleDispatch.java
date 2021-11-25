package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Joven;
import modelo.Mayor;
import modelo.Ni�o;

public class TestDoubleDispatch {

	Ni�o ni�o;
	Joven joven;
	Mayor mayor;
	@Before
	public void setUp() throws Exception {
		 ni�o = new Ni�o("29999999", "aaa", "bbb", "ccc", "ddd", "29999999", 1);
		 joven = new Joven("39999999", "aaa", "bbb", "ccc", "ddd", "29999999", 2);
		 mayor = new Mayor("39999999", "aaa", "bbb", "ccc", "ddd", "29999999", 3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrioridadNinoMayor() {
		assertFalse(ni�o.prioridad(mayor));
		
	}
	@Test
	public void testPrioridadNinoJoven() {
		assertTrue(ni�o.prioridad(joven));
	}
	
	@Test
	public void testPrioridadNinoNino() {
		assertFalse(ni�o.prioridad(ni�o));
	}
	
	@Test
	public void testPrioridadJovenJoven() {
		assertFalse(joven.prioridad(joven));
	}
	
	@Test
	public void testPrioridadJovenMayor() {
		assertTrue(joven.prioridad(mayor));
	}
	
	@Test
	public void testPrioridadJovenNino() {
		assertFalse(joven.prioridad(ni�o));
	}
	
	@Test
	public void testPrioridadMayorNino() {
		assertTrue(mayor.prioridad(ni�o));
	}
	
	@Test
	public void testPrioridadMayorJoven() {
		assertFalse(mayor.prioridad(joven));
	}
	
	@Test
	public void testPrioridadMayorMayor() {
		assertFalse(mayor.prioridad(mayor));
	}
}
