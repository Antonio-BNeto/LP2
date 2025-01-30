package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe que representa um objeto FAQ.
 * 
 * @author Antonio Barros De Alcantara Neto.
 */
public class FAQ implements Comparable<FAQ>{
	// Definindo atributos
	
	/**
	 * Pergunta da FAQ.
	 */
	private String pegunta;
	/**
	 * Resposta da FAQ.
	 */
	private String resposta;
	/**
	 * Destaque da FAQ.
	 */
	private int destaque;
	/**
	 * Tags que vão ser armazenadas na FAQ.
	 */
	private ArrayList<String> tags;
	
	/**
	 * Metodo costrutor de uma FAQ.
	 * 
	 * @param pergunta - Pergunta que vai ser colocada na FAQ.
	 */
	public FAQ(String pergunta) {
		this.pegunta = pergunta;
		this.resposta = "";
		this.destaque = 0;
		this.tags = new ArrayList<>();
	}
	
	/**
	 * Metodo construtor deu uma FAQ.
	 * 
	 * @param pergunta - Pergunta que vai ser colocada na FAQ.
	 * @param resposta - Resposta que vai ser colocada na FAQ.
	 */
	public FAQ(String pergunta, String resposta) {
		this.pegunta = pergunta;
		this.resposta = resposta; 
		this.destaque = 0;
		this.tags = new ArrayList<>();
	}
	
	/**
	 * Metodo que mostra qual a pergunta de uma FAQ.
	 * 
	 * @return - Retorna a pergunta da FAQ.
	 */
	public String getPegunta() {
		return pegunta;
	}

	/**
	 * Metodo que mostra qual a resposta de uma FAQ.
	 * 
	 * @return - Retorna uma resposta da FAQ.
	 */
	public String getResposta() {
		return resposta;
	}

	/**
	 * Metodo que altera uma resposta de uma FAQ.
	 * 
	 * @param resposta - Resposta que vai ser adicionada na FAQ.
	 */
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	/**
	 * Metodo que mostra quanto de destaque uma FAQ tem.
	 * 
	 * @return - Retorna o destaque de uma FAQ.
	 */
	public int getDestaque() {
		return destaque;
	}
	
	/**
	 * Metodo que adiciona mais um de destaque em uma FAQ.
	 */
	public void addDestaque() {
		this.destaque += 1;
	}
	
	/**
	 * Metodo que busca uma tag armazenada na FAQ.
	 * 
	 * @param tags - tags que vão ser pro
	 * @return
	 */
	public boolean buscaTag(String[] tags) {
		for(String s: tags) {
			if(this.tags.contains(s)) { 
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que adiciona um array de tags em uma FAQ.
	 * 
	 * @param tags - tags que vão ser adicionadas na FAQ.
	 */
	public void addTags(String[] tags) {
		for(String s: tags) {
			if(this.tags.size()<=3) {
				this.tags.add(s);
			}
		}
	}
	/**
	 * Metodo que compara duas FAQS com base na sua pergunta.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(pegunta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FAQ other = (FAQ) obj;
		return Objects.equals(pegunta, other.pegunta);
	}
	
	/**
	 * Metodo que vai compara duas FAQs com base no seu destaque e reorganiza da maior pra menor.
	 */
	@Override
	public int compareTo(FAQ o) {
		if(this.destaque> o.getDestaque()) {
			return -1;
		}else if(this.destaque< o.getDestaque()) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * Representação textual de uma FAQ.
	 */
	@Override
	public String toString() {
		return "Pergunta: " + pegunta +"\n"+
				"Resposta: " + resposta +"\n"+ 
				"Destaque: " + destaque +"\n"+
				"Tags: " + tags;
	}
	
}
