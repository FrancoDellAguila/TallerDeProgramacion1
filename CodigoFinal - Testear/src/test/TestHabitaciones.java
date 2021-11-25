package test;



import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Habitacion;
import modelo.Privada;
import modelo.TerapiaIntensiva;

public class TestHabitaciones {

	//tanto privada como terapiaIntensiva derivan de habitacion
	//tests habitacion privada

	@Test
	public void testConstructorPrivada() {
		String aux = "10";
		Privada privada = new Privada(aux);
		assertEquals(privada.getNumeroHabitacion(), aux);
	}

	@Test
	public void testSetCostoPrivada() {
		Privada privada = new Privada("10");
		Privada.setCostoPrivada(100);
		double a= privada.getCostoHabitacion();
		assertEquals(a,100,0);
	}
	
	@Test
	public void testSetCostoAsignacion() {
		Privada privada = new Privada("10");
		Privada.setCostoAsignacion(100);
		assertEquals(privada.getCostoasignacion(), 100,0);
	}
	
	@Test
	public void testgetCostoHabPriv1() {
		Privada privada = new Privada("10");
		Privada.setCostoPrivada(100);
		Privada.setCostoAsignacion(100);
		double rta = privada.getCosto(1);
		assertEquals(rta, 200,0);
	}

	@Test
	public void testgetCostoHabPriv3() {
		Privada privada = new Privada("10");
		Privada.setCostoPrivada(100);
		Privada.setCostoAsignacion(100);
		double rta = privada.getCosto(3);
		assertEquals(rta, (100 + (100*3*1.3)),0);
	}
	
	@Test
	public void testgetCostoHabPriv6() {
		Privada privada = new Privada("10");
		Privada.setCostoPrivada(100);
		Privada.setCostoAsignacion(100);
		double rta = privada.getCosto(6);
		assertEquals(rta, (100 + (100*6*2)),0);
	}
	
	//tests terapia intensiva
	
	@Test
	public void testConstructorTerapiaIntensiva() {
		String aux = "10";
		TerapiaIntensiva ter = new TerapiaIntensiva(aux);
		assertEquals(ter.getNumeroHabitacion(), aux);
	}
	@Test
	public void testSetCostoTerapiaIntensiva() {
		TerapiaIntensiva.setCostoTerapiaIntensiva(10);
		TerapiaIntensiva ter= new TerapiaIntensiva("10");
		assertEquals(ter.getCostoHabitacion(), 10, 0);
	}
	
	@Test
	public void testGetCostoTerapiaIntensiva() {
		Habitacion.setCostoAsignacion(100);
		TerapiaIntensiva.setCostoTerapiaIntensiva(10);
		TerapiaIntensiva ter= new TerapiaIntensiva("10");
		double costo = ter.getCosto(2);
		assertEquals(costo, 200,0); //200 = 100 + 10^2
	}
}
