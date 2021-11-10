package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;

/**
 *  @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 * Clase que extiende de la clase JFrame e implementa la interfaz IVista. Representa a la ventana del menú
 *
 */
public class Ventana_Menu extends JFrame implements IVistaMenu{
	private JPanel panelCentral;
	private JPanel panelIzq;
	private JPanel panelCentralizado;
	private JPanel panelA;
	private JPanel panelM;
	private JPanel panelB;
	private JButton btnMedicos;
	private JButton btnPacientes;
	private JButton btnFacturacion;
	private JPanel panelMenu;
	private JLabel lblMenu;
	
	
	/**
	 * Constructor sin parámtros para setear la ventana menú
	 */
	public Ventana_Menu() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 600, 400);
		panelCentral = new JPanel();
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(0, 3, 0, 0));
		
		panelIzq = new JPanel();
		panelCentral.add(panelIzq);
		
		panelCentralizado = new JPanel();
		panelCentral.add(panelCentralizado);
		panelCentralizado.setLayout(new GridLayout(3, 0, 0, 0));
		
		panelA = new JPanel();
		FlowLayout fl_panelA = (FlowLayout) panelA.getLayout();
		fl_panelA.setVgap(30);
		panelCentralizado.add(panelA);
		
		btnMedicos = new JButton("M\u00E9dicos");
		this.btnMedicos.setActionCommand("Medicos");
		panelA.add(btnMedicos);
		
		panelM = new JPanel();
		FlowLayout fl_panelM = (FlowLayout) panelM.getLayout();
		fl_panelM.setVgap(30);
		panelCentralizado.add(panelM);
		
		btnPacientes = new JButton("Pacientes");
		this.btnPacientes.setActionCommand("Pacientes");
		panelM.add(btnPacientes);
		
		panelB = new JPanel();
		FlowLayout fl_panelB = (FlowLayout) panelB.getLayout();
		fl_panelB.setVgap(30);
		panelCentralizado.add(panelB);
		
		btnFacturacion = new JButton("Facturacion");
		this.btnFacturacion.setActionCommand("Facturacion");
		panelB.add(btnFacturacion);
		
		panelMenu = new JPanel();
		getContentPane().add(panelMenu, BorderLayout.NORTH);
		
		lblMenu = new JLabel("Menu principal");
		panelMenu.add(lblMenu);
		setVisible(true);
	}
	/**
	 * Método con un parámetro que agrega un action listener a los botones de Ambulancia, Asociados y Facturación<br>
	 * @param listener ActionListener que representa al listener que se le asignará a los distintos botones.
	 */
	@Override
	public void addActionListener(ActionListener listener) {
		this.btnMedicos.addActionListener(listener);
		this.btnPacientes.addActionListener(listener);
		this.btnFacturacion.addActionListener(listener);
		
	}
	
	/**
	 * Método sin parámetro que se encargá de setear el Visible en false para que no se vea la pantalla al cerrar la ventana
	 */
	public void cerrar() {
		setVisible(false);
		dispose(); //No llama al windowsListener para evitar que haga persistencia si no se precionó la X de cerrar.
	}

}
