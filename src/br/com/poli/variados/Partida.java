package br.com.poli.variados;

import java.util.*;

import br.com.poli.exceptions.MovimentoIncorretoException;
import br.com.poli.exceptions.MovimentoInvalidoException;
import br.com.poli.tipospessoas.Jogador;
import br.com.poli.variados.Tabuleiro;

public class Partida {

	private Jogador jogador;
	private Tabuleiro tabuleiro;
	private int quantidadeErros;
	private boolean venceu;
	private Date tempo;
	private int score;
	private DificuldadePartida dificuldade;

	public Partida(Jogador jogador, Tabuleiro tabuleiro, int quantidadeErros, boolean venceu, Date tempo,DificuldadePartida dificuldade) {
		this.jogador = jogador;
		this.tabuleiro = tabuleiro;
		this.quantidadeErros = quantidadeErros;
		this.venceu = venceu;
		this.tempo = tempo;
		this.dificuldade = dificuldade;
	}

	public void executaMovimento(int linha, int coluna, int valor)
			throws MovimentoIncorretoException, MovimentoInvalidoException {
		try {
			if (tabuleiro.executaMovimento(linha, coluna, valor) == true) {
				venceu = tabuleiro.isTabuleiroPreenchido();
			}
		} catch (MovimentoIncorretoException e) {
			this.quantidadeErros+=1;
			System.out.println("Quantidade de erros = " +this.quantidadeErros);
			throw e;}
	}

	public boolean isFimDeJogo() {
		if (this.quantidadeErros == dificuldade.getQuantidadeMaximaErros()) {
			return true;
		} else {
			return false;
		}
	}

	public void iniciaPartida() {
		this.quantidadeErros = 0;
		this.tempo = new Date();
		this.venceu = false;
		this.tabuleiro.geraTabuleiro(dificuldade);
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int getQuantidadeErros() {
		return quantidadeErros;
	}

	public void setQuantidadeErros(int quantidadeErros) {
		this.quantidadeErros = quantidadeErros;
	}

	public boolean isVenceu() {
		return venceu;
	}

	public void setVenceu(boolean venceu) {
		this.venceu = venceu;
	}

	public Date getTempo() {
		return tempo;
	}

	public void setTempo(Date tempo) {
		this.tempo = tempo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public DificuldadePartida getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(DificuldadePartida dificuldade) {
		this.dificuldade = dificuldade;
	}

}