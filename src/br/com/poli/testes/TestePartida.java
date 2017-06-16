package br.com.poli.testes;

import br.com.poli.exceptions.MovimentoIncorretoException;
import br.com.poli.exceptions.MovimentoInvalidoException;
import br.com.poli.tipospessoas.Jogador;
import br.com.poli.variados.DificuldadePartida;
import br.com.poli.variados.Partida;
import br.com.poli.variados.Tabuleiro;

public class TestePartida {

	public static void main(String[] args) throws MovimentoIncorretoException, MovimentoInvalidoException {
		Tabuleiro tabuleiroTeste = new Tabuleiro();
		Partida nova = new Partida(new Jogador(17, "Fulano", 4202), tabuleiroTeste, 0, false, null, DificuldadePartida.DIFICIL);
		
		//Inicia uma nova partida
		nova.iniciaPartida();	
		// imprime o grid
		tabuleiroTeste.imprimeTabuleiro();

		/*
		 * � necess�rio rodar algumas vezes o programa para que a chamada a
		 * seguir seja v�lida, pois isso depende do tabuleiro gerado. Enquanto
		 * o valor para a dada posi��o n�o for v�lido, podem ser lan�adas 2 excec�es, uma indicando que a casa
		 * que voc� tentou jogar est� ocupada e uma outra (quando a casa est�
		 * vazia, ou seja, com valor igual a 0) informando que o valor jogado n�o
		 * corresponde ao presente no gabarito para aquela dada posi��o. Se o valor corresponder o programa segue,
		 * caso contr�rio, ele � interrompido e a quantidade de erros ser� incrementada e mostrada na tela.
		 */
		nova.executaMovimento(1, 1, 3);
		
		/*
		 * caso o restante do codigo abaixo seja mostrado, � porque a chamada
		 * acima foi v�lida e ent�o, ser� impresso o grid atual juntamente com o valor
		 * passado na chamada de executaMovimento
		 */
		tabuleiroTeste.imprimeTabuleiro();
		
		//As 2 chamadas de executaMovimento a seguir ir�o testar o funcionamento das exceptions
		//Sera lancada uma exce��o informando que o valor passado � invalido
		//tabuleiroTeste.executaMovimento(2, 3, 10);	
		//Sera lancada um exce��o informando que a linha e/ou coluna � invalida
		//tabuleiroTeste.executaMovimento(7, 10, 8);					
		
		System.out.println("Quantidade de erros: " + nova.getQuantidadeErros()); //Testa se os valores foram resetados
		System.out.println("O jogo terminou? "+nova.isFimDeJogo());//
	}

}
