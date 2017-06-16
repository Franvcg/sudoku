package br.com.poli.tipospessoas;

public class Jogador extends Pessoa {
	
	private int scoreRecorde;
	
	public Jogador(int idade, String nome, int scoreRecorde){
		super(idade, nome);
		this.scoreRecorde = scoreRecorde;
	}
	
	public int getScoreRecorde() {
		return scoreRecorde;
	}
	public void setScoreRecorde(int scoreRecorde) {
		this.scoreRecorde = scoreRecorde;
	}
		
}

