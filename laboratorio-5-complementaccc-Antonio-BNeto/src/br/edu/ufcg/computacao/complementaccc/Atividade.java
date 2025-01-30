package br.edu.ufcg.computacao.complementaccc;

import java.util.Objects;

/**
 * Classe abstrata das atividades.
 * 
 * @author Antonio Barros De Alcantara Neto.
 */

public class Atividade implements Comparable<Atividade> {
	//Definindo atributos
	
	/**
	 * Tipo da atividade.
	 */
	protected String tipo;
	/**
	 * Descrição da atividade.
	 */
	protected String descricao;
	/**
	 * Codigo da atividade.
	 */
	protected String codigo;
	/**
	 * link da atividade.
	 */
	protected String link; 
	/**
	 * creditos da atividade.
	 */
	protected int creditos;
	
	/**
	 * Metodo construtor de uma atividade
	 * 
	 * @param tipo - Tipo da atividade
	 * @param codigo - Codigo da atividade
	 */
	public Atividade(String tipo, String codigo) {
		this.tipo = tipo.toUpperCase();
		this.descricao = "";
		this.codigo = codigo.substring(0, 3) + "." + codigo.substring(3, 6) + "." + codigo.substring(6, 9) + "-"+ codigo.substring(9, 11)+"_"+codigo.substring(11,12);
		this.creditos = 0;
		this.link = "";
	}

	/**
	 * Metodo que retorna o tipo da atividade.
	 * 
	 * @return - Retorna o tipo da atividade.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Metodo que retorna o calculo dos creditos de uma atividade dependendo do tipo.
	 * 
	 * @return - Retorna os creditos da atividade.
	 */
	public int calculaCreditos() {
		return 0;
	}
	
	/**
	 * Metodoq que retorna a descrição de uma atividade.
	 * 
	 * @return - Retorna a descrição de uma atividade.
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Metodo que altera a descrição de uma atividade.
	 * 
	 * @param descricao - Descrição que vai ser colocada na atividade.
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Metodo que retorna o link de comprovação de uma atividade.
	 * 
	 * @return - Retorna o link de comprovação de uma atividade.
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Metodo que altera o link de comprovação de uma atividade.
	 * 
	 * @param link - Retorna o link de comprovação da atividade.
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 * Metodo que retorna o codigo de uma atividade.
	 * 
	 * @return - Retorna o codigo de uma atividade.
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Metodo que retorna quantos creditos creditos uma atividade possui. 
	 * 
	 * @return - Retorna quantos creditos uma atividade tem.
	 */
	public int getCreditos() {
		return creditos;
	}
	
	/**
	 * Representação textual de uma atividade.
	 */
	@Override
	public String toString() {
		return "Tipo: " + tipo +"\n"+
				"Descrição: " + descricao;
	}

	/**
	 * Metodo que compara se duas artividades são iguais depesndendo dos seus codigos.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	/**
	 * Metodo que compara duas atividades e ordena elas em ordem alfabeticas dependendo do tipo delas.
	 */
	@Override
	public int compareTo(Atividade o) {
		return this.tipo.compareTo(o.getTipo());
	}

}
