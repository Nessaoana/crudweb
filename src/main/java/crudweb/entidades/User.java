package crudweb.entidades;

public class User {
	private String nome;
	private String email;
	private int idade;

	
	
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

	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public User(String nome, String email, int idade){
		this.nome = nome;
		this.email = email;
		this.idade = idade;

	}	
	
	public User () {}
	
}
