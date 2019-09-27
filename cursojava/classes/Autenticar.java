package cursojava.classes;

import cursojava.interfaces.VerificarAcesso;

public class Autenticar{
	
	private VerificarAcesso permitirAcesso;
	
	public boolean autenticar() {
		return permitirAcesso.verificaracesso();
		
	}
	
	public Autenticar(VerificarAcesso acesso) {
		this.permitirAcesso = acesso;
	}
	
}
