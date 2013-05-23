package diedral.acex.gui;

/**
 * Una pantalla o página representa un elemento de la interacción con el usuario
 * mediante la interfaz gráfica.
 */
public interface Pantalla {
	/**
	 * Manejador del evento de puesta en funcionamiento.
	 */
	public void alMostrar();

	/**
	 * Manejador del evento de ocultación.
	 *
	 * @return {@code true} si se acepta la petición, {@code false} si se
	 * rechaza.
	 */
	public boolean alOcultar();

	/**
	 * Manejador del evento de cierre.
	 *
	 * @return {@code true} si se acepta la petición, {@code false} si se
	 * rechaza.
	 */
	public boolean alCerrar();
}
