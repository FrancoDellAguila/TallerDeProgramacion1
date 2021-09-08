package vista;

import controlador.Monitor;

public interface IVentanaJuego {

	public void arranca();
	public void setControlador(Monitor m);
	public void escribeEstado(String s, int cantint);
	public void limpia();
	public int getNumAdivina();
	
}
