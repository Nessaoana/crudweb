package crudweb.entidades;

import java.util.ArrayList;

public class ListaUser {
	private static ArrayList<User> usuarios;
	
	public ListaUser() {
	}

	public ListaUser(ArrayList<User> usuarios) {
		super();
		this.usuarios = usuarios;
	}

	public ArrayList<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<User> usuarios) {
		this.usuarios = usuarios;
	}

	public void addUser(User usuario) {
		this.usuarios.add(usuario);
	}
	public static User getUsuario(String nome){
		User user = null;
		
		for(User u : usuarios) {
			if(u.getNome().equalsIgnoreCase(nome)) {
				user = u;
			} else {
				System.out.println("Usuário não encontrado");
			}
		}
		return user;
	}
	
}
