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
	 * Dado un correo de un usuario, mira a ver si ese usuario está. Si ya existe una cuenta vinculada con ese 
	 * correo, no es válido modificar el correo actual a la dirección nueva dada por parámetro.
	 * @param correo
	 * @return true si no existe un usuario con ese correo, false si sí existe.
	 */
	public boolean validar(String correoModificado){
		for(Usuario usuario: _usuarios){
			if(usuario.dameContrasena().equals(correoModificado))
				return false;
		}
		return true;
	}

	/**
	 * Copia de la instancia
	 */
	private static GestorUsuarios _instancia;
	
	
	/**
	 * Almacén de usuario
	 */
	Set<Usuario> _usuarios = new TreeSet<Usuario>();
	
	 /**Serial UID
	 */
	private static final long serialVersionUID = -5908205608136658471L;
}
