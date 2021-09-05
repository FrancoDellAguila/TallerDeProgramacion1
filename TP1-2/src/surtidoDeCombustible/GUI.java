package surtidoDeCombustible;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;

public class GUI {

	private JFrame frame;
	private JTextField txtManguera;
	private JTextField txtManguera_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 571, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Inicializar");
		btnNewButton.setBounds(10, 11, 240, 128);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cargar Surtidor");
		btnNewButton_1.setBounds(305, 11, 240, 128);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Activar Manguera 1");
		btnNewButton_2.setBounds(10, 212, 240, 55);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Activar Manguera 2");
		btnNewButton_3.setBounds(10, 308, 240, 55);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Desactivar Manguera 1");
		btnNewButton_4.setBounds(305, 212, 240, 55);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Desactivar Manguera 2");
		btnNewButton_5.setBounds(305, 308, 240, 55);
		frame.getContentPane().add(btnNewButton_5);
		
		txtManguera = new JTextField();
		txtManguera.setText("Manguera 2");
		txtManguera.setBounds(241, 277, 66, 20);
		frame.getContentPane().add(txtManguera);
		txtManguera.setColumns(10);
		
		txtManguera_1 = new JTextField();
		txtManguera_1.setText("Manguera 1");
		txtManguera_1.setBounds(241, 181, 66, 20);
		frame.getContentPane().add(txtManguera_1);
		txtManguera_1.setColumns(10);
	}
}
