package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Classe que representa um objeto Atividade de Monitoria.
 * 
 * @author Antonio Barros De Alcantara Neto.
 */
public class RelatorioDetalhado extends Relatorio {
	
	/**
	 * Metodo que gera um relatorio Detalhado.
	 */
	public RelatorioDetalhado() {
	}
	
	/**
	 * Metodo que cria um relatorio Detalhado.
	 */
	@Override
	public void geraRelatorio(String dadosEstudante, List<Atividade> atividadesEstudante) {
		List<Atividade> ordenaAtividades = new ArrayList<>();
		for(Atividade atv:atividadesEstudante) {
			ordenaAtividades.add(atv);
		}
		Collections.sort(ordenaAtividades);
		
		int creditosEstagio = 0; 
		int creditosPesquisaExtensao = 0;
		int creditosMonitoria = 0;
		int creditosPublicacao = 0;
		
		StringBuilder output = new StringBuilder();
		output.append("Relatorio Detalhado de atividades dos Estudante:\n");
		output.append(dadosEstudante).append("\n");
		
		for(Atividade atv: atividadesEstudante) {
			if(atv.getTipo().equals("ESTAGIO")) {
				creditosEstagio += atv.getCreditos();
			}
			if(atv.getTipo().equals("MONITORIA")) {
				creditosMonitoria += atv.getCreditos();
			}
			if(atv.getTipo().equals("PESQUISA/EXTENSAO")) {
				creditosPesquisaExtensao += atv.getCreditos();
			}
			if(atv.getTipo().equals("PUBLICAÇÃO")) {
				creditosPublicacao += atv.getCreditos();
			}
			output.append(atv.toString()).append("\n");
		}
		output.append("Creditos Acumulados dos Estagios: ").append(creditosEstagio).append("\n");
		output.append("Creditos Acumulados da Monitoria: ").append(creditosMonitoria).append("\n");
		output.append("Creditos Acumulados da Pesquisa/Extensao: ").append(creditosPesquisaExtensao).append("\n");
		output.append("Creditos Acumulados das Publicações: ").append(creditosPublicacao).append("\n");
		
		this.relatorio = output.toString();
	}
}
