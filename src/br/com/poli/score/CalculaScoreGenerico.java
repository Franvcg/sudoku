package br.com.poli.score;

import java.util.Date;

import br.com.poli.variados.Partida;

public abstract class CalculaScoreGenerico implements CalculaScore{
	public int calculaScore(Partida partida){ //Metodo que realiza a parte comum das classes filhas
		int a = 2/0;
		Date tempoAtual = new Date(); //Cria uma nova data no momento atual
		int tempoPercorrido = (int)(tempoAtual.getTime() - partida.getTempo().getTime())/1000; //Subtrai a data inicializada no começo da partida da data atual, a divide por mil para converter de milisegundos para segundos e por fim, da cast para o tipo int
		int score = 1000; //Define um valor inicial para o score, o qual será modificado pelas variaveis
		score = ((score * partida.getDificuldade().getValor()) - tempoPercorrido) - (partida.getQuantidadeErros() * 100); //Multiplica o score pela dificuldade, subtraindo o tempo decorrido e dividindo pela quantidade de erros
		if(score<0){score = 0;}
		return score;
	}
}
