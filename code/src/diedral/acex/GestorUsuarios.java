/*
 * GestorUsuarios.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex;

/**
 * Gestor de usuarios.
 */
public class GestorUsuarios {
	/**
	 * Obtiene la instancia del gestor de usuarios.
	 * 
	 * @return Un {@code GestorVuelos} válido.
	 */
	public static GestorUsuarios dameInstancia(){
		if (_instancia == null)
			_instancia = new GestorUsuarios();
		
		return _instancia;
	}

	/**
	 * Copia de la instancia
	 */
	private static GestorUsuarios _instancia;
}
