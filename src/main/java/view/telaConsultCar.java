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
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextField;

import db_connection.ConnectionFactory;
import shape.ShapeService;
import tools.ConsoleService;
import tools.DescompactadorZip;
import tools.LogSystem;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class TelaConsultCar {

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
					TelaConsultCar window = new TelaConsultCar();
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
	public TelaConsultCar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		DescompactadorZip unzipper = new DescompactadorZip();
		LogSystem log = new LogSystem();
		ShapeService shape = new ShapeService();
		ConsoleService console = new ConsoleService();
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 676, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textInput = new JTextField("C:\\Users\\Davi Machado\\Desktop\\ConsultCar\\Zip");
		textInput.setBounds(142, 22, 487, 28);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		textOutput = new JTextField("C:\\Users\\Davi Machado\\Desktop\\ConsultCar\\Unzip");
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
					shape.dbfItem();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//log.logWriter("Conexão com Banco de Dados realizada com sucesso!!!");
			}
			
		});
		
		console.carregarConsole(consoleText);
		
	}
}