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

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.SwingConstants;

import decorators.IMedico;
import modelo.Clinica;
import modelo.Medico;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 * JFrame que representa la ventana donde se gestionan los Medicos. Se extiende de JFrame e implementa KeyListener, IVistaMedico y MouseListener.
 */
public class Ventana_Medicos extends JFrame implements  KeyListener , IVistaMedico,MouseListener{
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDni;
	private JTextField textFieldDomicilio;
	private JTextField textFieldCiudad;
	private JTextField textFieldTelefono;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JList<IMedico>listMedicos;
	private DefaultListModel<IMedico> listModel = new DefaultListModel<IMedico>();
	private ButtonGroup grupoEspecialidad = new ButtonGroup();
	private ButtonGroup grupoContratacion = new ButtonGroup();
	private ButtonGroup grupoPosgrado = new ButtonGroup();
	private JTextField textFieldMatricula;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	/**
	 * Constructor sin parametros que crea la ventana Medicos
	 */
	public Ventana_Medicos() {
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
		
		JLabel lblNewLabel = new JLabel("Lista Medicos:");
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
		
		JScrollPane scrollPaneMedicos = new JScrollPane();
		panelLista.add(scrollPaneMedicos);
		
		listMedicos = new JList<IMedico>();
		listMedicos.addMouseListener(this);
		scrollPaneMedicos.setViewportView(listMedicos);
		listMedicos.setVisibleRowCount(20);
		listMedicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMedicos.setModel(listModel);
		
		JPanel panelDerecho = new JPanel();
		getContentPane().add(panelDerecho);
		panelDerecho.setLayout(new GridLayout(12, 0, 0, 0));
		
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
		
		JPanel panelMatricula = new JPanel();
		panelDerecho.add(panelMatricula);
		panelMatricula.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelMatricula.add(lblMatricula);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.addKeyListener(this);
		textFieldMatricula.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldMatricula.setColumns(15);
		panelMatricula.add(textFieldMatricula);
		
		JPanel panelEspecialidad = new JPanel();
		panelDerecho.add(panelEspecialidad);
		panelEspecialidad.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panelEspecialidad.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Especialidad");
		panel_5.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panelEspecialidad.add(panel_4);
		
		JRadioButton RadioButtonClinica = new JRadioButton("Cl\u00EDnica");
		RadioButtonClinica.setActionCommand("Clinica");
		RadioButtonClinica.setSelected(true);
		panel_4.add(RadioButtonClinica);
		
		JRadioButton RadioButtonCirugia = new JRadioButton("Cirug\u00EDa");
		RadioButtonCirugia.setActionCommand("Cirugia");
		panel_4.add(RadioButtonCirugia);
		
		JRadioButton RadioButtonPediatria = new JRadioButton("Pediatr\u00EDa");
		RadioButtonPediatria.setActionCommand("Pediatria");
		panel_4.add(RadioButtonPediatria);
		
		JPanel panelContratacion = new JPanel();
		panelDerecho.add(panelContratacion);
		panelContratacion.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panelContratacion.add(panel_7);
		
		JLabel lblNewLabel_2 = new JLabel("Contratacion");
		panel_7.add(lblNewLabel_2);
		
		JPanel panel_6 = new JPanel();
		panelContratacion.add(panel_6);
		
		JRadioButton RadioButtonPermanente = new JRadioButton("Plantel Permanente");
		RadioButtonPermanente.setActionCommand("Permanente");
		RadioButtonPermanente.setSelected(true);
		panel_6.add(RadioButtonPermanente);
		
		JRadioButton RadioButtonResidente = new JRadioButton("Residente");
		RadioButtonResidente.setActionCommand("Residente");
		panel_6.add(RadioButtonResidente);
		
		JPanel panelPosgrado = new JPanel();
		panelDerecho.add(panelPosgrado);
		panelPosgrado.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panelPosgrado.add(panel_9);
		
		JLabel lblNewLabel_3 = new JLabel("Titulo posgrado");
		panel_9.add(lblNewLabel_3);
		
		JPanel panel_8 = new JPanel();
		panelPosgrado.add(panel_8);
		
		JRadioButton RadioButtonNinguno = new JRadioButton("Ninguno");
		RadioButtonNinguno.setSelected(true);
		panel_8.add(RadioButtonNinguno);
		
		JRadioButton RadioButtonMagister = new JRadioButton("Magister");
		RadioButtonMagister.setActionCommand("Magister");
		panel_8.add(RadioButtonMagister);
		
		JRadioButton RadioButtonDoctor = new JRadioButton("Doctor");
		RadioButtonDoctor.setActionCommand("Doctorado");
		panel_8.add(RadioButtonDoctor);
		
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

		grupoEspecialidad.add(RadioButtonClinica);
		grupoEspecialidad.add(RadioButtonCirugia);
		grupoEspecialidad.add(RadioButtonPediatria);
		
		grupoContratacion.add(RadioButtonPermanente);
		grupoContratacion.add(RadioButtonResidente);	

		grupoPosgrado.add(RadioButtonNinguno);
		grupoPosgrado.add(RadioButtonMagister);
		grupoPosgrado.add(RadioButtonDoctor);
		
		this.actulizarLista();
		this.setVisible(true);
	}
	
	/**
	 * Metodo que actualiza la lista de Medicos
	 */
	public void actulizarLista() {
		
		this.listModel.clear();
		for(IMedico i: Clinica.getInstance().getMedicos().values()) {
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
				!this.getDomicilio().isEmpty() && !this.getCiudad().isEmpty() && !this.getTelefono().isEmpty() && !this.getMatricula().isEmpty();
		
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
	 * Metodo que devuelve la matricula escrito en el TextField
	 */
	@Override
	public String getMatricula()
	{
		return this.textFieldMatricula.getText();
	}

	/**
	 * Metodo que devuelve la especialidad seleccionada en el grupButton de los radioButtons
	 */
	@Override
	public String getEspecialidad()
	{
		return grupoEspecialidad.getSelection().getActionCommand();
	}
	
	/**
	 * Metodo que devuelve la contratacio seleccionada en el grupButton de los radioButtons
	 */
	@Override
	public String getContratacion()
	{
		return grupoContratacion.getSelection().getActionCommand();
	}
	
	/**
	 * Metodo que devuelve el Posgrado seleccionado en el grupButton de los radioButtons
	 */
	@Override
	public String getPosgrado()
	{
		return grupoPosgrado.getSelection().getActionCommand();
	}
	
	/**
	 * Metodo que devuelve el medico seleccionado en la lista 
	 */
	public IMedico getMedico() {
		return this.listMedicos.getSelectedValue();
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
		boolean condicionE = !this.listMedicos.isSelectionEmpty();
		
		this.btnEliminar.setEnabled(condicionE);
	}


	@Override
	public void mouseEntered(MouseEvent e) {
	}


	@Override
	public void mouseExited(MouseEvent e) {
	}


	

}
