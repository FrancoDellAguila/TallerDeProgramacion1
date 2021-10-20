package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import modelo.Clinica;
import persistencia.IPersistencia;
import persistencia.Persistencia;
import util.Util;
import vista.IVista;

public class Controlador implements ActionListener,WindowListener{
	
	private IVista vista;
	private Clinica clinica;
	
	public Controlador (IVista vista) {
		this.vista= vista;
	}
	
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();	
	
		if (comando.equals("PersistirPacientes")) {
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
		}else if (comando.equals("PersistirMedicos")) {
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
		}else if (comando.equals("PersistirFacturas")) {
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
		}else if(comando.equals("AgregarMedico")) {
			String nombre,apellido,dni,direccion,ciudad,telefono,matricula,especialidad,posgrado,contratacion;
			
			nombre=this.vista.getNombre();
			apellido=this.vista.getApellido();
			dni=this.vista.getDNI();
			direccion=this.vista.getDomicilio();
			ciudad=this.vista.getCiudad();
			telefono=this.vista.getTelefono();
			matricula=this.vista.getMatricula();
			especialidad=this.vista.getEspecialidad();
			posgrado=this.vista.getPosgrado();
			contratacion=this.vista.getContratacion();
			//aca iria la creacion del medico
			this.vista.getMedicos(this.clinica.getMedicos().getMedicosBD()); //para volver a escribir los medicos en el area de texto
		}else if(comando.equals("Cerrar")) {
			this.vista.cerrar();
		}
	}
}
