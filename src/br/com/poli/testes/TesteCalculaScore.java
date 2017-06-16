package br.com.poli.testes;

import br.com.poli.score.CalculaScoreSemIdade;
import br.com.poli.score.CalculaScoreComIdade;
import br.com.poli.variados.DificuldadePartida;
import br.com.poli.variados.Partida;
import br.com.poli.variados.Tabuleiro;
import br.com.poli.tipospessoas.Jogador;

public class TesteCalculaScore {

	public static void main(String[] args) {
		Partida partida = new Partida(new Jogador(18, "Fulano", 0), new Tabuleiro(), 2, false, null, DificuldadePartida.NORMAL);
		CalculaScoreSemIdade calc = new CalculaScoreSemIdade();
		CalculaScoreComIdade calcIdade = new CalculaScoreComIdade();

		partida.iniciaPartida(); //A partida é iniciada para que uma nova data seja armazenada
		
		partida.setQuantidadeErros(2); //O metodo iniciaPartida zera a quantidade de erros, logo é preciso redefini-la pois ela influencia no calculo do score
		
		calc.calcula(partida); //Outra data é armazenada, a qual a data anterior é subtraida para se ter o tempo decorrido
		System.out.println("Score sem idade: " + partida.getScore()); //O score é printado sem a idade
		
		calcIdade.calcula(partida);  //O score é calculado novamente, dessa vez usando a idade como modificador
		System.out.println("Score com idade: " + partida.getScore()); //O score é printado, dessa vez 18 vezes maior que o score anterior, pois a idade inserida no construtor é 18
	}

}
