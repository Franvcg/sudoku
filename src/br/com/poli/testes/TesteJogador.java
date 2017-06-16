package br.com.poli.testes;

import br.com.poli.tipospessoas.Jogador;

public class TesteJogador {

	public static void main(String[] args) {
		Jogador fulano = new Jogador(17, "Fulano", 4202); //Atribui valores ao construtor
		System.out.println(fulano.getNome());		  //Printa os valores
		System.out.println(fulano.getIdade());
		System.out.println(fulano.getScoreRecorde());
	}

}
