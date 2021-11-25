package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import decorators.IMedico;
import modelo.ConsultaMedica;
import modelo.Habitacion;
import modelo.Internacion;

import modelo.Privada;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

public class TestPrestaciones {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConsultaMedica() {
		int cant= 2;
		IMedico medico = mock(IMedico.class);
		when(medico.getHonorario()).thenReturn(10.0);
		ConsultaMedica cons = new ConsultaMedica(cant, medico);
		assertEquals(cons.getCantidad(), 2, 0);
		assertEquals(cons.getSubtotal(), 1612,0);
	}
	
	@Test
	public void testInternacion() {
		int cant=2;
		Privada hab = mock(Privada.class);
		when(hab.getCosto(cant)).thenReturn((double) 1000);
		Internacion internacion = new Internacion(cant, hab);
		assertEquals(internacion.getCantidad(), cant, 0);
		assertEquals(internacion.getSubtotal(),1000,0);
	}

}
