package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.MySqlConnection;
import model.Carro;
import model.interessesClientes;

public class interessesDao implements CRUD{
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
		public static void create(interessesClientes interesses) 
		{
			sql = "INSERT INTO interessesClientes VALUES (null, ?,?,?)";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, interesses.getNomeCliente());
				preparedStatement.setInt(2, interesses.getTelefoneCliente());
				preparedStatement.setInt(3, interesses.getId_carro());
				
				preparedStatement.executeUpdate();
				System.out.println("Correct insert on database");
			} catch (SQLException e) {
				System.out.println("Incorrect insert on database " + e.getMessage());
			}
		
		}
		
		public static void updateInteresseCarro(Carro carro) 
		{
			sql = "UPDATE carros SET interesse=? WHERE id =?";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, carro.getInteresse());
				preparedStatement.setInt(2, carro.getId());
				
				preparedStatement.executeUpdate();
				System.out.println("Correct update on database");
			} catch (SQLException e) {
				System.out.println("Incorrect update on database" + e.getMessage());
			}
		}
		
		public static Carro findByPk(int carroId) 
		{
		    Carro carro = null;
		    List<interessesClientes> interessesList = new ArrayList<>();
		    
			sql = String.format("SELECT * FROM carros AS c JOIN interessesClientes AS iC ON iC.id_carro = c.id WHERE id_carro = %d", carroId);
			
			try (Statement statement = connection.createStatement();
			     ResultSet resultSet = statement.executeQuery(sql))  {
				
				while (resultSet.next()) {
		            if (carro == null) {
		                carro = new Carro();
		                carro.setId(resultSet.getInt("id"));
		                carro.setMarca(resultSet.getString("marca"));
		                carro.setModelo(resultSet.getString("modelo"));
		                carro.setAnoFabricacao(resultSet.getInt("anoFabricacao"));
		                carro.setAnoModelo(resultSet.getInt("anoModelo"));
		                carro.setValor(resultSet.getDouble("valor"));
		                carro.setDescricao(resultSet.getString("descricao"));
		                carro.setFotoCarro(resultSet.getString("fotoCarro"));
		                carro.setInteresse(resultSet.getInt("interesse"));
		            }
		            // Processar interessesClientes
		            interessesClientes interesses = new interessesClientes();
		            interesses.setId(resultSet.getInt("id"));
		            interesses.setId_carro(resultSet.getInt("id_carro"));
		            interesses.setNomeCliente(resultSet.getString("nomeCliente"));
		            interesses.setTelefoneCliente(resultSet.getInt("telefoneCliente"));

		            // Adicionar interessesClientes à lista
		            interessesList.add(interesses);
				}
				System.out.println("--correct find by pk Carros");
				
				// Adicionar a lista de interessesClientes ao carro
		        if (carro != null) {
		            carro.setInteressesClientes(interessesList);
		        }
		        System.out.println("--correct find by pk Carros");
		        return carro;
			} catch (SQLException e) {
				System.out.println("Incorrect find by pk Carros" +  e.getMessage());
				return null;
			}
		}
		
}
