package ar.edu.unlam.kanban;

/* Que un usuario pueda iniciar sesion
 * Que un usuario pueda crear un tablero
 * Que un usuario pueda compartir ese tablero con otros usuarios
 * Que un usuario pueda crear una tarea
 * 
 * un tablero Kanban en donde se pueda agregar tareas
 * Cada tarea puede tener distintos estados (PENDIENTE, EN CURSO y FINALIZADA)
 * Una tarea es creada por un usuario determinado
 * Si una tarea se encuentra PENDIENTE, cualquier usuario puede tomarla y pasarla a otro estado
 * Una tarea EN CURSO, no puede ser tomada por un usuario diferente al que la está realizando
 * 
 * */
import static org.junit.Assert.*;

import org.junit.Test;

public class KanbanTest {

	@Test
	public void queSePuedaCrearTresUsuariosEnElSistemaKanban() {
		String kanbanName = "Kanban-Unlam";

		String mailUser1 = "pablo@gmail.com";
		String password1 = "hol@";

		String mailUser2 = "jesi@gmail.com";
		String password2 = "qwerty";

		String mailUser3 = "matias@gmail.com";
		String password3 = "asdf";

		KanbanSystem kanban = new KanbanSystem(kanbanName);

		Usuario user1 = new Usuario(mailUser1, password1);
		Usuario user2 = new Usuario(mailUser2, password2);
		Usuario user3 = new Usuario(mailUser3, password3);

		kanban.agregarUsuario(user1);
		kanban.agregarUsuario(user2);
		kanban.agregarUsuario(user3);

		assertEquals((Integer) 3, kanban.getUsuariosRegistrados());
	}

	@Test
	public void queUnUsuarioPuedaCrearUnTablero() {
		String kanbanName = "Kanban-Unlam";

		String mailUser1 = "pablo@gmail.com";
		String password1 = "hol@";
		
		String nombreTablero = "Workspace UnLaM";
		
		KanbanSystem kanban = new KanbanSystem(kanbanName);

		Usuario user1 = new Usuario(mailUser1, password1);

		kanban.agregarUsuario(user1);
		
		//se loguea el usuario 1
		assertTrue(kanban.loguearUsuario(mailUser1,password1));
		
		//el usuario 1 crea un tablero
		assertTrue(user1.crearTablero(nombreTablero));
	}

	@Test
	public void queSePuedaCrearUnaTarea() {
		// Preparacion
		String nombreTarea = "Estudiar Java";
		Estado estadoTarea = Estado.PENDIENTE;
		
		String kanbanName = "Kanban-Unlam";

		String mailUser1 = "pablo@gmail.com";
		String password1 = "hol@";
		
		String nombreTablero = "Workspace UnLaM";
		
		KanbanSystem kanban = new KanbanSystem(kanbanName);

		Usuario user1 = new Usuario(mailUser1, password1);

		kanban.agregarUsuario(user1);
		
		// Validación

		//se loguea el usuario 1
		assertTrue(kanban.loguearUsuario(mailUser1,password1));
		
		//el usuario 1 crea un tablero
		assertTrue(user1.crearTablero(nombreTablero));
		
		//crear tarea siempre y cuando exista un tablero y este logueado el usuario
		assertTrue(user1.crearTarea(nombreTablero,nombreTarea,estadoTarea));	
	}

	@Test
	public void queSePuedaInvitarAOtrosUsuariosParaEditarElTablero() {

	}

	@Test
	public void queUnaTareaSePuedaEditarPorOtroUsuario() {

	}

	@Test
	public void queNoSePuedaTomarUnaTareaEnCursoPorOtroUsuario() {

	}

}
