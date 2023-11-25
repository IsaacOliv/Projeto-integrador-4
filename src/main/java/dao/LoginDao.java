package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.MySqlConnection;
import model.Cliente;

public class LoginDao implements Login {
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	@Override
    public boolean validarCredenciais(String login, String senha) {
        return login.equals(login) && senha.equals(senha);
    }
	
	public Cliente findByLoginSenha(String clienteLogin, String clienteSenha) {
		
		sql = String.format("SELECT * FROM usuarios WHERE login = %s AND senha = %s", clienteLogin, clienteSenha);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);   
			
			if ("login".equals(clienteLogin) && "senha".equals(clienteSenha)) {
	            Cliente clienteEncontrado = new Cliente();
	            clienteEncontrado.setLogin(result.getString("login"));
	            clienteEncontrado.setSenha(result.getString("senha"));
	            System.out.println("Busca encontrou usuario!");
	            return clienteEncontrado;
	        }

			System.out.println("nao encontrado");
			
			return null;
		} catch(SQLException e) {
			System.out.println("Falha na busca" + e.getMessage());
			return null;
		}
		
	}
}
