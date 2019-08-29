package crudweb.entidades;

import java.util.ArrayList;

public class ListaUser {
	private ArrayList usuarios;

	public ArrayList getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(User usuario) {
		this.usuarios.add(usuario);
	}
	
}
