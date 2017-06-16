package br.com.poli.variados;

public enum DificuldadePartida {
	
	/*
	 * We define difficulty as follows: Easy: 32+ clues (49 or fewer holes)
	 * Medium: 27-31 clues (50-54 holes) Hard: 26 or fewer clues (54+ holes)
	 * This is human difficulty, not algorighmically (though there is some
	 * correlation)
	 */
	
	
	FACIL(1,10,24), NORMAL(2,5,28), DIFICIL(3,3,32);


	private int valor;
	private int quantidadeMaximaErros;
	private int quantidadeEspacosVazios;
	
	private DificuldadePartida(int valor, int quantidadeMaximaErros,int quantidadeEspacosVazios) {
		this.valor=valor;
		this.quantidadeMaximaErros = quantidadeMaximaErros;
		this.quantidadeEspacosVazios = quantidadeEspacosVazios;
	}
	
	public int getValor(){
		return this.valor;
	}
	
	public int getQuantidadeMaximaErros(){
		return this.quantidadeMaximaErros;
	}

	public int getQuantidadeEspacosVazios() {
		return quantidadeEspacosVazios;
	}

	
	
}
