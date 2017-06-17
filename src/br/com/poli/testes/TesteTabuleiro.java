package br.com.poli.testes;

import br.com.poli.exceptions.MovimentoIncorretoException;
import br.com.poli.exceptions.MovimentoInvalidoException;
import br.com.poli.exceptions.TabuleiroInvalidoException;
import br.com.poli.variados.DificuldadePartida;
import br.com.poli.variados.Tabuleiro;

public class TesteTabuleiro {

	public static void main(String[] args) throws MovimentoIncorretoException, MovimentoInvalidoException, TabuleiroInvalidoException {

		Tabuleiro tabuleiroTeste = new Tabuleiro();
		
		/*
		 * gera o tabuleiro completo, apaga uma quantidade de casas(de acordo
		 * com a dificuldae) e printa o gabarito
		 */
		tabuleiroTeste.geraTabuleiro(DificuldadePartida.DIFICIL);
		// Imprime o valor presente na posição passada
		System.out.println(tabuleiroTeste.search(1, 1));
		/*
		 * retorna false, pois analisa o grid e não, o gabarito. O grid está com
		 * espaços vazios, o gabarito, não
		 */
		System.out.println(tabuleiroTeste.isTabuleiroPreenchido());
		// imprime o grid
		tabuleiroTeste.imprimeTabuleiro();

		/*
		 * é necessário rodar algumas vezes o programa para que a chamda a
		 * seguir seja válida, pois isso depende do tabuleiro gerado. enquanto
		 * ela não for, podem ser lançadas 2 excecões, uma indicando que a casa
		 * que você tentou jogar está ocupada e uma outra, quando a casa está
		 * vazia, ou seja, com valor igual a 0, porém, o valor jogado não
		 * corresponde ao presente no gabarito para aquela dada posição
		 */
		tabuleiroTeste.executaMovimento(1, 1, 3);
		/*
		 * caso o restante do codigo abaixo seja mostrado, é porque a linha
		 * acima foi válida e então, imprime o grid atual juntamente com o valor
		 * passado na chamada de executaMovimento
		 */
		tabuleiroTeste.imprimeTabuleiro();

		//As 2 chamadas de executaMovimento a seguir irão testar o funcionamento das exceptions 
		// Sera lancada uma exceção informando que o valor passado é invalido
		// tabuleiroTeste.executaMovimento(2, 3, 10);
		// Sera lancada um exceção informando que a linha e/ou coluna invalida
		// tabuleiroTeste.executaMovimento(7, 10, 8);

	}

}
