package filmnow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular o sistema FilmNow.
 * 
 * @author eliane
 *
 */
public class MainFilmNow {

	public static void main(String[] args) {
		FilmNow fn = new FilmNow();

		System.out.println("Carregando filmes ...");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaFilmes("filmes_inicial.csv", fn);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, fn, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário/a.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(A)Adicionar filme\n" + 						
						"(M)Mostrar todos\n" + 
						"(D)Detalhar filme\n" + 
						"(E)Exibir HotList\n" +
						"(H)Atribuir Hot\n" +
						"(R)Remover Hot\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.nextLine().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param fn  O sistema FilmNow que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, FilmNow fn, Scanner scanner) {
		switch (opcao) {
		case "A":
			adicionaFilme(fn, scanner);
			break;
		case "M":
			mostrarFilmes(fn);
			break;
		case "D":
			detalharFilme(fn, scanner);
			break;
		case "E":
			exibirHotList(fn);
			break;
		case "H":
			adicionaHotList(fn, scanner);
			break;
		case "R":
			removerHotList(fn, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Imprime lista de filmes.
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 */
	private static void mostrarFilmes(FilmNow fn) {

		String[] filmes = fn.getFilmes();
		for (int i = 0; i < filmes.length; i++) {
			if (filmes[i] != null) {
				System.out.println(formataFilme(i, filmes[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos filmes. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void detalharFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nQual filme> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		if (fn.getFilme(posicao) != null) {
			String filme = fn.getFilme(posicao);
			System.out.println("\nDados do filme:\n" + filme);
		}
	}

	/**
	 * Formata um filme para impressão. 
	 * 
	 * @param posicao A posição do filme (que é exibida)/
	 * @param filme O filme a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataFilme(int posicao, String filme) {
		return (posicao+1)  + " - " + filme;
	}

	/**
	 * Cadastra um filme no sistema. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nPosição no sistema> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		System.out.print("\nAno> ");
		String ano = scanner.nextLine();
		System.out.print("\nLocal> ");
		String local = scanner.nextLine();
		System.out.println(fn.cadastraFilme(posicao, nome, ano, local));
		
	}
	
	/**
	 * Lê carga de filmes de um arquivo csv. 
	 * 
	 * @param arquivoFilmes O caminho para o arquivo.
	 * @param fn O sistema FilmNow a ser populado com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaFilmes(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
		LeitorFilmNow leitor = new LeitorFilmNow();
		
		int carregados =  leitor.carregaContatos(arquivoFilmes, fn);
		System.out.println("Carregamos " + carregados + " registros.");
	}
	
	/**
	 * Cadastra um filme na HotList.
	 * 
	 * @param fn o sistema FilmNow a ser manipulado.
	 * @param scanner scanner para pedir informações para o usuário.
	 */
	private static void adicionaHotList(FilmNow fn, Scanner scanner) {
		System.out.println("Filme> ");
		int filme = Integer.parseInt(scanner.nextLine());
		System.out.println("Posicao> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		System.out.println(fn.adicionaHot(filme, posicao));
	}
	
	/**
	 * Imprime a lista da hotList formatada.
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 */
	private static void exibirHotList(FilmNow fn) {
		String[] hotList = fn.getHotList();
		for (int i = 0; i < hotList.length; i++) {
			if (hotList[i] != null) {
				System.out.println(formataFilme(i, hotList[i]));
			}
		}
	}
	
	/**
	 * Remove um filme especifico da HotList.
	 * 
	 * @param fn O sistema a ser manipulado.
	 * @param scanner scanner para saber de qual posição da hotList o filme deve ser removido.
	 */
	private static void removerHotList(FilmNow fn, Scanner scanner) {
		System.out.println("Posicao> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		fn.removerHot(posicao);
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}
		
}
