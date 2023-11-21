package dao;

import java.util.List;

import model.Carro;

public interface CRUD {

	public static void create(Carro carro) {};
	public static void delete(int carroId) {};
	public static List<Carro> find(String pesquisa) {return null;}
	public static Carro findByPk(int carroId) {return null;}
	public static void update(Carro carro) {}
	
}
