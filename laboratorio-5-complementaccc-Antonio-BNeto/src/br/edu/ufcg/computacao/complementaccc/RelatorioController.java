package br.edu.ufcg.computacao.complementaccc;

public class RelatorioController {
	
	private UsuarioController user;
	
	public RelatorioController(UsuarioController user) {
		this.user = user;
	}
	
	public int criarRelatorioCompleto(String cpf, int senha) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		
		if(user.verificaEstudante(cpf, senha)) {
			Relatorio relatorio = new RelatorioDetalhado();
			relatorio.geraRelatorio(user.pegaEstudante(cpf).toString(),user.pegaEstudante(cpf).atividadesDoEstudante());
			return user.pegaEstudante(cpf).adicionaRelatorio(relatorio.exibeRelatorio());
		}
		return 0;
	} 
	
	public int criarRelatorioResumido(String cpf, int senha) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		
		if(user.verificaEstudante(cpf, senha)) {
			Relatorio relatorio = new RelatorioResumido();
			relatorio.geraRelatorio(user.pegaEstudante(cpf).toString(), user.pegaEstudante(cpf).atividadesDoEstudante());
			return user.pegaEstudante(cpf).adicionaRelatorio(relatorio.exibeRelatorio());
		}
		return 0;
	}
	
	public int criarRelatorioPorATV(String cpf, int senha, String tipoAtividade) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		
		if(user.verificaEstudante(cpf, senha)) {
			Relatorio relatorio =  new RelatorioResumidoAtv();
			relatorio.geraRelatorioPorTipo(user.pegaEstudante(cpf).toString(),tipoAtividade ,user.pegaEstudante(cpf).atividadesDoEstudante());
			return user.pegaEstudante(cpf).adicionaRelatorio(relatorio.exibeRelatorio());
		}
		return 0;
	}
	
	public String exibirRelatorio(String cpf, int senha, int indexRelatorio) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		
		if(user.verificaEstudante(cpf, senha)) {
			return user.pegaEstudante(cpf).pegaRelatorio(indexRelatorio);
		}
		return "";
	}
	
}
