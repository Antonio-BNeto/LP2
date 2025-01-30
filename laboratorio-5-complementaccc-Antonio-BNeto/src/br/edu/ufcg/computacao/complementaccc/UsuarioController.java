package br.edu.ufcg.computacao.complementaccc;

import java.util.HashMap;

/**
 * Controlador dos Usuarios.
 * 
 * @author Antonio Barros De Alcantara Neto.
 *
 */
public class UsuarioController {
	//Definindo Atributos
	
	/**
	 * Os usuarios estudantes do sistema.
	 */
	private HashMap<String, UsuarioEstudante> estudantes;
	/**
	 * O usuario Admin do Sistema.
	 */
	private UsuarioAdmin admin;
	
	/**
	 * Metodo contrutor do UsuarioController.
	 */ 
	public UsuarioController() { 
		this.estudantes = new HashMap<>();
		this.admin = new UsuarioAdmin("Admin", "12345678910", 12345678);
	}
	
	/**
	 * Metodo que retorna um objeto Usuario exitente no controlador.
	 * 
	 * @param cpf - Cpf do estudante.
	 * @return - Retorna um objeto armazenado no controlador.
	 */
	protected UsuarioEstudante pegaEstudante(String cpf) {
		return estudantes.get(cpf);
	}
	
	/**
	 * Metodo que valida o nome passado como parametro.
	 * 
	 * @param nome - Nome do Usuario.
	 */
	private void validaNome(String nome) {
		if(nome == null|| nome.isBlank()) {
			throw new IllegalArgumentException("NOME INVÁLIDO!");
		}
	}
	
	/**
	 * Metodo que valida o cpf passado como parâmetro.
	 * 
	 * @param cpf - Cpf do Usuario.
	 */
	protected void validaCpf(String cpf) {
		if(cpf == null|| cpf.isBlank()) {
			throw new IllegalArgumentException("CPF INVÁLIDO!");
		}
	}
	
	/**
	 * Metodo que valida a senha passado como parâmetro.
	 * 
	 * @param senha - Senha do Usuario.
	 */
	protected void validaSenha(int senha) {
		if(senha < 10000000 || senha > 99999999) {
			throw new IllegalArgumentException("SENHA INVÁLIDA!");
		}
	}
	
	/**
	 * Metodo que valida Matricula passado como parâmetro.
	 * 
	 * @param matricula - Matricula do estudante.
	 */
	private void validaMatricula(String matricula) {
		if(matricula == null || matricula.isBlank()) {
			throw new IllegalArgumentException("MATRICULA INVÁLIDA!");
		}
	}
	
	/**
	 * Metodo que verifica se o cpf e a senha passada como parametro são do Admin.
	 * 
	 * @param cpf - Cpf do Admin.
	 * @param senha - Senha do Admin.
	 * @return true:Se o cpf e a senha pertencerem ao Admin/false:Se o cpf e a senha não pertencerem ao Admin.
	 */
	protected boolean verificaAdmin(String cpf, int senha) {
		validaCpf(cpf);
		validaSenha(senha);
		
		if(admin.getCpf().equals(cpf) && admin.getSenha() == senha) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Metodo que verifica se o cpf e a senha passadas como parametros pertencem a algum estudante armazenado no controllador de usuarios.
	 * 
	 * @param cpf - Cpf do Estudante.
	 * @param senha - Senha do Estudante.
	 * @return
	 */
	protected boolean verificaEstudante(String cpf, int senha){
		validaCpf(cpf);
		validaSenha(senha);
		
		if(estudantes.get(cpf)!= null) {
			if(estudantes.get(cpf).getSenha() == senha) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que cria um estudante no sistema.
	 * 
	 * @param nome - Nome do estudante.
	 * @param cpf - Cpf do Estudante.
	 * @param senha - Senha do Estudante.
	 * @param matricula - Matricula do estudante.
	 * @return - true:Se o estudante for adicionado no sistema/false: Se o estudante não for adicionado.
	 */
	public boolean criarEstudante(String nome, String cpf, int senha, String matricula){
		validaCpf(cpf);
		validaNome(nome);
		validaSenha(senha);
		validaMatricula(matricula);
		
		if(!(estudantes.containsKey(cpf))) {
			UsuarioEstudante estudante = new UsuarioEstudante(nome, cpf, senha, matricula);
			estudantes.put(cpf, estudante);
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que exibe os usúarios estudantes por padrão é em ordem alfabetica. Quem realiza esse metodo é o Admin do Sistema.
	 * 
	 * @param cpf - Cpf do Admin.
	 * @param senha - Senha do Admin.
	 * @return - Um array com as representações textuais de cada estudante armazenado no sistema ou null se a senha e o cpf não forem do admin. 
	 */
	public String[] exibirEstudantes(String cpf, int senha) {
		validaCpf(cpf);
		validaSenha(senha);
		
		if(verificaAdmin(cpf, senha)) {
			return estudantes.values().stream().sorted().map(UsuarioEstudante::toString).toArray(String[]::new);			
		}
		
		return null;
		
	}
	
	/**
	 * Metodo que vai alterar a senha ou o nome de um estudante específico.
	 * 
	 * @param cpf - Cpf do Estudante.
	 * @param senha - Senha do Estudante.
	 * @param tipoAlteracao - Qual a alteração que vai ser realizada.
	 * @param novoValor - Novo valor que vai ser adicionado.
	 * @return - true:Se a mudança for realizada./ false:Se a mudança não for realizada.
	 */
	public boolean alterarEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
		validaCpf(cpf);
		validaSenha(senha);
		
		if(!verificaEstudante(cpf, senha)) {
			return false;
		}
		switch(tipoAlteracao.toLowerCase()) {
		case "senha":
			validaSenha(Integer.parseInt(novoValor));
			estudantes.get(cpf).setSenha(Integer.parseInt(novoValor));
			return true;
		case "nome":
			validaNome(novoValor);
			estudantes.get(cpf).setNome(novoValor);
			return true;
		default:
			return false;
		}
	}
	
	/**
	 * Metodo que mostra uma representação textual do Admin do Sistema.
	 * 
	 * @param cpf - Cpf do Admin.
	 * @param senha - Senha do Admin.
	 * @return - ToString do Admin/Ou "O cpf ou a senha não pertencem ao Admin!"
	 */
	public String exibirAdmin(String cpf, int senha) {
		validaCpf(cpf);
		validaSenha(senha);
		
		String output = "O cpf ou a senha não pertencem ao Admin!";
		
		if(verificaAdmin(cpf, senha)) {
			output = admin.toString();
		}
		
		return output;
	}
	
	/**
	 * Metodo que configura um novo Admin no sistema.
	 * 
	 * @param cpf - Cpf do Admin Atual.
	 * @param senhaAtual - Senha do Admin Atual.
	 * @param nomeNovo - Novo nome do Admin.
	 * @param cpfNovo - Novo cpf do Admin.
	 * @param SenhaNova - Nova Senha do Admin.
	 * @return - true:Se for realizada as alterações no Admin/ false:Se as alterações não forem realizadas.
	 */
	public boolean configurarNovoAdmin(String cpf, int senhaAtual, String nomeNovo, String cpfNovo, int senhaNova) {
		validaCpf(cpf);
		validaSenha(senhaAtual);
		validaNome(nomeNovo);
		validaCpf(cpfNovo);
		validaSenha(senhaNova);		
		
		if(verificaAdmin(cpf, senhaAtual)) {
			admin.setCpf(cpfNovo);
			admin.setNome(nomeNovo);
			admin.setSenha(senhaNova);
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que configura Uma nova Senha para o Admin.
	 * 
	 * @param cpf - Cpf do Admin atual.
	 * @param senhaAtual - Senha do Admin atual.
	 * @param senhaNova - Nova Senha do Admin.
	 * @return - true:Se for realizada com sucesso a troca da senha/false:Se a senha não for alterada. 
	 */
	public boolean configurarSenhaAdmin(String cpf, int senhaAtual, int senhaNova) {
		validaCpf(cpf);
		validaSenha(senhaAtual);
		validaSenha(senhaNova);
		
		if(verificaAdmin(cpf, senhaAtual)) {
			admin.setSenha(senhaNova);
			return true;
		}
		return false;
	}
}