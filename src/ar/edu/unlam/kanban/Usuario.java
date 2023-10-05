package ar.edu.unlam.kanban;

import java.util.TreeSet;

public class Usuario {
	
	private String mail;
	private String password;
	private Boolean login;
	
	private TreeSet<Tablero>ListaDeTableros;
	

	public Usuario(String mail, String password) {
		this.mail = mail;
		this.password = password;
		this.login = false;
		this.ListaDeTableros = new TreeSet<>();
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public String getPassword() {
		return this.password;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		return true;
	}

	public Boolean getLogIn() {
		return this.login;
	}

	public void setLogIn(boolean status) {
		this.login = status;	
	}

	public boolean crearTablero(String nombreTablero) {
		if(this.getLogIn()) {
			Tablero unTablero = new Tablero(nombreTablero);
			return this.ListaDeTableros.add(unTablero);
		}
		
		return false;
	}

	public boolean crearTarea(String nombreTableroBuscado, String nombreTareaNueva, Estado estadoTarea) {
		Tablero tablero = this.buscarTablero(nombreTableroBuscado);
		
		if(tablero!=null) {
			//creo la tarea
			Tarea tareaCreada = new Tarea(nombreTareaNueva, estadoTarea);
			
			//guardo la tarea en el tablero
			return tablero.agregarTarea(tareaCreada);
			
		}
		
		return false;
		
	}

	public Tablero buscarTablero(String nombreTableroBuscado) {
		for(Tablero buscado : this.ListaDeTableros) {
			if(buscado.getNombre().equals(nombreTableroBuscado)){
				return buscado;
			}
		}
		return null;
	}
	
	

}
