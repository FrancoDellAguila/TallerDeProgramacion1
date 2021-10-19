package util;

import java.util.ArrayList;
import java.util.Random;

import modelo.Clinica;
import persistencia.ClinicaDTO;

public class Util
{
       
    public static PacienteDTO pacienteDTOFromClinica() 
    {
		PacienteDTO respuesta = new PacienteDTO();
		//respuesta.setAsociados(Clinica.getInstance().getAsociados());
		respuesta.setDireccion(Clinica.getInstance().getDireccion());
		respuesta.setdNI();
		respuesta.setNombre();
		respuesta.setApellido();
		respuesta.setCiudad();
		respuesta.setTelefono();
		respuesta.setDomicilio();
		return respuesta;
    }
    
    public static MedicoDTO medicoDTOFromPrueba() 
    {
		MedicoDTO respuesta = new MedicoDTO();
		//respuesta.setAsociados(Clinica.getInstance().getAsociados());
		respuesta.setDireccion(Prueba.getInstance().getDireccion());
		
		return respuesta;
    }
    
    public static FacturaDTO facturaDTOFromClinica() 
    {
		FacturaDTO respuesta=new FacturaDTO();
		//respuesta.setAsociados(Clinica.getInstance().getAsociados());
		respuesta.setDireccion(Clinica.getInstance().getDireccion());
		
		return respuesta;
    }
    
    public static void clinicaFromClinicaDTO(ClinicaDTO clinicaDTO) 
    {
    	//Clinica.getInstance().setAsociados(clinicaDTO.getAsociados());
    	Clinica.getInstance().setDireccion(clinicaDTO.getDireccion());
    	
	
    }
    
    public static void clinicaFromClinicaDTO(ClinicaDTO clinicaDTO) 
    {
    	//Clinica.getInstance().setAsociados(clinicaDTO.getAsociados());
    	Clinica.getInstance().setDireccion(clinicaDTO.getDireccion());
    	
	
    }
    
    public static void clinicaFromClinicaDTO(ClinicaDTO clinicaDTO) 
    {
    	//Clinica.getInstance().setAsociados(clinicaDTO.getAsociados());
    	Clinica.getInstance().setDireccion(clinicaDTO.getDireccion());
    	
	
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
