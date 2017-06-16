package br.com.poli.score;
import br.com.poli.variados.Partida;
import br.com.poli.score.CalculaScore;

public class CalculaScoreSemIdade extends CalculaScoreGenerico implements CalculaScore {

	public void calcula(Partida partida) {
		partida.setScore(calculaScore(partida)); //Atribui o valor calculado ao atributo Score da classe Partida
	}

}
