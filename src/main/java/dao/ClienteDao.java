package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.MySqlConnection;
import model.Cliente;

public class ClienteDao implements CRUD{
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Cliente cliente) {
		//sql = "INSERT INTO clientes VALUES (null, ?, ?, 'true', ?, ?, now(),now())";
		sql = "INSERT INTO usuarios (nome, dataNascimento, ativo, login, senha, created_at, updated_at) VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setDate(2, new java.sql.Date(cliente.getDataNascimento().getTime()));
			preparedStatement.setBoolean(3, cliente.isAtivo());
			preparedStatement.setString(4, cliente.getLogin());
			preparedStatement.setString(5, cliente.getSenha());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Salvo no banco!");
			
			
		} catch(SQLException e) {
			System.out.println("Não salvou no banco! "+ e.getMessage());
		}
	}
	
	public static void delete(int clienteId) {
		sql = "DELETE FROM usuarios WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, clienteId);
			preparedStatement.executeUpdate();
			
			System.out.println("Cliente deletado!");
		}catch(SQLException e){
			System.out.println("Cliente não deletado! " + e.getMessage());
		}
	}
	
	public static List<Cliente> find(String pesquisa){
		
		sql = String.format("SELECT * FROM usuarios WHERE nome like '%s%%'", pesquisa);
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);   
			while (result.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(result.getInt("id"));
				cliente.setNome(result.getString("nome"));
				cliente.setDataNascimento(result.getDate("dataNascimento"));
				cliente.setAtivo(result.getBoolean("ativo"));
				
				clientes.add(cliente);
				
			}
			
			System.out.println("Busca encontrou usuarios!");
			
			return clientes;
		} catch(SQLException e) {
			System.out.println("Falha na busca" + e.getMessage());
			return null;
		}
	}
	
	public static Cliente findByPk(int clienteId) {
		
		sql = String.format("SELECT * FROM usuarios WHERE id = %d ", clienteId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);   
			
			Cliente cliente = new Cliente();
			
			while (result.next()) {
				
				cliente.setId(result.getInt("id"));
				cliente.setNome(result.getString("nome"));
				cliente.setDataNascimento(result.getDate("dataNascimento"));
				cliente.setAtivo(result.getBoolean("ativo"));
			
			}
			
			System.out.println("Busca encontrou usuarios!");
			
			return cliente;
		} catch(SQLException e) {
			System.out.println("Falha na busca" + e.getMessage());
			return null;
		}
		
	}
	
	public static void update(Cliente cliente) {
		sql = "UPDATE usuarios SET nome=?, dataNascimento=?, login=?, senha=?, updated_at=CURRENT_TIMESTAMP WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setDate(2, new java.sql.Date(cliente.getDataNascimento().getTime()));
			preparedStatement.setString(3, cliente.getLogin());
			preparedStatement.setString(4, cliente.getSenha());
			preparedStatement.setInt(5,  cliente.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Atualizado no banco!");
			
			
		} catch(SQLException e) {
			System.out.println("Não atualizado no banco! "+ e.getMessage());
		}
	}
}
