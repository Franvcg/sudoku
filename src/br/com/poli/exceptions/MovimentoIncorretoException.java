package br.com.poli.exceptions;

public class MovimentoIncorretoException extends Exception {
	//O construtor recebe uma string, de modo que a mensagem apresentada pelo m�todo que o chama pode ser 
	//personalizada, de forma a ter mais rela��o com a situa��o em que ela for chamada
	public MovimentoIncorretoException(String mensagem) {
		super(mensagem);
	}

}
