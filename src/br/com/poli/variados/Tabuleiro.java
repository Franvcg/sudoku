package br.com.poli.variados;

import java.util.*;

import br.com.poli.exceptions.MovimentoIncorretoException;
import br.com.poli.exceptions.MovimentoInvalidoException;
import br.com.poli.exceptions.TabuleiroInvalidoException;

public class Tabuleiro implements ResolvedorSudoku {

	private int[][] grid;
	private int[][] gabarito;

	public Tabuleiro() {
		grid = new int[9][9];
	}

	/*
	 * 1 º if-> verifica se o valor passado esta entre 1 e 9 2 º if-> verifica
	 * se o valor da linha e da coluna é maior que 0 e menor ou igual a 9 3 º
	 * if-> Utilizando o método auxiliar, casaVazia, verifica se uma dada
	 * posicao já está ocupada com algum valor diferente de 0 4 º if->
	 * Utilizando o método auxiliar, comparaJogada. O funcionamento do método é
	 * explicado mais abaixo
	 * 
	 */
	public boolean executaMovimento(int linha, int coluna, int valor)
			throws MovimentoIncorretoException, MovimentoInvalidoException {
		if (valor > 0 && valor < 10) {
			if (linha > 0 && linha <= 9 && coluna > 0 && coluna <= 9) {
				if (casaVazia(linha, coluna) == false) {
					throw new MovimentoInvalidoException("A posição acessada encontra-se ocupada");
				} else {
					grid[linha - 1][coluna - 1] = valor;
					if (comparaJogada(linha, coluna, valor) == false) {
						throw new MovimentoIncorretoException("Jogada incorreta!");
					} else {
						return true;
					}
				}
			} else {
				throw new MovimentoInvalidoException(
						"A posição da linha e/ou coluna é inválida. Insira um valor entre 1 e 9");
			}
		} else {
			throw new MovimentoInvalidoException(
					"O valor que você tentou inserir é inválido. Favor inserir um outro valor, entre 1 e 9");
		}
	}

	/*
	 * Passa-se uma posicão(x,y) e um valor para a mesma. Faz-se verificações
	 * para ver se o valor passado pode ser inserido naquela casa. Tudo isso com
	 * verificações para linha, coluna e quadrado 3x3. Retorna false se o valor
	 * já estiver presente e true, caso contrário. O primeiro for retorna false
	 * caso o valor passado já esteja presente em alguma coluna da linha
	 * passada. O segundo for retorna false se o valor passado já estiver
	 * presente em alguma linha da coluna passada. O terceiro for retorna false
	 * se o valor passado já estive contido em um quadrado 3x3.
	 */
	private boolean verificaMovimento(int linha, int coluna, int valor) {
		int valorX = 0;
		int valorY = 0;

		for (int i = 0; i < 9; i++) {
			if (valor == grid[linha][i]) {
				return false;
			}

		}

		for (int i = 0; i < 9; i++) {
			if (valor == grid[i][coluna]) {
				return false;
			}
		}

		if (linha > 2) {
			if (linha > 5) {
				valorX = 6;
			} else {
				valorX = 3;
			}
		}
		if (coluna > 2) {
			if (coluna > 5) {
				valorY = 6;
			} else {
				valorY = 3;
			}
		}
		for (int i = valorX; i < 10 && i < valorX + 3; i++) {
			for (int j = valorY; j < 10 && j < valorY + 3; j++) {
				if (valor == grid[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	// método auxiliar, responsável por comparar o tabuleiro atual, ou seja,
	// aquele que o jogador está manipulando,preenchendo,
	// com o gabarito. Dada uma linha e uma coluna passada por parâmetro, o
	// método avalia se o valor correspondente aquela posição
	// é igual tanto para o grid como para o gabarito.Retorna um boolean
	// é utilizado em executaMovimento

	public boolean comparaJogada(int linha, int coluna, int valor) {
		if (gabarito[linha - 1][coluna - 1] == valor) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Responsável por tentar gerar um tabuleiro válido. Para isso, através do
	 * método verificaMovimento, tenta preencher todas as casas com valores de 1
	 * a 9, respeitando o critério das linhas, colunas e quadrados 3x3. Os
	 * parâmetros correspondem a um valor para a linha e coluna. Quando chamamos
	 * resolveTabuleiro dentro de geraTabuleiro, passamos (0,0), referente a
	 * posição inicial, de forma que seja possível percorrer todas as 81 casas
	 * do tabuleiro. Retorna true se um tabuleiro válido for gerado e false,
	 * caso não seja possivel. Os valores passados no método são armazenados em
	 * valorX e ValorY. O objeto do tipo Random será usado para gerar números de
	 * forma aleatória dentro de um intervalo. Esse intervalo corresponde a
	 * variável "valoresValidos", de tamanho 9, que corresponde a um vetor que
	 * contém todos os nove valores possíveis e válidos para serem inseridos em
	 * um sudoku, os numéros de 1 a 9. valorAuxMutavel1 e valorAuxMutavel2
	 * correspondem a variáveis auxiliares, que tem o seu alterado a cada
	 * iteração do for. No segundo for, temos que se o valor de
	 * "valoresValidos[i]", com i sendo uma dada iteração, for válido para
	 * aquela casa, o valor será armazenado no grid naquela casa. Os dois if's
	 * que seguem verificam se o valor da linha e coluna correspondem a 8, o que
	 * significa a ultima casa do tabuleiro, ou seja, todas as casas anteriores
	 * a esta já encontram-se preenchidas e como já estão preenchidas, significa
	 * que o valor que elas possuem é válido e segue as regras do jogo. Com
	 * isso, é chamado o método resolveTabuleiro, de forma recursiva, para
	 * realizar novamente esse processo.
	 * 
	 */
	public boolean resolveTabuleiro(int linha, int coluna) throws TabuleiroInvalidoException {

		Random r = new Random();
		int[] valoresValidos = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int valorX = linha;
		int valorY = coluna;
		int valorAuxMutavel1 = 0;
		int valorAuxMutavel2 = 0;

		for (int i = 1; i < 9; i++) {
			valorAuxMutavel1 = r.nextInt(i);
			valorAuxMutavel2 = valoresValidos[valorAuxMutavel1];
			valoresValidos[valorAuxMutavel1] = valoresValidos[i];
			valoresValidos[i] = valorAuxMutavel2;
		}

		for (int i = 0; i < 9; i++) {
			if (verificaMovimento(linha, coluna, valoresValidos[i])) {
				grid[linha][coluna] = valoresValidos[i];
				if (linha == 8) {
					if (coluna == 8) {
						return true;
					} else {
						valorX = 0;
						valorY = coluna + 1;
					}
				} else {
					valorX = linha + 1;
				}
				if (resolveTabuleiro(valorX, valorY)) {
					return true;
				}
			}
		}
		grid[linha][coluna] = 0;
		return false;
	}

	/*
	 * Retorna um boolean, indicando se o grid(tabuleiro) está totalmente
	 * preenchido
	 */
	public boolean isTabuleiroPreenchido() {
		for (int linha = 0; linha < 9; linha++) {
			for (int coluna = 0; coluna < 9; coluna++) {
				if (this.grid[linha][coluna] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	// Função criada apenas para testar a isTabuleiroPreenchido
	public void preencherTabuleiro(int valor) {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if (grid[x][y] == 0) {
					if (valor > 0 && valor < 10)
						grid[x][y] = valor;
				}
			}
		}
	}

	/*
	 * Método responsável por esvaziar(tornar zero) uma dada quantidade de
	 * casas. A quantidade será definida de acordo com a dificuldade da partida.
	 */
	public void tornarCasasVazias(DificuldadePartida partida) {

		double casasTotais = 81;
		double casasEsvaziar = (double) partida.getQuantidadeEspacosVazios();

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				double percVazia = casasEsvaziar / casasTotais;
				if (Math.random() <= percVazia) {
					grid[i][j] = 0;
					casasEsvaziar--;
				}
				casasTotais--;
			}
	}

	/**
	 * Imprime o grid(tabuleiro) atual
	 */
	public void imprimeTabuleiro() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/*
	 * método auxiliar, responsável por retornar o valor correspondente a
	 * posição passada(linha e coluna)
	 */
	public int search(int linha, int coluna) {
		return grid[--linha][--coluna];
	}

	/*
	 * método auxiliar, utilizado em executaMovimento. Retorna um boolean Se o
	 * valor em uma dada posição for igual a zero, aquela posição é considerada
	 * vazia, já que o sudoku não admite valor zero
	 */
	public boolean casaVazia(int linha, int coluna) {
		if (grid[linha - 1][coluna - 1] == 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Método responsável por gerar um tabuleiro Recebe como paramêtro um enum
	 * referente a dificuldade da partida, nele haverá infos relacionadas as
	 * características que o tabuleiro deverá possuir de acordo com a
	 * dificuldade passada. O for de dentro do método imprime o sudoku gerado
	 * completo, sem espaços vazios, ou seja, zeros. É necessária a sua presença
	 * afim de mostrar ao usuário durante o teste, uma comparação entre os
	 * valores presentes no gabarito e o grid do sudoku com espaços vazios. Essa
	 * comparação pode ser feita a partir do momento em que chamamos o
	 * geraTabuleiro e o executaMovimento
	 * 
	 */
	public int[][] geraTabuleiro(DificuldadePartida partida) throws TabuleiroInvalidoException {
		grid = new int[9][9];
		gabarito = new int[9][9];
		resolveTabuleiro(0, 0);
		for (int linha = 0; linha < 9; linha++) {
			for (int coluna = 0; coluna < 9; coluna++) {
				gabarito[linha][coluna] = grid[linha][coluna];
				System.out.print(gabarito[linha][coluna] + "  ");
			}
			System.out.println();
		}
		System.out.println();
		tornarCasasVazias(partida);

		return grid;

	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	public int[][] getGabarito() {
		return gabarito;
	}

	public void setGabarito(int[][] gabarito) {
		this.gabarito = gabarito;
	}

}