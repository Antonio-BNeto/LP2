package br.edu.ufcg.computacao.complementaccc;

/**
 * Fachada do Sistema ComplementaCCC.
 * 
 * @author Antonio Barros De Alcantara Neto
 *
 */

public class ComplementaCCCFacade {
	//declarar controladores
	UsuarioController user = new UsuarioController();
	FAQController faq = new FAQController(user);
	AtividadeController atv = new AtividadeController(user);
	RelatorioController relatorio = new RelatorioController(user);
	
	boolean criarEstudante(String nome, String cpf, int senha, String matricula) {
		return user.criarEstudante(nome, cpf, senha, matricula);
	}
	
	String[] exibirEstudantes(String cpf, int senha){
		//ADMIN
		return user.exibirEstudantes(cpf, senha);
	}
	
	boolean alterarEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
		return user.alterarEstudante(cpf, senha, tipoAlteracao, novoValor);
	}
	
	String exibirAdmin(String cpf, int senha){
		//ADMIN
		return user.exibirAdmin(cpf, senha);
		
	}
	
	boolean configurarNovoADMIN(String cpf, int senhaAtual, String cpfNovo, int senhaNova){
		//ADMIN
		return user.configurarNovoAdmin(cpf, senhaAtual, cpfNovo, cpfNovo, senhaNova);
	}
	
	boolean configurarSenhaADMIN(String cpf, int senhaAtual, int senhaNova){
		return user.configurarSenhaAdmin(cpf, senhaAtual, senhaNova);
		//ADMIN
	}
	
	boolean adicionarItemFAQ(String cpf, int senha, String pergunta) {
		//ADMIN
		return faq.adicionarItemFAQ(cpf,senha,pergunta);
	}
	
	boolean adicionarItemFAQ(String cpf, int senha, String pergunta, String resposta) {
		//ADMIN
		return faq.adicionarItemFAQ(cpf, senha,pergunta, resposta);
	}
	
	boolean alteraRespostaItem(String cpf, int senha, int itemIndex, String resposta) {
		//ADMIN
		return faq.alterarRespostaItem(cpf, senha, itemIndex, resposta);
	}
	
	String[] listarFAQ() {
		return faq.listarFAQ();
	}
	
	String[] listarFAQPorDestaque() {
		return faq.listarFAQPorDestaque();
	}
	
	boolean destacarItem(int itemIndex) {
		return faq.destacarItem(itemIndex);
	}
	
	boolean atribuirTagsItemFAQ(String cpf, int senha,int itemIndex, String[] tags) {
		//ADMIN
		return faq.atribuirTagsItemFAQ(cpf, senha, itemIndex, tags);
	}
	
	String[] buscarItemFAQ(String[] tags) {
		return faq.buscarItemFAQ(tags);
	}
	
	String criarAtividadeMonitoriaEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		//Estudante
		return atv.criarAtividadeMonitoriaEmEstudante(cpf,senha,tipo, unidadeAcumulada, disciplina);		
	}
	
	boolean alterarDescricaoAtividade(String cpf, int senha, String codigoAtividade, String descricao) {
		//Estudante
		return atv.alterarDescricaoAtividade(cpf,senha,codigoAtividade, descricao);
	}
	
	boolean alterarComprovacaoAtividade(String cpf, int senha, String codigoAtividade, String linkComprovacao) {
		return atv.alterarComprovacaoAtividade(cpf,senha,codigoAtividade, linkComprovacao);
	}
	
	String criarAtividadePesquisaExtensaoEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		//Estudante
		return atv.criarAtividadePesquisaExtensaoEmEstudante(cpf, senha,tipo, unidadeAcumulada, disciplina);
	}
	
	String criarAtividadeEstagioEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		//Estudante
		return atv.criarAtividadeEstagioEmEstudante(cpf,senha, tipo, unidadeAcumulada, disciplina);
	}
	
	String criarAtividadePublicacaoEmEstudante(String cpf, int senha, String tipo, String tituloArtigo, String doi, String qualis) {
		//Estudante
		return atv.criarAtividadePublicacaoEmEstudantes(cpf,senha, tipo, tituloArtigo, doi, qualis);
	}
	
	double creditosAtividade(String cpf, int senha, String codigoAtividade) { 
		//Estudante
		return atv.creditosAtividade(cpf,senha,codigoAtividade);
	}
	
	//Falta implementar
	int criarRelatorioCompleto(String cpf, int senha) {
		return relatorio.criarRelatorioCompleto(cpf, senha);
	}
	
	int criarRelatorioResumido(String cpf, int senha) {
		return relatorio.criarRelatorioResumido(cpf, senha);
	}
	
	int criarRelatorioPorATV(String cpf, int senha, String tipoAtividade) {
		return relatorio.criarRelatorioPorATV(cpf, senha, tipoAtividade);
	}
	
	String exibirRelatorio(String cpf, int senha, int indexRelatorio) {
		return "";
	}

}
