package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Monitor;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	private JTextField textAdivina;
	private JTextField textResultado;
	private Monitor controladorJuego;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego frame = new VentanaJuego();
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
	public VentanaJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Juego adivinar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		textResultado = new JTextField();
		textResultado.setEnabled(false);
		panel_2.add(textResultado);
		textResultado.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		textAdivina = new JTextField();
		textAdivina.setColumns(10);
		panel_3.add(textAdivina);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton btnAdivina = new JButton("Adivina");
		panel_4.add(btnAdivina);
		
		JButton btnJuegoNuevo = new JButton("Juego Nuevo");
		panel_4.add(btnJuegoNuevo);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
	}

}
