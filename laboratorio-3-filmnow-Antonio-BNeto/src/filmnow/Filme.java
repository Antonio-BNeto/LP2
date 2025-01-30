package filmnow;

import java.util.Objects;

public class Filme {
	//Definindo Atributos
	
	/**
	 * Atributo que representa o nome do filme.
	 */
	private String nome;
	
	/**
	 * Atributo que representa o ano de lançamento do filme.
	 */
	private String ano;
	
	/**
	 * Atributo que representa o local onde o filme pode ser assistido. 
	 */
	private String local;
	
	
	/**
	 * Constroi um filme recebendo como parametro o nome o ano e o local.
	 * @param nome Nome do filme.
	 * @param ano Ano de lançamento do filme.
	 * @param local Local onde o filme está disponivel para ser assistido.
	 */
	public Filme(String nome, String ano, String local) {
		this.nome = nome;
		this.ano = ano;
		this.local = local;
	}	

	/**
	 * Retorna o ano que o filme foi lançado
	 * @return Ano que o filme foi lançado
	 */
	public String getAno() {
		return ano;
	}

	/**
	 * Retorna o Nome do filme
	 * @return nome do filme
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * metodo que retorna de forma formatada da representação de um filme.
	 */
	@Override
	public String toString() {
		if(this.ano == "") {
			return this.nome + "\n" + this.local;
		}
		return this.nome + ", " + this.ano + "\n" + this.local ;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ano, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(nome, other.nome);
	}		
	
}
