package br.com.poli.score;
import br.com.poli.variados.Partida;
import br.com.poli.score.CalculaScore;

public class CalculaScoreComIdade extends CalculaScoreGenerico implements CalculaScore {

	public void calcula(Partida partida) {
		partida.setScore(calculaScore(partida) * partida.getJogador().getIdade());
	}	//Atribui o valor calculado ao atributo Score da classe Partida, multiplicando pela idade do jogador

}
