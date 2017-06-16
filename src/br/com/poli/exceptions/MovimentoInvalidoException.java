package br.com.poli.exceptions;

public class MovimentoInvalidoException extends Exception {
	//O construtor recebe uma string, de modo que a mensagem apresentada pelo método que o chama pode ser 
	//personalizada, de forma a ter mais relação com a situação em que ela for chamada
	public MovimentoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
