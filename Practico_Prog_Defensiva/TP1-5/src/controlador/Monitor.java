package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import modelo.NumeroNoValidoException;
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
			
			try {
				modelo.probar(vista.getNumAdivina());
			} catch (NumeroNoValidoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vista.escribeEstado(modelo.getEstado(), modelo.getCantint());
			
		}
	}

	public Monitor(IVentanaJuego vista, Juego modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
	}
	
	
	
}
