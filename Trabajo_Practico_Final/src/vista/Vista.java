package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame implements IVista  {

	private JPanel contentPane;
	private JPanel panel_pacientes;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_PersistirMedicos;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_PersistirFacturas;
	private JTextField textField_pacientes;
	private JTextField textField_medicos;
	private JTextField textField_facturas;
	private JButton btnNewButton_Cerrar;
	private JPanel panel;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JButton btnNewButton_PersistirPacientes;
	private Controlador controladorVista;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel_pacientes = new JPanel();
		this.contentPane.add(this.panel_pacientes);
		
		this.lblNewLabel = new JLabel("Persistir Pacientes");
		this.panel_pacientes.add(this.lblNewLabel);
		
		btnNewButton_PersistirPacientes = new JButton("Persistir");
		this.btnNewButton_PersistirPacientes.setActionCommand("PersistirPacientes");
		
		this.panel_pacientes.add(btnNewButton_PersistirPacientes);
		
		this.textField_pacientes = new JTextField();
		this.textField_pacientes.setEditable(false);
		this.panel_pacientes.add(this.textField_pacientes);
		this.textField_pacientes.setColumns(10);
		
		this.panel_1 = new JPanel();
		this.contentPane.add(this.panel_1);
		
		this.lblNewLabel_1 = new JLabel("Persistir medicos");
		this.panel_1.add(this.lblNewLabel_1);
		
		this.btnNewButton_PersistirMedicos = new JButton("Persistir");
		this.btnNewButton_PersistirMedicos.setActionCommand("PersistirMedicos");
		
		this.panel_1.add(this.btnNewButton_PersistirMedicos);
		
		this.textField_medicos = new JTextField();
		this.textField_medicos.setEditable(false);
		this.textField_medicos.setText("");
		this.panel_1.add(this.textField_medicos);
		this.textField_medicos.setColumns(10);
		
		this.panel_2 = new JPanel();
		this.contentPane.add(this.panel_2);
		
		this.lblNewLabel_2 = new JLabel("Persistir facturas");
		this.panel_2.add(this.lblNewLabel_2);
		
		this.btnNewButton_PersistirFacturas = new JButton("Persistir");
		this.btnNewButton_PersistirFacturas.setActionCommand("PersistirFacturas");
		
		this.panel_2.add(this.btnNewButton_PersistirFacturas);
		
		this.textField_facturas = new JTextField();
		this.textField_facturas.setEditable(false);
		this.panel_2.add(this.textField_facturas);
		this.textField_facturas.setColumns(10);
		
		this.panel_3 = new JPanel();
		this.contentPane.add(this.panel_3);
		this.panel_3.setLayout(new GridLayout(0, 4, 0, 0));
		
		this.panel = new JPanel();
		this.panel_3.add(this.panel);
		
		this.panel_4 = new JPanel();
		this.panel_3.add(this.panel_4);
		
		this.panel_5 = new JPanel();
		this.panel_3.add(this.panel_5);
		
		this.panel_6 = new JPanel();
		this.panel_3.add(this.panel_6);
		
		this.btnNewButton_Cerrar = new JButton("Cerrar");
		
		this.panel_6.add(this.btnNewButton_Cerrar);
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
		this.btnNewButton_Cerrar.addActionListener(c);
		this.btnNewButton_PersistirFacturas.addActionListener(c);
		this.btnNewButton_PersistirMedicos.addActionListener(c);
		this.btnNewButton_PersistirPacientes.addActionListener(c);
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
	
	public void cerrar() {
		this.setVisible(false);
	}
}
