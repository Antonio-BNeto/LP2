package mrbet;

/**
 * Representação de um Campeonato.
 */

public class Campeonato {
	//Definindo Atributos
	
	/**
	 * Array que vai conter os times que foram adicionados no Campeonato
	 */
	private Time[] times;
	/**
	 * Nome do Campeonato
	 */
	private String nome;
	/**
	 * Quantidade maxima de participantes que um Campeonato pode ter.
	 */
	private int quantMaxParticipantes;
	/**
	 * indice que mostra quantos participantes atuais o campeonato tem adicionado.
	 */
	private int participantesAtuais;
	
	/**
	 * Construtor do Campeonato.
	 * 
	 * @param nome - Nome do Campeonato
	 * @param quantMaxParticipantes - Quantidade maxima de participantes que um campeonato pode possuir.
	 */
	public Campeonato(String nome, int quantMaxParticipantes) {
		this.nome = nome;
		this.quantMaxParticipantes = quantMaxParticipantes;
		this.times = new Time[quantMaxParticipantes];
		this.participantesAtuais = 0;
	}
	
	/**
	 * Metodo get que retorna o nome do Campeonato.
	 * 
	 * @return Nome do Campeonato.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo get que retorna a quantidade maxima de participantes o campeonato pode possuir.
	 * 
	 * @return - Quantidade máxima de participantes que o campeonato pode ter.
	 */
	public int getQuantMaxParticipantes() {
		return quantMaxParticipantes;
	}
	
	/**
	 * Metodo que percorre o array de times até a quantidade de participantes atuais para saber se o time existe no campeonato.
	 * 
	 * @param time - Objeto que vai ser comparado.
	 * @return - True: Se o time estiver adicionado/false: se o time não estiver adicionado.
	 */
	public boolean buscaTimeEmCampeonato(Time time) {
		for(int i=0; i<this.participantesAtuais; i++) {
			if(times[i].equals(time))return true;
		}
		return false;
	}
	
	/**
	 * Metodo que adiciona o time em um campeonato caso o time ainda não esteja adicionado.
	 * 
	 * @param time - objeto que vai ser cadastrado no array de times.
	 * @return - true:Se o time foi adicionado/false:Se o time não foi adicionado.
	 */
	public boolean addTimeNoCampeonato(Time time) {
		if(this.participantesAtuais < this.quantMaxParticipantes) {
			this.times[this.participantesAtuais] = time;
			this.participantesAtuais ++;
			return true;
		}
		return false;
	}
	
	/**
	 * Representação textual de um campeonato.
	 */
	@Override
	public String toString() {
		return  String.format("%s - %s/%s", this.nome, this.participantesAtuais, this.quantMaxParticipantes);
	}
	
}