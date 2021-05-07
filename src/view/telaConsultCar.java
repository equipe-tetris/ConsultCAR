package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;

public class telaConsultCar {

	private JFrame frame;
	private JTextField textInput;
	private JTextField textOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaConsultCar window = new telaConsultCar();
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
	public telaConsultCar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 831, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textInput = new JTextField();
		textInput.setBounds(118, 26, 575, 28);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		textOutput = new JTextField();
		textOutput.setColumns(10);
		textOutput.setBounds(118, 75, 575, 28);
		frame.getContentPane().add(textOutput);
		
		JLabel lblNewLabel = new JLabel("Arquivo/Entrada");
		lblNewLabel.setBounds(21, 26, 87, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDiretriosaida = new JLabel("Diret\u00F3rio/Saida");
		lblDiretriosaida.setBounds(21, 75, 87, 21);
		frame.getContentPane().add(lblDiretriosaida);
		
		JButton btnProcessar = new JButton("Processar");
		btnProcessar.setBounds(283, 137, 227, 45);
		frame.getContentPane().add(btnProcessar);
		
		JTextArea textConsole = new JTextArea();
		textConsole.setBackground(Color.LIGHT_GRAY);
		textConsole.setBounds(41, 218, 740, 253);
		frame.getContentPane().add(textConsole);
	}
}
