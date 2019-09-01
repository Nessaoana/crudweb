package crudweb.entidades;

public class User {
	private String nome;
	private int idade;
	private String sexo;
	
	
	public String getNome() {
		return this.nome;
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

	public String getSexo() {
		return this.sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	public User(String nome, int idade, String sexo){
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}	
}
