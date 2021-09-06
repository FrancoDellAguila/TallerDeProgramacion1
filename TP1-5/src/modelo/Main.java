package modelo;

import controlador.Monitor;
import vista.IVentanaJuego;
import vista.VentanaJuego;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Juego modelo = new Juego();
			IVentanaJuego vista = new VentanaJuego();
			Monitor controlador = new Monitor(vista,modelo);
			vista.setControlador(controlador);
			vista.arranca();
	}

}
