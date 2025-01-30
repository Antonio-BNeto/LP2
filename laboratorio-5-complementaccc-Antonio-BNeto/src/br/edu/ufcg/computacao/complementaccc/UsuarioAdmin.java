package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que representa um objeto Usuario Admin.
 * 
 * @author Antonio Barros De Alcantara Neto
 *
 */

public class UsuarioAdmin extends Usuario {
	
	/**
	 * Metodo construtor de um Usuario Admin.
	 * 
	 * @param nome - Nome do Usuario Admin.
	 * @param cpf - Cpf do Usuario Admin.
	 * @param senha - Senha do Usuario Admin.
	 */
	public UsuarioAdmin(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
	}

	/**
	 * Representação textual de um admin.
	 */
	@Override
	public String toString() {
		return "Nome: " + this.nome+ "\n"+ 
				"CPF: "+ this.cpf;
	}
	
}