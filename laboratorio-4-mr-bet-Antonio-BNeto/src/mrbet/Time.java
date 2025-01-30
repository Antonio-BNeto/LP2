package mrbet;

import java.util.Objects;

/**
 * Representação de um Time.
 */

public class Time {
	//Definindo Atributos.
	
	/**
	 * Codigo que vai identificar Cada Time.
	 */
	private String codigoTime;
	/**
	 * Nome do Time.
	 */
	private String nome;
	/**
	 * Mascote do Time.
	 */
	private String mascote;
	
	/**
	 * Cronstrutor do Time.
	 * 
	 * @param codigoTime - Codigo que identifica o Time.
	 * @param nome - Nome do Time.
	 * @param mascote - Mascote do Time.
	 */
	public Time(String codigoTime, String nome, String mascote) {
		this.codigoTime = codigoTime;
		this.nome = nome;
		this.mascote = mascote;
	}
	/**
	 * Metodo que retorna o nome do Time.
	 * 
	 * @return - O nome do Time.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Representação textual do Time formatada.
	 */
	@Override
	public String toString() {
		return String.format("[%s] %s / %s", codigoTime, nome, mascote);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoTime);
	}
	
	/**
	 * Metodo que compara um time com base no seu codigo.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(codigoTime, other.codigoTime);
	}
}
