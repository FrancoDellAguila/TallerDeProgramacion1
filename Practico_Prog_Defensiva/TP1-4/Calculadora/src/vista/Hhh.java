package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hhh implements IVentana{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hhh window = new Hhh();
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
	public Hhh() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3, 3, 0, 0));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Operando 1");
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("Operando 1");
		textField.setColumns(10);
		panel_1.add(textField);
		
		JPanel panel_7 = new JPanel();
		frame.getContentPane().add(panel_7);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Operando 2");
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setText("Operando 2");
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JPanel panel_8 = new JPanel();
		frame.getContentPane().add(panel_8);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("+");
		rdbtnNewRadioButton_1.setBounds(6, 7, 60, 23);
		panel_4.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("-");
		rdbtnNewRadioButton_2.setBounds(78, 7, 60, 23);
		panel_4.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("*");
		rdbtnNewRadioButton_3.setBounds(6, 55, 60, 25);
		panel_4.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("/");
		rdbtnNewRadioButton.setBounds(78, 56, 60, 23);
		panel_4.add(rdbtnNewRadioButton);
		
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5);
		
		JPanel panel_6 = new JPanel();
		frame.getContentPane().add(panel_6);
		
		JPanel panel_3 = new JPanel();
		panel_6.add(panel_3);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton = new JButton("Calcular");
		panel_2.add(btnNewButton);
	}

	@Override
	public void arranca() {
		pack();
		setLocationRelativeTo(null);
		setVisibleTrue();
	}

	@Override
	public void setControlador(Monitor m) {
		// TODO Auto-generated method stub
		
	}
}
