/**
 * GestorSugerencias.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex.scentral;

import java.io.Serializable;
import java.util.Date;

import diedral.acex.Sugerencia;

/**
 * Gestor de sugerencias.
 * 
 * En él se aplica el patrón solitario.
 */
public class GestorSugerencias implements Serializable {
	/**
	 * Gestiona las sugerencias. Es decir las ignora.
	 * 
	 * @param sug Sugerencia.
	 * 
	 * @return Código de referencia de la sugerencia o {@code 0}
	 * si no se ha podido registrar.
	 */
	public long enviarSugerencia(Sugerencia sug){
		return new Date().getTime();
	}
	
	
	/**
	 * Obtiene la instancia del gestor de sugerencias.
	 * 
	 * @return Un {@code GestorSugerencias} válido.
	 */
	public static GestorSugerencias dameInstancia(){
		if (_instancia == null)
			_instancia = new GestorSugerencias();
		
		return _instancia;
	}
	
	
	// MIEMBROS PRIVADOS
	
	/**
	 * Almacena la instancia única del gestor
	 */
	private static GestorSugerencias _instancia;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -8705693435085327942L;
}
