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

public class CarroDao implements CRUD{
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
		public static void create(Carro carro) 
		{
			sql = "INSERT INTO carros VALUES (null, ?,?,?,?,?,?)";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, carro.getMarca());
				preparedStatement.setString(2, carro.getModelo());
				preparedStatement.setInt(3, carro.getAnoFabricacao());
				preparedStatement.setInt(4, carro.getAnoModelo());
				preparedStatement.setDouble(5, carro.getValor());
				preparedStatement.setString(6, carro.getDescricao());
				
				preparedStatement.executeUpdate();
				System.out.println("Correct insert on database");
			} catch (SQLException e) {
				System.out.println("Incorrect insert on database" + e.getMessage());
			}
		}
		
		public static void delete(int carroId) 
		{
			sql = "DELETE FROM carros WHERE id = ?";
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setInt(1, carroId);
				preparedStatement.executeUpdate();
				
				System.out.println("--correct delete on cliente");
				
			}catch(SQLException e) {
				System.out.println("--incorrect delete on cliente. " +e.getMessage());
			}
		}
		
		public static List<Carro> find(String pesquisa) 
		{
			sql = String.format("SELECT * FROM carros WHERE marca like '%s%%' OR modelo like '%s%%'", pesquisa, pesquisa);
			List<Carro> carros = new ArrayList<Carro>();
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				
				while (resultSet.next()) {
					Carro carro = new Carro();
					carro.setId(resultSet.getInt("id"));
					carro.setMarca(resultSet.getString("marca"));
					carro.setModelo(resultSet.getString("modelo"));
					carro.setAnoFabricacao(resultSet.getInt("anoFabricacao"));
					carro.setAnoModelo(resultSet.getInt("anoModelo"));
					carro.setValor(resultSet.getDouble("valor"));
					carro.setDescricao(resultSet.getString("descricao"));
					
					carros.add(carro);
				}
				System.out.println("--correct find Carros");
				return carros;

			} catch (SQLException e) {
				System.out.println("Incorrect find Carros" +  e.getMessage());
				return null;
			}
		}
		
		public static Carro findByPk(int carroId) 
		{
			sql = String.format("SELECT * FROM carros WHERE id = %d", carroId);
			
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				Carro carro = new Carro();
				
				while (resultSet.next()) {
					
					carro.setId(resultSet.getInt("id"));
					carro.setMarca(resultSet.getString("marca"));
					carro.setModelo(resultSet.getString("modelo"));
					carro.setAnoFabricacao(resultSet.getInt("anoFabricacao"));
					carro.setAnoModelo(resultSet.getInt("anoModelo"));
					carro.setValor(resultSet.getDouble("valor"));
					carro.setDescricao(resultSet.getString("descricao"));
					
				}
				System.out.println("--correct find by pk Carros");
				return carro;
			} catch (SQLException e) {
				System.out.println("Incorrect find by pk Carros" +  e.getMessage());
				return null;
			}

		}
		
		public static void update(Carro carro) 
		{
			sql = "UPDATE carros SET marca=?, modelo=?, anoFabricacao=?, anoModelo=?, valor=?, descricao=? WHERE id =?";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, carro.getMarca());
				preparedStatement.setString(2, carro.getModelo());
				preparedStatement.setInt(3, carro.getAnoFabricacao());
				preparedStatement.setInt(4, carro.getAnoModelo());
				preparedStatement.setDouble(5, carro.getValor());
				preparedStatement.setString(6, carro.getDescricao());
				preparedStatement.setInt(7, carro.getId());
				
				preparedStatement.executeUpdate();
				System.out.println("Correct update on database");
			} catch (SQLException e) {
				System.out.println("Incorrect update on database" + e.getMessage());
			}
		}
}
