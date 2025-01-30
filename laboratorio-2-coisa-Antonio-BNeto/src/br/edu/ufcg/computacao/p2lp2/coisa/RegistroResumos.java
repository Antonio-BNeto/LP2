package br.edu.ufcg.computacao.p2lp2.coisa;


/**
* classe que registra os resumos feito pelo aluno. Todo aluno pode armazernar uma quantidade limitada de resumos
* 
* @author Antonio Barros De Alcantara Neto
*/
public class RegistroResumos {
	// Definindo os atributos
	
	/**
	 * Uma lista de Strings que vai armazenar os temas dos resumos feito pelo aluno.
	 */
	private String[] temas;
	
	/**
	 * Uma lista de Strings que vai armazenar o conteudo dos resumos criados pelo aluno.
	 */
	private String[] resumos;
	
	/*
	 * Variavel auxiliar que ajuda a se locomover pelas listas de resumos e de temas.
	 */
	private int indiceResumoTema;
	
	/**
	 * construtor - constroi uma lista com diversos null para que o aluno possa ficar inserindo os seus resumos.
	 * 
	 * @param numerosDeResumos - o limite de resumos que o aluno podera fazer
	 */
	public RegistroResumos(int numerosDeResumos){
		this.temas = new String[numerosDeResumos];
		this.resumos = new String[numerosDeResumos];
		this.indiceResumoTema = 0; 
	}
	
	/**
	 * adiciona o tema na lista de temas e o resumo na lista de resumos.
	 * 
	 * @param tema - tema do resumo que o aluno fez
	 * @param resumo - o conteudo que esta dentro do resumo.
	 */
	public void adiciona(String tema, String resumo) {
		this.temas[indiceResumoTema] = tema;
		this.resumos[indiceResumoTema] = resumo;
		
		if (this.indiceResumoTema < (this.resumos.length-1)) {
			this.indiceResumoTema ++;
		} else {
			this.indiceResumoTema = 0 ;
		}
		
	}
	
	/**
	 * Separa os resumos que contem algum conteudo na lista e os retorna
	 * 
	 * @return - retorna os resumos validos da lista.
	 */
	public String[] pegaResumos(){
		int resumosValidos = 0;
		
		for(int i = 0; i< this.resumos.length; i++){
			if(this.resumos[i]!= null){
				resumosValidos ++;
			}else {
				break;
			}
		}
		
		String[] resumosSaida = new String[resumosValidos];
		
		for(int i = 0; i< resumosValidos; i++){
			resumosSaida[i] = this.temas[i] + ": "+ this.resumos[i];
		}
		
		return resumosSaida;
	}
	
	/**
	 * Pega a lista de resumos validos e o imprime.
	 * 
	 * @return - retorna uma String com os resumos cadastrados e os temas.
	 */
	public String imprimeResumos() {
		int resumosCadastrados = 0;
		
		StringBuffer sb = new StringBuffer("- ");
		
		for (int i = 0; i<this.resumos.length; i++) {
			if(this.resumos[i] != null) {
				if(i > 0) {
					sb.append(" | " + this.temas[i]);
				} else {
					sb.append(this.temas[i]);
				}
				resumosCadastrados ++;
			} else {
				break;
			}
		}
		
		return "- " 
				+ resumosCadastrados + 
				"  resumo(s) cadastrado(s)" 
				+"\n"+ 
				sb.toString(); 
	}
	
	/**
	 * Conta quantos resumos validos se encontram na lista
	 * 
	 * @return - Retorna a quantidade de resumos validos armazenados na lista
	 */
	public int conta(){
		int length = 0;
		for(int i = 0; i< this.resumos.length; i++){
			if(this.resumos[i] != null){
				length ++;
			}else {
				break;
			} 
		}
		
		return length;
	}
	
	/**
	 * Analisa se o resumo existe na lista apartir do nome do resumo
	 * 
	 * @param tema - nome que o resumo possui.
	 * @return - retorna um valor boolean afirmando se o resumo existe ou não existe na lista
	 */
	public boolean temResumo(String tema){
		for(int i = 0; i < this.resumos.length; i++) {
			if(this.temas[i] == tema){
				return true;
			}
		}
		return false;
	}
	
	

}
