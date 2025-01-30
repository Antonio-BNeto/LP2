package filmnow;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testes de FilmNow
 * 
 * @author Antonio Barros De Alcantara Neto
 */

class FilmNowTest {
	
	private FilmNow fn;
	
	@BeforeEach
	void setup() {
		this.fn = new FilmNow();
	}
	
	/**
	 * Testando o metodo de adicionar filmes no sistema;
	 */

	@Test
	void testAdicionaFilmeEmPosicaoVazia() {
		assertEquals(("FILME ADICIONADO"), fn.cadastraFilme(5,"Avatar", "2009", "Disney+"));
	}
	
	@Test
	void testAdicionarFilmeEmPosicaoExistente() {
		assertEquals(("FILME ADICIONADO"), fn.cadastraFilme(1, "Avatar", "2009", "Disney+"));
		assertEquals(("FILME ADICIONADO"), fn.cadastraFilme(1, "20 dias em Mariupol", "2023", "Cinema")); 
		}
	
	@Test
	void testFilmeJaExistenteNoSistema() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		assertEquals(("FILME JÁ ADICIONADO"), fn.cadastraFilme(3, "Avatar", "2009", "Disney+"));
		}
	
	@Test
	 void testFilmesComLocaisDiferentes() {
		 fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		 assertEquals(("FILME JÁ ADICIONADO"), fn.cadastraFilme(3, "Avatar", "2009", "Popcornflix"));
	 }
	
	@Test
	void testAdicionarFilmeNaPosicaoLimite() {
		assertEquals(("FILME ADICIONADO"), fn.cadastraFilme(100, "Avatar", "2009", "Disney+"));
	}
	
	@Test
	void testAdicionarFilmeNaPosicaoAcimaDoLimite() {
		assertEquals(("POSIÇÃO INVÁLIDA"),fn.cadastraFilme(101, "Avatar", "2009", "Disney+"));
	}
	
	@Test
	void testAdicionarFilmeNaPosicaoAbaixoDoLimite() {
		assertEquals(("POSIÇÃO INVÁLIDA"),fn.cadastraFilme(0, "Avatar", "2009", "Disney+"));
	}
	
	@Test
	void testAdicionarFilmeComLocalVazio() {
		assertEquals(("FILME INVALIDO"), fn.cadastraFilme(5, "20 dias em Mariupol", "2023", ""));
	}
	
	@Test
	void testAdicionarFilmeComAnoVazio() {
		assertEquals(("FILME ADICIONADO"), fn.cadastraFilme(5, "20 dias em Mariupol", "", "Cinema"));
	}
	
	@Test
	void testAdicionarFilmeComNomeVazio() {
		assertEquals(("FILME INVALIDO"), fn.cadastraFilme(6, "", "2023", "Cinema"));
	}
	
	@Test
	void testAdicionarFilmeComNomeAnoLocalVazio() {
		assertEquals(("FILME INVALIDO"), fn.cadastraFilme(100, "", "", ""));
	}
	
	/**
	 * Testando o metodo de detalhar um filme especifco no sistema.
	 */
	
	@Test
	void testDetalharFilmeComTodosOsDados() {
		fn.cadastraFilme(100, "Avatar", "2009", "Disney+");
		assertEquals(("Avatar, 2009\nDisney+"), fn.getFilme(100));
	}
	
	@Test
	void testDetalharFilmeAdicionadoSemAno() {
		fn.cadastraFilme(1, "20 dias em Mariupol", "", "Cinema");
		assertEquals(("20 dias em Mariupol\nCinema"), fn.getFilme(1));
	}
	
	@Test
	void testDetalharFilmeSemFilme() {
		assertEquals((""), fn.getFilme(50));
	}
	
	@Test
	void testDetalharFilmeComPosicaoAbaixoDoLimite() {
		assertEquals(("POSIÇÃO INVÁLIDA"), fn.getFilme(0));
	}
	
	@Test
	void testDetalharFilmeComPosicaoAcimaDoLimite() {
		assertEquals(("POSIÇÃO INVÁLIDA"),fn.getFilme(101));
	}
	
	@Test
	void testDetalharFilmeNaPosicaoLimiteSuperiorComAno() {
		fn.cadastraFilme(100, "20 dias em Mariupol", "2009", "Cinema");
		assertEquals(("20 dias em Mariupol, 2009\nCinema"), fn.getFilme(100));
	}
	
	@Test
	void testDetalharFilmeNaPosicaoLimiteSuperiorSemAno() {
		fn.cadastraFilme(100, "20 dias em Mariupol", "", "Cinema");
		assertEquals(("20 dias em Mariupol\nCinema"), fn.getFilme(100));
	}
	
	@Test
	void testDetalharFilmeNaPosicaoLimiteInferiorComAno() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		assertEquals(("Avatar, 2009\nDisney+"),fn.getFilme(1));
	}
	
	@Test
	void testDetalharFilmeNaPosicaoLimiteInferiorSemAno() {
		fn.cadastraFilme(1, "Avatar", "", "Disney+");
		assertEquals(("Avatar\nDisney+"), fn.getFilme(1));
	}	
	
	@Test
	void testDetalharFilmeDaHotList() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		assertEquals(("Avatar, 2009\nDisney+"), fn.getFilme(1));
		fn.adicionaHot(1, 1);
		assertEquals(("🔥 Avatar, 2009\nDisney+"),fn.getFilme(1));
	}
	
	@Test
	void testDetalharFilmeDaHotListSemAno() {
		fn.cadastraFilme(100, "20 dias em Mariupol", "", "Cinema");
		assertEquals(("20 dias em Mariupol\nCinema"),fn.getFilme(100));
		fn.adicionaHot(100,1);
		assertEquals(("🔥 20 dias em Mariupol\nCinema"),fn.getFilme(100));
	}
	
	@Test
	void testDetalharFilmeQueFoiAdicionadoNaHotListEDepoisRemovidoComAno() {
		fn.cadastraFilme(1, "Avatar", "2000", "Disney+");
		fn.adicionaHot(1, 2);
		assertEquals("🔥 Avatar, 2000\nDisney+", fn.getFilme(1));
		fn.removerHot(2);
		assertEquals(("Avatar, 2000\nDisney+"), fn.getFilme(1));
	}
	
	@Test
	void testDetalharFilmeQueFoiAdicionadoNaHotListEDepoisRemovidoSemAno() {
		fn.cadastraFilme(100, "Avatar", "", "Disney+");
		fn.adicionaHot(100, 1);
		assertEquals(("🔥 Avatar\nDisney+"), fn.getFilme(100));
		fn.removerHot(1);
		assertEquals(("Avatar\nDisney+"), fn.getFilme(100));
	}
	
	/**
	 * Testar adicionar HotList no sistema
	 */
	
	@Test
	void testAdicionarFilmeNaHotListVazia() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		assertEquals(("ADICIONADO À HOTLIST NA POSIÇÃO 2!"),fn.adicionaHot(1, 2));
	}
	
	@Test
	void testAdicionarFilmeNaHotListExistente() {
		fn.cadastraFilme(1, "20 dias em Mariupol", "2000", "Cinema");
		fn.cadastraFilme(100, "Avatar", "2009", "Disney+");
		fn.adicionaHot(1, 1);
		assertEquals(("ADICIONADO À HOTLIST NA POSIÇÃO 1!"), fn.adicionaHot(100, 1));
	}
	
	@Test
	void testAdicionarFilmeNaHotListPosicaoLimiteSuperior() {
		fn.cadastraFilme(100, "Avatar", "2009", "Disney+");
		assertEquals(("ADICIONADO À HOTLIST NA POSIÇÃO 10!"), fn.adicionaHot(100, 10));
	}
	
	@Test
	void testAdicionarFilmeNaHotListPosicaoLimiteInferior() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		assertEquals(("ADICIONADO À HOTLIST NA POSIÇÃO 1!"), fn.adicionaHot(1, 1));
	}
	
	@Test
	void testAdicionarFilmeSemAnoNaHotList() {
		fn.cadastraFilme(100, "Programação 2", "", "UFCG");
		assertEquals(("ADICIONADO À HOTLIST NA POSIÇÃO 1!"),fn.adicionaHot(100, 1));
	}
	
	@Test
	void testAdicionarFilmeNaHotListSemFilme() {
		assertEquals((null), fn.adicionaHot(1, 1));
	}
	
	@Test
	void testAdicionarFilmeNaPosicaoAcimaDoLimiteDaHotList() {
		fn.cadastraFilme(1, "Demons Slayer", "2020", "crunchyroll");
		assertEquals((null), fn.adicionaHot(1, 11));
	}
	
	@Test
	void testAdicionarFilmeNaPosicaoAbaixoDoLimiteDaHotList() {
		fn.cadastraFilme(1, "Demons Slayer", "2020", "crunchyroll");
		assertEquals((null), fn.adicionaHot(1,0));
	}
	
	/**
	 * Testando Remover Filme na HotList
	 */
	
	@Test
	void testRemovendoFilmeDaHotList() {
		fn.cadastraFilme(1, "Fuga das galinhas" , "2020", "Cinema");
		assertEquals(("ADICIONADO À HOTLIST NA POSIÇÃO 1!"), fn.adicionaHot(1, 1));
		fn.removerHot(1);
		assertNull(fn.getHotList()[0]);		
	}
	@Test
	void testRemovendoFilmeDaHotListVazia() {
		fn.removerHot(1);
		assertNull(fn.getHotList()[0]);
	}

}
