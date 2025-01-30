package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que representa um objeto Atividade de Monitoria.
 * 
 * @author Antonio Barros De Alcantara Neto.
 */

public class AtividadeMonitoria extends Atividade {
	//Definindo Atributos
	
	/**
	 * Unidade Acumulada da atividade do tipo Monitoria.
	 */
	private int semestre;
	/**
	 * Disciplina que foi feita a monitoria.
	 */
	private String disciplina;
	
	/**
	 * Metodo construtor da atividade do tipo monitoria.
	 * 
	 * @param tipo - Tipo da atividade.
	 * @param codigo - codigo da atividade.
	 * @param unidadeAcumulada - Unidade acumulada da atividade.
	 * @param disciplina - Disciplina da atividade.
	 */
	public AtividadeMonitoria(String tipo, String codigo,int unidadeAcumulada, String disciplina) {
		super(tipo, codigo);
		this.disciplina = disciplina;
		this.semestre = unidadeAcumulada;
	}
	
	/*
	 * Metodo que calcula quantos creditos uma atividade do tipo monitoria vai ter dependendo de quantos 
	 * semestres foi feito a monitoria.
	 */
	@Override
	public int calculaCreditos() {
		int calculo = this.semestre * 4;
		
		if(calculo>16) {
			this.creditos = 16;
		}else {
			this.creditos = calculo;
		}
		return this.creditos;
	}
	
}
