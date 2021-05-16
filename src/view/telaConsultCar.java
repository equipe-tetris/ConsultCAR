package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JTextField;

import db_connection.conexaoDB;
import unzip.DescompactadorZip;
import unzip.logSystem;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class telaConsultCar {

	private JFrame frame;
	private JTextField textInput;
	private JTextField textOutput;
	public String input;

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
		
		DescompactadorZip unzipper = new DescompactadorZip();
		logSystem log = new logSystem();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 676, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textInput = new JTextField("C:\\Users\\Davi Machado\\Desktop\\ConsultCar\\ArquivoCompactado");
		textInput.setBounds(142, 22, 487, 28);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		textOutput = new JTextField("C:\\Users\\Davi Machado\\Desktop\\ConsultCar\\ArquivoDescompactado");
		textOutput.setColumns(10);
		textOutput.setBounds(142, 71, 487, 28);
		frame.getContentPane().add(textOutput);
		
		JLabel lblNewLabel = new JLabel("Diret\u00F3rio/Entrada:");
		lblNewLabel.setBounds(21, 26, 87, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDiretriosaida = new JLabel("Diret\u00F3rio/Saida:");
		lblDiretriosaida.setBounds(21, 75, 87, 21);
		frame.getContentPane().add(lblDiretriosaida);
		
		JButton btnProcessar = new JButton("Descompactar");
		btnProcessar.setBounds(118, 145, 183, 45);
		frame.getContentPane().add(btnProcessar);
		
		JButton btnConexao = new JButton("Importar DB");
		btnConexao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConexao.setBounds(366, 145, 183, 45);
		frame.getContentPane().add(btnConexao);
		
		
		JTextArea consoleText = new JTextArea();
		consoleText.setBounds(21, 215, 616, 288);
		frame.getContentPane().add(consoleText);
		
		
		btnProcessar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					log.logWriter("Iniciando processo de descompactação");
					
					unzipper.unzipZipsInDirTo(
							Paths.get(textInput.getText()), 
							Paths.get(textOutput.getText()));
					
					log.logWriter("Encerrando processo de descompactação");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
			}
			
		});
			
		
		btnConexao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					conexaoDB conexao = new conexaoDB();
					log.logWriter("Conexão com Banco de Dados realizada com sucesso!!!");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		
	}
}
