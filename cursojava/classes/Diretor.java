package cursojava.classes;

import cursojava.interfaces.VerificarAcesso;

public class Diretor implements VerificarAcesso {
	
	private String login;
	private String senha;
	
	
	

	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}




	@Override
	public boolean verificaracesso(String login, String senha) {
		this.login = login;
		this.senha = senha;
		return verificaracesso();
	}




	@Override
	public boolean verificaracesso() {
		
		return login.equals("admin") && senha.equals("admin");
	}




	
	
	
	
}
