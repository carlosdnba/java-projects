package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCursoJsp;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;
	
	public DaoUsuario() {
		this.connection = SingleConnection.getConnection();
	}
	
	public void salvarUsuario(BeanCursoJsp usuario) {
		String sql = "insert into user_table (nome, login, senha, telefone, cep, rua, bairro, cidade, estado, foto, contenttype) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
					  
		try {
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getNome());
			insert.setString(2, usuario.getLogin());
			insert.setString(3, usuario.getSenha());
			insert.setString(4, usuario.getTelefone());
			insert.setString(5, usuario.getCep());
			insert.setString(6, usuario.getRua());
			insert.setString(7, usuario.getBairro());
			insert.setString(8, usuario.getCidade());
			insert.setString(9, usuario.getEstado());
			insert.setString(10, usuario.getFotoBase64());
			insert.setString(10, usuario.getContentType());
			insert.execute();
			
			connection.commit();
		} catch (Exception e) {
			e.getStackTrace();
			try {
				connection.rollback();
			} catch (SQLException sqlException) {
				sqlException.getStackTrace();
			}
		}
	}
	
	public List<BeanCursoJsp> listar() throws SQLException {
		List<BeanCursoJsp> lista = new ArrayList<>();
		String sql = "SELECT * FROM public.user_table";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
			beanCursoJsp.setId(resultSet.getLong("id"));
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setSenha(resultSet.getString("senha"));
			beanCursoJsp.setNome(resultSet.getString("nome"));
			beanCursoJsp.setTelefone(resultSet.getString("telefone"));
			lista.add(beanCursoJsp);
		}

		return lista;
	}
	
	public void delete(String id) {
		String sql = "DELETE FROM user_table " +
				"WHERE ID = '" + id + "'";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
		} catch (Exception e) {
			e.getStackTrace();
			try {
				connection.rollback();
			} catch (SQLException sqlException) {
				sqlException.getStackTrace();
			}
		}
	}
	
	public BeanCursoJsp consultar(String id) throws SQLException {
		String sql = "SELECT * FROM user_table " +
				"WHERE ID = '" + id + "'";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
			beanCursoJsp.setId(resultSet.getLong("id"));
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setSenha(resultSet.getString("senha"));
			beanCursoJsp.setNome(resultSet.getString("nome"));
			beanCursoJsp.setTelefone(resultSet.getString("telefone"));

			return beanCursoJsp;
		}

		return null;
	}

	public void atualizar(BeanCursoJsp usuario) {

		String sql = "UPDATE user_table SET LOGIN = ?, SENHA = ? , NOME = ?, TELEFONE = ? " +
				"WHERE ID = " + usuario.getId();

		try {
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getLogin());
			insert.setString(2, usuario.getSenha());
			insert.setString(3, usuario.getNome());
			insert.setString(4, usuario.getTelefone());

			insert.executeUpdate();
			
			connection.commit();
		} catch (Exception e) {
			e.getStackTrace();
			try {
				connection.rollback();
			} catch (SQLException sqlException) {
				sqlException.getStackTrace();
			}
		}
	}
	
	public Boolean validarLogin(String login) throws SQLException {
		String sql = "SELECT count(1) as qtd FROM user_table " +
				"WHERE LOGIN = '" + login + "'";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			return resultSet.getInt("qtd") <= 0;
		}

		return false;
	}
}
