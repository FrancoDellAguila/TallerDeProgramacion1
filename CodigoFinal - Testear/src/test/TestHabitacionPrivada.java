package test;



import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import modelo.Privada;

public class TestHabitacionPrivada {

	private Privada privada;
	
	@Before
	public void setUp() throws Exception {
		privada = new Privada("10");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetCostoPrivada() {
		Privada.setCostoPrivada(100);
		double a= this.privada.getCostoHabitacion();
		assertEquals(a,100,0);
	}
	
	@Test
	public void testSetCostoAsignacion() {
		Privada.setCostoAsignacion(100);
		assertEquals(privada.getCostoasignacion(), 100,0);
	}
	
	@Test
	public void testgetCosto1() {
		Privada.setCostoPrivada(100);
		Privada.setCostoAsignacion(100);
		double rta = privada.getCosto(1);
		assertEquals(rta, 200,0);
	}

	@Test
	public void testgetCosto3() {
		Privada.setCostoPrivada(100);
		Privada.setCostoAsignacion(100);
		double rta = privada.getCosto(3);
		assertEquals(rta, (100 + (100*3*1.3)),0);
	}
	
	@Test
	public void testgetCosto6() {
		Privada.setCostoPrivada(100);
		Privada.setCostoAsignacion(100);
		double rta = privada.getCosto(6);
		assertEquals(rta, (100 + (100*6*2)),0);
	}
}
