package br.edu.ufcg.computacao.p2lp2.coisa;

/**
* Classe que acompanha a rotina de descanso de um aluno. O aluno deve descansar no minimo por 26 horas semanais para que possa ser
* considerando descansado. 
* 
* @author Antonio Barros De Alcantara Neto
*/

public class Descanso {
	// Definindo os atributos
	
	/**
	 * Variavel que tem como objetivo saber quantas horas o aluno descansou durante a semana.
	 */
	private int horasDescanso;
	
	/**
	 * Variavel que mostra quantas semanas o aluno passou.
	 */
	private int numSemana;
	
	/**
	 * Atributo utilizado para saber qual estado o aluno se encontra, cansado ou descansado. Inicialmente o aluno se encontra cansado.
	 */
	private String estado;
	
	/**
	 * O emoji representativo da sensação geral do aluno.
	 */
	private String emoji;
	
	/**
	 * Constroi uma rotina de descanso para um aluno apartir das horas de descanso e das semanas decorridas.
	 * O aluno inicialmente se encontra no estado cansado.
	 * 
	 */
	public Descanso() {
		this.horasDescanso = 0;
		this.numSemana = 1;
		this.estado= "cansado";
		this.emoji = "";
	}
	
	/**
	 * Utilização do metodo set para inserir/atualizar as horas de descanso do aluno.
	 * 
	 * @param horas - inserir/atualizar um inteiro com o valor
	 * das horas que o aluno descansou durante a semana
	 */
	public void defineHorasDescanso(int horas) {
		this.horasDescanso = horas;
		calcularStatus();
	}
	
	/**
	 * Utilização do metodo set para inserir/atualizar a quantidade de semanas que o aluno vivenciou.
	 * 
	 * @param semanas - inserir/atualizar um inteiro com
	 * a quantidade de semanas que o aluno passou.
	 */
	public void defineNumeroSemanas(int semanas) {
		this.numSemana = semanas;
		calcularStatus();
	}
	
	/**
	 *  Retorna a String com o estado que o aluno se encontra.
	 *  A representação possui duas possibilidades a cansado e a descansado.
	 *  
	 * @return - retorna o estado em que o aluno se encontra.
	 */
	public String getStatusGeral() {
		calcularStatus();
		if(!this.emoji.equals("")) {
			return this.estado + " - "+ this.emoji;
		}else {
			return this.estado;
		}
	}
	/**
	 * Calcula o estado do aluno usando de base os numeros de horas que ele descansou durante as semanas.
	 * Caso o estado do aluno mude em relção ao estado anterior, o emoji é limpo.
	 */
	public void calcularStatus() {
		String ultimoEstado = this.estado;
		
		if (numSemana == 0 || horasDescanso/numSemana < 26) {
			this.estado = "cansado";
		} else {
			this.estado = "descansado";
		}
		
		if(!ultimoEstado.equals("") && !this.estado.equals(ultimoEstado)) {
			this.emoji = "";
		}
	}
	/**
	 * Define o emoji que representa a sensação que o aluno esta sentido
	 * @param valor- o emoji a ser atribuido;
	 */
	void definirEmoji(String valor) {
		this.emoji = valor;
	}
}
