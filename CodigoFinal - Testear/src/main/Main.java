package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;

import controlador.Controlador_Menu;
import decorators.IMedico;
import excepciones.PacienteYaExisteException;
import modelo.Clinica;
import modelo.Compartida;
import modelo.ConsultaMedica;
import modelo.Factura;
import modelo.Habitacion;
import modelo.Joven;
import modelo.Mayor;
import modelo.Medico;
import modelo.Paciente;
import modelo.Privada;
import modelo.TerapiaIntensiva;
import persistencia.IPersistencia;
import persistencia.Persistencia;


/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias   
 *<br>
 *Clase main.
 */
public class Main {

	/**
	 * Método static main que inicializa la aplicación.
	 */
	public static void main(String[] args) {
		IPersistencia idao = new Persistencia();
		Habitacion.setCostoAsignacion(1000);
		Compartida.setCostoCompartida(500);
		Privada.setCostoPrivada(1000);
		TerapiaIntensiva.setCostoTerapiaIntensiva(1500);
		
		ConsultaMedica.setValorConsulta(800);
		ConsultaMedica.setPorcentajeExtra(90);
		Medico.setHonorarioBase(1200);		
		Habitacion h1 = new Privada("55");
		Habitacion h2 = new Compartida("22");
		Clinica.getInstance().addHabitacion(h1);
		Clinica.getInstance().addHabitacion(h2);
		try {

			idao.abrirInput("pacientes.dat");
			Clinica.getInstance().setPacientesRegistrados( (HashMap<String, Paciente>) idao.leer());
			idao.cerrarInput();
			idao.abrirInput("medicos.dat");
			Clinica.getInstance().setMedicos((HashMap<Long, IMedico>) idao.leer());
			idao.cerrarInput();
			idao.abrirInput("facturas.dat");
			Clinica.getInstance().setFacturas((TreeSet<Factura>) idao.leer());
			idao.cerrarInput();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		Controlador_Menu controlador_menu = new Controlador_Menu();
		
	}
	
}
