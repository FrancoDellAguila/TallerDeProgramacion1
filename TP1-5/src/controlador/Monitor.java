package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import vista.IVentanaJuego;

public class Monitor implements ActionListener{
	
	private IVentanaJuego vista;
	private Juego modelo;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Juego Nuevo")) {
			
			modelo.juego();
			vista.limpia();
			
		}else if (e.getActionCommand().equals("Adivina")) {
			
			modelo.probar(vista.getNumAdivina());
			vista.escribeEstado(modelo.getEstado());
			
		}
	}

	public Monitor(IVentanaJuego vista, Juego modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
	}
	
	
	
}
