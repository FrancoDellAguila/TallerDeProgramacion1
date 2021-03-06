package vista;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

import decorators.IMedico;
import modelo.Paciente;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Interfaz de uso para la ventana medico
 */
public interface IVistaMedico extends IVista{
	String getNombre();
	String getApellido();
	String getDni();
	String getDomicilio();
	String getCiudad();
	String getTelefono();	
	String getMatricula();
	
	String getEspecialidad();
	String getContratacion();
	String getPosgrado();
	
	
	IMedico getMedico();
	void error(String mensaje);
	void actulizarLista();
	
	ButtonGroup getGrupoEspecialidad();
	ButtonGroup getGrupoContratacion();
	ButtonGroup getGrupoPosgrado();
	JTextField getTextFieldNombre();
	JTextField getTextFieldApellido();
	JTextField getTextFieldDni();
	JTextField getTextFieldDomicilio();
	JTextField getTextFieldCiudad();
	JTextField getTextFieldTelefono();
	JButton getBtnEliminar();
	JButton getBtnAgregar();
	JTextField getTextFieldMatricula();
	DefaultListModel<IMedico> getListModel();
	JList<IMedico> getListMedicos();
	
	
}
