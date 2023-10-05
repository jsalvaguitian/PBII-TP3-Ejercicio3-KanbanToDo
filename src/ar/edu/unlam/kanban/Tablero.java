package ar.edu.unlam.kanban;

import java.util.ArrayList;
import java.util.List;

public class Tablero implements Comparable<Tablero>{
	private String nombre;
	private List<Tarea>tareas;
	private List<Usuario>editores;
	
	public Tablero(String nombre) {
		this.nombre = nombre;
		this.tareas = new ArrayList<>();
		this.editores = new ArrayList<>();	
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	@Override
	public int compareTo(Tablero o) {
		
		return this.nombre.compareTo(o.getNombre());
	}

	public Boolean agregarTarea(Tarea tareaCreada) {
		return this.tareas.add(tareaCreada);
		
	}

	
	

}
