package br.edu.ufcg.computacao.complementaccc;

import java.util.*;

/**
 * Controlador das FAQs.
 * 
 * @author Antonio Barros De Alcantara Neto.
 *
 */

public class FAQController {
	//Definindo Atributos
	
	/**
	 * Lista de vai armazenar todas as faqs criadas.
	 */
	private List<FAQ> faqs;
	/**
	 * UsuarioController que vai ser utilizado pra verificar se o cpf e a senha.
	 * pertence ao admin.
	 */
	private UsuarioController user; 
	
	/**
	 * Metodo construtor do Controlador de FAQ.
	 * 
	 * @param user - UsuarioController que vai ser pego o UsuarioAdmin.
	 */
	public FAQController(UsuarioController user) {
		this.faqs = new ArrayList<FAQ>();
		this.user = user;
	}
	
	
	/**
	 * Metodo que valida a entrada de uma pergunta, como as perguntas são do tipos interrogativas e com base na lingua portuguesa
	 * toda as perguntas apresentam o simbolo de interrogação, então verifiquei se no final da pergunta tem "?".
	 * 
	 * @param pergunta - Pergunta da FAQ.
	 */
	private void validaPergunta(String pergunta) {
		if(pergunta.isBlank() || pergunta == null || !(pergunta.endsWith("?"))) {
			throw new IllegalArgumentException("PERGUNTA INVÁLIDA");
		}
	}
	
	/**
	 * Metodo que valida a entrada de uma resposta.
	 * 
	 * @param resposta - Resposta de uma FAQ.
	 */
	private void validaResposta(String resposta) {
		if(resposta.isBlank() || resposta == null) {
			throw new IllegalArgumentException("RESPOSTA INVÁLIDA");
		}
		
	}
	
	/**
	 * Metodo que valida a entrada de tags como só é possivel armazenar 3 tags por faq,então 
	 * verifiquei se o tamanho do array de tags é 3 e se os elementos dentro deles é validos.
	 * 
	 * @param tags - Tags que vão ser armazenadas na FAQ.
	 */
	private void validaTags(String[] tags) {
		if(tags.length!= 3) {
			throw new IllegalArgumentException("TAGS INVÁLIDAS");
		}
		int cont = 0;
		for(String s : tags) {
			if(tags[cont] == null|| tags[cont].isBlank()) {
				throw new IllegalArgumentException("TAGS INVÁLIDAS");
			}
			cont++;
		}
		
	}
	
	/**
	 * Metodo que valida o indice que vai ser pega a FAQ armazenada no controller.
	 * 
	 * @param itemIndex - Indice da FAQ armazenada no controller.
	 */
	private void validaItemIndex(int itemIndex) {
		if(itemIndex<1 || itemIndex>faqs.size()) {
			throw new IllegalArgumentException("INDICE INVÁLIDO");
		}
	}
	
	/**
	 * Metodo que adiciona uma FAQ no controller sem uma resposta.
	 * 
	 * @param cpf - Cpf do Admin.
	 * @param senha - Senha do Admin.
	 * @param pergunta - Pergunta que vai ser adicionada.
	 * @return - true:Se for adicionada uma FAQ na lista/false:Se não for adicionada uma FAQ. 
	 */
	public boolean adicionarItemFAQ(String cpf, int senha,String pergunta) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		validaPergunta(pergunta);
		
		if(!user.verificaAdmin(cpf, senha)) {
			return false;
		}
		FAQ perg = new FAQ(pergunta);
		if(faqs.contains(perg)) {
			return false;
		}		
		faqs.add(perg);
		return true;
	}
	
	/**
	 *  Metodo que adiciona uma FAQ no Controller com uma resposta.
	 * 
	 * 
	 * @param cpf - Cpf do Admin.
	 * @param senha - Senha do Admin.
	 * @param pergunta - Pergunta que vai ser adicionada.
	 * @param resposta - Resposta que vai ser adicionada.
	 * @return - true:Se for adicionada a FAQ no sistema/false:Se não for adicionada uma FAQ no sistema.
	 */
	public boolean adicionarItemFAQ(String cpf, int senha, String pergunta, String resposta) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		validaPergunta(pergunta);
		validaResposta(resposta);
		
		if(!user.verificaAdmin(cpf, senha)) {
			return false;
		}
		FAQ perg = new FAQ(pergunta, resposta);
		if(faqs.contains(perg)) {
			return false;
		}
		faqs.add(perg);
		return true;
	}
	
	/**
	 * Metodo que altera a resposta de uma FAQ especifica.
	 * 
	 * @param cpf - Cpf do Admin.
	 * @param senha - Senha do Admin.
	 * @param itemIndex - Indice do item que foi armazenado no sistema.
	 * @param resposta - Resposta que vai ser adicionada na FAQ.
	 * @return - true: se alterar a resposta/ false: se não alterar a resposta.
	 */
	public boolean alterarRespostaItem(String cpf, int senha ,int itemIndex, String resposta) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		validaItemIndex(itemIndex);
		validaResposta(resposta);
		
		if(user.verificaAdmin(cpf,senha) && faqs.get(itemIndex-1) != null) {
			faqs.get(itemIndex-1).setResposta(resposta);
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que lista as FAQ armazenadas no sistema em ordem de inserção.
	 * 
	 * @return - Todas as FAQ armazenadas no sistema em ordem de inserção.
	 */
	public String[] listarFAQ() {
		return faqs.stream().map(FAQ::toString).toArray(String[]::new);
	}
	
	/**
	 * Metodo que lista as FAQ armazenadas do sistema em ordem de destaque da FAQ com maior destaque para a com menor.
	 * 
	 * @return - Todas as FAQ armazenadas no sistema por ordem de destaque. 
	 */
	public String[] listarFAQPorDestaque() {
		return faqs.stream().sorted().map(FAQ::toString).toArray(String[]::new);
		
	}
	
	/**
	 * Metodo que adiciona um destaque para uma FAQ.
	 * 
	 * @param itemIndex - indice da FAQ armazenada no sistema que vai ser adicionado o destaque.
	 * @return - true:Se a FAQ foi destacada/false:Se a FAQ não existir no sistema.
	 */
	public boolean destacarItem(int itemIndex) {
		validaItemIndex(itemIndex);
		
		if(faqs.get(itemIndex-1)!= null) {
			faqs.get(itemIndex-1).addDestaque();
			return true;
		}
		return false;
	}
	
	/**
	 * Adicionar tags a uma FAQ armazenada no sistema.
	 *  
	 * @param cpf - Cpf do Admin.
	 * @param senha - Senha do Admin.
	 * @param itemIndex - Idice do item que vai ser adicionada as tags.
	 * @param tags - tags que vão ser adicionadas na FAQ.
	 * @return - true:Se for atribuido a tags no item/false:Se não for atribuido a tags no item.
	 */
	public boolean atribuirTagsItemFAQ(String cpf, int senha, int itemIndex, String[] tags) {
		user.validaCpf(cpf);
		user.validaSenha(senha);
		validaItemIndex(itemIndex);
		validaTags(tags);
		
		if(!user.verificaAdmin(cpf, senha)) { 
			return false;
		}
		faqs.get(itemIndex-1).addTags(tags);
		return true;
	}
	
	/**
	 * Metodo que busca um Item armazenado no sistema com base no array de string de tags.
	 * 
	 * @param tags - Array de String que vai possuir elementos aos quais vai ser baseada a busca;
	 * @return - todos os itens que possuirem alguma daquelas tags prassadas como parametro.
	 */
	public String[] buscarItemFAQ(String[] tags) {
		validaTags(tags);
		 
		List<String> itens= new ArrayList<>();
		
		for(FAQ f: faqs) {
			if(f.buscaTag(tags)) {
				itens.add(f.toString());
			}
		}
	
		return itens.stream().toArray(String[]::new);
	}
}