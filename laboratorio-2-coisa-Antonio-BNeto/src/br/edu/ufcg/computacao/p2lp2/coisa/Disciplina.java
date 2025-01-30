package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.Arrays;
/**
* Classe que calcula a media aritmetica de um aluno apartir das suas notas.
* 
* @author Antonio Barros De Alcantara Neto
*/
public class Disciplina {
		// Definindo Atributos
	
		/**
		 * Nome da disciplina que o aluno vai estudar.
		 */
		private String nomeDisciplina;
		
		
		/**
		 * Uma lista de doubles que vai reter as notas do aluno.
		 */
		private double[] notas;
		
		/**
		 * Quantidade de horas que o aluno passou estudando a disciplina.
		 */
		private int horasDisciplinas;
		
		/**
		 * Armazena os pesos que correspondem às notas do aluno.
		 */
		private int[] pesos;
		
		/**
		 * variavel que vai calcular a media aritmetica do aluno.
		 */
		private double media;
		
		/**
		 * Constroi uma disciplina apartir do seu nome. Toda disciplina comeca
		 * o capmo da media como nulo.
		 *
		 * @param nomeDisciplina - cria a disciplina , no formato "laboratório de programação 2"
		 */
		public Disciplina(String nomeDisciplina){
			this(nomeDisciplina, 4);
		}
		
		/**
		 * Costrutor da classe Disciplina que recebe dois parâmetros o nome da disciplina e a quntidade de notas
		 * @param nomeDisciplina - O nome da disciplina. 
		 * @param qtdeNotas - quantas notas vão compor a media do aluno.
		 */
		public Disciplina(String nomeDisciplina, int qtdeNotas) {
			this(nomeDisciplina, qtdeNotas, new int[0]);
		}
		
		/**
		 * Construtor da classe Disciplina, numerero de notas e os pesos das notas.
		 * @param nomeDisciplina - O nome da disciplina
		 * @param qtdeNotas - O número de notas que compõem a media.
		 * @param pesoDasNotas - Um array contendo os pessoa de cada nota.
		 */
		public Disciplina(String nomeDisciplina, int qtdeNotas, int[] pesoDasNotas) {
			this.nomeDisciplina = nomeDisciplina;
			this.notas = new double[qtdeNotas];
			this.pesos = pesoDasNotas;
			this.horasDisciplinas = 0;
			this.media = 0;
		}
		
		/**
		 * Utilizando o metodo set para inserir/atualizar a quantidade de horas ja estudadas pelo aluno na disciplina
		 * 
		 * @param horas - somar a quantidade de  horas que um aluno passsou estudando de uma certa disciplina.
		 */
		public void cadastraHoras(int horas) {
			this.horasDisciplinas += horas;
		}
		
		/**
		 * Utilizando o metodo set para inserir/atualizar as notas que o aluno tirou de uma disciplina. 
		 * 
		 * @param nota - array que vai armazena as notas do aluno.
		 * @param valorNota - armazena uma nota de cada vez para poder calcular a sua media aritmetica.
		 */
		public void cadastraNota(int nota, double valorNota) {
			this.notas[nota-1] = valorNota;
			calculandoMedia();
		}
		
		/**
		 * Retonando um boolean confirmando se a media aritmetica do aluno foi maior ou igual a 7.
		 * 
		 * @return - retorna a media aritmetica calculada.
		 */
		public boolean aprovado() {
			if(this.media>=7.0) { 
				return true;
			} else {
				return false;
			}
		}
		
		/**
		 * Retorna uma String no formato "(nome da disciplina) (horas das disciplinas) (media do aluno)  (notas do aluno)"
		 */
		public String toString() {
			return nomeDisciplina+" "
					+horasDisciplinas+" "
					+media+" "
					+Arrays.toString(notas); 
		}
		/**
		 * Calcula a media do aluno com base nas notas cadastradas e, se houver peso das notas.
		 * Se nenhum peso for especificado elas possuiram o mesmo peso.
		 */
		public void calculandoMedia() {
			if(this.pesos.length == 0) {
				this.media = (Arrays.stream(this.notas).sum()/this.notas.length);
			} else {
				double somaTotal = 0;
				for(int i=0; i<this.notas.length; i++) {
					somaTotal += (int) (notas[i] * pesos[i]);
				}
			this.media = somaTotal/Arrays.stream(this.pesos).sum();
			}
		}
}