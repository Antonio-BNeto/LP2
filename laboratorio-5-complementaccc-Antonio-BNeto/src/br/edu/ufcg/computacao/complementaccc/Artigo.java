package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que representa um objeto Artigo.
 * 
 * @author Antonio Barros de Alcantara Neto.
 */

public class Artigo {
	//Definindo atributos
	
	/**
	 * Titulo do artigo.
	 */
	private String titulo;
	/**
	 * Tipo da atividade.
	 */
	private String tipo;
	/**
	 * Qualis da atividade.
	 */
	private String qualis;
	/**
	 * Doi da atividade.
	 */
	private String doi;
	/**
	 * Creditos da atividade.
	 */
	private int credito;
	
	/**
	 * Metodo construtor de um artigo.
	 * 
	 * @param tipo - Tipo da atividade.
	 * @param titulo - Titulo do artigo.
	 * @param doi - Doi do artigo.
	 * @param qualis - Qualis da atividade.
	 */
	public Artigo(String tipo,String titulo,String doi ,String qualis) {
		this.tipo = tipo;
		this.titulo = titulo;
		this.qualis = qualis.toLowerCase();
		this.doi = doi;
		this.credito = 0;
	}

	/**
	 * Assumindo que possa existir dois tipos de publicação a Publicação<PERIODICO> e a publicação<Conferência>
	 * e se elas tendo o msm qualis vão possuir creditos diferentes, então criei um metodo capaz de confirmar 
	 * qual o credito do Artigo, utilizando essas informações de base.
	 * 
	 * @return - O credito do artigo.
	 */
	public int getCredito() {
		int  creditos = 0;
		switch(this.qualis) {
			case "a1":
				if(this.tipo.equalsIgnoreCase("PUBLICAÇÃO<PERIÓDICO>")) {
					creditos = 4; 
				}else if(this.tipo.equalsIgnoreCase("PUBLICAÇÃO<CONFERÊNCIA>")){
					creditos = 3;
				}
				break;
			case "a2":
				if(this.tipo.equalsIgnoreCase("PUBLICAÇÃO<PERIÓDICO>")) {
					creditos = 4;
				}else if(this.tipo.equalsIgnoreCase("PUBLICAÇÃO<CONFERÊNCIA>")) {
					creditos = 3;
				}
				break;
			case "a3":
				if(this.tipo.equalsIgnoreCase("PUBLICAÇÃO<PERIÓDICO>")) {
					creditos = 3;
				}else if(this.tipo.equalsIgnoreCase("PUBLICAÇÃO<CONFERÊNCIA>")) {
					creditos = 2;
				}	
				break;
			case "a4":
				if(this.tipo.equalsIgnoreCase("PUBLICAÇÃO<PERIÓDICO>")||this.tipo.equalsIgnoreCase("PUBLICAÇÃO<CONFERÊNCIA>")){
					creditos = 1;
				}
				break;
			case "b1":
				if(this.tipo.equalsIgnoreCase("PUBLICAÇÃO<PERIÓDICO>")|| this.tipo.equalsIgnoreCase("PUBLICAÇÃO<CONFERÊNCIA>")){
					creditos = 1;
				}
				break;		
		}
		return creditos;
	}
}
