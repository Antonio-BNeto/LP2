package br.edu.ufcg.computacao.complementaccc;

import java.util.Comparator;

/**
 * Classe Abstrata do Usuario.
 * 
 * @author Antonio Barros De Alcantara Neto.
 *
 */
public class Usuario implements Comparable<Usuario>{
	//Definindo atributos
	
	/*
	 * Nome do Usuario.
	 */
	protected String nome;
	/**
	 * Cpf do Usuario.
	 */
	protected String cpf;
	/**
	 * Senha do Usuario.
	 */
	protected int senha;
	
	/**
	 * Metodo construtor de um Usuario.
	 * 
	 * @param nome - Nome do Usuario.
	 * @param cpf - Cpf do Usuario.
	 * @param senha - Senha do Usuario.
	 */
	public Usuario(String nome, String cpf, int senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	/**
	 * Metodo que retorna o nome do Usuario.
	 * 
	 * @return - Retorna o nome do Usuario.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Metodo que muda o nome do Usuario.
	 * 
	 * @param nome - Nome que vai ser colocado no lugar do nome anterior.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Metodo que retorna o cpf do Usuario.
	 * 
	 * @return - Retorna o cpf do Usuario.
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Metodo que muda o cpf do Usuario
	 * 
	 * @param cpf - Cpf que vai se colocado no Usuario.
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * Metodo que Retorna a senha do Usuario.
	 * 
	 * @return - Retorna a senha do estudante.
	 */
	public int getSenha() {
		return senha;
	}

	/**
	 * Metodo que vai colocar uma nova senha no Usuario.
	 * 
	 * @param novaSenha - Nova senha que vai ser colocada no Usuario.
	 */
	public void setSenha(int novaSenha) {
		this.senha = novaSenha;
	}

	/**
	 * Metodo que compara dois usuarios com base na ordem alfabetica dos nomes.
	 */
	@Override
	public int compareTo(Usuario usuario) {
		return this.nome.compareTo(usuario.getNome());
	}
	
}
