package br.com.poli.tipospessoas;

public abstract class Pessoa {
	private int idade;
	private String nome;
	
	public Pessoa(int idade, String nome){
		this.setIdade(idade);
		this.setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
