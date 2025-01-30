package br.edu.ufcg.computacao.complementaccc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioEstudanteTest {
	
	private UsuarioEstudante estudante;
	private Atividade atv;
		
	@BeforeEach
	void setup() {
		this.estudante = new UsuarioEstudante("Antonio", "11111111111", 88888888, "123456789");
		this.atv = new Atividade("ESTÁGIO",estudante.getCpf()+estudante.getQtdAtividades());
		estudante.adicionaAtividade(atv);

	}
	@Test
	void representaçãoTextualDeUmEstudante() {
		assertEquals("NOME: Antonio\nCPF: 11111111111\nMATRICULA: 123456789", estudante.toString());
	}
	
	@Test
	void adicionandoUmaatividadeNoEstudante() { 
		estudante.adicionaAtividade(new Atividade("Monitoria",estudante.getCpf()+estudante.getQtdAtividades()));
		assertEquals(3, estudante.getQtdAtividades());
	}
	
	@Test
	void pegaAtividadeComBaseNoCodigo() {
		assertEquals("Tipo: ESTÁGIO\nDescrição: ",estudante.pegaAtividadeDoEstudante("111.111.111-11_1").toString());
	
	}

}
