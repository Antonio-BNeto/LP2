package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioControllerTest {
	
	private UsuarioController uc; 
	
	@BeforeEach
	void setup() {
		this.uc = new UsuarioController();
	}
	
	// Testes Do metodo criar estudantes  
	
	@Test
	void criarEstudanteComSucesso() {
		assertEquals(true,uc.criarEstudante("Antonio", "34922902102", 10000000, "123458349"));
	}
	
	@Test
	void criaEstudanteComParrametrosInvalidos() {
		assertThrows(IllegalArgumentException.class,() ->{
			uc.criarEstudante(null, "34922902102", 10000000, "123458349");
			uc.criarEstudante("", "34922902102", 10000000, "123458349");
			
			uc.criarEstudante("Antonio", "", 10000000, "123458349");
			uc.criarEstudante("Antonio", null, 10000000, "123458349");
			
			uc.criarEstudante("Antonio", "349229021029", 10000, "123458349");
			uc.criarEstudante("Antonio", "349229021029", 1000000000, "123458349");
			
			uc.criarEstudante("Antonio", "34922902102", 10000000, null);
			uc.criarEstudante("Antonio", "34922902102", 10000000, "");
		});
	}
	
	@Test
	void criaEstudanteComNomesDuplicados() {
		assertEquals(true,uc.criarEstudante("Antonio", "34922902102", 10000000, "123458349"));
		assertEquals(true,uc.criarEstudante("Antonio", "34922902112", 10000000, "124459349"));
	}
	
	@Test
	void criarEstudantesComCpfDuplicados() {
		assertEquals(true,uc.criarEstudante("Antonio", "34922902102", 10000000, "123458349"));
		assertEquals(false,uc.criarEstudante("Barros", "34922902102", 12312312, "124459349"));
	}
	
	@Test
	void criaEstudanteComSenhasDuplicadas() {
		assertEquals(true,uc.criarEstudante("Antonio", "34922902102", 10000000, "123458349"));
		assertEquals(true,uc.criarEstudante("Barros", "34922902112", 10000000, "124459349"));
	}
	@Test
	void criaEstudanteComMatriculasDuplicadas() {
		assertEquals(true,uc.criarEstudante("Antonio", "34922902102", 10000000, "123458349"));
		assertEquals(true,uc.criarEstudante("Barros", "34922902112", 10000000, "123458349"));
	}
	
	//Testes do metodo exibirEstudante
	
	
	@Test
	void exibirEstudanteComAdminValido() {
		uc.criarEstudante("Antonio", "33333333333", 10000000, "123458349");
		uc.criarEstudante("Barros", "22222222222", 10000000, "123458349");
		uc.criarEstudante("Alcantara","11111111111",99999999,"123456789");
		
		String[] output = new String[] {"NOME: Alcantara\nCPF: 11111111111\nMATRICULA: 123456789",
										"NOME: Antonio\nCPF: 33333333333\nMATRICULA: 123458349",
										"NOME: Barros\nCPF: 22222222222\nMATRICULA: 123458349"};
		
		String[] exibiEstudantes = uc.exibirEstudantes("12345678910", 12345678);
		
		assertArrayEquals(output,exibiEstudantes);
	}
	
	@Test
	void exibirEstudantesSemASenhaOuCpfDoAdim() {
		uc.configurarNovoAdmin("12345678910", 12345678, "Antonio", "12345678910", 12345678);
		assertEquals(null, uc.exibirEstudantes("12345778910", 12345678));
		assertEquals(null, uc.exibirEstudantes("12345678910", 12345668));
		assertEquals(null, uc.exibirEstudantes("12345578910", 12345668));
	}
	
	@Test
	void exibirEstudanteComAdminInvalido() {
		uc.criarEstudante("Antonio", "34922902102", 10000000, "123458349");
		assertEquals(null,uc.exibirEstudantes("admi", 12345678));
	}
	
	
	@Test
	void exibirEstudanteOrdemAlfabetica() {
		uc.criarEstudante("Alice", "33333333333", 10000000, "123458349");
		uc.criarEstudante("Barbara", "22222222222", 10000000, "123458349");
		uc.criarEstudante("Natasha","11111111111",99999999,"123456789");
		uc.criarEstudante("Arthur", "44444444444", 88888888, "123456789");
		
		String[] output = new String[] {"NOME: Alice\nCPF: 33333333333\nMATRICULA: 123458349",
										"NOME: Arthur\nCPF: 44444444444\nMATRICULA: 123456789",
										"NOME: Barbara\nCPF: 22222222222\nMATRICULA: 123458349",
										"NOME: Natasha\nCPF: 11111111111\nMATRICULA: 123456789"};
		
		String[] exibiEstudantes = uc.exibirEstudantes("12345678910", 12345678);
		
		assertArrayEquals(output,exibiEstudantes);
	}
	
	
	//Testes pro metodo alteraEstudante
	
	
	@Test
	void alteraNomeEstudante() {
		uc.criarEstudante("Antonio", "34922902102", 10000000, "123458349");
		assertEquals(true, uc.alterarEstudante("34922902102", 10000000, "Nome", "Barros"));
	}
	
	@Test
	void alteraSenhaEstudante() {
		uc.criarEstudante("Antonio", "34922902102", 10000000, "123458349");
		assertEquals(true, uc.alterarEstudante("34922902102", 10000000, "Senha", "12345678"));
	}
	
	@Test
	void alteraEstudanteComTipoDeAlteracaoInvalida() {
		uc.criarEstudante("Antonio", "34922902102", 10000000, "123458349");
		assertEquals(false, uc.alterarEstudante("34922902102", 10000000, "Cpf", "12345678910"));
	}
	
	@Test
	void alterarSenhaDoEstudanteComNovoValorInvalido() {
		uc.criarEstudante("Antonio", "34922902102", 10000000, "123458349");
		assertThrows(IllegalArgumentException.class,()->{
			uc.alterarEstudante("34922902102",10000000, "Senha", "Oi");
			uc.alterarEstudante("34922902102",10000000, "Senha", "123");
		});
	}
	
	@Test
	void alterarNomeDoEstudanteComNovoValorInvalido() {
		uc.criarEstudante("Antonio", "3492290212", 10000000, "123456789");
		assertThrows(IllegalArgumentException.class, ()->{
			uc.alterarEstudante("3492290212",10000000, "nome", "");
			uc.alterarEstudante("3492290212",10000000, "nome", null);
		});
	}
	
	@Test
	void alteraNomeOuSenhaDoEstudanteComAutenticacaoValida() {
		assertEquals(true,uc.criarEstudante("Antonio", "34922902102", 10000000, "123458349"));
		assertEquals(true,uc.alterarEstudante("34922902102", 10000000, "Nome", "Alcantara"));
	}
	
	
	//Testes exibir Admin
	
	@Test
	void exibirAdminValido() {
		assertEquals("Nome: Admin"+"\n"+"CPF: 12345678910",uc.exibirAdmin("12345678910", 12345678));
	}
	
	@Test
	void exibirAdminInvalido() {
		assertEquals("O cpf ou a senha não pertencem ao Admin!", uc.exibirAdmin("12345678911", 12345578));
	}
	
	@Test
	void exibirAdminComParametrosInvalidos() {
		assertThrows(IllegalArgumentException.class, ()->{
			uc.exibirAdmin(null, 0);
			uc.exibirAdmin(null, 12345678);
			uc.exibirAdmin("12345678910", 0);
		});
	}
	
	
	
	//Testes configuraNovoAdmin
	
	@Test
	void configurarNovoAdminValido() {
		assertEquals(true,uc.configurarNovoAdmin("12345678910", 12345678, "Antonio", "77777777777", 99999999));
	}
	
	@Test
	void configurarNovoAdminComAdminAtualInvalido() {
		assertEquals(false, uc.configurarNovoAdmin("11111111111", 12345678, "Neto", "77777777777", 88888888));
	}	
	
	@Test
	void configuraNovoAdminComParametrosInvalidos() {
		assertThrows(IllegalArgumentException.class,()->{
			uc.configurarNovoAdmin(null, 12345678, "Neto", "77777777777", 88888888);
			uc.configurarNovoAdmin("Admin", 0, "Neto", "77777777777", 88888888);
			uc.configurarNovoAdmin("Admin", 12345678, null, "77777777777", 88888888);
			uc.configurarNovoAdmin("Admin", 12345678, "Neto", null, 88888888);
			uc.configurarNovoAdmin("Admin", 12345678, "Neto", "77777777777", 0);
			
			uc.configurarNovoAdmin("", 12345678, "Neto", "77777777777", 88888888);
			uc.configurarNovoAdmin("Admin", 100000000, "Neto", "77777777777", 88888888);
			uc.configurarNovoAdmin("Admin", 12345678, "", "77777777777", 88888888);
			uc.configurarNovoAdmin("Admin", 12345678, "Neto", "", 88888888);
			uc.configurarNovoAdmin("Admin", 12345678, "Neto", "77777777777", 100000000);
		});
	}
	
	
	//Testes do configurarSenhaAdmin
	
	
	@Test
	void configurarSenhaAdminSucesso() {
		uc.configurarNovoAdmin("12345678910", 12345678, "Antonio", "12345678910", 12345678);
		assertEquals(true,uc.configurarSenhaAdmin("12345678910", 12345678, 87654321));
	}
	
	@Test
	void alteraSenhaDoAdminComAutenticacaoInvalida() {
		assertEquals(false,uc.configurarSenhaAdmin("12345678910", 55555555, 87654321));
		assertEquals(false,uc.configurarSenhaAdmin("12346678910", 12345678, 87654321));
	}
	
	
	//Testes do metodo de verificaEstudante e VerificaAdmin
	
	@Test
	void verificaEstudanteExistente() {
		assertEquals(true,uc.criarEstudante("Antonio", "34922902102", 10000000, "123458349"));
		assertEquals(true,uc.verificaEstudante("34922902102", 10000000));
	}
	@Test
	void verificaEstudanteInexistente() {
		assertEquals(false, uc.verificaEstudante("Antonio", 12345678));
	}
	 
	@Test
	void verificaEstudanteComParametrosInvalidos() {
		assertThrows(IllegalArgumentException.class,()->{
			uc.verificaEstudante("Antonio", 0);
			uc.verificaEstudante(null, 99999999); 
		});
	}
	
	@Test
	void verificaAdminExistente() {
		uc.configurarNovoAdmin("12345678910", 12345678, "Antonio", "12345678910", 12345678);
		assertEquals(true, uc.verificaAdmin("12345678910", 12345678));
	}
	@Test
	void verificaAdminInexistente() {
		assertEquals(false, uc.verificaAdmin("11111111111", 12345678));
	}
	@Test
	void verificaAdminParametrosInvalidos() {
		assertThrows(IllegalArgumentException.class, ()->{
			uc.verificaAdmin("", 0);
			uc.verificaAdmin(null, 99999999);
		});
			
	}
	
}