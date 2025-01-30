package br.edu.ufcg.computacao.p2lp2.coisa;

/**
* Classe que registra a informação sobre a quantidade de horas
* de internet que um aluno tem dedicado de uma disciplina remota
* 
* @author Antonio Barros De Alcantara Neto
*/
public class RegistroTempoOnline {
	//Definindo Atributos
	
	/**
	 * O tempo que o aluno passou estudando a disciplina online
	 */
	private int tempoOnlineUsado;
	
	/**
	 * O tempo que o aluno deve comprir da disciplina online.
	 */
	private int tempoOnlineEsperado;
	
	/**
	 * Nome da disciplina que o aluno esta estudando.
	 */
	private String nomeDisciplina;
	
	/**
	 * Constroi o registro do tempo online de um aluno apartir do nome da disciplina.
	 * caso não especificado o tmpo online esperado da disciplina, então ela vai receber por default 120 horas.   
	 * 
	 * @param nomeDisciplina - nome da disciplina que o aluno esta estudando.
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina= nomeDisciplina;
		this.tempoOnlineUsado = 0;
		this.tempoOnlineEsperado = 120;
	}
	
	/**
	 * Constroi o registro do tempo online de um aluno apartir do nome da diciplina e
	 * da quantidade de hora online esperadas
	 * 
	 * @param nomeDisciplina - nome da disciplina que o aluno esta estudando.
	 * @param tempoOnlineEsperado - quantidade de tempo online que o aluno deve passar estudando.
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado){
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineUsado = 0;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	/**
	 * Utilizando do metodo set para atualizar a quantidade de tempo que o aluno ja passou online estudando.
	 * 
	 * @param tempo - somando o tempo que o aluno passou estudando.
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnlineUsado += tempo;
	}
	
	/**
	 * Retorna um boolean que representa se o aluno completou a meta de horas esperadas pela disciplina
	 * 
	 * 
	 * @return - retorna um boolean que ira mostra se a quandidade de tempo estudado pelo aluno
	 * é maior ou igual ao tempo onine esperado da disciplina.
	 */
	public boolean atingiuMetaTempoOnline(){
		return tempoOnlineUsado >= tempoOnlineEsperado;
	}
	
	/**
	 * Retorna a String que representa o nome da disciplina, a quantidade de horas esperadas e o tempo que o aluno estudou.
	 * No formato"nome da disciplina (tempo usado pelo aluno/ tempo esperado)"
	 */
	public String toString(){
		return nomeDisciplina +
				" " +
				tempoOnlineUsado +
				"/" +
				tempoOnlineEsperado;
	}
}
