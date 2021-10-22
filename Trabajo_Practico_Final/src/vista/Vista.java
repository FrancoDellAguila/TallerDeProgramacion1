package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.IMedico;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Vista extends JFrame implements IVista  {

	private JPanel contentPane;
	private Controlador controladorVista;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JButton btnNewButton_PersistirMedicos;
	private JTextField textField_medicos;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_PersistirPacientes;
	private JTextField textField_pacientes;
	private JPanel panel_8;
	private JPanel panel_9;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_PersistirFactura;
	private JTextField textField_facturas;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel lblNewLabel_3;
	private JTextField textField_nombre;
	private JLabel lblNewLabel_4;
	private JTextField textField_apellido;
	private JLabel lblNewLabel_5;
	private JTextField textField_dni;
	private JLabel lblNewLabel_6;
	private JTextField textField_ciudad;
	private JLabel lblNewLabel_7;
	private JTextField textField_domicilio;
	private JLabel lblNewLabel_8;
	private JTextField textField_telefono;
	private JLabel lblNewLabel_9;
	private JTextField textField_matricula;
	private JLabel lblNewLabel_10;
	private JTextField textField_especialidad;
	private JLabel lblNewLabel_11;
	private JTextField textField_posgrado;
	private JLabel lblNewLabel_12;
	private JTextField textField_contratacion;
	private JButton btnNewButton_agregarMedico;
	private JPanel panel_12;
	private JScrollPane scrollPane;
	private JTextArea textArea_medicos;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.contentPane.add(this.tabbedPane, BorderLayout.CENTER);
		
		this.panel = new JPanel();
		this.tabbedPane.addTab("Persistencia", null, this.panel, null);
		this.panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panel_1 = new JPanel();
		this.panel.add(this.panel_1);
		
		this.lblNewLabel = new JLabel("Persistir medicos");
		this.panel_1.add(this.lblNewLabel);
		
		this.btnNewButton_PersistirMedicos = new JButton("Persistir");
		this.btnNewButton_PersistirMedicos.setActionCommand("PersistirMedicos");
		this.panel_1.add(this.btnNewButton_PersistirMedicos);
		
		this.textField_medicos = new JTextField();
		this.textField_medicos.setText("");
		this.textField_medicos.setEditable(false);
		this.textField_medicos.setColumns(10);
		this.panel_1.add(this.textField_medicos);
		
		this.panel_2 = new JPanel();
		this.panel.add(this.panel_2);
		
		this.lblNewLabel_1 = new JLabel("Persistir pacientes");
		this.panel_2.add(this.lblNewLabel_1);
		
		this.btnNewButton_PersistirPacientes = new JButton("Persistir");
		this.btnNewButton_PersistirPacientes.setActionCommand("PersistirPacientes");
		this.panel_2.add(this.btnNewButton_PersistirPacientes);
		
		this.textField_pacientes = new JTextField();
		this.textField_pacientes.setEditable(false);
		this.textField_pacientes.setColumns(10);
		this.panel_2.add(this.textField_pacientes);
		
		this.panel_9 = new JPanel();
		this.panel.add(this.panel_9);
		
		this.lblNewLabel_2 = new JLabel("Persistir facturas");
		this.panel_9.add(this.lblNewLabel_2);
		
		this.btnNewButton_PersistirFactura = new JButton("Persistir");
		this.btnNewButton_PersistirFactura.setActionCommand("PersistirFacturas");
		this.panel_9.add(this.btnNewButton_PersistirFactura);
		
		this.textField_facturas = new JTextField();
		this.textField_facturas.setEditable(false);
		this.textField_facturas.setColumns(10);
		this.panel_9.add(this.textField_facturas);
		
		this.panel_8 = new JPanel();
		this.tabbedPane.addTab("Agregar Medico", null, this.panel_8, null);
		this.panel_8.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_10 = new JPanel();
		this.panel_8.add(this.panel_10);
		this.panel_10.setLayout(new GridLayout(11, 2, 0, 0));
		
		this.lblNewLabel_3 = new JLabel("Nombre");
		this.panel_10.add(this.lblNewLabel_3);
		
		this.textField_nombre = new JTextField();
		this.panel_10.add(this.textField_nombre);
		this.textField_nombre.setColumns(10);
		
		this.lblNewLabel_4 = new JLabel("Apellido");
		this.panel_10.add(this.lblNewLabel_4);
		
		this.textField_apellido = new JTextField();
		this.panel_10.add(this.textField_apellido);
		this.textField_apellido.setColumns(10);
		
		this.lblNewLabel_5 = new JLabel("DNI");
		this.panel_10.add(this.lblNewLabel_5);
		
		this.textField_dni = new JTextField();
		this.panel_10.add(this.textField_dni);
		this.textField_dni.setColumns(10);
		
		this.lblNewLabel_6 = new JLabel("Ciudad");
		this.panel_10.add(this.lblNewLabel_6);
		
		this.textField_ciudad = new JTextField();
		this.panel_10.add(this.textField_ciudad);
		this.textField_ciudad.setColumns(10);
		
		this.lblNewLabel_7 = new JLabel("Domicilio");
		this.panel_10.add(this.lblNewLabel_7);
		
		this.textField_domicilio = new JTextField();
		this.panel_10.add(this.textField_domicilio);
		this.textField_domicilio.setColumns(10);
		
		this.lblNewLabel_8 = new JLabel("Telefono");
		this.panel_10.add(this.lblNewLabel_8);
		
		this.textField_telefono = new JTextField();
		this.panel_10.add(this.textField_telefono);
		this.textField_telefono.setColumns(10);
		
		this.lblNewLabel_9 = new JLabel("Matricula");
		this.panel_10.add(this.lblNewLabel_9);
		
		this.textField_matricula = new JTextField();
		this.panel_10.add(this.textField_matricula);
		this.textField_matricula.setColumns(10);
		
		this.lblNewLabel_10 = new JLabel("Especialidad");
		this.panel_10.add(this.lblNewLabel_10);
		
		this.textField_especialidad = new JTextField();
		this.panel_10.add(this.textField_especialidad);
		this.textField_especialidad.setColumns(10);
		
		this.lblNewLabel_11 = new JLabel("Posgrado");
		this.panel_10.add(this.lblNewLabel_11);
		
		this.textField_posgrado = new JTextField();
		this.panel_10.add(this.textField_posgrado);
		this.textField_posgrado.setColumns(10);
		
		this.lblNewLabel_12 = new JLabel("Contrataci\u00F3n");
		this.panel_10.add(this.lblNewLabel_12);
		
		this.textField_contratacion = new JTextField();
		this.panel_10.add(this.textField_contratacion);
		this.textField_contratacion.setColumns(10);
		
		this.panel_12 = new JPanel();
		this.panel_10.add(this.panel_12);
		
		this.btnNewButton_agregarMedico = new JButton("Agregar Medico");
		this.btnNewButton_agregarMedico.setActionCommand("AgregarMedico");
		this.panel_10.add(this.btnNewButton_agregarMedico);
		
		this.panel_11 = new JPanel();
		this.panel_8.add(this.panel_11);
		this.panel_11.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panel_11.add(this.scrollPane);
		
		this.textArea_medicos = new JTextArea();
		this.scrollPane.setViewportView(this.textArea_medicos);
	}

	@Override
	public void arranca() {
		pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}

	@Override
	public void setControlador(Controlador c) {
		this.controladorVista=c;
		this.btnNewButton_PersistirFactura.addActionListener(c);
		this.btnNewButton_PersistirMedicos.addActionListener(c);
		this.btnNewButton_PersistirPacientes.addActionListener(c);
		this.btnNewButton_agregarMedico.addActionListener(c);
	}

	@Override
	public void informaStatusPacientes(String status) {
		this.textField_pacientes.setText(status);
	}

	@Override
	public void informaStatusMedicos(String status) {
		this.textField_medicos.setText(status);
	}

	@Override
	public void informaStatusFacturas(String status) {
		this.textField_facturas.setText(status);
	}
	

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.textField_nombre.getText();
	}

	@Override
	public String getApellido() {
		// TODO Auto-generated method stub
		return this.textField_apellido.getText();
	}

	@Override
	public String getDNI() {
		// TODO Auto-generated method stub
		return this.textField_dni.getText();
	}

	@Override
	public String getDomicilio() {
		// TODO Auto-generated method stub
		return this.textField_domicilio.getText();
	}

	@Override
	public String getCiudad() {
		// TODO Auto-generated method stub
		return this.textField_ciudad.getText();
	}

	@Override
	public String getTelefono() {
		// TODO Auto-generated method stub
		return this.textField_telefono.getText();
	}

	@Override
	public String getMatricula() {
		// TODO Auto-generated method stub
		return this.textField_matricula.getText();
	}

	@Override
	public String getEspecialidad() {
		// TODO Auto-generated method stub
		return this.textField_especialidad.getText();
	}

	@Override
	public String getPosgrado() {
		// TODO Auto-generated method stub
		return this.textField_posgrado.getText();
	}

	@Override
	public String getContratacion() {
		// TODO Auto-generated method stub
		return this.textField_contratacion.getText();
	}

	@Override
	public void getMedicos(ArrayList<IMedico> medicos) {
		this.textArea_medicos.setText("");
		Iterator<IMedico> it= medicos.iterator();
		while(it.hasNext()) {
			this.textArea_medicos.append(it.next().toString()+"\n");
		}
	}

	@Override
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
