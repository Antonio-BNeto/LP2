package mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeTest {
	
	private Time time1;
	private Time time2;
	private Time time3;
	
	@BeforeEach
	void setup() {
		this.time1 = new Time("250_PB", "Nacional de Patos", "Canário");
		this.time2 = new Time("250_PB", "Sport Lagoa Seca", "Carneiro");
		this.time3 = new Time("001_PB", "Nacional de Patos", "Canário");
	}
	/**
	 * testando os metodos da classe time.
	 */
	@Test
	void saidaDoTimeFormatada() {
		assertEquals("[250_PB] Nacional de Patos / Canário",time1.toString());
	}
	@Test
	void comparandoDoisTimesComMesmoCodigo(){
		assertTrue(time1.equals(time2));
	}
	@Test
	void comparandoDoisTimesComCodigosDiferentes() {
		assertFalse(time1.equals(time3));
	}
}
