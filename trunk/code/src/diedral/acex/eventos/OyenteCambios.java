/*
 * OyenteCambios.java - ACE Gestión Externa - Grupo diedral 2013 
 */
package diedral.acex.eventos;

/**
 * Clase genérica para implementar un mecanismo sencillo de 
 * reporte de cambios de un determinado objeto con entidad
 * propia.
 *
 */
public interface OyenteCambios<T> {
	/**
	 * Informa de que el objeto ha cambiado.
	 * 
	 * @param arg Objeto que ha sufrido el cambio.
	 */
	public void haCambiado(T arg);
}
