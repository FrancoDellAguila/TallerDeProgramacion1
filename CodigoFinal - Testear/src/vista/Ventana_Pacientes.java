package vista;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.SwingConstants;


import modelo.Clinica;
import modelo.Paciente;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 * JFrame que representa la ventana donde se gestionan los Pacientes. Se extiende de JFrame e implementa KeyListener, IVistaPaciente y MouseListener.
 */
public class Ventana_Pacientes extends JFrame implements  KeyListener , IVistaPaciente,MouseListener{
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDni;
	private JTextField textFieldDomicilio;
	private JTextField textFieldCiudad;
	private JTextField textFieldTelefono;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JList<Paciente>listPacientes;
	private DefaultListModel<Paciente> listModel = new DefaultListModel<Paciente>();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	/**
	 * Constructor sin parametros que crea la ventana Pacientes
	 */
	public Ventana_Pacientes() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
		setBounds(100, 100, 980, 600);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperiorIzquierdo = new JPanel();
		FlowLayout fl_panelSuperiorIzquierdo = (FlowLayout) panelSuperiorIzquierdo.getLayout();
		fl_panelSuperiorIzquierdo.setVgap(15);
		panel.add(panelSuperiorIzquierdo, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Lista Pacientes:");
		panelSuperiorIzquierdo.add(lblNewLabel);
		try {
			ClassLoader cl = this.getClass().getClassLoader();
			ImageIcon programIcon = new ImageIcon(cl.getResource("res/registro.png"));
			setIconImage(programIcon.getImage());
		} catch (Exception whoJackedMyIcon) {
			System.out.println("Could not load program icon.");
		}
		JPanel panelLista = new JPanel();
		panel.add(panelLista, BorderLayout.CENTER);
		panelLista.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPanePacientes = new JScrollPane();
		panelLista.add(scrollPanePacientes);
		
		listPacientes = new JList<Paciente>();
		listPacientes.addMouseListener(this);
		scrollPanePacientes.setViewportView(listPacientes);
		listPacientes.setVisibleRowCount(20);
		listPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPacientes.setModel(listModel);
		
		JPanel panelDerecho = new JPanel();
		getContentPane().add(panelDerecho);
		panelDerecho.setLayout(new GridLayout(8, 0, 0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelDerecho.add(panelSuperior);
		panelSuperior.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDatos= new JLabel("   Datos: ");
		lblDatos.setFont(new Font("Dialog", Font.PLAIN, 16));
		panelSuperior.add(lblDatos, BorderLayout.SOUTH);
		
		JPanel panelNombre = new JPanel();
		panelDerecho.add(panelNombre);
		panelNombre.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelNombre.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addKeyListener(this);
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNombre.add(textFieldNombre);
		textFieldNombre.setColumns(15);
		
		JPanel panelApellido = new JPanel();
		panelDerecho.add(panelApellido);
		panelApellido.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelApellido.add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.addKeyListener(this);
		textFieldApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldApellido.setColumns(15);
		panelApellido.add(textFieldApellido);
		
		JPanel panelDni = new JPanel();
		panelDerecho.add(panelDni);
		panelDni.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDni.add(lblDni);
		
		textFieldDni = new JTextField();
		textFieldDni.addKeyListener(this);
		textFieldDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldDni.setColumns(15);
		panelDni.add(textFieldDni);
		
		JPanel panelDomicilio = new JPanel();
		panelDerecho.add(panelDomicilio);
		panelDomicilio.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDomicilio.add(lblDomicilio);
		
		textFieldDomicilio = new JTextField();
		textFieldDomicilio.addKeyListener(this);
		textFieldDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldDomicilio.setColumns(15);
		panelDomicilio.add(textFieldDomicilio);
		
		JPanel panelCiudad = new JPanel();
		panelDerecho.add(panelCiudad);
		panelCiudad.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelCiudad.add(lblCiudad);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.addKeyListener(this);
		textFieldCiudad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldCiudad.setColumns(15);
		panelCiudad.add(textFieldCiudad);
		
		JPanel panelTelefono = new JPanel();
		panelDerecho.add(panelTelefono);
		panelTelefono.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelTelefono.add(lblTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.addKeyListener(this);
		textFieldTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldTelefono.setColumns(15);
		panelTelefono.add(textFieldTelefono);
		
		JPanel panelBotones = new JPanel();
		FlowLayout fl_panelBotones = (FlowLayout) panelBotones.getLayout();
		fl_panelBotones.setVgap(20);
		fl_panelBotones.setHgap(20);
		panelDerecho.add(panelBotones);
		
		btnEliminar = new JButton("Eliminar");
		this.btnEliminar.setEnabled(false);
		this.btnEliminar.setActionCommand("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotones.add(btnEliminar);
		
		btnAgregar = new JButton("Agregar");
		this.btnAgregar.setEnabled(false);
		this.btnAgregar.setActionCommand("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotones.add(btnAgregar);
		this.actulizarLista();
		this.setVisible(true);
	}
	
	/**
	 * Metodo que actualiza la lista de Pacientes
	 */
	public void actulizarLista() {
		
		this.listModel.clear();
		for(Paciente i: Clinica.getInstance().getPacientesRegistrados().values()) {
			this.listModel.addElement(i);
		}
	}
	
	
	
	/**
	 * Metodo que añade un Action Listener a cada boton de la ventana 
	 */
	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAgregar.addActionListener(listener);
		this.btnEliminar.addActionListener(listener);
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	/**
	 * Metodo que se ejecuta cuando una tecla del teclado se suelta y 
	 * habilita o desabilita los botones si se cumplen las condiciones<br>
	 * @param e: parametro de tipo KeyEvent que representa el evento.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		boolean condicionA = !this.getNombre().isEmpty() && !this.getApellido().isEmpty() && this.getDni().length()>6 &&
				!this.getDomicilio().isEmpty() && !this.getCiudad().isEmpty() && !this.getTelefono().isEmpty();
		
		this.btnAgregar.setEnabled(condicionA);
	}

	/**
	 * Metodo que devuelve el nombre escrito en el TextField
	 */
	@Override
	public String getNombre() {
		
		return this.textFieldNombre.getText();
	}

	/**
	 * Metodo que devuelve el apellido escrito en el TextField
	 */
	@Override
	public String getApellido() {
		return this.textFieldApellido.getText();
	}
	/**
	 * Metodo que devuelve el dni escrito en el TextField
	 */
	@Override
	public String getDni() {
		return this.textFieldDni.getText();
	}

	/**
	 * Metodo que devuelve el domicilio escrito en el TextField
	 */
	@Override
	public String getDomicilio() {
		return this.textFieldDomicilio.getText();
	}

	/**
	 * Metodo que devuelve el ciudad escrito en el TextField
	 */
	@Override
	public String getCiudad() {
		return this.textFieldCiudad.getText();
	}

	/**
	 * Metodo que devuelve el telefono escrito en el TextField
	 */
	@Override
	public String getTelefono() {
	
		return this.textFieldTelefono.getText();
	}

	/**
	 * Metodo que devuelve el Paciente seleccionado en la lista 
	 */
	public Paciente getPaciente() {
		return this.listPacientes.getSelectedValue();
	}
	/**
	 * Metodo que muesta un cartel de error a partir del String pasado por parametro
	 */
	public void error(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}


	@Override
	public void mousePressed(MouseEvent e) {
	}

	/**
	 * Metodo que se ejecuta cuando se suelta el boton de mouse y fija la condicion del boton de eliminar
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		boolean condicionE = !this.listPacientes.isSelectionEmpty();
		
		this.btnEliminar.setEnabled(condicionE);
	}


	@Override
	public void mouseEntered(MouseEvent e) {
	}


	@Override
	public void mouseExited(MouseEvent e) {
	}


	

}
