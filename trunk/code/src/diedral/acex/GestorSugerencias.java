/**
 * GestorSugerencias.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex;

import java.util.Date;

/**
 * Gestor de sugerencias.
 */
public class GestorSugerencias {
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
}
