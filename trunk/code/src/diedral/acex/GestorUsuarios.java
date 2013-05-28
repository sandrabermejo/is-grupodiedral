/*
 * GestorUsuarios.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * Gestor de usuarios.
 */
public class GestorUsuarios implements Serializable {
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
	
	
	/**
	 * Almacén de usuario
	 */
	Set<Usuario> _oferta = new TreeSet<Usuario>();
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -5908205608136658471L;
}
