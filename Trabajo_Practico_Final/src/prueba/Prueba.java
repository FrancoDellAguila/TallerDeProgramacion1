package prueba;
import personas.Paciente;
import vista.IVista;
import vista.Vista;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.PacienteFactory;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import controlador.Controlador;
import excepciones.ImposibleCrearMedicoException;
import excepciones.NoExisteRangoEtarioException;
import infraestructura.Factura;
import infraestructura.HabitacionCompartida;
public class Prueba {

	public static void main(String[] args) {
		
		
		Paciente paciente=null,paciente2=null,paciente3=null,paciente4=null;
		//cuando copien y pegen para hacer mas pacientes recuerden cambiarles el DNI
		try {
			paciente = PacienteFactory.getPaciente("41927911", "Juan Jose   ", "Java", "MDP    ","2235673421", "San Juan 2140","Nino");
			paciente2 = PacienteFactory.getPaciente("41822123", "Ximena		", "ConX", "MDP    ","2235673421", "San Juan 2140","Mayor");
		    paciente3  = PacienteFactory.getPaciente("4444444", "Rigoberto", "Rodriguez", "Miramar","43256321", "Independencia 01","Joven");
		       
		} catch (NoExisteRangoEtarioException e) {
			System.out.println(e.getMessage()+e.getRango());
		}
            
       
        // Creacion de medicos
        IMedico medico=null, medico2 =null,medico3=null;
        try {
			 medico = MedicoFactory.getMedico("25900987","Luis","Montini","MDP","2234565","Independencia","1111","Cirujia","Permanente","Magister");
			 Clinica.getInstance().getMedicos().agregarMedico(medico);
			 medico2 = MedicoFactory.getMedico("25980987","Juan","Montini","MDP","2234566","Independencia","2222","Clinica","Permanente","Doctor");
			 Clinica.getInstance().getMedicos().agregarMedico(medico2);
			 medico3 = MedicoFactory.getMedico("2565657","Pablo","Montini","MDP","2234567","Independencia","3333","Pediatria","Permanente","Magister");
			 Clinica.getInstance().getMedicos().agregarMedico(medico3);
		} catch (ImposibleCrearMedicoException e) {
            System.out.println(e.getMessage()+e.getDato());
        }
        
        GregorianCalendar fecha1 = new GregorianCalendar(2020,1,1);
        GregorianCalendar fecha2 = new GregorianCalendar(2020,2,1);
        //MODULO DE INGRESO
        Clinica.getInstance().ingresoPaciente(paciente); //busca o genera la historia
        Clinica.getInstance().ingresoPaciente(paciente2);
        Clinica.getInstance().ingresoPaciente(paciente3);
        System.out.println("Pacientes en espera");
        System.out.println("El paciente en la sala de espera es: "+Clinica.getInstance().getSalaEspera().getPaciente());
        System.out.println("Los pacientes en el patio son: "+Clinica.getInstance().getPatio());
        //DERIVACION Y ATENCION
        System.out.println("------------------------");
        Clinica.getInstance().atenderPaciente(paciente);
        Clinica.getInstance().atenderPaciente(paciente2);
        
        Factura factura = new Factura(1,fecha1,paciente);
        factura.asignarMedico(medico);
        System.out.println("FACTURA:");
        factura.asignarMedico(medico);
        factura.asignarHabitacion(new HabitacionCompartida(32,21,200));
      
        Factura factura2 = new Factura(2,fecha1,paciente2);
        factura2.asignarMedico(medico);
        //MODULO DE EGRESO Y FACTURACION
        Clinica.getInstance().egreso(paciente,factura);
        Clinica.getInstance().egreso(paciente2,factura2);
        //REPORTE MEDICO
        System.out.println("--------------------");
        System.out.println("REPORTE:");
        Clinica.getInstance().reporteMedico(medico, fecha1, fecha2);    
        
        
        Controlador controlador = new Controlador();
	}
 
}
