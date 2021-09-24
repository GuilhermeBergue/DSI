package br.edu.ifsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/dsi";
		String user = "root";
		String password = "";
		
		Connection conexao = null;
		
		System.out.println("Abrindo programa ...");
		
		try {		
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Carregando driver JDBC ...");
			
			conexao = 
				DriverManager.getConnection(url, user, password);
			System.out.println("Abrindo conexao ...");
			
		} catch(ClassNotFoundException cnfex) {
			System.out.println("Erro ao carregar o driver de conexao");
			
		} catch(SQLException sqlex) {
			System.out.println("Problema ao estabelecer conexao com o BD");
			
		} finally {
			
			try {
				if(conexao != null)
					conexao.close();
				System.out.println("Fechando conexao ...");
				
			} catch(SQLException sqlex) {
				System.out.println("Problema ao fechar a conexao com o BD");
			}
		}
		
		System.out.println("Fechando programa ...");
	}
}