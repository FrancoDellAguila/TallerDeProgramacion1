package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.ConsultaMedica;
import modelo.Factura;
import modelo.Internacion;
import modelo.Paciente;
import modelo.Prestacion;

public class TestFactura {

	Paciente p;
	
	@Before
	public void setUp() throws Exception {
		p= new Paciente("4215555363", "aaa", "bbb", "ccc", "ddd", "2523636", 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructorSinPrestaciones() {
		Factura f1 = new Factura (p);
		Paciente auxp = f1.getPaciente();
		int aux = f1.getNroFactura();
		//assertEquals(f1.getFecha(), Calendar.getInstance()); depende del momento en que se toman las fechas.
		assertEquals(auxp, p);
		assertEquals(f1.getTotal(), 0, 0);
		Factura f2 = new Factura(new Paciente("9999999", "aa", "bb", "cc", "dd", "11111111", 2));
		assertEquals(f2.getNroFactura(), (aux+1), 0);
	}
	
	@Test //mocks para simular las prestaciones ya que se necesita de instanciar medicos o habitaciones
	public void testConstructorConPrestaciones() {
		ConsultaMedica p1 = mock(ConsultaMedica.class);
		when(p1.getSubtotal()).thenReturn(100.0);
		Internacion p2 = mock(Internacion.class);
		when(p2.getSubtotal()).thenReturn(50.0);
		HashMap<String, Prestacion> h = new HashMap<String, Prestacion>();
		h.put("c", p1);
		h.put("i", p2);
		Factura f1= new Factura(p, h);
		int aux = f1.getNroFactura();
		assertEquals(f1.getFecha(), Calendar.getInstance()); // depende del momento en que se toman las fechas.
		assertEquals(f1.getPaciente(), p);
		assertEquals(f1.getPrestaciones(), h);
		//assertEquals(f1.getTotal(), 150, 0); lo saque porque el gettotal se testea aparte por mas que se calcule en el constructor
		Factura f2 = new Factura(new Paciente("9999999", "aa", "bb", "cc", "dd", "11111111", 2));
		assertEquals(f2.getNroFactura(), (aux+1), 0);
	}
	
	@Test
	public void testCalculaTotal() {
		ConsultaMedica p1 = mock(ConsultaMedica.class);
		when(p1.getSubtotal()).thenReturn(100.0);
		Internacion p2 = mock(Internacion.class);
		when(p2.getSubtotal()).thenReturn(50.0);
		HashMap<String, Prestacion> h = new HashMap<String, Prestacion>();
		h.put("c", p1);
		h.put("i", p2);
		Factura f1= new Factura(p, h);
		
		assertEquals(f1.getPrestaciones(), h);
		assertEquals(f1.getTotal(), 150, 0);		
	}
	
	@Test
	public void testCalculaSubTotalImpar() {
		ConsultaMedica p1 = mock(ConsultaMedica.class);
		when(p1.getSubtotal()).thenReturn(100.0);
		Internacion p2 = mock(Internacion.class);
		when(p2.getSubtotal()).thenReturn(50.0);
		HashMap<String, Prestacion> h = new HashMap<String, Prestacion>();
		h.put("c", p1);
		h.put("i", p2);
		Factura f1= new Factura(p, h);
		
		double aux= f1.calcularSubTotalImpar();
		assertEquals(aux, 50, 0);
	}
	
	@Test
	public void testAddPrestacionSinDatos() {
		
		Factura f1= new Factura(p);
		ConsultaMedica p1 = mock(ConsultaMedica.class);
		when(p1.getSubtotal()).thenReturn(100.0);
		f1.addPrestacion("p1", p1);
		HashMap<String, Prestacion> h = f1.getPrestaciones();
		assertEquals(h.get("p1"), p1);
	}
	
	@Test
	public void testAddPrestacionConDatos() {
		
		Internacion p2 = mock(Internacion.class);
		when(p2.getSubtotal()).thenReturn(50.0);
		HashMap<String, Prestacion> h = new HashMap<String, Prestacion>();
		h.put("i", p2);
		Factura f1= new Factura(p, h);
		ConsultaMedica p1 = mock(ConsultaMedica.class);
		when(p1.getSubtotal()).thenReturn(100.0);
		f1.addPrestacion("p1", p1);
		h = f1.getPrestaciones();
		assertEquals(h.get("p1"), p1);
	}
		

}
