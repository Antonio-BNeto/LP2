package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes. 
 * 
 * @author eliane
 *
 */
public class FilmNow {
	
	private static final int TAMANHOFILMES = 100;
	private static final int TAMANHOHOTLIST = 10;
	
	
	private Filme[] filmes; // uma representacao simploria da lista de filmes.
	private Filme[] hotList; // uma representação simploria da lista de hotlist.
	
 	/**
	 * Cria o FilmNow.
	 */
	public FilmNow() {
		this.filmes = new Filme[TAMANHOFILMES];
		this.hotList = new Filme[TAMANHOHOTLIST];
	}
	
	/**
	 * Observa se um filme existe no array de filmes.
	 * 
	 * @param filme Filme que vai comparar com os elementos do array.
	 * @return true:se existir/false:se não existir.
	 */
	private boolean existeFilme(Filme filme) {
		for(int i= 0; i < TAMANHOFILMES; i++) {
			if(filmes[i]!= null) {
				if(filmes[i].equals(filme)) {
					return true;
				}
			}
		}
		return false;
	}	
	
	/**
	 * Observa se um filme existe na hotlist.
	 * 
	 * @param posicao Posição do array de filmes que compara com a hotlist.
	 * @return true:se existir/false:se não existir.
	 */
	private boolean existeNaHotList(int posicao) {
		for(int i = 0; i < TAMANHOHOTLIST; i++) {
			if(hotList[i] != null) {
				if(hotList[i].equals(filmes[posicao-1])) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Acessa a lista de filmes mantida.
	 * 
	 * @return O array de filmes.
	 */
	public String[] getFilmes() {
		String[] output = new String[TAMANHOFILMES];
		for(int i = 0; i < TAMANHOFILMES; i++) {        
			if(filmes[i] != null) {					
				output[i] = this.filmes[i].getNome();
			}
		}
		return output;
	}

	/**
	 * Acessa os dados de um filme específico.
	 * 
	 * @param posicao Posição do filme no sistema.
	 * @return Dados do filme. Null se não há filme na posição.
	 */
	public String getFilme(int posicao) {
		String retorno = "";
		if(posicao < 1 || posicao > 100 ) {
			retorno = "POSIÇÃO INVÁLIDA";
		}else {
			if(filmes[posicao-1] != null) {
				if(existeNaHotList(posicao)) {
					retorno += "🔥 ";
				}
				retorno += filmes[posicao-1].toString();
			}
		}
		
		return retorno;
	}
	
	/**
	 * Retorna o array de String que possui os elementos da hotList.
	 * 
	 * @return  O array de String.
	 */
	public String[] getHotList() {
		String[] output = new String[TAMANHOHOTLIST];
		for (int i = 0; i<TAMANHOHOTLIST; i++) {
			if(hotList[i]!= null) {
				output[i] = this.hotList[i].getNome() + ", " + this.hotList[i].getAno();
			}
		}
		return output;
	}
	
	/**
	 * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior.
	 * @param posicao Posição do filme.
	 * @param nome Nome do filme.
	 * @param ano Ano de lançamento do filme.
	 * @param local Local onde o filme pode ser assitido.
	 * @return Mensagem de validação.
	 */
	public String cadastraFilme(int posicao, String nome, String ano, String local) {
		String retorno;
		if(nome != "" && local != "") {
			if(posicao < 1 || posicao > 100) {
				retorno = "POSIÇÃO INVÁLIDA";
			}else {
				Filme filme = new Filme(nome, ano, local);
				if(!(existeFilme(filme))){
					this.filmes[posicao-1] = filme;
					retorno = "FILME ADICIONADO";
				}else {
					retorno = "FILME JÁ ADICIONADO";
				}
			}
		}else {
			retorno = "FILME INVALIDO";
		}
		return retorno;
	}
	
	/**
	 * Metodo que adiciona um Filme presente na lista de filmes na lista de hotList. 
	 * 
	 * @param posicaoFilme Posição que o filme se encontra no array de filmes
	 * @param posicaoHot Posição que o filme vai ser armazenado na hotList.
	 * @return retorna se o filme foi adicionado e a posição referente. 
	 */
	public String adicionaHot(int posicaoFilme, int posicaoHot) {
		if(filmes[posicaoFilme-1] != null){ 
			if(posicaoHot<1 || posicaoHot>10) return null;
			if(!(existeNaHotList(posicaoFilme))) {
				hotList[posicaoHot-1] = filmes[posicaoFilme-1];
				return "ADICIONADO À HOTLIST NA POSIÇÃO " + posicaoHot + "!" ;
			}
		}
		return null;
	}
	
	/**
	 * Metodo usado para remover um filme da hotList.
	 *  
	 * @param posicaoHot posição na lista de hotList que deseja remover o filme.
	 */
	public void removerHot(int posicaoHot) {
		hotList[posicaoHot-1] = null;
	}
		
}
