package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Clinica;
import modelo.Factura;
import modelo.Paciente;

public class TestUnidadCalculoImporteAdicionales {

	private TreeSet<Factura> facturas;
	private ArrayList<Double> listaDeInsumos;
	
	@Before
	public void setUp() throws Exception {
		this.facturas = new TreeSet<Factura>();
		this.listaDeInsumos = new ArrayList<Double>();
	}

	@After
	public void tearDown() throws Exception {
		this.facturas.clear();
		Clinica.getInstance().setFacturas(facturas);
		this.listaDeInsumos.clear();
	}

	@Test
	public void testNoHayFactura() {
		Clinica.getInstance().setFacturas(facturas);
		this.listaDeInsumos.add((double) 200);
		Calendar f= new GregorianCalendar(2021,11,11);
		double rta= Clinica.getInstance().calculoImporteAdicionales(0, f, listaDeInsumos);
		assertEquals(rta, 0, 0);
	}

	
	@Test
	public void testHayFacturasNoExisteElNroEnFacturas() {
		Factura f1= mock(Factura.class);
		when(f1.getNroFactura()).thenReturn(10);
		this.facturas.add(f1);
		Clinica.getInstance().setFacturas(facturas);
		Calendar f= new GregorianCalendar(2021,11,11);
		double rta= Clinica.getInstance().calculoImporteAdicionales(0, f, listaDeInsumos);
		assertEquals(rta, 0, 0);
	}
	
	@Test
	public void testHayFacturasYExisteElNroEnFacturasYListaDeInsumosNull() {
		Paciente p = mock(Paciente.class);
		when(p.esMayor()).thenReturn(true);
		Factura f1= mock(Factura.class);
		when(f1.getNroFactura()).thenReturn(10);
		when(f1.getTotal()).thenReturn(100.0);
		when(f1.calcularSubTotalImpar()).thenReturn(50.0);
		when(f1.getFecha()).thenReturn(new GregorianCalendar(2021,11,10));
		when(f1.getPaciente()).thenReturn(p);
		this.facturas.add(f1);
		Clinica.getInstance().setFacturas(facturas);
		Calendar f= new GregorianCalendar(2021,11,11);
		double rta= Clinica.getInstance().calculoImporteAdicionales(10, f, null);
		assertEquals(rta, 78, 0);//importeTotal= (100-50*0,7)*1,2=78
	}
	
	@Test //esto implica que insumos sea distinto de null
	public void testHayFacturasYExisteElNroEnFacturasYRandomDistintoFecha() {
		Paciente p = mock(Paciente.class);
		when(p.esMayor()).thenReturn(false);
		Math m = mock(Math.class);
		when(m.random()).thenReturn(0.2);
		this.listaDeInsumos.add(100.0);
		Factura f1= mock(Factura.class);
		when(f1.getNroFactura()).thenReturn(10);
		when(f1.getTotal()).thenReturn(100.0);
		when(f1.getFecha()).thenReturn(new GregorianCalendar(2021,11,10));
		when(f1.getPaciente()).thenReturn(p);
		this.facturas.add(f1);
		Clinica.getInstance().setFacturas(facturas);
		Calendar f= new GregorianCalendar(2021,11,11);
		double rta= Clinica.getInstance().calculoImporteAdicionales(10, f, this.listaDeInsumos);
		assertEquals(rta, 110, 0);//importeTotal= (100*0,5*0,2) + 100 = 110
	}
	
	
}
