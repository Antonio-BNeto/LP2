package br.edu.ufcg.computacao.p2lp2.coisa;

public class CoisaBonus {
	
	public static void main(String[] args) {
		registrarDescanso();
		System.out.println("-----");
		controlarDisciplina();
		System.out.println("-----");
		}
	
	public static void registrarDescanso() {
		Descanso descanso = new Descanso();
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(30);
		descanso.defineNumeroSemanas(1);
		descanso.definirEmoji(":)");
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26);
		descanso.defineNumeroSemanas(1);
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26);
		descanso.defineNumeroSemanas(2);
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26);
		descanso.defineNumeroSemanas(2);
		descanso.definirEmoji(":(");
		System.out.println(descanso.getStatusGeral());
		
	}
	
	private static void controlarDisciplina() {
		Disciplina P2 = new Disciplina("Programação II", 5);
		P2.cadastraHoras(49);
		P2.cadastraNota(1, 1.0);
		P2.cadastraNota(2, 2.0);
		P2.cadastraNota(3, 3.0);
		P2.cadastraNota(4, 5.0);
		P2.cadastraNota(5, 9.0);
		System.out.println(P2.aprovado());
		System.out.println(P2.toString());
		
		Disciplina LP2 = new Disciplina("Laboratorio de Programação II", 5, new int[] {25, 15, 30, 20, 10});
		LP2.cadastraHoras(36);
		LP2.cadastraNota(1, 8.0);
		LP2.cadastraNota(2, 7.0);
		LP2.cadastraNota(3, 9.0);
		System.out.println(LP2.aprovado());
		LP2.cadastraNota(4, 6.0);
		LP2.cadastraNota(5, 10.0);
		System.out.println(LP2.aprovado());
		System.out.println(LP2.toString());
		
		}
	
	
}
