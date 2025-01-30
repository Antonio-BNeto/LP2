package mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CampeonatoTest {
	
	private Time time1;
	private Campeonato camp1;
	private Time time2;
	private Campeonato camp2;
	
	@BeforeEach
	void setup() {
		this.time1 = new Time("250_PB", "Nacional de Patos", "Canário");
		this.camp1 = new Campeonato("Copa do Nordeste", 20);
		this.time2 = new Time("252_PB", "Sport Lagoa Seca", "Carneiro");
		this.camp2 = new Campeonato("Brasileirão Série A 2023", 1);
	}
	/**
	 * Testando os Metodos da classe Campeonato.
	 */

	@Test
	void addTimeEmCampeonatoComEspaco() {
		assertTrue(camp1.addTimeNoCampeonato(time1));
	}
	@Test 
	void addTimeEmCampeonatoCheio(){
		camp2.addTimeNoCampeonato(time1);
		assertFalse(camp2.addTimeNoCampeonato(time2));
	}
	@Test
	void buscaTimeAdicionadoEmCampeonato() {
		camp1.addTimeNoCampeonato(time1);
		assertTrue(camp1.buscaTimeEmCampeonato(time1));
	}
	@Test
	void buscaTimeNaoAdicionadoEmCampeonato() {
		assertFalse(camp1.buscaTimeEmCampeonato(time1));
	}
	@Test
	void saidaDoCampeonatoSemParticipantes() {
		assertEquals("Copa do Nordeste - 0/20", camp1.toString());
	}
	@Test
	void saidaDoCampeonatoComParticipantes() {
		camp1.addTimeNoCampeonato(time1);
		assertEquals("Copa do Nordeste - 1/20", camp1.toString());
	}

}
