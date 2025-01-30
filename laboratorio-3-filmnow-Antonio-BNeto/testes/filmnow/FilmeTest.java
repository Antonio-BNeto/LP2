package filmnow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testes de Filme
 * 
 * @author Antonio Barros De Alcantara Neto
 */

public class FilmeTest {

    private Filme filme1;
    private Filme filme2;
    private Filme filme3;
    private Filme filme4;

    @BeforeEach
    void preparaFilmes() {
        this.filme1 = new Filme("Avatar", "2009", "Disney+");
        this.filme2 = new Filme("Avatar", "2009", "Cinema");
        this.filme3 = new Filme("Avatar", "", "CG");
        this.filme4 = new Filme("", "", "");
    }
    
    @Test
    void testSaidaDoFilmeComTodosOsDados() {
    	assertEquals(("Avatar, 2009\nDisney+"), filme1.toString());
    }
    
    @Test
    void testandoSaidaFilmeSemOAno() {
       assertEquals("Avatar\nCG", this.filme3.toString());
    }
    
    @Test
    void testandoSaidaDoFilmeSemDados() {
    	assertEquals("\n", this.filme4.toString());
    }
    
    @Test
    void testComparandoFilmesIguais() {
    	assertEquals(true,this.filme1.equals(filme2));
    }
    
    @Test
    void testComparandoFilmesDiferentes() {
    	assertEquals((false), this.filme1.equals(filme3));
    }
    
}
