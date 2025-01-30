package br.edu.ufcg.computacao.complementaccc;

import java.rmi.server.UnicastRemoteObject;

/**
 * Classe que representa um objeto Atividade de Pesquisa e Extensão.
 * 
 * @author Antonio Barros De Alcantara Neto.
 */

public class AtividadePesquisaExtensao extends Atividade {
	//Definindo atributos
	
	/**
	 * Meses que foi realizada a atividade de pesquisa e extensão.
	 */
	private int meses;
	/**
	 * Disciplina que a atividade foi realizada.
	 */
	private String disciplina;
	
	/**
	 * Metodo construtor da atividade de Pesquisa e extensão.
	 * 
	 * @param tipo - Tipo da atividade.
	 * @param codigo - Codigo da atividade.
	 * @param unidadeAcumulada - Unidade acumulada da atividade.
	 * @param disciplina - Disciplina da atividade.
	 */
	public AtividadePesquisaExtensao(String tipo, String codigo, int unidadeAcumulada,String disciplina) {
		super(tipo, codigo);
		this.meses = unidadeAcumulada;
		this.disciplina = disciplina;
	}
	
	/**
	 * Metodo que calcula os creditos de uma atividade de pesquisa e extensão.
	 */
	@Override
	public int calculaCreditos() {
		if(this.meses>=12) {
			double calculo = meses* 0.83; 
			
			if(calculo>18) {
				this.creditos = 18;
			}else {
				this.creditos = (int)Math.round(calculo);
			}
			return this.creditos;
		}
		return 0;
	}

}
