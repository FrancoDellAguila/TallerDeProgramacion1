package vista;

import java.util.ArrayList;

import controlador.Controlador;
import modelo.IMedico;

public interface IVista {

	public void arranca();
	public void setControlador(Controlador c);
	public void informaStatusPacientes(String status);
	public void informaStatusMedicos(String status);
	public void informaStatusFacturas(String status);
	public void mostrarMensaje(String mensaje);
	
	
	public String getNombre();
	public String getApellido();
	public String getDNI();
	public String getDomicilio();
	public String getCiudad();
	public String getTelefono();
	public String getMatricula();
	public String getEspecialidad();
	public String getPosgrado();
	public String getContratacion();
	public void getMedicos(ArrayList<IMedico> medicos);
}
