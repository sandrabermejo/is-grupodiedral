/*
 * GestorUsuarios.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex.scentral;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import diedral.acex.AyudantePersistencia;
import diedral.acex.Usuario;
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
		if (_instancia == null) {
			// Intenta cargarlo de los datos almacenados
			_instancia = (GestorUsuarios) AyudantePersistencia.dameInstancia().recuperayVigila(
					versionTID);
			
			if (_instancia == null) {
				_instancia = new GestorUsuarios();
				AyudantePersistencia.dameInstancia().vigila(_instancia, versionTID);
			}
		}
		
		return _instancia;
	}
	/**
	 * Mete un nuevo usuario en el sistema.
	 * Lanza una excepción si el nuevo usuario a meter tiene un correo asociado
	 * que ya existe en el sistema.
	 * @param usuario
	 * @throws UsuarioInvalidoException
	 */
	public void meteUsuario(Usuario usuario) throws UsuarioInvalidoException {
		if(usuario != null){
			if(validar(usuario.dameCorreo()))
				_usuarios.put(usuario.dameCorreo(), usuario);
			else
				throw new UsuarioInvalidoException("Un usuario existente ya tiene ese eMail asociado");
		} else 
			throw new UsuarioInvalidoException("El usuario recibido no tiene ningún dato.");
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
	 * Dado un usuario, lo borra del sistema. Devuelve un true si la operación ha terminado con éxito.
	 * @param usuario
	 * @return operación terminada con éxito.
	 */
	public boolean borrarUsuario(Usuario usuario){
		if(usuario != null){
			if(_usuarios.containsKey(usuario.dameCorreo())){
				_usuarios.remove(usuario.dameCorreo());
				return true;
			}
		}
	return false;
	}
	/**
	 * Dado un nuevo usuario y un mail de un usuario ya existente,
	 * mete un nuevo usuario en el sistema.
	 * 
	 * @param usuario
	 * @param mailAntiguo
	 */
	public void reemplazarUsuario(Usuario usuario, String mailAntiguo){
		/*
		 * El nombre no es muy afortunado.
		 */
		
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
	 * 
	 * @param correoModificado ...
	 * 
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
	private Map<String, Usuario> _usuarios = new TreeMap<String, Usuario>();
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -5908205608136658471L;
	
	/**
	 * Serial UID (modo texto)
	 */
	private static final String versionTID = AyudantePersistencia.generaTID(serialVersionUID);
}