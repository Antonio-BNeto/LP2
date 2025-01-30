package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FAQControllerTest {
	
	private UsuarioController uc;
	private FAQController faq;
	
	@BeforeEach
	void setup() {
		this.uc = new UsuarioController();
		this.faq = new FAQController(uc);
	}

	//Testes do metodo adicionarItemFAQ só com uma pergunta.
	
	@Test
	void adicionandoUmaFAQ() {
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?")); 
	}
	
	@Test
	void adicionandoUmaFAQComPerguntaExistenteNoController() {
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?"));
		assertEquals(false, faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?"));
	}
	
	@Test
	void adicionandoUmaFAQComCpfNaoSendoDoAdmin() {
		assertEquals(false, faq.adicionarItemFAQ("11111111111", 12345678, "Qual o seu nome?"));
	}
	@Test
	void adicionandoUmaFAQComSenhaNaoSendoDoAdmin() {
		assertEquals(false, faq.adicionarItemFAQ("12345678910", 88888888, "Qual o seu nome?"));
	}
	@Test
	void adicionandoUmaFAqSemQueASenhaEOCpfSejaDoAdmin() {
		assertEquals(false, faq.adicionarItemFAQ("11111111111", 99999999, "Qual o seu nome?"));
	}
	@Test
	void adicionandoUmaFAQComParametrosInvalidos() {
		assertThrows(IllegalArgumentException.class,()->{
			faq.adicionarItemFAQ("12345678910", 0, "Qual o seu nome?");
			faq.adicionarItemFAQ(null, 0, "Qual o seu nome?");
			faq.adicionarItemFAQ(null, 0, "Qual o seu nome");
		});
	}
	
	//Testes do metodo adicionarItemFAQ com pergunta e resposta.
	
	@Test
	void adicionandoUmaFAQComResposta() {
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio"));
	}
	
	@Test
	void adicionandoUmaFAQComPerguntasIguaisMasRespostasDiferentes() {
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio"));
		assertEquals(false, faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Barros"));
	}
	
	@Test
	void adicionadoUmaFAQComRespostaMasCpfNaoPertenceAoAdmin() {
		assertEquals(false, faq.adicionarItemFAQ("11111111111", 12345678, "Qual o seu nome?", "Meu nome é Antonio"));
	}
	
	@Test
	void adicionaUmaFAQComRespostaMasSenhaPertenceAoAdmin() {
		assertEquals(false, faq.adicionarItemFAQ("12345678910", 77777777, "Qual o seu nome?", "Meu nome é Antonio"));
	}
	
	@Test
	void adicionaUmaFAQComRespostaMasPossuiParametrosDoAdminInvalidos() {
		assertThrows(IllegalArgumentException.class,()->{
			faq.adicionarItemFAQ(null, 12345678, "Qual o seu nome?", "Meu nome é Antonio");
			faq.adicionarItemFAQ("", 12345678, "Qual o seu nome?", "Meu nome é Antonio");
			faq.adicionarItemFAQ("Admin", 9999999, "Qual o seu nome?", "Meu nome é Antonio");
			faq.adicionarItemFAQ("Admin", 100000000, "Qual o seu nome?", "Meu nome é Antonio");	
		});
	}
	
	//Testes para o metodo alteraRespostaItem
	
	@Test
	void alteraARespostaDeUMItemComSucesso() {
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio"));
		assertEquals(true, faq.alterarRespostaItem("12345678910", 12345678, 1, "Meu nome é Barros"));
	}
	
	@Test
	void alteraARespostaDeUMItemComIndiceInvalido() {
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio"));
		assertThrows(IllegalArgumentException.class,()->{
			faq.alterarRespostaItem("12345678910", 12345678, -1, "Meu nome é Barros");
		});	
	}
	
	@Test
	void alterarRespostaDeUmItemComAdminInvalido() {
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio"));
		assertEquals(false, faq.alterarRespostaItem("11111111111", 12345678, 1, "Meu nome é Barros"));
		assertEquals(false, faq.alterarRespostaItem("12345678910", 99999999, 1, "Meu nome é Barros"));
	}
	@Test
	void alterarRespostadeUmItemComRespostaInvalida() {
		assertThrows(IllegalArgumentException.class, ()->{
			faq.alterarRespostaItem("12345678910", 12345678, 1, "");
			faq.alterarRespostaItem("12345678910", 12345678, 1, null);
		});
	}
	
	//Testes para o metodo listarFAQ
	
	@Test
	void listarFAQ() {
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio"));
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual a sua idade?", "Tenho 17 anos"));
		
		String[] saidaEsperada = new  String[] {"Pergunta: Qual o seu nome?\nResposta: Meu nome é Antonio\nDestaque: 0\nTags: []",
												"Pergunta: Qual a sua idade?\nResposta: Tenho 17 anos\nDestaque: 0\nTags: []"
		};
		
		String[] saida = faq.listarFAQ();
		
		assertArrayEquals(saidaEsperada, saida);
	}
	
	@Test
	void listarFAQVazia() {
		String[] esperado = new  String[] {};
		String[] saida = faq.listarFAQ();
		
		assertArrayEquals(esperado, saida);
		
	}
	
	//Testes para Destacar uma FAQ
	
	@Test
	void destacarItemComSucesso() {
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio"));
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual a sua idade?", "Tenho 17 anos"));
		assertEquals(true,faq.destacarItem(1));
	}
	
	@Test
	void destacarItemComIndiceInvalido() {
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio"));
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual a sua idade?", "Tenho 17 anos"));
		
		assertThrows(IllegalArgumentException.class, ()->{
			faq.destacarItem(0);
		});
	}
	
	//Testes para Listar FAQ por ordem de destaque
	@Test
	void listarFAQPorDestaque() {
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio"));
		assertEquals(true, faq.adicionarItemFAQ("12345678910", 12345678, "Qual a sua idade?", "Tenho 17 anos"));
		faq.destacarItem(1);
		faq.destacarItem(2); 
		faq.destacarItem(2);
		
		String[] saidaEsperada = new  String[] {"Pergunta: Qual a sua idade?\nResposta: Tenho 17 anos\nDestaque: 2\nTags: []",
												"Pergunta: Qual o seu nome?\nResposta: Meu nome é Antonio\nDestaque: 1\nTags: []"
		};
		
		String[] saida = faq.listarFAQPorDestaque();
		
		assertArrayEquals(saidaEsperada, saida);
	}
	
	@Test 
	void listarFAQPorDestaqueVazia() {
		String[] esperado = new  String[] {};
		String[] saida = faq.listarFAQ();
		
		assertArrayEquals(esperado, saida);
	}
	
	//Testes do metodo do atribuir itens tags
	
	@Test
	void atribuirItemTagsValidas() {
		faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio");
		assertEquals(true, faq.atribuirTagsItemFAQ("12345678910", 12345678, 1, new String[] {"Por Exemplo", "Estagio", "carga horária"}));
	}
	
	@Test 
	void atribuirItemTagsInvalidas() {
		faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio");
		assertThrows(IllegalArgumentException.class, ()->{
			faq.atribuirTagsItemFAQ("12345678910", 12345678, 1, new String[] {" ", "Estagio", "carga horária"});
			faq.atribuirTagsItemFAQ("12345678910", 12345678, 1, new String[] {null, "Estagio", "carga horária"});
			
			faq.atribuirTagsItemFAQ("12345678910", 12345678, 1, new String[] {"Por Exemplo", " ", "carga horária"});
			faq.atribuirTagsItemFAQ("12345678910", 12345678, 1, new String[] {"Por Exemplo", null, "carga horária"});
			
			faq.atribuirTagsItemFAQ("12345678910", 12345678, 1, new String[] {"Por Exemplo", "Estagio", " "});
			faq.atribuirTagsItemFAQ("12345678910", 12345678, 1, new String[] {"Por Exemplo", "Estagio", null});
			
		});
	}
	
	@Test
	void atribuirItemTagsComTamanhoDeTagsInvalidas() {
		faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio");
		assertThrows(IllegalArgumentException.class,()->{
			faq.atribuirTagsItemFAQ("12345678910", 12345678, 1, new String[] {"Por Exemplo", "Estagio"});
		});
	}
	
	//Testes para o metodo buscar Item FAQ
	
	@Test
	void buscarItemFAQComSucesso() {
		faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio");
		faq.atribuirTagsItemFAQ("12345678910", 12345678, 1, new String[] {"Por Exemplo", "Estagio", "carga horária"});
		
		String[] esperado = new String[] {"Pergunta: Qual o seu nome?\nResposta: Meu nome é Antonio\nDestaque: 0\nTags: [Por Exemplo, Estagio, carga horária]"};
		
		String[] saida = faq.buscarItemFAQ(new String[] {"Por Exemplo", "Estagio", "carga horária"});
		
		assertArrayEquals(esperado, saida);
		
	}
	
	@Test
	void buscarItemFAQComTagsNoBuscaTagsNãoExistentesNoController() {
		faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio");
		faq.adicionarItemFAQ("12345678910", 12345678, "Qual a sua idade?", "Tenho 17 anos");
		faq.atribuirTagsItemFAQ("12345678910", 12345678, 1, new String[] {"Por Exemplo", "Estagio", "carga horária"});
		
		String[] esperado = new String[] {};
		
		String[] saida = faq.buscarItemFAQ(new String[] {"Oi", "Eai", "como vai"});
		
		assertArrayEquals(esperado, saida);
	}
	
	@Test
	void buscarItemFAQComTagsExistenteNaSegundaFAQ() {
		faq.adicionarItemFAQ("12345678910", 12345678, "Qual a sua idade?", "Tenho 17 anos");
		faq.adicionarItemFAQ("12345678910", 12345678, "Qual o seu nome?", "Meu nome é Antonio");
		faq.atribuirTagsItemFAQ("12345678910", 12345678, 2, new String[] {"Por Exemplo", "Estagio", "carga horária"});
		
		String[] esperado = new String[] {"Pergunta: Qual o seu nome?\nResposta: Meu nome é Antonio\nDestaque: 0\nTags: [Por Exemplo, Estagio, carga horária]"};
		
		String[] saida = faq.buscarItemFAQ(new String[] {"Por Exemplo", "Estagio", "carga horária"});
		
		assertArrayEquals(esperado, saida);
	}
	
}
