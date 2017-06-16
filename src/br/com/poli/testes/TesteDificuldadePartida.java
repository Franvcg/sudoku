package br.com.poli.testes;

import br.com.poli.variados.DificuldadePartida;

public class TesteDificuldadePartida {

	public static void main(String[] args) {
		System.out.println("Facil: "+DificuldadePartida.FACIL.getQuantidadeMaximaErros()+"/"+DificuldadePartida.FACIL.getValor());
		System.out.println("Normal: "+DificuldadePartida.NORMAL.getQuantidadeMaximaErros()+"/"+DificuldadePartida.NORMAL.getValor());
		System.out.println("Dificil: "+DificuldadePartida.DIFICIL.getQuantidadeMaximaErros()+"/"+DificuldadePartida.DIFICIL.getValor());
		//Print dos valores de DificuldadePartida nas 3 dificuldades para teste
	}

}
