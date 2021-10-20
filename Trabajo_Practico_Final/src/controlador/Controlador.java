package controlador;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import persistencia.IPersistencia;
import persistencia.Persistencia;
import util.Util;

public class Controlador implements ActionListener,WindowListener{
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();	
	
		if (comando.equalsIgnoreCase("Serializar Paciente")) {
			IPersistencia idao = new Persistencia();
			try {
	        	idao.abrirOutput("Paciente.bin");
	        	System.out.println("Creacion archivo escritura");
	        	ClinicaDTO cdto = Util.clinicaDTOFromCLinica();
	        	idao.escribir(cdto);
	        	System.out.println("Clinica serializada al apretar boton");
	        	idao.cerrarOutput();
	        	System.out.println("Archivo cerrado");
	        	
	        }catch(Exception e1) {
	        	System.out.println(e1.getMessage());
	        }
		}
		if (comando.equalsIgnoreCase("Serializar Medico")) {
			IPersistencia idao = new Persistencia();
			try {
	        	idao.abrirOutput("Medico.bin");
	        	System.out.println("Creacion archivo escritura");
	        	ClinicaDTO cdto = Util.clinicaDTOFromCLinica();
	        	idao.escribir(cdto);
	        	System.out.println("Clinica serializada al apretar boton");
	        	idao.cerrarOutput();
	        	System.out.println("Archivo cerrado");
	        	
	        }catch(Exception e1) {
	        	System.out.println(e1.getMessage());
	        }
		}
		if (comando.equalsIgnoreCase("Serializar Factura")) {
			IPersistencia idao = new Persistencia();
			try {
	        	idao.abrirOutput("Factura.bin");
	        	System.out.println("Creacion archivo escritura");
	        	ClinicaDTO cdto = Util.clinicaDTOFromCLinica();
	        	idao.escribir(cdto);
	        	System.out.println("Clinica serializada al apretar boton");
	        	idao.cerrarOutput();
	        	System.out.println("Archivo cerrado");
	        	
	        }catch(Exception e1) {
	        	System.out.println(e1.getMessage());
	        }
		}
	}
}
