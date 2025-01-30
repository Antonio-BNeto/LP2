package mrbet;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MrBetSistemaTest {

	private MrBetSistema mr;
	
	@BeforeEach
	void setup() {
		this.mr = new MrBetSistema();
		this.mr.adicionaTime("250_PB", "Nacional de Patos", "Canário");
		this.mr.adicionaTime("252_PB", "Sport Lagoa Seca", "Carneiro");
		this.mr.adicionaTime("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
		this.mr.adicionaTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
	}
	
	/**
	 * Testando o metodo adicionaTime
	 */
	
	@Test
	void adicionaTime(){
		assertEquals("INCLUSÃO REALIZADA!", mr.adicionaTime("001_PB", "Botafogo", "Cachorro"));
	}
	
	@Test
	void adicionaTimeComCodigoCadastrado() {
		mr.adicionaTime("001_PB", "Botafogo", "Cachorro");
		assertEquals("TIME JÁ EXISTE!", mr.adicionaTime("001_PB", "Sport Lagoa Seca", "Carneiro"));
	}
	@Test
	void adicionaTimesComCodigosDiferentes() {
		assertEquals("INCLUSÃO REALIZADA!", mr.adicionaTime("001_PB", "Nacional de Patos", "Canário"));
		assertEquals("INCLUSÃO REALIZADA!", mr.adicionaTime("002_PB", "Nacional de Patos", "Canário"));	
	}
	@Test
	void adicionarTimeComCodigoTimeNullOuVazio() {
		assertThrows(IllegalArgumentException.class,() ->{
			mr.adicionaTime(null, "Nacional de Patos","Canário");
		});
		assertThrows(IllegalArgumentException.class,() ->{
			mr.adicionaTime("", "Nacional de Patos","Canário");
		});
	}
	
	@Test
	void adicionarTimeComNomeNullOuVazio() {
		assertThrows(IllegalArgumentException.class,() ->{
			mr.adicionaTime("001_PB", null,"Canário");
		});
		assertThrows(IllegalArgumentException.class,() ->{
			mr.adicionaTime("001_PB", "","Canário");
		});
	}
	@Test
	void adicionarTimeComMascoteNullOuVazio() {
		assertThrows(IllegalArgumentException.class,() ->{
			mr.adicionaTime("001_PB", "Nacional de Patos",null);
		});
		assertThrows(IllegalArgumentException.class,() ->{
			mr.adicionaTime("001_PB", "Nacional de Patos","");
		});
	}
	
	/**
	 * Testando o metodo recuperaTime
	 */
	
	@Test
	void recuperaTimeQueExisteNoSistema() {
		assertEquals("[250_PB] Nacional de Patos / Canário", mr.recuperaTime("250_PB"));
	}
	@Test 
	void recuperaTimeQueNaoExisteNoSistema(){
		assertEquals("TIME NÃO EXISTE!", mr.recuperaTime("001_PB"));
	}
	
	/**
	 * Testando o metodo adicionaCampeonato
	 */
	
	@Test
	void adicionaCampeonatoComSucesso() {
		assertEquals("CAMPEONATO ADICIONADO!",mr.adicionaCampeonato("Brasileirão Série A 2023", 20));
	}
	@Test
	void adicionaCampeonatoComNomeExistente() {
		mr.adicionaCampeonato("Brasileirão Série A 2023", 20);
		assertEquals("CAMPEONATO JÁ EXISTE!", mr.adicionaCampeonato("brasileirão série a 2023", 20));
	}
	@Test
	void adicionaCampeonatosComNomesDiferentes() {
		assertEquals("CAMPEONATO ADICIONADO!", mr.adicionaCampeonato("Brasileirão Série A 2023", 20));
		assertEquals("CAMPEONATO ADICIONADO!", mr.adicionaCampeonato("Brasileirão Série B 2023", 20));
	}
	@Test
	void adicionaCampeonatoComNomeVazioOuNull() {
		assertThrows(IllegalArgumentException.class,() ->{
			mr.adicionaCampeonato(null, 20);
		});
		assertThrows(IllegalArgumentException.class,() ->{
			mr.adicionaCampeonato("", 20);
		});
	}
	@Test
	void adicionaCampeonatoComParticipantesIgualAZero() {
		assertThrows(IllegalArgumentException.class,() ->{
			mr.adicionaCampeonato("Brasileirão Série A 2023", 0);
		});
	}
	
	/**
	 * Testando o Bora Incluir Time em campeonato e Verificar se o time está em campeonato
	 */
	
	// Testes do metodo incluiTimeCampeonato
	
	@Test
	void incluirTimeEmCampeonatoExistente() {
		mr.adicionaCampeonato("Brasileirão Série A 2023", 20);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mr.incluiTimeCampeonato("250_PB", "Brasileirão Série A 2023"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mr.incluiTimeCampeonato("252_PB", "brasileirão série a 2023"));
	}
	@Test
	void incluirTimeDuasVezesNoMesmoCampeonato() {
		mr.adicionaCampeonato("Brasileirão Série A 2023", 20);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mr.incluiTimeCampeonato("250_PB", "Brasileirão Série A 2023"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mr.incluiTimeCampeonato("252_PB", "Brasileirão Série A 2023"));
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mr.incluiTimeCampeonato("250_PB", "Brasileirão Série A 2023"));
	}
	@Test
	void incluirTimeNaoExistenteEmCampeonato() {
		mr.adicionaCampeonato("Brasileirão Série A 2023", 20);
		IllegalArgumentException illegalException = assertThrows(IllegalArgumentException.class, () -> mr.incluiTimeCampeonato("001_PB", "brasileirão série a 2023"));
		assertTrue(illegalException.getMessage().contains("O TIME NÃO EXISTE!"));
	}
	@Test
	void incluirTimeEmCampeonatoNaoExistente() {
		RuntimeException runtimeException = assertThrows(RuntimeException.class,() -> mr.incluiTimeCampeonato("250_PB", "Brasileirão série A 2023"));
		assertTrue(runtimeException.getMessage().contains("O CAMPEONATO NÃO EXISTE!"));
	}
	@Test
	void incluirTimeNaoExistenteEmCampeonatoNaoExistente(){
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> mr.incluiTimeCampeonato("001_PB", "Brasileirão Série A 2023"));
		assertTrue(runtimeException.getMessage().contains("O CAMPEONATO NÃO EXISTE!"));
	}
	@Test
	void incluirTimeEmCampeonatoCheio() {
		mr.adicionaCampeonato("Brasileirão Série A 2023", 1);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!",mr.incluiTimeCampeonato("250_PB", "Brasileirão Série A 2023"));
		assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS",mr.incluiTimeCampeonato("252_PB","Brasileirão Série A 2023"));
	}
	
	//Testes o metodo verificaTimeCampeonato
	
	@Test
	void verificaSeOTimeEstaAdicionadoEmUmCampeonatoExistente() {
		mr.adicionaCampeonato("Copa do Nordeste 2023", 30);
		mr.incluiTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		assertEquals("O TIME ESTÁ NO CAMPEONATO!", mr.verificaTimeCampeonato("250_PB", "Copa do Nordeste 2023"));
	}
	@Test
	void verificarSeOTimeNaoEstaAdicionadoNoCampeonato() {
		mr.adicionaCampeonato("Copa do Nordeste 2023", 20);
		assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!", mr.verificaTimeCampeonato("250_PB", "Copa do Nordeste 2023"));
	}
	
	@Test 
	void verificarParticipacaoTimeCampeonatoComCodigoTimeNullouVazio() {
		mr.adicionaCampeonato("Copa do Nordeste 2023", 20);
		assertThrows(IllegalArgumentException.class, () ->{
			mr.verificaTimeCampeonato(null, "Copa do Nordeste");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			mr.verificaTimeCampeonato("", "Copa do Nordeste");
		});
	}
	
	@Test
	void verificarParticipacaoEmCampeonatoComNomeCampeonatoNullOuVazio() {
		mr.adicionaCampeonato("Copa do Nordeste 2023", 20);
		assertThrows(IllegalArgumentException.class, () ->{
			mr.verificaTimeCampeonato("250_PB", null);
		});
		assertThrows(IllegalArgumentException.class, () ->{
			mr.verificaTimeCampeonato("250_PB", "");
		});
	}
	
	@Test
	void verificarSeOTimeEstaAdicionadoEmUmCampeonatoNaoExistente() {
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> mr.verificaTimeCampeonato("250_PB", "brasileirão série a 2023"));
		assertTrue(runtimeException.getMessage().contains("O CAMPEONATO NÃO EXISTE!"));
	}
	@Test
	void verificarSeOTimeNaoExistenteEstaAdicionadoEmUmCampeonato() {
		mr.adicionaCampeonato("Brasileirão Série A 2023", 20);
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> mr.verificaTimeCampeonato("001_PB", "brasileirão série a 2023"));
		assertTrue(runtimeException.getMessage().contains("O TIME NÃO EXISTE!"));
	}
	@Test 
	void verificarSeOTimeNaoExistenteEstaAdicionadoEmUMCampeonatoNaoExistente(){
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> mr.verificaTimeCampeonato("001_PB", "brasileirão série a 2023"));
		assertTrue(runtimeException.getMessage().contains("O CAMPEONATO NÃO EXISTE!"));
	}
	
	/**
	 * Testando o metodo exibirCampeonatoDoTime
	 */
	
	@Test
	void exibeCampeonatosQueOTimeParticipa() {
		mr.adicionaCampeonato("Copa do Nordeste 2023", 20);
		mr.incluiTimeCampeonato("250_PB", "copa do nordeste 2023");
		assertEquals("Campeonatos do Nacional de Patos:\n* Copa do Nordeste 2023 - 1/20",mr.exibeCampeonatosTime("250_PB"));
	}
	@Test 
	void exibeCampeonatosAtualizadosQueOTimeParicipa(){
		mr.adicionaCampeonato("Copa do Nordeste 2023", 20);
		mr.incluiTimeCampeonato("250_PB", "copa do nordeste 2023");
		assertEquals("Campeonatos do Nacional de Patos:\n* Copa do Nordeste 2023 - 1/20",mr.exibeCampeonatosTime("250_PB"));
		mr.incluiTimeCampeonato("252_PB", "copa do nordeste 2023");
		assertEquals("Campeonatos do Nacional de Patos:\n* Copa do Nordeste 2023 - 2/20",mr.exibeCampeonatosTime("250_PB"));
	}
	@Test
	void exibeCampeonatosSendoQueOTimeNaoParticipaDeNenhum() {
		assertEquals("Campeonatos do Nacional de Patos:", mr.exibeCampeonatosTime("250_PB"));
	}
	@Test 
	void exibeCampeonatosDeUmTimeNaoExistente() {
		mr.adicionaCampeonato("Copa do Nordeste 2023", 20);
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () ->mr.exibeCampeonatosTime("001_PB"));
		assertTrue(runtimeException.getMessage().contains("O TIME NÃO EXISTE!"));
	}
	@Test 
	void exibeCampeonatosDeUmTimeComCodigoVazioOuNull(){
		assertThrows(IllegalArgumentException.class,() ->{
			mr.exibeCampeonatosTime(null);
		});
		assertThrows(IllegalArgumentException.class,() ->{
			mr.exibeCampeonatosTime("");
		});
	}
	
	/**
	 *  Tentar a sorte e status
	 */
	
	//Testes do metodo adicionaAposta
	
	@Test
	void apostaBemSucedida() {
		mr.adicionaCampeonato("Brasileirão Série A 2023", 20);
		mr.incluiTimeCampeonato("250_PB", "Brasileirão Série A 2023");
		assertEquals("APOSTA REGISTRADA!", mr.adicionaAposta("250_PB", "Brasileirão Série A 2023", 20, 30.00));
	}
	@Test
	void apostaComAColocacaoZero() {
		mr.adicionaCampeonato("Copa do Nordeste 2023", 30);
		mr.incluiTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		assertThrows(IllegalArgumentException.class,()->{
			mr.adicionaAposta("250_PB", "Copa do Nordeste 2023", 0, 20);
		});
	}
	@Test
	void apostaComAColocacaoLimite() {
		mr.adicionaCampeonato("Brasileirão Série A 2023", 20);
		mr.incluiTimeCampeonato("250_PB", "brasileirão série a 2023");
		assertEquals("APOSTA REGISTRADA!", mr.adicionaAposta("250_PB", "brasileirão série a 2023", 20, 30.2));
	}
	@Test
	void apostaComAColocacaoMaiorQueAQuantMaxDeParticipantes() {
		mr.adicionaCampeonato("Brasileirão Série A 2023", 20);
		mr.incluiTimeCampeonato("250_PB", "brasileirão série a 2023");
		assertEquals("APOSTA NÃO REGISTRADA!", mr.adicionaAposta("250_PB", "brasileirão série a 2023", 22, 30.2));
	}
	@Test
	void apostaSemCampeonatoExistente() {
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> mr.adicionaAposta("250_PB", "brasileirão série a 2023", 20, 30.3));
		assertTrue(runtimeException.getMessage().contains("O CAMPEONATO NÃO EXISTE!"));
	}
	@Test
	void apostaSemTimeExistente() {
		mr.adicionaCampeonato("Copa do Nordeste 2023", 20);
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> mr.adicionaAposta("001_PB", "copa do nordeste 2023", 20, 30.9));
		assertTrue(runtimeException.getMessage().contains("O TIME NÃO EXISTE!"));
	}
	@Test
	void apostaSemTimeECampeonatoExistentes() {
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> mr.adicionaAposta("001_PB", "copa do nordeste", 20, 30.0));
		assertTrue(runtimeException.getMessage().contains("O CAMPEONATO NÃO EXISTE!"));
	}
	@Test
	void apostaComValorIgualAZero() {
		mr.adicionaCampeonato("Copa do Nordeste 2023", 30);
		mr.incluiTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		assertThrows(IllegalArgumentException.class,()->{
			mr.adicionaAposta("250_PB", "Copa do Nordeste 2023", 20, 0);
		});
	}
	
	//teste do metodo statusAposta
	
	@Test
	void statusAposta() {
		mr.adicionaCampeonato("Campeonato Paraibano 2023", 14);
		mr.incluiTimeCampeonato("250_PB", "Campeonato Paraibano 2023");
		assertEquals("APOSTA REGISTRADA!", mr.adicionaAposta("250_PB", "Campeonato Paraibano 2023", 2, 50));
		assertEquals("Apostas:\n\n1. [250_PB] Nacional de Patos / Canário\nCampeonato Paraibano 2023\n2/14\nR$ 50,00", mr.statusAposta());
	}
}
