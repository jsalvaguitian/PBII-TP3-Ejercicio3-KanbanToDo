package ar.edu.unlam.kanban;

import java.util.HashSet;

public class KanbanSystem {
	private String name;
	private HashSet<Usuario> usuariosRegistrados;

	public KanbanSystem(String kanbanName) {
		this.name = kanbanName;
		this.usuariosRegistrados = new HashSet<>();	
	}

	public void agregarUsuario(Usuario usuario) {
		this.usuariosRegistrados.add(usuario);
	}
	
	public Integer getUsuariosRegistrados() {
		return this.usuariosRegistrados.size();
	}

	public Boolean loguearUsuario(String mailUser1, String password1) {
		for(Usuario user: this.usuariosRegistrados) {
			if(user.getMail().equals(mailUser1) && user.getPassword().equals(password1))
				user.setLogIn(true);
				return user.getLogIn();
		}
		return false;
	}

}
