package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelatorioResumidoAtv extends Relatorio {
	
	/**
	 * Metodo construtor de um relatorio resumido por atividade.
	 */
	public RelatorioResumidoAtv() {
	}
	/**
	 * Metodo que gera um relatorio Resumido por tipo.
	 */
	@Override
	public void geraRelatorioPorTipo(String dadosEstudante,String tipoAtividade,List<Atividade> atividades) {		
		StringBuilder output = new StringBuilder();
		output.append("Relatorio resumido por atividade:\n");
		output.append(dadosEstudante).append("\n");
		
		int creditosAtividade = 0;
		int maxCreditosAtividade = 0;
		
		switch(tipoAtividade){
		case "PESQUISA/EXTENSAO":
			maxCreditosAtividade = 18;
			break;
		case "MONITORIA":
			maxCreditosAtividade = 16;
			break;
		case "ESTÁGIO":
			maxCreditosAtividade = 18;
			break;
		case "PUBLICAÇÃO<PERIÓDICO>":
			maxCreditosAtividade = 16;
			break;
		case "PUBLICAÇÃO<CONFERÊNCIA>":
			maxCreditosAtividade = 16;
			break;
		}
		
		for(Atividade atv: atividades) {
			if(atv.getTipo().equals(tipoAtividade)) {
				output.append(atv.toString()).append("\n");
				creditosAtividade += atv.calculaCreditos();
			}
		}
		output.append("Creditos Maximos: ").append(maxCreditosAtividade).append("\n");
		output.append("Creditos Acumulados: ").append(creditosAtividade).append("\n");
		
		this.relatorio = output.toString();
		
	}

}
