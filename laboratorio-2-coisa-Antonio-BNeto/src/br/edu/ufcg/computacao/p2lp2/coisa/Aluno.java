package br.edu.ufcg.computacao.p2lp2.coisa;

/*
 * Representação de um estudante de computação
 * */
public class Aluno {
	
	private String nome;
	private int anoNascimento;
	private double cra;

	
	/**
	 * Construtor da classe aluno
	 * @param nome 
	 * @param anoNascimento
	 */
	public Aluno(String nome, int anoNascimento) {
		this.nome = nome;
		this.cra = 0.0;
		this.anoNascimento = anoNascimento;
	}

	/**
	 * Utilização do metodo set para inserir/atualizar o cra do aluno
	 * @param cra - inserir/atualiza um double com o valor do cra do aluno
	 */
	public void setCra(double cra) {
		this.cra = cra;
	}
	/**
	 * Utilização do metodo get para retornar o valor do ano de nascimento.
	 * @return - retorna um inteiro com a idade do aluno.
	 */
	public int getIdade() {
		return 2021 - anoNascimento;
	}
	
	/**
	 *Utilização do metodo toString para retornar a representação do aluno. 
	 */
	public String toString() {
		return "Aluno - "  + this.nome;
	}


}
