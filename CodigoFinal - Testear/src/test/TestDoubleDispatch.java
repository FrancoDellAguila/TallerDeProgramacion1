package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Joven;
import modelo.Mayor;
import modelo.Niño;

public class TestDoubleDispatch {

	Niño niño;
	Joven joven;
	Mayor mayor;
	@Before
	public void setUp() throws Exception {
		 niño = new Niño("29999999", "aaa", "bbb", "ccc", "ddd", "29999999", 1);
		 joven = new Joven("39999999", "aaa", "bbb", "ccc", "ddd", "29999999", 2);
		 mayor = new Mayor("39999999", "aaa", "bbb", "ccc", "ddd", "29999999", 3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrioridadNinoMayor() {
		assertFalse(niño.prioridad(mayor));
		
	}
	@Test
	public void testPrioridadNinoJoven() {
		assertTrue(niño.prioridad(joven));
	}
	
	@Test
	public void testPrioridadNinoNino() {
		assertFalse(niño.prioridad(niño));
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
		assertFalse(joven.prioridad(niño));
	}
	
	@Test
	public void testPrioridadMayorNino() {
		assertTrue(mayor.prioridad(niño));
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
