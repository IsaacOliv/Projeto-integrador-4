package dao;

import model.Cliente;

public interface Login {
	boolean validarCredenciais(String login, String senha);
	
	public static Cliente findByLoginSenha(String login, String senha) {
		return null;
	}
}
