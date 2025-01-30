package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Classe que representa um objeto Usuario Estudante.
 * 
 * @author Antonio Barros De Alcantara Neto.
 *
 */

public class UsuarioEstudante extends Usuario{
	//Definindo atributos.
	
	/**
	 * Matricula do estudante.
	 */
	private String matricula;
	/**
	 * Quantidade de atividades armazenadas atualmente no estudante.
	 */
	private int qtdAtividades;
	/**
	 * Atividades que foram criadas e armazenadas no estudante.
	 */
	private Map<String, Atividade> atividadesDoEstudante;
	/**
	 * Relatorios criados pelo estudante.
	 */
	private List<String> relatorios;
	
	/**
	 * Metodo construtor do Usuario Estudante. 
	 * 
	 * @param nome - Nome do estudante.
	 * @param cpf - cpf do estudante.
	 * @param senha - senha do estudante.
	 * @param matricula - matricula do estudante.
	 */
	public UsuarioEstudante(String nome, String cpf, int senha, String matricula) {
		super(nome, cpf, senha);
		this.matricula = matricula;
		this.qtdAtividades = 1;
		this.atividadesDoEstudante = new HashMap<>();
		this.relatorios = new ArrayList<>();
	}
	
	/**
	 * Metodo que pega uma atividade que foi adicionada no estudante.
	 * 
	 * @param codigoAtividade - Codigo da atividade no Hashmap de atividades do estudante.
	 * @return - Retorna uma atividade com base no seu codigo.
	 */
	public Atividade pegaAtividadeDoEstudante(String codigoAtividade) {
		return atividadesDoEstudante.get(codigoAtividade);
	}
	
	/**
	 * Metodo que mostra quantas atividades foram adicionadas no estudante.
	 * 
	 * @return - Quantidade de atividades armazenadas no estudante.
	 */
	public int getQtdAtividades() { 
		return qtdAtividades;
	}

	/**
	 * Metodo que adiciona uma atividade nas atividades do estudante.
	 * 
	 * @param atv - Atividade que vai ser adicionada no estudante.
	 */
	public void adicionaAtividade(Atividade atv) {
		atividadesDoEstudante.put(atv.getCodigo(), atv);
		this.qtdAtividades++;
	}
	
	/**
	 * Metodo que cria uma ArrayList que irá armazenar todas as atividades do estudante.
	 * 
	 * @return - Uma lista que vai conter todas as atividades do estudante.
	 */
	public List<Atividade> atividadesDoEstudante() { 
		List<Atividade> atividades = new ArrayList<>();
		
		for(Atividade atv: atividadesDoEstudante.values()) {
			atividades.add(atv);
		}
		Collections.sort(atividades);
		
		return atividades;
	}
	
	/**
	 * Metodo que vai adicionar um relatorio no estudante.
	 * 
	 * @param relatorio - Relatorio que vai ser armazenado no estudante.
	 */
	public int adicionaRelatorio(String relatorio) {
		relatorios.add(relatorio);
		return relatorios.size();
	}
	
	/**
	 * Metodo que retorna a representação textual de um relatorio armazenado no estudante.
	 * 
	 * @param indexItem - indice que vai ser pego o relatorio armazenado.
	 * @return - Retorna uma representação textual de um relatorio dependendo do tipo de relatorio.
	 */
	public String pegaRelatorio(int indexItem) {
		return relatorios.get(indexItem-1);
	}
	
	/**
	 * Representação textual de um Usuario Estudante.
	 */
	@Override
	public String toString() {
		return "NOME: "+ this.nome +"\n"+
				"CPF: " + this.cpf+ "\n"+ 
				"MATRICULA: " + this.matricula;	
	}
	
	/**
	 * Metodo que vai comparar dois usuarios estudantes com base no seu cpf.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEstudante other = (UsuarioEstudante) obj;
		return Objects.equals(cpf, other.cpf);
	}	
}