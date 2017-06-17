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
	 * 1 � if-> verifica se o valor passado esta entre 1 e 9 2 � if-> verifica
	 * se o valor da linha e da coluna � maior que 0 e menor ou igual a 9 3 �
	 * if-> Utilizando o m�todo auxiliar, casaVazia, verifica se uma dada
	 * posicao j� est� ocupada com algum valor diferente de 0 4 � if->
	 * Utilizando o m�todo auxiliar, comparaJogada. O funcionamento do m�todo �
	 * explicado mais abaixo
	 * 
	 */
	public boolean executaMovimento(int linha, int coluna, int valor)
			throws MovimentoIncorretoException, MovimentoInvalidoException {
		if (valor > 0 && valor < 10) {
			if (linha > 0 && linha <= 9 && coluna > 0 && coluna <= 9) {
				if (casaVazia(linha, coluna) == false) {
					throw new MovimentoInvalidoException("A posi��o acessada encontra-se ocupada");
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
						"A posi��o da linha e/ou coluna � inv�lida. Insira um valor entre 1 e 9");
			}
		} else {
			throw new MovimentoInvalidoException(
					"O valor que voc� tentou inserir � inv�lido. Favor inserir um outro valor, entre 1 e 9");
		}
	}

	/*
	 * Passa-se uma posic�o(x,y) e um valor para a mesma. Faz-se verifica��es
	 * para ver se o valor passado pode ser inserido naquela casa. Tudo isso com
	 * verifica��es para linha, coluna e quadrado 3x3. Retorna false se o valor
	 * j� estiver presente e true, caso contr�rio. O primeiro for retorna false
	 * caso o valor passado j� esteja presente em alguma coluna da linha
	 * passada. O segundo for retorna false se o valor passado j� estiver
	 * presente em alguma linha da coluna passada. O terceiro for retorna false
	 * se o valor passado j� estive contido em um quadrado 3x3.
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

	// m�todo auxiliar, respons�vel por comparar o tabuleiro atual, ou seja,
	// aquele que o jogador est� manipulando,preenchendo,
	// com o gabarito. Dada uma linha e uma coluna passada por par�metro, o
	// m�todo avalia se o valor correspondente aquela posi��o
	// � igual tanto para o grid como para o gabarito.Retorna um boolean
	// � utilizado em executaMovimento

	public boolean comparaJogada(int linha, int coluna, int valor) {
		if (gabarito[linha - 1][coluna - 1] == valor) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Respons�vel por tentar gerar um tabuleiro v�lido. Para isso, atrav�s do
	 * m�todo verificaMovimento, tenta preencher todas as casas com valores de 1
	 * a 9, respeitando o crit�rio das linhas, colunas e quadrados 3x3. Os
	 * par�metros correspondem a um valor para a linha e coluna. Quando chamamos
	 * resolveTabuleiro dentro de geraTabuleiro, passamos (0,0), referente a
	 * posi��o inicial, de forma que seja poss�vel percorrer todas as 81 casas
	 * do tabuleiro. Retorna true se um tabuleiro v�lido for gerado e false,
	 * caso n�o seja possivel. Os valores passados no m�todo s�o armazenados em
	 * valorX e ValorY. O objeto do tipo Random ser� usado para gerar n�meros de
	 * forma aleat�ria dentro de um intervalo. Esse intervalo corresponde a
	 * vari�vel "valoresValidos", de tamanho 9, que corresponde a um vetor que
	 * cont�m todos os nove valores poss�veis e v�lidos para serem inseridos em
	 * um sudoku, os num�ros de 1 a 9. valorAuxMutavel1 e valorAuxMutavel2
	 * correspondem a vari�veis auxiliares, que tem o seu alterado a cada
	 * itera��o do for. No segundo for, temos que se o valor de
	 * "valoresValidos[i]", com i sendo uma dada itera��o, for v�lido para
	 * aquela casa, o valor ser� armazenado no grid naquela casa. Os dois if's
	 * que seguem verificam se o valor da linha e coluna correspondem a 8, o que
	 * significa a ultima casa do tabuleiro, ou seja, todas as casas anteriores
	 * a esta j� encontram-se preenchidas e como j� est�o preenchidas, significa
	 * que o valor que elas possuem � v�lido e segue as regras do jogo. Com
	 * isso, � chamado o m�todo resolveTabuleiro, de forma recursiva, para
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
	 * Retorna um boolean, indicando se o grid(tabuleiro) est� totalmente
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

	// Fun��o criada apenas para testar a isTabuleiroPreenchido
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
	 * M�todo respons�vel por esvaziar(tornar zero) uma dada quantidade de
	 * casas. A quantidade ser� definida de acordo com a dificuldade da partida.
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
	 * m�todo auxiliar, respons�vel por retornar o valor correspondente a
	 * posi��o passada(linha e coluna)
	 */
	public int search(int linha, int coluna) {
		return grid[--linha][--coluna];
	}

	/*
	 * m�todo auxiliar, utilizado em executaMovimento. Retorna um boolean Se o
	 * valor em uma dada posi��o for igual a zero, aquela posi��o � considerada
	 * vazia, j� que o sudoku n�o admite valor zero
	 */
	public boolean casaVazia(int linha, int coluna) {
		if (grid[linha - 1][coluna - 1] == 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * M�todo respons�vel por gerar um tabuleiro Recebe como param�tro um enum
	 * referente a dificuldade da partida, nele haver� infos relacionadas as
	 * caracter�sticas que o tabuleiro dever� possuir de acordo com a
	 * dificuldade passada. O for de dentro do m�todo imprime o sudoku gerado
	 * completo, sem espa�os vazios, ou seja, zeros. � necess�ria a sua presen�a
	 * afim de mostrar ao usu�rio durante o teste, uma compara��o entre os
	 * valores presentes no gabarito e o grid do sudoku com espa�os vazios. Essa
	 * compara��o pode ser feita a partir do momento em que chamamos o
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