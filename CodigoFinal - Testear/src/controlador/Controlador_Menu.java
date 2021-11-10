package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import modelo.Clinica;
import persistencia.IPersistencia;
import persistencia.Persistencia;
import vista.IVistaMenu;
import vista.Ventana_Menu;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Controlador para la ventana del menu
 */
public class Controlador_Menu implements ActionListener,WindowListener{
	private IVistaMenu vista = null;
	/**
     * Constructor sin parametros, al momento de crear el controlador crea la ventana<br>
     *
     */
	public Controlador_Menu() {
		this.vista = new Ventana_Menu();
		this.vista.addActionListener(this);
		this.vista.addWindowListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Facturacion")) {
			Controlador_Facturacion controlador_facturacion= new Controlador_Facturacion();
			this.vista.cerrar();
		}else if(e.getActionCommand().equals("Pacientes")) {
			Controlador_Pacientes controlador_asociados = new Controlador_Pacientes();
			this.vista.cerrar();
		} else if(e.getActionCommand().equals("Medicos")) {
			Controlador_Medicos controlador_medicos = new Controlador_Medicos();
			this.vista.cerrar();
		} 
		
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		
		
		
			IPersistencia idao = new Persistencia();
			
			try
			{
				idao.abrirOutput("pacientes.dat");
				idao.escribir(Clinica.getInstance().getPacientesRegistrados());
				idao.cerrarOutput();
				idao.abrirOutput("medicos.dat");
				idao.escribir(Clinica.getInstance().getMedicos());
				idao.cerrarOutput();
				idao.abrirOutput("facturas.dat");
				idao.escribir(Clinica.getInstance().getFacturas());
				idao.cerrarOutput();
				
			} catch (Exception ex)
			{
				// TODO Auto-generated catch block
				System.out.println("Exception " + ex.getMessage());
			}
		
		
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
