package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtOperando;
	private JTextField txtOperando_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Operando 1");
		panel.add(lblNewLabel);
		
		txtOperando = new JTextField();
		txtOperando.setText("Operando 1");
		panel.add(txtOperando);
		txtOperando.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Operando 2");
		panel_2.add(lblNewLabel_1);
		
		txtOperando_1 = new JTextField();
		txtOperando_1.setText("Operando 2");
		panel_2.add(txtOperando_1);
		txtOperando_1.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("+");
		rdbtnNewRadioButton_1.setBounds(6, 5, 54, 23);
		panel_4.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("-");
		rdbtnNewRadioButton.setBounds(81, 5, 54, 23);
		panel_4.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("*");
		rdbtnNewRadioButton_2.setBounds(6, 53, 54, 23);
		panel_4.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("/");
		rdbtnNewRadioButton_3.setBounds(81, 53, 54, 23);
		panel_4.add(rdbtnNewRadioButton_3);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		panel_6.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		JButton btnNewButton = new JButton("Calcular");
		panel_7.add(btnNewButton);
		
		JPanel panel_8 = new JPanel();
		contentPane.add(panel_8);
	}

	@Override
	public void arranca() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void setControlador(Monitor m) {
		// TODO Auto-generated method stub
	}
	
}
