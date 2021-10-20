package vista;

import controlador.Controlador;

public interface IVista {

	public void arranca();
	public void setControlador(Controlador c);
	public void informaStatusPacientes(String status);
	public void informaStatusMedicos(String status);
	public void informaStatusFacturas(String status);
	public void cerrar();
}
