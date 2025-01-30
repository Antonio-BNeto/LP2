package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que representa um objeto Atividade de Publicação.
 * 
 * @author Antonio Barros De Alcantara Neto.
 */

public class AtividadePublicacao extends Atividade {
	//Definindo Atributo
	
	/**
	 * Artigo que vai ser publicado.
	 */
	private Artigo artigo;
	
	/**
	 * Metodo construtor de uma atividade do tipo publicação.
	 * 
	 * @param tipo - Tipo da atividade.
	 * @param codigo - Codigo da atividade.
	 * @param titulo - Titulo do artigo.
	 * @param doi - DOI do artigo.
	 * @param qualis - Qualis do artigo.
	 */
	public AtividadePublicacao(String tipo, String codigo, String titulo, String doi, String qualis) {
		super(tipo, codigo);
		this.artigo = new Artigo(tipo,titulo,doi,qualis);
	}
	
	/**
	 * Metodo que calcula quantos creditos um artigo tem dependendo do tipo de publicação e do qualis.
	 */
	@Override
	public int calculaCreditos() {
		this.creditos = this.artigo.getCredito(); 
		return this.creditos;
	}

}
