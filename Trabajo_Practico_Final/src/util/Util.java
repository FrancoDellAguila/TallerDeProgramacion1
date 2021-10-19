package util;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import modelo.Clinica;
import persistencia.FacturaDTO;
import persistencia.MedicoDTO;
import persistencia.PacienteDTO;
import personas.Paciente;



public class Util
{
       
    public static PacienteDTO pacienteDTOFromClinica() 
    {
		PacienteDTO respuesta = new PacienteDTO();
		
		respuesta.setPacientes(Clinica.getInstance().getPacientes().getPacientesBD());
		
		return respuesta;
    }
    
    public static MedicoDTO medicoDTOFromClinica() 
    {
		MedicoDTO respuesta = new MedicoDTO();
		
		respuesta.setMedicos(Clinica.getInstance().getMedicos().getMedicosBD());
		
		return respuesta;
    }
    
    public static FacturaDTO facturaDTOFromClinica() 
    {
		FacturaDTO respuesta = new FacturaDTO();
	
		respuesta.setFacturas(Clinica.getInstance().getFacturas());
		
		return respuesta;
    }
    

    
    public static void clinicaFromClinicaDTOs(PacienteDTO pacientesDTO, MedicoDTO medicosDTO, FacturaDTO facturaDTO) 
    {
    	//Clinica.getInstance().setAsociados(clinicaDTO.getAsociados());
    	TreeSet<Paciente> aux1 = pacientesDTO.getPacientes();
    	
    	Clinica.getInstance().setPacientes().setPacientesBD(aux1);
    	Clinica.getInstance().setMedicos(setMedicosBD(medicosDTO.getMedicos()));
    	Clinica.getInstance().setFacturas(facturaDTO.getFacturas());
	
    }
    
  
	public static final Random r = new Random();

	public static void espera(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void espera() {
		Util.espera(r.nextInt(300));
	}

    
    
    
}
