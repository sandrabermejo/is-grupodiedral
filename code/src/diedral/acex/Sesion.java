/*
 * Sesion.java - ACE Gestión Externa - Grupo diedral 2013 
 */
package diedral.acex;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import diedral.acex.eventos.OyenteCambios;

/**
 * Clase que representa una sesión de uso de la aplicación.
 *
 */
public class Sesion implements Serializable {
	/**
	 * Crea una sesión vacía.
	 */
	public Sesion(){
		_usuario = null;
	}
	
	/**
	 * Contruye una sesión para un usuario.
	 * 
	 * @param usuario Un usuario.
	 */
	public Sesion(Usuario usuario) {
		_usuario = usuario;
	}
	
	/**
	 * Carga el usuario en la sesión activa.
	 * 
	 * @param usuario Usuario válido.
	 */
	public void cargaUsuario(Usuario usuario){
		_usuario = usuario;
		
		emitirEventoCambio();
	}
	
	/**
	 * Obtiene el usuario vinculado a la presente sesión.
	 * 
	 * @return Dicho usuario
	 */
	public Usuario dameUsuario(){
		return _usuario;
	}
	
	/**
	 * Desvincula al usuario de la sesión actual.
	 */
	public void expropiarUsuario(){
		_usuario = null;
		
		emitirEventoCambio();
	}
	
	/**
	 * ¿Está la sesión activa?
	 * 
	 * @return {@code true} en caso afirmativo.
	 */
	public boolean esActiva(){
		return _usuario != null;
	}
	
	/**
	 * Registra un oyente de cambios de sesión.
	 * 
	 * @param oyente El oyente.
	 */
	public void registraOyenteCambio(OyenteCambios<Sesion> oyente){
		_oyentes.add(oyente);
	}
	
	
	// MÉTODOS PRIVADOS
	
	/**
	 * Emite un evento de cambio.
	 */
	private void emitirEventoCambio(){
		for (OyenteCambios<Sesion> oyente : _oyentes)
			oyente.haCambiado(this);
	}
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Usuario
	 */
	private Usuario _usuario;
	
	/**
	 * Oyentes de cambios
	 */
	private Set<OyenteCambios<Sesion>> _oyentes = new HashSet<>();

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -916714074651113105L;
}
