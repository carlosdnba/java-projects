package dao;

import connection.SingleConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DaoLogin {

	private Connection connection;
	
	// metodo que faz a conexao com o banco especificado na classe SingleConnection
	public DaoLogin() {
		// transforma a conexao criada com o pacote da sql na conexao criada na classe SingleConnection
		this.connection = SingleConnection.getConnection();
	}
	
	// metodo que verifica se o login e senha recebidos do front existem no banco, 
	// retornando um booleano
	public boolean validarLogin(String login, String senha) throws Exception  {
		
		String sql = "SELECT * FROM user_table " +
                     "WHERE LOGIN = '" + login + "'" +
                     " AND SENHA = '" + senha + "'";
		
		// The performance of the application will be faster if you use PreparedStatement interface because query is compiled only once.
		PreparedStatement statement = this.connection.prepareStatement(sql);
		// Executes the select query. It returns an instance of ResultSet.
        ResultSet resultSet = statement.executeQuery();
		
        // retorna true ou false por default
		return resultSet.next();
	}
	
}
