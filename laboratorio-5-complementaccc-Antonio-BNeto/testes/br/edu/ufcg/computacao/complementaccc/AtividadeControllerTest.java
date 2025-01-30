package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtividadeControllerTest {
	
	private UsuarioController user;
	private AtividadeController atv;
	
	@BeforeEach
	void setup() {
		this.user = new UsuarioController();
		user.criarEstudante("Antonio", "11111111111", 88888888, "12345678");
		this.atv = new AtividadeController(user);
	}  
	
	//Testes para o metodo de criar uma atividade de monitoria
	
	@Test
	void criandoUmaAtividadeDeMonitoriaComSucesso() {
		assertEquals("Atividade adicionada", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "MONITORIA", 20, "LP2"));
		assertEquals("Atividade adicionada", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "monitoria", 20, "LP2"));
	}
	@Test
	void criarAtividadeDeMonitoriaComCPfESenhaNaoPertencendoAoEstudante() {
		assertEquals("Erro", atv.criarAtividadeMonitoriaEmEstudante("22222222222", 88888888, "MONITORIA", 20, "LP2"));
		assertEquals("Erro", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 99999999, "monitoria", 20, "LP2"));
	}
	
	@Test
	void criarUmaAtividadeDoTipoMonitoriaComTipoSendoEstagio() {
		assertEquals("O tipo dessa atividade é pra ser MONITORIA", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "ESTÁGIO", 20, "LP2"));
		assertEquals("O tipo dessa atividade é pra ser MONITORIA", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "estágio", 20, "LP2"));
	}
	
	@Test
	void criarUmaAtividadeDoTipoMonitoriaComTipoSendoPesquisaExtensao() {
		assertEquals("O tipo dessa atividade é pra ser MONITORIA", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "PESQUISA/EXTENSÃO", 20, "LP2"));
		assertEquals("O tipo dessa atividade é pra ser MONITORIA", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "pesquisa/extensão", 20, "LP2"));
	}
	
	@Test
	void criarUmaAtividadeDoTipoMonitoriaComTipoSendoPublicacaoPeriodico() {
		assertEquals("O tipo dessa atividade é pra ser MONITORIA", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "PUBLICAÇÃO<PERIÓDICO>", 20, "LP2"));
		assertEquals("O tipo dessa atividade é pra ser MONITORIA", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "publicação<periódico>", 20, "LP2"));
	}
	
	@Test
	void criarUmaAtividadeDoTipoMonitoriaComTipoSendoPublicacaoConferencia() {
		assertEquals("O tipo dessa atividade é pra ser MONITORIA", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "PUBLICAÇÃO<CONFERÊNCIA>", 20, "LP2"));
		assertEquals("O tipo dessa atividade é pra ser MONITORIA", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "publicação<conferência>", 20, "LP2"));
	}
	
	@Test
	void criarAtividadeDeMonitoriaComCpfOuSenhaInvalidados() {
		assertThrows(IllegalArgumentException.class,()->{
			atv.criarAtividadeMonitoriaEmEstudante("1111111111", 88888888, "MONITORIA", 20, "LP2");
			atv.criarAtividadeMonitoriaEmEstudante("11111111111", 0, "MONITORIA", 20, "LP2"); 
			
		});
	}
	@Test
	void criarAtividadeDeMonitoriaComTipoInvalido() {
		assertThrows(IllegalArgumentException.class,()->{
			atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "", 20, "LP2");
			atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, null, 20, "LP2");
		});
	}
	@Test
	void criarAtividadeDeMonitoriaComDisciplinaInvalida() {
		assertThrows(IllegalArgumentException.class,()->{
			atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "MONITORIA", 20, "");
			atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "monitoria", 20, null);
		});
	}
	@Test
	void criarAtividadeDeMonitoriaComUnidadeAcumuladaInvalida() {
		assertThrows(IllegalArgumentException.class, ()->{
			atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888 , "MONITORIA", 0, "LP2");
			atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "monitoria", -1, "LP2");
		}); 
	}
	
	//Testes para o metodo de alterar descrição de uma atividade
	
	@Test
	void alterandoADescricaoDeUmaAtividade() { 
		assertEquals("Atividade adicionada", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "MONITORIA", 20, "LP2"));
		assertEquals("Atividade adicionada", atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "PESQUISA/EXTENSÃO", 20, "LP2"));
		assertEquals(true, atv.alterarDescricaoAtividade("11111111111", 88888888, "111.111.111-11_1", "Atividade do tipo monitoria"));
	}
	
	@Test
	void alterandoADescricaoDeUmaAtividadeComDescricaoInvalida() {
		assertEquals("Atividade adicionada", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "MONITORIA", 20, "LP2"));
		assertThrows(IllegalArgumentException.class,()->{
			atv.alterarDescricaoAtividade("11111111111", 88888888, "111.111.111-11_1", "");
			atv.alterarDescricaoAtividade("11111111111", 88888888, "111.111.111-11_1", null);
		});
	}
	
	
	//Testes para o metodo de criar atividade de pesquisa e extensão
	
	@Test
	void criarAtividadeDePesquisaExtensaoComSucesso() {
		assertEquals("Atividade adicionada", atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "PESQUISA/EXTENSÃO", 20, "LP2"));
		assertEquals("Atividade adicionada", atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "pesquisa/extensão", 20, "LP2"));
	}
	@Test
	void criarAtividadeDePesquisaExtensaoComTipoSendoEstagio() {
		assertEquals("O tipo dessa atividade é pra ser PESQUISA/EXTENSÃO", atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "ESTÁGIO", 20, "LP2"));
		assertEquals("O tipo dessa atividade é pra ser PESQUISA/EXTENSÃO", atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "estágio", 20, "LP2"));
	}
	@Test
	void criarAtividadeDePesquisaExtensaoComTipoSendoMonitoria() {
		assertEquals("O tipo dessa atividade é pra ser PESQUISA/EXTENSÃO", atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "MONITORIA", 20, "LP2"));
		assertEquals("O tipo dessa atividade é pra ser PESQUISA/EXTENSÃO", atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "monitoria", 20, "LP2"));
	}
	@Test
	void criarAtividadeDePesquisaExtensaoComTipoSendoPublicacaoPeriodico() {
		assertEquals("O tipo dessa atividade é pra ser PESQUISA/EXTENSÃO", atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "PUBLICAÇÃO<PERIÓDICO>", 20, "LP2"));
		assertEquals("O tipo dessa atividade é pra ser PESQUISA/EXTENSÃO", atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "publicação<periódico>", 20, "LP2"));
	}
	@Test
	void criarAtividadeDePesquisaExtensaoComTipoSendoPublicacaoConferencia() {
		assertEquals("O tipo dessa atividade é pra ser PESQUISA/EXTENSÃO", atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "PUBLICAÇÃO<CONFERÊNCIA>", 20, "LP2"));
		assertEquals("O tipo dessa atividade é pra ser PESQUISA/EXTENSÃO", atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "publicação<conferência>", 20, "LP2"));
	}
	
	@Test
	void criarAtividadeDePesquisaExtensaoComCpfOuSenhaInvalidados() {
		assertThrows(IllegalArgumentException.class,()->{
			atv.criarAtividadePesquisaExtensaoEmEstudante("1111111111", 88888888, "PESQUISA/EXTENSÃO", 20, "LP2");
			atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 0, "pesquisa/extensão", 20, "LP2"); 
			
		});
	}
	@Test
	void criarAtividadeDePesquisaExtensaoComTipoInvalido() {
		assertThrows(IllegalArgumentException.class,()->{
			atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "", 20, "LP2");
			atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, null, 20, "LP2");
		});
	}
	@Test
	void criarAtividadeDePesquisaExtensaoComDisciplinaInvalida() {
		assertThrows(IllegalArgumentException.class,()->{
			atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "PESQUISA/EXTENSÃO", 20, "");
			atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "pesquisa/extensão", 20, null);
		});
	}
	@Test
	void criarAtividadeDePesquisaExtensaoComUnidadeAcumuladaInvalida() {
		assertThrows(IllegalArgumentException.class, ()->{
			atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888 , "PESQUISA/EXTENSÃO", 0, "LP2");
			atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "pesquisa/extensão", -1, "LP2");
		});
	}
	
	
	//Testes para o metodo de criar atividade de estagio.
	
	@Test
	void criarAtividadeDeEstagioComSucesso() {
		assertEquals("Atividade adicionada", atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "ESTÁGIO", 20, "LP2"));
		assertEquals("Atividade adicionada", atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "estágio", 20, "LP2"));
	}
	@Test
	void criarAtividadeDeEstagioComTipoSendoMonitoria() {
		assertEquals("O tipo dessa atividade é pra ser ESTÁGIO", atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "MONITORIA", 20, "LP2"));
		assertEquals("O tipo dessa atividade é pra ser ESTÁGIO", atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "monitoria", 20, "LP2"));
	}
	@Test
	void criarAtiviadeDeEstagioComTipoSendoPesquisaExtensao() {
		assertEquals("O tipo dessa atividade é pra ser ESTÁGIO", atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "PESQUISA/EXTENSÃO", 20, "LP2"));
		assertEquals("O tipo dessa atividade é pra ser ESTÁGIO", atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "pesquisa/extensão", 20, "LP2"));
	}
	@Test
	void criarAtividadeDeEstagioComTipoSendoPublicacaoPeriodico() {
		assertEquals("O tipo dessa atividade é pra ser ESTÁGIO", atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "PUBLICAÇÃO<PERIÓDICO>", 20, "LP2"));
		assertEquals("O tipo dessa atividade é pra ser ESTÁGIO", atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "publicação<periódico>", 20, "LP2"));
	}
	@Test
	void criarAtividadeDeEstagioComTipoSendoPublicacaoConferencia() {
		assertEquals("O tipo dessa atividade é pra ser ESTÁGIO", atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "PUBLICAÇÃO<CONFERÊNCIA>", 20, "LP2"));
		assertEquals("O tipo dessa atividade é pra ser ESTÁGIO", atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "publicação<conferência>", 20, "LP2"));
	}
	@Test
	void criarAtividadeDeEstagioComCPfESenhaNaoPertencendoAoEstudante() {
		assertEquals("Erro", atv.criarAtividadeEstagioEmEstudante("22222222222", 88888888, "ESTÁGIO", 20, "LP2"));
		assertEquals("Erro", atv.criarAtividadeEstagioEmEstudante("11111111111", 99999999, "estágio", 20, "LP2"));
	}
	
	@Test
	void criarAtividadeDeEstagioComCpfOuSenhaInvalidados() {
		assertThrows(IllegalArgumentException.class,()->{
			atv.criarAtividadeEstagioEmEstudante("1111111111", 88888888, "ESTÁGIO", 20, "LP2");
			atv.criarAtividadeEstagioEmEstudante("11111111111", 0, "estágio", 20, "LP2"); 
			
		});
	}
	
	@Test
	void criarAtividadeDeEstagioComTipoInvalido() {
		assertThrows(IllegalArgumentException.class,()->{
			atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "", 20, "LP2");
			atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, null, 20, "LP2");
		});
	}
	@Test
	void criarAtividadeDeEstagioComDisciplinaInvalida() {
		assertThrows(IllegalArgumentException.class,()->{
			atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "ESTÁGIO", 20, "");
			atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "estágio", 20, null);
		});
	}
	@Test
	void criarAtividadeDeEstagioComUnidadeAcumuladaInvalida() {
		assertThrows(IllegalArgumentException.class, ()->{
			atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888 , "ESTÁGIO", 0, "LP2");
			atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "estágio", -1, "LP2");
		});
	}
	
	//Testes para o metodo creditosAtividades
	
	@Test
	void calculandoOsCreditosDeUmaAtividadeDePesquisaExtensao() {
		assertEquals("Atividade adicionada", atv.criarAtividadePesquisaExtensaoEmEstudante("11111111111", 88888888, "PESQUISA/EXTENSÃO", 20, "LP2"));
		assertEquals(17,atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}
	@Test
	void calculandoOscreditosDeUmaAtividadeDeEstagio() {
		assertEquals("Atividade adicionada", atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "ESTÁGIO", 300, "LP2"));
		assertEquals(5,atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}
	@Test
	void calculandoOsCreditosDeUmaAtividadeDeEstagioQueNaoConseguiuAUnidadeAcumuladaMinima() {
		assertEquals("Atividade adicionada", atv.criarAtividadeEstagioEmEstudante("11111111111", 88888888, "ESTÁGIO", 1, "LP2"));
		assertEquals(0,atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}
	@Test
	void calculacreditosDeUmaAtividadeDeMonitoria() {
		assertEquals("Atividade adicionada", atv.criarAtividadeMonitoriaEmEstudante("11111111111", 88888888, "MONITORIA", 20, "LP2"));
		assertEquals(16, atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}
	
	//qualis a1
	@Test
	void calculaCreditosDeUmaAtividadeDoTipoPublicacaoPeriodicoQualisA1() {
		assertEquals("Atividade adicionada", atv.criarAtividadePublicacaoEmEstudantes("11111111111", 88888888, "PUBLICAÇÃO<PERIÓDICO>", "Artigo de testes para lp2", "doi", "a1"));
		assertEquals(4, atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}
	@Test
	void calculaCreditosDeUmaAtividadeDoTipoPublicacaoConferenciaComQualisA1() {
		assertEquals("Atividade adicionada", atv.criarAtividadePublicacaoEmEstudantes("11111111111", 88888888, "PUBLICAÇÃO<CONFERÊNCIA>", "Artigo de testes para lp2", "doi", "a1"));
		assertEquals(3, atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}
	
	//qualis a2
	
	@Test
	void calculaCreditosDeUmaAtividadeDoTipoPublicacaoPeriodicoQualisA2() {
		assertEquals("Atividade adicionada", atv.criarAtividadePublicacaoEmEstudantes("11111111111", 88888888, "PUBLICAÇÃO<PERIÓDICO>", "Artigo de testes para lp2", "doi", "a2"));
		assertEquals(4, atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}
	
	@Test
	void calculaCreditosDeUmaAtividadeDoTipoPublicacaoConferenciaQualisA2() {
		assertEquals("Atividade adicionada", atv.criarAtividadePublicacaoEmEstudantes("11111111111", 88888888, "PUBLICAÇÃO<CONFERÊNCIA>", "Artigo de testes para lp2", "doi", "a2"));
		assertEquals(3, atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}
	//qualis a3
	
	@Test
	void calculandoCreditosDeUmaAtividadeDoTipoPublicacaoPeriodicoQualisA3() {
		assertEquals("Atividade adicionada", atv.criarAtividadePublicacaoEmEstudantes("11111111111", 88888888, "PUBLICAÇÃO<PERIÓDICO>", "Artigo de testes para lp2", "doi", "a3"));
		assertEquals(3, atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}
	@Test
	void calculandoCreditosDeUmaAtividadeDoTipoPublicacaoConferenciaQualisA3() {
		assertEquals("Atividade adicionada", atv.criarAtividadePublicacaoEmEstudantes("11111111111", 88888888, "PUBLICAÇÃO<CONFERÊNCIA>", "Artigo de testes para lp2", "doi", "a3"));
		assertEquals(2, atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}
	
	//qualis a4
	@Test
	void calculandoCreditosDeUmaAtividadeDoTipoPublicacaoPeriodicoQualisA4() {
		assertEquals("Atividade adicionada", atv.criarAtividadePublicacaoEmEstudantes("11111111111", 88888888, "PUBLICAÇÃO<PERIÓDICO>", "Artigo de testes para lp2", "doi", "a4"));
		assertEquals(1, atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}
	@Test
	void calculandoCreditosDeUmaAtividadeDoTipoPublicacaoConferenciaQualisA4() {
		assertEquals("Atividade adicionada", atv.criarAtividadePublicacaoEmEstudantes("11111111111", 88888888, "PUBLICAÇÃO<CONFERÊNCIA>", "Artigo de testes para lp2", "doi", "a4"));
		assertEquals(1, atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}

	//qualis b1
	
	@Test
	void calculandoCreditosDeUmaAtividadeDoTipoPublicacaoPeriodicoQualisB1() {
		assertEquals("Atividade adicionada", atv.criarAtividadePublicacaoEmEstudantes("11111111111", 88888888, "PUBLICAÇÃO<PERIÓDICO>", "Artigo de testes para lp2", "doi", "b1"));
		assertEquals(1, atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}
	@Test
	void calculandoCreditosDeUmaAtividadeDoTipoPublicacaoConferenciaQualisB1() {
		assertEquals("Atividade adicionada", atv.criarAtividadePublicacaoEmEstudantes("11111111111", 88888888, "PUBLICAÇÃO<CONFERÊNCIA>", "Artigo de testes para lp2", "doi", "b1"));
		assertEquals(1, atv.creditosAtividade("11111111111", 88888888, "111.111.111-11_1"));
	}
}