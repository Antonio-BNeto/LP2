package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que representa um objeto Atividade de Estágio.
 * 
 * @author Antonio Barros De Alcantara Neto.
 */

public class AtividadeEstagio extends Atividade {
	//Definindo Atributos
	/**
	 * Unidades acumuladas do estagio.
	 */
	private int horas;
	/**
	 * Disciplina que foi realizada o estagio.
	 */
	private String disciplina;

	/**
	 * Metodo construtor de uma atividade do tipo estagio.
	 * 
	 * @param tipo - Tipo da atividade.
	 * @param codigo - Codigo da atividade.
	 * @param unidadeAcumulada - Unidade acumulada da atividade.
	 * @param disciplina - Disciplina em qual foi feito o estagio.
	 */
	public AtividadeEstagio(String tipo, String codigo, int unidadeAcumulada, String disciplina) {
		super(tipo, codigo);
		this.disciplina = disciplina;
		this.horas = unidadeAcumulada;
	}
	/**
	 * Como as atividades de Estagios devem possuir no minimo 300 horas de unidades acumuladas então 
	 * caso não cumpram com isso deve ser retornado 0.
	 */
	@Override
	public int calculaCreditos() {
		if(this.horas>=300) {
			double calculo = horas * 0.016;
			if(calculo>18) {
				this.creditos = 18;
			}else {
				this.creditos = (int) Math.round(calculo);
			} 
			return this.creditos;
		}
		return 0;
	}

}
