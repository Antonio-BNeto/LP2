package br.edu.ufcg.computacao.complementaccc;

/**
 * Controlador das atividades que vão ser adicionada no estudante.
 * 
 * @author Antonio Barros De Alcantara Neto.
 */

public class AtividadeController {
	//Definindo Atributos.
	
	/**
	 * Controlador do Usuario.
	 */
	private UsuarioController user;
	
	/**
	 * Metodo construtor da AtiviadeController. 
	 * 
	 * @param user - Um UsuarioController pra poder adicionar ativiades no estudante. 
	 */
	public AtividadeController(UsuarioController user) {
		this.user = user;
	} 
	
	/**
	 * Metodo que adiciona uma atividade em um estudante.
	 * 
	 * @param cpf - cpf do estudante que vai ser adicionado a atividade.
	 * @param atv - atividade que vai ser adicionada no estudante.
	 */
	private void adicionaAtividadeEstudante(String cpf, Atividade atv) {
		user.pegaEstudante(cpf).adicionaAtividade(atv);
	}
	
	/**
	 * Metodo que valida a entrada de um Tipo como parâmetro.
	 * 
	 * @param tipo - Tipo da Atividade.
	 */
	private void validaTipo(String tipo) {
		String[] tiposValidos = new  String[] {"ESTÁGIO","MONITORIA", "PESQUISA/EXTENSÃO", "PUBLICAÇÃO<PERIÓDICO>", "PUBLICAÇÃO<CONFERÊNCIA>"};
		for(String s: tiposValidos) {
			if(s.equalsIgnoreCase(tipo)) {
				return;
			}
		}
		
		throw new IllegalArgumentException("TIPO INVÁLIDO"); 
	}
	
	/**
	 * Metodo que valida o tipo de qualis que um artigo vai ter.
	 * 
	 * @param qualis - Qualis que vai ser validado.
	 */
	private void validaQualis(String qualis) {
		String[] tipoQualis = new String[] {"a1", "a2", "a3", "a4", "b1"};
		
		for(String s: tipoQualis) {
			if(s.equalsIgnoreCase(qualis)) {
				return;
			}
		}
		throw new IllegalArgumentException("QUALIS INVÁLIDO");
	}
	
	/**
	 * Metodo que valida a entrada de uma unidadeAcumulada como parâmetro.
	 * 
	 * @param unidadeAcumulada - Unidade Acumulada da Atividade.
	 */
	private void validaUnidadeAcumulada(int unidadeAcumulada) {
		if(unidadeAcumulada<=0) {
			throw new IllegalArgumentException("UNIDADE ACUMULADA INVÁLIDA");
		}
	}
	
	/**
	 * Metodo que valida a entrada de um titulo.
	 * 
	 * @param titulo - Titulo que vai ser validado.
	 */
	private void validaTitulo(String titulo) {
		if(titulo.isBlank() || titulo == null) {
			throw new IllegalArgumentException("TÍTULO INVÁLIDO");
		}
	}
	
	/**
	 *Metodo que valida a entrada de um doi como parametro.
	 * 
	 * @param doi - Doi que vai ser validado.
	 */
	private void validaDoi(String doi) {
		if(doi.isBlank()|| doi == null) {
			throw new IllegalArgumentException("DOI INVÁLIDO");
		}
	}
	
	/**
	 * Metodo que valida a entrada de uma disciplina como parâmetro .
	 * 
	 * @param disciplina - Disciplina da Atividade.
	 */
	private void validaDisciplina(String disciplina) {
		if(disciplina.isBlank()|| disciplina == null) {
			throw new IllegalArgumentException("DISCIPLINA INVÁLIDA");
		}
	}
	
	/**
	 * Metodo que valida a entrada de um link como parâmetro.
	 * 
	 * @param link - Link da Atividade.
	 */
	private void validaLink(String link) {
		if(link.isBlank()|| link == null) {
			throw new IllegalArgumentException("LINK INVÁLIDO");  
		}
	}
	
	/**
	 * Metodo que valida a entradad ed uma descrição como parâmetro.
	 * 
	 * @param descricao - Descrição de uma Atividade.
	 */
	private void validaDescricao(String descricao) {
		if(descricao.isBlank()|| descricao == null) {
			throw new IllegalArgumentException("DESCRIÇÃO INVÁLIDA");
		}
	}
	
	/**
	 * Metodo que cria uma atividade do tipo Monitoria e armazena ela em um estudante com base no seu cpf.Verifiquei se o tipo da atividade de Monitoria é igual a monitoria,
	 * pois não faz sentido criar uma atividade de monitoria e colocar o tipo como estágio.
	 * 
	 * 
	 * @param cpf - Cpf do estudante.
	 * @param senha - Senha do estudante.
	 * @param tipo - Tipo da atividade complementar.
	 * @param unidadeAcumulada - unidade acumulada da atividade complementar.
	 * @param disciplina - disciplina da atividade complementar.
	 * @return - Se a atividade foi adicionada no estudante "Atividade Adicionada" ou "Erro" caso o contrario.
	 */
	public String criarAtividadeMonitoriaEmEstudante(String cpf,int senha,String tipo, int unidadeAcumulada, String disciplina) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		validaTipo(tipo);
		validaUnidadeAcumulada(unidadeAcumulada);
		validaDisciplina(disciplina);
		
		if(!(user.verificaEstudante(cpf, senha))) {
			return "Erro";
		}
		if(!(tipo.equalsIgnoreCase("MONITORIA"))) {
			return  "O tipo dessa atividade é pra ser MONITORIA";
		}
		Atividade atv = new AtividadeMonitoria(tipo, cpf+user.pegaEstudante(cpf).getQtdAtividades(), unidadeAcumulada, disciplina);
		adicionaAtividadeEstudante(cpf, atv);
		return "Atividade adicionada";
	}
	
	
	/**
	 * Metodo que altera a descrição de uma ativiade.
	 * 
	 * 
	 * @param cpf - Cpf do estudante a qual a atividade está armazenado.
	 * @param senha - Senha do estudante.
	 * @param codigoAtividade - codigo da Aividade no Estudante.
	 * @param descricao - Descrição que vai ser adicioada na ativiadade.
	 * @return - true: Se a descrição for adicionada com sucesso/false:Se a descrição não for adicionada.
	 */
	public boolean alterarDescricaoAtividade(String cpf,int senha,String codigoAtividade, String descricao) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		validaDescricao(descricao);
		
		if(!(user.verificaEstudante(cpf, senha))) {
			return false;
		}
		user.pegaEstudante(cpf).pegaAtividadeDoEstudante(codigoAtividade).setDescricao(descricao);
		return true;
		
	}
	
	/**
	 * Metodo que altera o comprovação da Atividade ou o Link.
	 * 
	 * @param cpf - Cpf do estudante.
	 * @param senha - Senha do estudante.
	 * @param codigoAtividade - codigo da Atividade.
	 * @param linkComprovacao - Link de comprovação que vai ser adicionada.
	 * @return true:Se a comprvação for adicionada/false:Se a comprovação não for adicionada.
	 */
	public boolean alterarComprovacaoAtividade(String cpf,int senha,String codigoAtividade, String linkComprovacao) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		validaLink(linkComprovacao);
		
		
		if(!user.verificaEstudante(cpf, senha)) {
			return false;
		}
		user.pegaEstudante(cpf).pegaAtividadeDoEstudante(codigoAtividade).setLink(linkComprovacao);
		return true;
	}
	
	/**
	 * Metodo que cria uma atividade de Pesquisa e Extensão para um estudante.
	 * 
	 * @param cpf -Cpf do estudante.
	 * @param senha - Senha do estudante.
	 * @param tipo - tipo da Atividade.
	 * @param unidadeAcumulada - Unidade Acumulada da Atividade.
	 * @param disciplina - Disciplina da Atividade complementar.
	 * @return - Se a atividade foi adicionada no estudante "Atividade Adicionada" ou "Erro" caso o contrario.
	 */
	public String criarAtividadePesquisaExtensaoEmEstudante(String cpf,int senha,String tipo, int unidadeAcumulada,String disciplina) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		validaTipo(tipo);
		validaUnidadeAcumulada(unidadeAcumulada); 
		validaDisciplina(disciplina);
		
		if(!(user.verificaEstudante(cpf, senha))) {
			return "Erro";
		}
		if(!(tipo.equalsIgnoreCase("PESQUISA/EXTENSÃO"))) {
			return  "O tipo dessa atividade é pra ser PESQUISA/EXTENSÃO";
		}
		Atividade atv = new AtividadePesquisaExtensao(tipo, cpf+user.pegaEstudante(cpf).getQtdAtividades(), unidadeAcumulada, disciplina);
		adicionaAtividadeEstudante(cpf, atv);
		return "Atividade adicionada";
		
	}
	
	/**
	 * Metodo que cria uma atividade do tipo Estagio para o estudante.
	 * 
	 * @param cpf - Cpf do estudante.
	 * @param senha - Senha do estudante.
	 * @param tipo - Tipo da Atividade. 
	 * @param unidadeAcumulada - Unidade de Acumulada da atividade.
	 * @param disciplina - Disciplina da atividade complementar.
	 * @return - Se a atividade foi adicionada no estudante "Atividade Adicionada" ou "Erro" caso o contrario.
	 */
	public String criarAtividadeEstagioEmEstudante(String cpf,int senha, String tipo, int unidadeAcumulada, String disciplina) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		validaTipo(tipo);
		validaUnidadeAcumulada(unidadeAcumulada);
		validaDisciplina(disciplina);
		
		if(!(user.verificaEstudante(cpf, senha))) {
			return "Erro";
		}
		
		if(!(tipo.equalsIgnoreCase("ESTÁGIO"))) {
			return  "O tipo dessa atividade é pra ser ESTÁGIO";
		}
		
		Atividade atv = new AtividadeEstagio(tipo, cpf+user.pegaEstudante(cpf).getQtdAtividades(), unidadeAcumulada, disciplina);
		adicionaAtividadeEstudante(cpf, atv);
		return "Atividade adicionada";
	}
	
	/**
	 * Metodo que cria uma atividade do tipo publicação para um estudante.
	 * 
	 * 
	 * @param cpf - Cpf do estudante que vai ser adicionada a atividade.
	 * @param senha - Senha do estudante.
	 * @param tipo - Tipo da Atividade.
	 * @param tituloArtigo - Titulo do Artigo.
	 * @param doi - Doi do artigo.
	 * @param qualis - Qualis do artigo.
	 * @return Se a atividade foi adicionada no estudante "Atividade Adicionada!" ou "Erro" caso o contrario.
	 */
	public String criarAtividadePublicacaoEmEstudantes(String cpf,int senha ,String tipo, String tituloArtigo, String doi, String qualis) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		validaTipo(tipo);
		validaTitulo(tituloArtigo);
		validaDoi(doi);
		validaQualis(qualis);
		
		
		if(!(user.verificaEstudante(cpf, senha))) { 
			return "Erro";
		}
		if(!(tipo.equalsIgnoreCase("PUBLICAÇÃO<PERIÓDICO>")|| tipo.equalsIgnoreCase("PUBLICAÇÃO<CONFERÊNCIA>"))) {
			return  "O tipo dessa atividade é pra ser PUBLICAÇÃO<PERIÓDICO> ou PUBLICAÇÃO<CONFERÊNCIA>";
		}
		Atividade atv = new AtividadePublicacao(tipo, cpf+user.pegaEstudante(cpf).getQtdAtividades(), tituloArtigo, doi, qualis);
		adicionaAtividadeEstudante(cpf, atv);
		return "Atividade adicionada";
	}
	
	/**
	 * Metodo que pega o credito gerado por uma atividade especifica armazenada no estudante.
	 * 
	 * @param cpf - Cpf do estudante.
	 * @param senha - Senha do estudante.
	 * @param codigoAtividade - Codigo da atividade armazenada no estudante.
	 * @return 
	 */
	public double creditosAtividade(String cpf,int senha,String codigoAtividade) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		
		if(user.verificaEstudante(cpf, senha)) {
			return user.pegaEstudante(cpf).pegaAtividadeDoEstudante(codigoAtividade).calculaCreditos();
		}
		return -1;
	}
}
