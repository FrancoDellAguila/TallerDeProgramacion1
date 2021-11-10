package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador_Facturacion;
import decorators.IMedico;
import modelo.Clinica;
import modelo.Compartida;
import modelo.ConsultaMedica;
import modelo.Factura;
import modelo.Habitacion;
import modelo.Medico;
import modelo.Paciente;
import modelo.Privada;
import modelo.TerapiaIntensiva;

import persistencia.IPersistencia;
import persistencia.Persistencia;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
 
/**
 * @author Betti Francisco, Kollman Deborah, Stimmler Francisco, Veitch Matias
 *<br>
 *Clase que representa la ventana encargada de mostrar todo el proceso de facturación. Se extiende de JFrame e implementa KeyListener e IVistaFacturacion.
 */
public class Ventana_Facturacion extends JFrame implements  KeyListener , IVistaFacturacion {

	private JPanel contentPane;
	private JTextField textField_Dias;
	private JTextField textField_Consultas;
	private JButton btnAgregarMedico;
	private JButton btnAgregarHabitacion;
	private JButton btnFacturar;
	
	private JButton btnMostrarFacturas;
	private JButton btnMostrarFacturasFecha;
	
	private JComboBox<Habitacion> comboBox_Habitacion;
	private JComboBox<Paciente> comboBox_Paciente;
	private ComboBoxRendererMedico rendererMedico = new ComboBoxRendererMedico();
	private ComboBoxRendererPaciente rendererPaciente = new ComboBoxRendererPaciente();
	private JTextArea textArea_Facturas;
	private JComboBox<IMedico> comboBox_Medico;
	private JButton btnBorrarUltimaFactura;
	private JButton btnBorrarTodo;
	private DatePicker calendario1;
	private DatePicker calendario2;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;

	private Calendar calendarioInicio;
	private Calendar calendarioFin;
	
	/**
	 * Constructor sin parámetros para setear la ventana de facturación.
	 */
	public Ventana_Facturacion() {
	    
		setFocusable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 980, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
				
		try {
			ClassLoader cl = this.getClass().getClassLoader();
			ImageIcon programIcon = new ImageIcon(cl.getResource("res/test.png"));
			setIconImage(programIcon.getImage());
		} catch (Exception whoJackedMyIcon) {
			System.out.println("Could not load program icon.");
		}
		
		JPanel panel_izquierda = new JPanel();
		contentPane.add(panel_izquierda, BorderLayout.WEST);
		GridBagLayout gbl_panel_izquierda = new GridBagLayout();
		gbl_panel_izquierda.columnWidths = new int[] {380};
		gbl_panel_izquierda.rowHeights = new int[] {14, 0, 0};
		gbl_panel_izquierda.columnWeights = new double[]{1.0};
		gbl_panel_izquierda.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_izquierda.setLayout(gbl_panel_izquierda);
		
		JPanel panel_lvl_Facturas = new JPanel();
		GridBagConstraints gbc_panel_lvl_Facturas = new GridBagConstraints();
		gbc_panel_lvl_Facturas.insets = new Insets(0, 0, 5, 0);
		gbc_panel_lvl_Facturas.fill = GridBagConstraints.BOTH;
		gbc_panel_lvl_Facturas.gridx = 0;
		gbc_panel_lvl_Facturas.gridy = 0;
		panel_izquierda.add(panel_lvl_Facturas, gbc_panel_lvl_Facturas);
		GridBagLayout gbl_panel_lvl_Facturas = new GridBagLayout();
		gbl_panel_lvl_Facturas.columnWidths = new int[]{46, 0};
		gbl_panel_lvl_Facturas.rowHeights = new int[]{14, 0};
		gbl_panel_lvl_Facturas.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_lvl_Facturas.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_lvl_Facturas.setLayout(gbl_panel_lvl_Facturas);
		
		JLabel lblFacturas = new JLabel("Facturas:");
		GridBagConstraints gbc_lblFacturas = new GridBagConstraints();
		gbc_lblFacturas.gridx = 0;
		gbc_lblFacturas.gridy = 0;
		panel_lvl_Facturas.add(lblFacturas, gbc_lblFacturas);
		
		JScrollPane scrollPane_Facturas = new JScrollPane();
		GridBagConstraints gbc_scrollPane_Facturas = new GridBagConstraints();
		gbc_scrollPane_Facturas.gridwidth = 2;
		gbc_scrollPane_Facturas.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_Facturas.gridx = 0;
		gbc_scrollPane_Facturas.gridy = 1;
		
		panel_izquierda.add(scrollPane_Facturas, gbc_scrollPane_Facturas);
		
		textArea_Facturas = new JTextArea();
		textArea_Facturas.setLineWrap(true);
		scrollPane_Facturas.setViewportView(textArea_Facturas);

		this.actualizar();
		
		JPanel panel_Derecho = new JPanel();
		contentPane.add(panel_Derecho, BorderLayout.EAST);
		panel_Derecho.setLayout(new BorderLayout(35, 0));
		
		JPanel panel_Superior_Paciente = new JPanel();
		panel_Derecho.add(panel_Superior_Paciente, BorderLayout.NORTH);
		panel_Superior_Paciente.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
		
		JPanel panel_Paciente = new JPanel();
		FlowLayout fl_panel_Paciente = (FlowLayout) panel_Paciente.getLayout();
		fl_panel_Paciente.setHgap(30);
		fl_panel_Paciente.setAlignment(FlowLayout.LEADING);
		panel_Superior_Paciente.add(panel_Paciente);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		panel_Paciente.add(lblPaciente);
		
		JPanel panel_Lista = new JPanel();
		FlowLayout fl_panel_Lista = (FlowLayout) panel_Lista.getLayout();
		fl_panel_Lista.setHgap(30);
		panel_Superior_Paciente.add(panel_Lista);
		
		comboBox_Paciente = new JComboBox<Paciente>();
		for(Paciente i:Clinica.getInstance().getPacientesRegistrados().values()) {

			comboBox_Paciente.addItem(i);	
		}
		comboBox_Paciente.setRenderer(this.rendererPaciente);
		comboBox_Paciente.setMaximumRowCount(3);
		panel_Lista.add(comboBox_Paciente);
		
		btnBorrarUltimaFactura = new JButton("Borrar ultima");
		this.btnBorrarUltimaFactura.setActionCommand("Borrar ultima");
		panel_Superior_Paciente.add(btnBorrarUltimaFactura);
		
		btnBorrarTodo = new JButton("Borrar todo");
		this.btnBorrarTodo.setActionCommand("Borrar todo");
		panel_Superior_Paciente.add(btnBorrarTodo);
		
		JPanel panel_Central_Agregar = new JPanel();
		panel_Derecho.add(panel_Central_Agregar, BorderLayout.CENTER);
		panel_Central_Agregar.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Medio_Habitacion = new JPanel();
		FlowLayout fl_panel_Medio_Habitacion = (FlowLayout) panel_Medio_Habitacion.getLayout();
		fl_panel_Medio_Habitacion.setHgap(15);
		fl_panel_Medio_Habitacion.setVgap(20);
		panel_Central_Agregar.add(panel_Medio_Habitacion, BorderLayout.NORTH);
		
		JPanel panel_Habitacion = new JPanel();
		FlowLayout fl_panel_Habitacion = (FlowLayout) panel_Habitacion.getLayout();
		fl_panel_Habitacion.setHgap(20);
		panel_Medio_Habitacion.add(panel_Habitacion);
		
		JLabel lblHabitacion = new JLabel("Habitacion");
		panel_Habitacion.add(lblHabitacion);
		
		JPanel panel_Lista_Habitacion = new JPanel();
		panel_Medio_Habitacion.add(panel_Lista_Habitacion);
		
		comboBox_Habitacion = new JComboBox<Habitacion>();
		comboBox_Habitacion.setMaximumRowCount(3);
		
		for(Habitacion i:Clinica.getInstance().getHabitaciones().values()) {

			comboBox_Habitacion.addItem(i);	
		}
		panel_Lista_Habitacion.add(comboBox_Habitacion);
		
		JPanel panel_Dias = new JPanel();
		panel_Medio_Habitacion.add(panel_Dias);
		panel_Dias.setLayout(new BorderLayout(0, 0));
		
		textField_Dias = new JTextField();
		textField_Dias.addKeyListener(this);
		panel_Dias.add(textField_Dias);
		textField_Dias.setColumns(6);
		
		JPanel panel_lblDias = new JPanel();
		panel_Dias.add(panel_lblDias, BorderLayout.NORTH);
		
		JLabel lblDias = new JLabel("Dias");
		panel_lblDias.add(lblDias);
		
		btnAgregarHabitacion = new JButton("Agregar habitacion");
		this.btnAgregarHabitacion.setActionCommand("Agregar habitacion");
		
		this.btnAgregarHabitacion.setEnabled(false);
		panel_Medio_Habitacion.add(btnAgregarHabitacion);
		
		JPanel panel_Inferior_Medico_Start = new JPanel();
		panel_Central_Agregar.add(panel_Inferior_Medico_Start, BorderLayout.CENTER);
		panel_Inferior_Medico_Start.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Inferior_Medico = new JPanel();
		FlowLayout fl_panel_Inferior_Medico = (FlowLayout) panel_Inferior_Medico.getLayout();
		fl_panel_Inferior_Medico.setHgap(15);
		fl_panel_Inferior_Medico.setVgap(20);
		panel_Inferior_Medico_Start.add(panel_Inferior_Medico, BorderLayout.NORTH);
		
		JPanel panel_Medico = new JPanel();
		FlowLayout fl_panel_Medico = (FlowLayout) panel_Medico.getLayout();
		fl_panel_Medico.setHgap(30);
		panel_Inferior_Medico.add(panel_Medico);
		
		JLabel lblMedico = new JLabel("Medico");
		panel_Medico.add(lblMedico);
		
		JPanel panel_Lista_Medico = new JPanel();
		panel_Inferior_Medico.add(panel_Lista_Medico);
		
		comboBox_Medico = new JComboBox<IMedico>();
		for(IMedico i:Clinica.getInstance().getMedicos().values()) {

			comboBox_Medico.addItem(i);	
		}
		comboBox_Medico.setRenderer(this.rendererMedico);
		panel_Lista_Medico.add(comboBox_Medico);
		
		JPanel panel_Consultas = new JPanel();
		panel_Inferior_Medico.add(panel_Consultas);
		panel_Consultas.setLayout(new BorderLayout(0, 0));
		
		textField_Consultas = new JTextField();
		textField_Consultas.addKeyListener(this);
		panel_Consultas.add(textField_Consultas);
		textField_Consultas.setColumns(6);
		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Consultas.add(lblConsultas, BorderLayout.NORTH);
		
		btnAgregarMedico = new JButton("Agregar consultas");
		this.btnAgregarMedico.setActionCommand("Agregar consultas");
		this.btnAgregarMedico.setEnabled(false);
		panel_Inferior_Medico.add(btnAgregarMedico);
		
		btnFacturar = new JButton("Facturar");
		this.btnFacturar.setActionCommand("Facturar");
		this.btnFacturar.setEnabled(false);
		panel_Inferior_Medico_Start.add(btnFacturar, BorderLayout.SOUTH);
		
		JPanel panelFecha = new JPanel();
		panel_Inferior_Medico_Start.add(panelFecha, BorderLayout.CENTER);
		this.setVisible(true);
		
		calendario1 = new DatePicker();
		calendario2 = new DatePicker();
		panelFecha.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panelFecha.add(panel);
		
		btnMostrarFacturas = new JButton("Mostrar todas las facturas");
		btnMostrarFacturas.setActionCommand("MostrarFacturas");
		panel.add(btnMostrarFacturas);
		
		JPanel panel_1 = new JPanel();
		panelFecha.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JButton btnFechaInicio = new JButton("Fecha inicio");
		panel_2.add(btnFechaInicio);
		
		txtFechaInicio = new JTextField();
		panel_2.add(txtFechaInicio);
		txtFechaInicio.setEditable(false);
		txtFechaInicio.setColumns(10);
		
		Ventana_Facturacion facturacion = this;		
		btnFechaInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendario1.popupShow(btnFechaInicio, facturacion, true);
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JButton btnFechaFin = new JButton("Fecha fin");
		panel_3.add(btnFechaFin);
		
		txtFechaFin = new JTextField();
		panel_3.add(txtFechaFin);
		txtFechaFin.setEditable(false);
		txtFechaFin.setColumns(10);
		btnFechaFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendario2.popupShow(btnFechaFin, facturacion, false);
			}
		});
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		btnMostrarFacturasFecha = new JButton("Mostrar facturas");
		btnMostrarFacturasFecha.setActionCommand("MostrarFacturasFecha");
		panel_4.add(btnMostrarFacturasFecha);
		
		btnMostrarFacturasFecha.setEnabled(false);
	}

	/**
	 * Método que quita la información que se está mostrando en el área de las facturas y completa con la información de todas las facturas de la clínica.
	 */
	public void actualizar() {
		textArea_Facturas.setText(null);
		for(Factura i:Clinica.getInstance().getFacturas()) {
    		textArea_Facturas.append(i.mostrarFactura());
		}
	}
	
	/**
	 * Método que habilita o deshabilita el botón de facturar.
	 */
	public void setEnablebtnFacturar(boolean bool) {
		this.btnFacturar.setEnabled(bool);
	}
	
	public IMedico getMedico() {
		return (IMedico) this.comboBox_Medico.getSelectedItem();
	}

	public Habitacion getHabitacion() {
		return (Habitacion) this.comboBox_Habitacion.getSelectedItem();
	}
	
	/**
	 * Método que devuelve la cantidad de días que un paciente permaneció en una habitación. El dato está como texto y le realiza un parseo a int.
	 * <br>
	 * @return devuelve un int con la cantidad de días que un paciente permaneció en una habitación.
	 */
	public int getCantDias() {
		try {
		return Integer.parseInt(this.textField_Dias.getText());
		}catch(NumberFormatException e) {
			return 0;
		}
	}
	
	/**
	 * Método que devuelve la cantidad de consultas que realizó un paciente. El dato está como texto y le realiza un parseo a int.
	 * <br>
	 * @return devuelve un int con la cantidad de consultas que realizó un paciente.
	 */
	public int getCantConsultas() {
		try {
			return Integer.parseInt(this.textField_Consultas.getText());
			}catch(NumberFormatException e) {
				return 0;
			}
	}
	
	public Paciente getPaciente() {
		return (Paciente) this.comboBox_Paciente.getSelectedItem();
	}
	
	/**
	 * Se sobreescribe el método addActionListener, en el cual se le asignará un ActionListener a distintos botones.
     * @param listener: parametro de tipo ActionListener que representa al listener que se le asignará a los distintos botones.
	 */
	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAgregarHabitacion.addActionListener(listener);
		this.btnAgregarMedico.addActionListener(listener);
		this.btnFacturar.addActionListener(listener);
		this.btnBorrarUltimaFactura.addActionListener(listener);
		this.btnBorrarTodo.addActionListener(listener);
		this.btnMostrarFacturas.addActionListener(listener);
		this.btnMostrarFacturasFecha.addActionListener(listener);
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
	
	
		int cantDias = 0;
		int consultas = 0;

		cantDias = this.getCantDias();
		consultas = this.getCantConsultas();

		boolean condicionh =  cantDias > 0;
		boolean condicionm = consultas > 0;
		
		boolean condicionf = this.calendarioInicio != null && this.calendarioFin != null;
		
		this.btnAgregarHabitacion.setEnabled(condicionh);
		this.btnAgregarMedico.setEnabled(condicionm);
		this.btnMostrarFacturasFecha.setEnabled(condicionf);
	}

	public ComboBoxRendererMedico getRendererMedico() {
		return rendererMedico;
	}

	public void setRendererMedico(ComboBoxRendererMedico rendererMedico) {
		this.rendererMedico = rendererMedico;
	}

	public ComboBoxRendererPaciente getRendererPaciente() {
		return rendererPaciente;
	}

	public void setRendererPaciente(ComboBoxRendererPaciente rendererPaciente) {
		this.rendererPaciente = rendererPaciente;
	}

	/**
	 * Método que devuelve la fecha inicio del intervalo
	 */
	@Override
	public Calendar getFechaInicio() {
		
		return this.calendarioInicio;
	}


	/**
	 * Método que devuelve la fecha final del intervalo
	 */
	@Override
	public Calendar getFechaFin() {
		
		return this.calendarioFin;
	}

	public void SetFechaInicio(Calendar c)
	{
		this.txtFechaInicio.setText(c.getTime().getDate() + "/" + (c.getTime().getMonth()+1) + "/" + (c.getTime().getYear()+1900));
		this.calendarioInicio = c;
		
		keyReleased(null);
	}

	public void SetFechaFin(Calendar c)
	{
		
		this.txtFechaFin.setText(c.getTime().getDate() + "/" + (c.getTime().getMonth()+1) + "/" + (c.getTime().getYear()+1900));
		
		this.calendarioFin = c;
		
		keyReleased(null);
	}

	@Override
	public void mostrarFacturas(String facturas) {
		textArea_Facturas.setText(null);
		textArea_Facturas.append(facturas);
		
	}

}
