/*
 * GestorUsuarios.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import diedral.acex.excepciones.UsuarioInvalidoException;

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
	 * Mete un nuevo usuario en el sistema.
	 * Lanza una excepción si el nuevo usuario a meter tiene un correo asociado
	 * que ya existe en el sistema.
	 * @param usuario
	 * @throws UsuarioInvalidoException
	 */
	public void meteUsuario(Usuario usuario) throws UsuarioInvalidoException{
		if(usuario != null){
			if(validar(usuario.dameCorreo())){
				_usuarios.put(usuario.dameCorreo(), usuario);
			} else {
				throw new UsuarioInvalidoException("Un usuario existente ya tiene ese eMail asociado");
			}
		}
	}
	/**
	 * Busca un usuario con un correo asociado y lo devuelve.
	 * Devuelve null si no existe.
	 * @param correo
	 * @return Usuario con ese correo asociado.
	 */
	public Usuario buscaUsuario(String correo){
		if(_usuarios.containsKey(correo))
			return _usuarios.get(correo);
		else
			return null;
	}
	/**
	 * Dado un nuevo usuario y un mail de un usuario ya existente,
	 * mete un nuevo usuario en el sistema.
	 * @param usuario
	 * @param mailAntiguo
	 */
	public void reemplazarUsuario(Usuario usuario, String mailAntiguo){
		if(_usuarios.containsKey(mailAntiguo)){
			//borrar el usuario no modificado
			_usuarios.remove(mailAntiguo);
			//insertar el nuevo usuario modificado
			_usuarios.put(usuario.dameCorreo(), usuario);
		}
	}
	
	/**
	 * Dado un correo de un usuario, mira a ver si ese usuario está. Si ya existe una cuenta vinculada con ese 
	 * correo, no es válido modificar el correo actual a la dirección nueva dada por parámetro.
	 * @param correo
	 * @return true si no existe un usuario con ese correo, false si sí existe.
	 */
	public boolean validar(String correoModificado){
		return !_usuarios.containsKey(correoModificado);
	}

	/**
	 * Copia de la instancia
	 */
	private static GestorUsuarios _instancia;
	
	
	/**
	 * Almacén de usuario
	 */
	Map<String, Usuario> _usuarios = new TreeMap<String, Usuario>();
	
	 /**Serial UID
	 */
	private static final long serialVersionUID = -5908205608136658471L;
}
