package mrbet;

import java.util.Scanner;

public class MainMrBetSistema {
	
	private static MrBetSistema mr;
	private static Scanner scanner;
	
	public static void main(String[] args) {
		
		mr = new MrBetSistema();
		
		scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu();
			comando(escolha);
		}
	}
	
	private static String menu() {
		System.out.println( 
						"----------MENU---------\n" +
						"(M)Minha inclusão de times\n" + 						
						"(R)Recuperar time\n" + 
						"(.)Adicionar campeonato\n" + 
						"(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" +
						"(E)Exibir campeonatos que o time participa\n" +
						"(T)Tentar a sorte e status\n" +
						"(!)Já pode fechar o programa!\n" + 
						"\n" + 
						"Opção> ");
		return scanner.nextLine().toUpperCase();
	}
	
	private static void comando(String opcao) {
		switch (opcao) {
		case "M":
			incluirTime();
			break;
		case "R":
			recuperarTime();
			break;
		case ".":
			adicionaCampeonato();
			break;
		case "B":
			subcomando1();
			break;
		case "E":
			exibirCampeonatosDoTime();
			break;
		case "T":
			subcomando2();
			break;
		case "!":
			fecharPrograma();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	private static void incluirTime() {
		System.out.println("Código: ");
		String codigo = scanner.nextLine();
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		System.out.println("Mascote: ");
		String mascote = scanner.nextLine();
		System.out.println(mr.adicionaTime(codigo, nome, mascote));
		System.out.println();
	}
	
	private static void recuperarTime() {
		System.out.println("Código: ");
		String codigo = scanner.nextLine();
		System.out.println(mr.recuperaTime(codigo));
		System.out.println();
	}
	
	private static void adicionaCampeonato() {
		System.out.println("Campeonato: ");
		String nome = scanner.nextLine();
		System.out.println("Participantes: ");
		int numTimes = Integer.parseInt(scanner.nextLine());
		System.out.println(mr.adicionaCampeonato(nome, numTimes));
		System.out.println();
		
	}
	
	private static String subMenu1() {
		System.out.println( 
						"(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato?");
		return scanner.nextLine().toUpperCase();
	}
	
	private static void subcomando1() {
		String option = "" ;
		option = subMenu1();
		
		switch(option) {
		case "I":
			incluirTimeCampeonato();
			break;
		case "V":
			verificarTimeCampeonato();
			break;
		default:
			System.out.println("Opção invalida! \n");
		}
		
	}
	
	private static void incluirTimeCampeonato() {
		System.out.println("Código: ");
		String codigo = scanner.nextLine();
		System.out.println("Campeonato: ");
		String campeonato = scanner.nextLine();
		System.out.println(mr.incluiTimeCampeonato(codigo, campeonato));
		System.out.println();
	}
	
	private static void verificarTimeCampeonato() {
		System.out.println("Código: ");
		String codigo = scanner.nextLine();
		System.out.println("Campeonato: ");
		String campeonato = scanner.nextLine();
		System.out.println(mr.verificaTimeCampeonato(codigo, campeonato));
		System.out.println();
	}
	
	private static void exibirCampeonatosDoTime() {
		System.out.println("Time:");
		String codigo = scanner.nextLine();
		System.out.println(mr.exibeCampeonatosTime(codigo));
	}
	
	private static String subMenu2() {
		System.out.println( 
						"(A)Apostar ou (S)Status das Apostas?");
		return scanner.nextLine().toUpperCase();
	}
	
	private static void subcomando2() {
		String option = "" ;
		option = subMenu2();
		
		switch(option) {
		case "A":
			apostar();
			break;
		case "S":
			statusAposta();
			break;
		default:
			System.out.println("Opção Invalida! \n ");
		}
	}
	
	private static void apostar() {
		System.out.println("Código: ");
		String codigo = scanner.nextLine();
		System.out.println("Campeonato: ");
		String campeonato = scanner.nextLine();
		System.out.println("Colocação: ");
		int colocacao = Integer.parseInt(scanner.nextLine());
		System.out.println("Valor da Aposta: R$");
		double valor = Double.valueOf(scanner.nextLine()).doubleValue();
		System.out.println(mr.adicionaAposta(codigo, campeonato, colocacao, valor));
		System.out.println();
		
	}
	
	private static void statusAposta() {
		System.out.println(mr.statusAposta());
	}
	
	private static void fecharPrograma() {
		System.out.println("\nPor hoje é só pessoal! ");
		System.exit(0);
	}
	
}
