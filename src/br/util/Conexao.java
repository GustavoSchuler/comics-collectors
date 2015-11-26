package br.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static Connection instance;
	
	Conexao(){
		try {
			
			String url = "jdbc:postgresql://localhost:5432/comics";  
            String usuario = "postgres";  
            String senha = "admin";  
  
            Class.forName("org.postgresql.Driver"); 
  
            instance = DriverManager.getConnection(url, usuario, senha);  
  
            System.out.println("Conexão realizada com sucesso.");
  
        } catch (Exception e) {  
             e.printStackTrace();
        }
	}
	
	public static Connection getConnection(){
		if( instance == null){
			new Conexao();
		}
		
		return instance;
	}

}
