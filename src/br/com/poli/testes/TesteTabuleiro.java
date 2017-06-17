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
		// Imprime o valor presente na posi��o passada
		System.out.println(tabuleiroTeste.search(1, 1));
		/*
		 * retorna false, pois analisa o grid e n�o, o gabarito. O grid est� com
		 * espa�os vazios, o gabarito, n�o
		 */
		System.out.println(tabuleiroTeste.isTabuleiroPreenchido());
		// imprime o grid
		tabuleiroTeste.imprimeTabuleiro();

		/*
		 * � necess�rio rodar algumas vezes o programa para que a chamda a
		 * seguir seja v�lida, pois isso depende do tabuleiro gerado. enquanto
		 * ela n�o for, podem ser lan�adas 2 excec�es, uma indicando que a casa
		 * que voc� tentou jogar est� ocupada e uma outra, quando a casa est�
		 * vazia, ou seja, com valor igual a 0, por�m, o valor jogado n�o
		 * corresponde ao presente no gabarito para aquela dada posi��o
		 */
		tabuleiroTeste.executaMovimento(1, 1, 3);
		/*
		 * caso o restante do codigo abaixo seja mostrado, � porque a linha
		 * acima foi v�lida e ent�o, imprime o grid atual juntamente com o valor
		 * passado na chamada de executaMovimento
		 */
		tabuleiroTeste.imprimeTabuleiro();

		//As 2 chamadas de executaMovimento a seguir ir�o testar o funcionamento das exceptions 
		// Sera lancada uma exce��o informando que o valor passado � invalido
		// tabuleiroTeste.executaMovimento(2, 3, 10);
		// Sera lancada um exce��o informando que a linha e/ou coluna invalida
		// tabuleiroTeste.executaMovimento(7, 10, 8);

	}

}
