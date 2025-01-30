package mrbet;

/**
 * Representação de uma Aposta.
 */

public class Aposta {
	//Definindo Atributos.
	
	/**
	 * Time que sera feito a aposta.
	 */
	private Time time;
	/**
	 * Campeonato que séra feito a aposta.
	 */
	private Campeonato campeonato;
	/**
	 * Colocação que o usuário acha que o time chega no campeonato.
	 */
	
	private int colocacao;
	/**
	 * Valor que o usuário vai apostar.
	 */
	private double valor;
	
	/**
	 * Construtor da Aposta.
	 * 
	 * @param time - Time que vai ser feito a aposta.
	 * @param campeonato - Campeonato que vai ser feito a aposta.
	 * @param colocacao - Colocação que o Time vai Chegar no Campeonato.
	 * @param valor - Valor que foi apostado.
	 */
	public Aposta(Time time, Campeonato campeonato, int colocacao, double valor){
		this.time = time;
		this.campeonato = campeonato;
		this.colocacao = colocacao;
		this.valor = valor;
	}
	
	/**
	 * Representação textual da Aposta formatada. 
	 */
	@Override
	public String toString() {
		return String.format("%s\n"
				+ "%s\n"
				+ "%s/%s\n"
				+ "R$ %.2f", time.toString(), campeonato.getNome(), colocacao ,campeonato.getQuantMaxParticipantes(), valor);
	}
}
