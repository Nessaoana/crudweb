package crudweb.entidades;

import java.util.ArrayList;

public class ListaUser {
	private ArrayList<User> usuarios;

	public ArrayList<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(User usuario) {
		this.usuarios.add(usuario);
	}
	
}
