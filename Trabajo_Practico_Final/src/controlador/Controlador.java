package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import persistencia.FacturaDTO;
import persistencia.IPersistencia;
import persistencia.MedicoDTO;
import persistencia.PacienteDTO;
import persistencia.Persistencia;
import util.Util;
import vista.IVista;
import vista.Vista;

public class Controlador implements ActionListener,WindowListener{
	
	private IVista vista;
	
	public Controlador () {
		this.vista= new Vista();
		this.vista.setControlador(this);
		this.vista.arranca();
		this.vista.getMedicos(Clinica.getInstance().getMedicos().getMedicosBD());
	}
	
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();	
	
		if (comando.equals("PersistirPacientes")) {
			IPersistencia idao = new Persistencia();
			try {
	        	idao.abrirOutput("Paciente.bin");
	        	System.out.println("Creacion archivo escritura");
	        	PacienteDTO cdto = Util.pacienteDTOFromClinica();
	        	System.out.println("se creo");//borrar
	        	idao.escribir(cdto);
	        	System.out.println("Clinica serializada al apretar boton");
	        	idao.cerrarOutput();
	        	System.out.println("Archivo cerrado");
	        	this.vista.informaStatusPacientes("OK");
	        }catch(Exception e1) {
	        	System.out.println(e1.getMessage());
	        	this.vista.informaStatusPacientes("ERROR");
	        }
		}else if (comando.equals("PersistirMedicos")) {
			IPersistencia idao = new Persistencia();
			try {
	        	idao.abrirOutput("Medico.bin");
	        	System.out.println("Creacion archivo escritura");
	        	MedicoDTO cdto = Util.medicoDTOFromClinica();
	        	idao.escribir(cdto);
	        	System.out.println("Clinica serializada al apretar boton");
	        	idao.cerrarOutput();
	        	System.out.println("Archivo cerrado");
	        	this.vista.informaStatusMedicos("OK");
	        }catch(Exception e1) {
	        	System.out.println(e1.getMessage());
	        	this.vista.informaStatusMedicos("ERROR");
	        }
		}else if (comando.equals("PersistirFacturas")) {
			IPersistencia idao = new Persistencia();
			try {
	        	idao.abrirOutput("Factura.bin");
	        	System.out.println("Creacion archivo escritura");
	        	FacturaDTO cdto = Util.facturaDTOFromClinica();
	        	idao.escribir(cdto);
	        	System.out.println("Clinica serializada al apretar boton");
	        	idao.cerrarOutput();
	        	System.out.println("Archivo cerrado");
	        	this.vista.informaStatusFacturas("OK");
	        }catch(Exception e1) {
	        	System.out.println(e1.getMessage());
	        	this.vista.informaStatusFacturas("ERROR");
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
			
				IMedico medico = null;
				try {
					medico = MedicoFactory.getMedico(dni, nombre, apellido, ciudad, telefono, direccion, matricula, especialidad, contratacion, posgrado);
					Clinica.getInstance().getMedicos().agregarMedico(medico);
				} catch (NoExisteEspecialidadException | NoExisteContratacionException | NoExistePosgradoException e1) {
					this.vista.mostrarMensaje(e1.getMessage() + ": " + e1.getDato());
				}
				
			
			this.vista.getMedicos(Clinica.getInstance().getMedicos().getMedicosBD()); //para volver a escribir los medicos en el area de texto
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
