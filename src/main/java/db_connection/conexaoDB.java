package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class conexaoDB {
	
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	
	public conexaoDB(){
		url = "jdbc:postgresql://localhost:5432/consultcar";
		usuario = "postgres";
		senha = "postgres";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			JOptionPane.showMessageDialog(null, "Conexão Realizada com Sucesso!");			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
}
