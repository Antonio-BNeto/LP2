package br.edu.ufcg.computacao.complementaccc;

import java.util.List;

/**
 * Classe Abstrata de um Relatorio.
 * 
 * @author Antonio Barros De Alcantara Neto.
 */

public class Relatorio {
	//Definindo Atributo
	
	/**
	 * Relatorio
	 */
	protected String relatorio;

	/**
	 * Metodo contrutor de um relatorio.
	 */
	public Relatorio() {
		this.relatorio = "";
	}
	
	/**
	 * Metodo que gera um relatorio
	 * 
	 * @param dados - Dados do estudante como nome,cpf e matricula.
	 * @param atividades - Atividades que estão armazenadas no estudante.
	 */
	public void geraRelatorio(String dados, List<Atividade> atividades) {
		
	}
	
	/**
	 * Metodo que gera um relatorio resumido por tipo.
	 * 
	 * @param dados -Dados do estudante com o nome, cpf e matricula.
	 * @param tipo - tipo da atividade.
	 * @param atividades - Atividades que estão armazenadas no estudante.
	 */
	public void geraRelatorioPorTipo(String dados, String tipo, List<Atividade> atividades) {
	
	}
	
	/**
	 * Metodo que exibe um relatorio.
	 * 
	 * @return - Retorna um relatorio formatado dependendo do tipo de Relatorio.
	 */
	public String exibeRelatorio() {
		return this.relatorio;
	}
	
}
