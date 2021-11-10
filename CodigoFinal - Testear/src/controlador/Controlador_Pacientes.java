package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import excepciones.PacienteYaExisteException;
import modelo.Paciente;

import modelo.Clinica;
import vista.IVista;
import vista.IVistaPaciente;
import vista.Ventana_Pacientes;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Controlador para la ventana de Pacientes
 */
public class Controlador_Pacientes implements ActionListener, WindowListener{
	private IVistaPaciente vista = null;
	/**
     * Constructor sin parametros, al momento de crear el controlador crea la ventana<br>
     *
     */
	public Controlador_Pacientes()
	{
		this.vista = new Ventana_Pacientes();
		this.vista.addActionListener(this);
		this.vista.addWindowListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Agregar")) {
		
			try {
				Clinica.getInstance().addPaciente(new Paciente(this.vista.getDni(),this.vista.getNombre(),this.vista.getApellido(),this.vista.getDomicilio(),this.vista.getCiudad(),this.vista.getTelefono()));
				
			} catch (PacienteYaExisteException e1) {
			
				this.vista.error(e1.getMessage());
			}
		}else if(e.getActionCommand().equals("Eliminar")) {
			Clinica.getInstance().borrarPaciente(this.vista.getPaciente());
		}
		this.vista.actulizarLista();
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		Controlador_Menu controlador_menu = new Controlador_Menu();
		
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
