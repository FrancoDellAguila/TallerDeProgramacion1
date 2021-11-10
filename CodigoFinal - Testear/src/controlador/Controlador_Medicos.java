package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import decorators.IMedico;
import excepciones.PacienteYaExisteException;
import modelo.Clinica;
import modelo.MedicoFactory;
import modelo.Paciente;
import vista.IVistaMedico;
import vista.IVistaPaciente;
import vista.Ventana_Medicos;
import vista.Ventana_Pacientes;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Controlador para la ventana de Medicos
 */
public class Controlador_Medicos implements ActionListener, WindowListener{
	private IVistaMedico vista = null;
	/**
	 * Constructor sin parametros, al momento de crear el controlador crea la ventana<br>
	 *
	 */
	public Controlador_Medicos()
	{
		this.vista = new Ventana_Medicos();
		this.vista.addActionListener(this);
		this.vista.addWindowListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Agregar")) {
			try {
				long Matricula = Long.parseLong(this.vista.getMatricula());



				IMedico medico = MedicoFactory.getMedico(this.vista.getEspecialidad(),this.vista.getContratacion(),this.vista.getPosgrado(), 
						this.vista.getDni(), this.vista.getNombre(), this.vista.getApellido(), this.vista.getDomicilio(), this.vista.getCiudad(),
						this.vista.getTelefono(), Matricula);

				Clinica.getInstance().addMedico(medico);
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Matricula incorrecta", "ERROR!", JOptionPane.WARNING_MESSAGE);
			}

		}else if(e.getActionCommand().equals("Eliminar")) {
			Clinica.getInstance().borrarMedico(this.vista.getMedico());
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
