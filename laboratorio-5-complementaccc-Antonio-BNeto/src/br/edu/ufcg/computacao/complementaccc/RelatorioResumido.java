package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Classe que representa um objeto Relatorio Resumidos.
 * 
 * @author Antonio Barros De Alcantara Neto.
 */
public class RelatorioResumido extends Relatorio {
	
	/**
	 * Metodo construtor de um Relatorio resumido.
	 */
	public RelatorioResumido() {
	}
	
	/**
	 * Metodo que gera um relatorio Resumidos
	 */
	@Override
	public void geraRelatorio(String dadosEstudante, List<Atividade> atividades) {
		StringBuilder output = new StringBuilder();
		output.append(dadosEstudante).append("\n");
		
		int creditosEstagio = 0; 
		int creditosPesquisaExtensao = 0;
		int creditosMonitoria = 0;
		int creditosPublicacao = 0;
		
		
		int maxCreditosEstagio = 18;
		int maxCreditosPesquisaExtensao = 18;
		int maxCreditosMonitoria = 16;
		int maxCreditosPublicacao = 16;
		
		for(Atividade atv: atividades) {
			if(atv.getTipo().equals("ESTÁGIO")) {
				if(atv.calculaCreditos() == 0) {
					output.append("NÃO CONSEGUIU ATINGIR O TEMPO MINIMO DE ESTÁGIO QUE É 300 HORAS").append("\n");
				}
				creditosEstagio += atv.getCreditos();
			}
			if(atv.getTipo().equals("MONITORIA")) {
				creditosMonitoria += atv.getCreditos();
			}
			if(atv.getTipo().equals("PESQUISA/EXTENSAO")) {
				if(atv.calculaCreditos() == 0) {
					output.append("NÃO CONSEGUIU ATINGIR O TEMPO MINIMO DE PESQUISA QUE É 12 MESES").append("\n");
				}
				creditosPesquisaExtensao += atv.getCreditos();
			}
			if(atv.getTipo().equals("PUBLICAÇÃO")) {
				creditosPublicacao += atv.getCreditos();
			}
			output.append(atv.toString()).append("\n");
		}
		
		output.append("Creditos Acumulados dos Estagios: ").append(creditosEstagio).append("\n");
		output.append("Creditos Maximos do Estagio").append(maxCreditosEstagio).append("\n");
		output.append("Creditos Acumulados da Monitoria: ").append(creditosMonitoria).append("\n");
		output.append("Creditos Maximos da Monitoria").append(maxCreditosMonitoria).append("\n");
		output.append("Creditos Acumulados da Pesquisa/Extensao: ").append(creditosPesquisaExtensao).append("\n");
		output.append("Creditos Maximos das Pesquisas e extensão").append(maxCreditosPesquisaExtensao).append("\n");
		output.append("Creditos Acumulados das Publicações: ").append(creditosPublicacao).append("\n");
		output.append("Creditos Maximos da Publicação").append(maxCreditosPublicacao).append("\n");
		
		this.relatorio = output.toString();
		
	}
}	