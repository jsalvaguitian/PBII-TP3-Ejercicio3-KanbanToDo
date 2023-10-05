package ar.edu.unlam.kanban;

public class Tarea {
	private String nombreTarea;
	private Estado estado;
	private Usuario encargado;
	

	public Tarea(String nombreTarea, Estado estadoTarea) {
		this.nombreTarea = nombreTarea;
		this.estado = estadoTarea;
		this.encargado = null;
	}

}
