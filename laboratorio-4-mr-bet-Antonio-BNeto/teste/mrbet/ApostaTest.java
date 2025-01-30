package mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApostaTest {
	private Time time;
	private Campeonato camp;
	private Aposta aposta;
	
	@BeforeEach
	void setup() {
		this.time = new Time("250_PB", "Nacional de Patos", "Canário");
		this.camp = new Campeonato("Copa do Nordeste", 20);
		this.aposta = new Aposta(time, camp, 2, 30);
	}
	
	/**
	 * Testando o metodo da classe Aposta.
	 */
	
	@Test
	void saidaDaAposta() {
		assertEquals("[250_PB] Nacional de Patos / Canário\nCopa do Nordeste\n2/20\nR$ 30,00", aposta.toString());
	}
}
