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
		 * é necessário rodar algumas vezes o programa para que a chamada a
		 * seguir seja válida, pois isso depende do tabuleiro gerado. Enquanto
		 * o valor para a dada posição não for válido, podem ser lançadas 2 excecões, uma indicando que a casa
		 * que você tentou jogar está ocupada e uma outra (quando a casa está
		 * vazia, ou seja, com valor igual a 0) informando que o valor jogado não
		 * corresponde ao presente no gabarito para aquela dada posição. Se o valor corresponder o programa segue,
		 * caso contrário, ele é interrompido e a quantidade de erros será incrementada e mostrada na tela.
		 */
		nova.executaMovimento(1, 1, 3);
		
		/*
		 * caso o restante do codigo abaixo seja mostrado, é porque a chamada
		 * acima foi válida e então, será impresso o grid atual juntamente com o valor
		 * passado na chamada de executaMovimento
		 */
		tabuleiroTeste.imprimeTabuleiro();
		
		//As 2 chamadas de executaMovimento a seguir irão testar o funcionamento das exceptions
		//Sera lancada uma exceção informando que o valor passado é invalido
		//tabuleiroTeste.executaMovimento(2, 3, 10);	
		//Sera lancada um exceção informando que a linha e/ou coluna é invalida
		//tabuleiroTeste.executaMovimento(7, 10, 8);					
		
		System.out.println("Quantidade de erros: " + nova.getQuantidadeErros()); //Testa se os valores foram resetados
		System.out.println("O jogo terminou? "+nova.isFimDeJogo());//
	}

}
