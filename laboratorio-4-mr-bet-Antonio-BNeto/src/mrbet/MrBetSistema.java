package mrbet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Sistema que armazena Times, Campeonatos e Apostas, que o usúario cadastra. 
 * 
 * @author Antonio Barros de Alcantara Neto - 123110363
 *
 */

public class MrBetSistema {
	//Definindo Atributos
	
	/**
	 * Coleção que armazena os times adicionados no sistema.
	 */
	private HashMap<String, Time> times;
	/*
	 * coleção que armazena os campeonatos adicionados no sistema.
	 */
	private HashMap<String, Campeonato> campeonatos;
	/**
	 * Coleção que armazena de forma sequencial as apostas adicionadas no sistema.
	 */
	private ArrayList<Aposta> apostas;
	
	/**
	 * Construtor do Sistema.
	 */
	public MrBetSistema() {
		this.times = new HashMap<>();
		this.campeonatos = new HashMap<>();
		this.apostas = new ArrayList<>();
	}
	
	/**
	 * Metodo que valida se o codigo do time é valido.
	 * 
	 * @param codigoTime - Codigo que identifica o time.
	 */
	private void validarCodigoTime(String codigoTime) {
		if(codigoTime == null || codigoTime.isEmpty()) {
			throw new IllegalArgumentException("O CÓDIGO DO TIME É INVÁLIDO");
		}
	}
	
	/**
	 * Metodo que valida se o nome do time é valido.
	 * 
	 * @param nome - Nome do time
	 */
	private void validarNomeTime(String nome) {
		if(nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("NOME DO TIME É INVÁLIDO ");
		}
	}
	
	/**
	 * Metodo que valida se o mascote do time é valido.
	 * 
	 * @param mascote - Mascote do time
	 */
	private void validarMascoteTime(String mascote) {
		if(mascote == null || mascote.isEmpty()) {
			throw new IllegalArgumentException("O MASCOTE É INVÁLIDO");
		}
	}
	
	/**
	 * Metodo que valida se o nome do campeonato é valido.
	 * 
	 * @param nomeCampeonato - Nome do Campeonato
	 */
	private void validarNomeCampeonato(String nomeCampeonato) {
		if(nomeCampeonato == null || nomeCampeonato.isEmpty()) {
			throw new IllegalArgumentException("NOME DO CAMPEONATO INVALÍDO");
		}
	}
	
	/**
	 * Metodo que valida se o numero de participantes do campeonato é valido.
	 * 
	 * @param quantMaxParticipantes - quantidade de participantes que um campeonato possui.
	 */
	private void validarParticipantesCampeonato(int quantMaxParticipantes) {
		if(quantMaxParticipantes <= 0) {
			throw new IllegalArgumentException("QUANTIDADE DE PARTICIPANTES INVÁLIDA"); 
		}
	}
	
	/**
	 * Metodo que verifica se o time existe no sistema
	 * 
	 * @param codigoTime - Código do time.
	 */
	private void verificarExisteTime(String codigoTime) {
		if(!this.times.containsKey(codigoTime)) {
			throw new IllegalArgumentException("O TIME NÃO EXISTE!");
		}
	}
	
	/**
	 * Metodo que verifica se o campeonato existe no sistema.
	 * 
	 * @param nomeCampeonato - Nome do Campeonato.
	 */
	private void verificarExisteCampeonato(String nomeCampeonato) {
		if(!this.campeonatos.containsKey(nomeCampeonato.toLowerCase())) {
			throw new NullPointerException("O CAMPEONATO NÃO EXISTE!");
		}
	}
	
	/**
	 * Metodo que valida se a colocação da aposta é valida.
	 * 
	 * @param colocacao - Colocação que o usúario acha que o time vai chegar.
	 */
	private void validarColocacaoAposta(int colocacao) {
		if(colocacao <= 0) {
			throw new IllegalArgumentException("COLOCAÇÃO INVÁLIDA");
		}
	}
	
	/**
	 * Metodo que valida se o valor da aposta é valido.
	 * 
	 * @param valorAposta
	 */
	private void validarValorAposta(double valorAposta) {
		if(valorAposta <= 0) {
			throw new IllegalArgumentException("VALOR DA APOSTA INVÁLIDO");
		}
	}
	
	/**
	 * Metodo que adiciona um Time no Sistema caso o codigo do time não exista no sistema adicionado.
	 * 
	 * @param codigoTime - Codigo que identifica o time no sistema.
	 * @param nome - Nome do Time.
	 * @param mascote - Mascote que o time tem.
	 * @return - Uma mensagem indicando se o time foi adicionao no sistema.
	 */
	public String adicionaTime(String codigoTime, String nome, String mascote){
		validarCodigoTime(codigoTime);
		validarNomeTime(nome);
		validarMascoteTime(mascote);
		
		if(!this.times.containsKey(codigoTime)) {
			Time time = new Time(codigoTime, nome, mascote);
			this.times.put(codigoTime, time);
			return "INCLUSÃO REALIZADA!";
		}
		return "TIME JÁ EXISTE!";
	}
	
	/**
	 * Metodo que recupera um time adicionado no sistema com uma saida formatada.
	 * 
	 * @param codigoTime - Codigo que identifica o time no sistema.
	 * @return - Uma representação textual de um time.
	 */
	public String recuperaTime(String codigoTime) {
		validarCodigoTime(codigoTime);
		
		if(!this.times.containsKey(codigoTime)) {
			 return "TIME NÃO EXISTE!";
		}
		return this.times.get(codigoTime).toString();
	}	
	
	/**
	 * Metodo que adiciona um Campeonato no Sistema caso ele não exista.
	 * 
	 * @param nomeCampeonato - Nome do campeonato.
	 * @param quantMaxParticipantes - Quantidade maxima de participantes que um campeonato pode ter.
	 * @return - Uma mensagem indicando se o campeonato doi adicionado no sistema.	 
	 */
	public String adicionaCampeonato(String nomeCampeonato, int quantMaxParticipantes) {
		validarNomeCampeonato(nomeCampeonato);
		validarParticipantesCampeonato(quantMaxParticipantes);
		
		if(!campeonatos.containsKey(nomeCampeonato.toLowerCase())) {
			Campeonato camp = new Campeonato(nomeCampeonato, quantMaxParticipantes);
			this.campeonatos.put(nomeCampeonato.toLowerCase(), camp);
			return "CAMPEONATO ADICIONADO!";
		}
		return "CAMPEONATO JÁ EXISTE!";
	}
	
	/**
	 * Metodo que inclui um time em um campeonato existentes no sistema.
	 * 
	 * @param codigoTime - Codigo do Time que vai ser adicionado no campeonato.
	 * @param nomeCampeonato - Nome do campeonato que vai receber o time.
	 * @return - Uma mensagem indicando se o time foi incluido no campeonato.
	 */
	public String incluiTimeCampeonato(String codigoTime, String nomeCampeonato) {
		verificarExisteCampeonato(nomeCampeonato);
		verificarExisteTime(codigoTime);
		
		if(campeonatos.get(nomeCampeonato.toLowerCase()).addTimeNoCampeonato(times.get(codigoTime))) {
			return "TIME INCLUÍDO NO CAMPEONATO!";
		}
		return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS";
			
	}
	
	/**
	 * Metodo que verifica se um time existe dentro de um campeonato especifco.
	 * 
	 * @param codigoTime - Codigo do time que vai ser buscado dentro do campeonato.
	 * @param nomeCampeonato - Nome do campeoanto que vai ser realizada a busca.
	 * @return - Uma mensagem indicando se o time foi cadastrado no campeonato.
	 */
	public String verificaTimeCampeonato(String codigoTime, String nomeCampeonato) {
		validarCodigoTime(codigoTime);
		validarNomeCampeonato(nomeCampeonato);
		verificarExisteCampeonato(nomeCampeonato);
		verificarExisteTime(codigoTime);
		
		if(campeonatos.get(nomeCampeonato.toLowerCase()).buscaTimeEmCampeonato(times.get(codigoTime))) {
			return "O TIME ESTÁ NO CAMPEONATO!";
		}
		return "O TIME NÃO ESTÁ NO CAMPEONATO!";
		
	}
	
	/**
	 * Metodo que exibe os campeonatos que um determinado time participa de forma formatada.
	 * 
	 * @param codigoTime - Codigo do time que vai ser buscado dentro dos campeonatos.
	 * @return - Todos os campeonatos que o Time participa.
	 */
	public String exibeCampeonatosTime(String codigoTime) {
		validarCodigoTime(codigoTime);
		verificarExisteTime(codigoTime);
		
		StringBuilder exibeJogosTime = new StringBuilder();
		exibeJogosTime.append("Campeonatos do " + times.get(codigoTime).getNome() + ":");
		for(Campeonato campeonato: campeonatos.values()) {
			if(campeonato.buscaTimeEmCampeonato(times.get(codigoTime))) {
				exibeJogosTime.append("\n").append("* ").append(campeonato.toString());
			}
		}
		return exibeJogosTime.toString();
		
	}
	
	/**
	 * Metodo que adiciona uma aposta no sistema.
	 * 
	 * @param codigoTime - Codigo do Time que vai participar da aposta. 
	 * @param nomeCampeonato - Nome do campeonato que vai ser a aposta.
	 * @param colocacao - Colocação que o usuário acha que o time chega dentro do campeonato.
	 * @param valorAposta - Valor que o usuário vai apostar.
	 * @return - Uma Mensagem indicando se a aposta foi registrada.
	 */
	public String adicionaAposta(String codigoTime, String nomeCampeonato, int colocacao, double valorAposta) {
		validarCodigoTime(codigoTime);
		validarNomeCampeonato(nomeCampeonato);
		validarColocacaoAposta(colocacao);
		validarValorAposta(valorAposta);
		verificarExisteCampeonato(nomeCampeonato);
		verificarExisteTime(codigoTime);
		
		if(colocacao <= campeonatos.get(nomeCampeonato.toLowerCase()).getQuantMaxParticipantes()) {
			Aposta aposta = new Aposta(times.get(codigoTime), campeonatos.get(nomeCampeonato.toLowerCase()), colocacao, valorAposta);
			apostas.add(aposta);
			return "APOSTA REGISTRADA!";
		}	
		return "APOSTA NÃO REGISTRADA!";
	}
	
	/**
	 * Metodo que retorna todas as apostas cadastradas no Sistema.
	 * 
	 * @return - As apostas adicionadas no sistema na ordem de inserção.
	 */
	public String statusAposta() {
		int ordem = 1;
		StringBuilder output = new StringBuilder("Apostas:\n");
		for(Aposta aposta: apostas) {
			output.append("\n").append(ordem++).append(". ").append(aposta.toString());
		}
		return output.toString();
	}
}
