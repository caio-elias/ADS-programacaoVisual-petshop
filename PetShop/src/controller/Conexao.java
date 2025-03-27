
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Conexao {
	private Connection conexao;
	private static volatile Conexao instanciaUnica;
        
	private Conexao() {
		try {
			Class.forName("org.postgresql.Driver");
			Properties prop = new Properties();
			prop.put("user","postgres");
			prop.put("password", "341766");
			prop.put("charset", "UTF-8");
			prop.put("lc_ctype", "ISO8859_1");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", prop);
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
		}
	}
        
	public static Conexao obterInstancia() {
		if (instanciaUnica == null) {
			synchronized (Conexao.class) {
				if (instanciaUnica == null) {
					instanciaUnica = new Conexao();
				}
			}
		}
		return instanciaUnica;
	}
	public Connection obterConexao() {
		if (conexao != null) {
			return conexao;
		} else {
			throw new NullPointerException("Variavel conexão não iniciada.");
		}
	
	}
}


