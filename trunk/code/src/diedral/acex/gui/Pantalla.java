/**
 * Pantalla.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex.gui;

/**
 * Una pantalla o página representa un elemento de la interacción con el usuario
 * mediante la interfaz gráfica.
 */
public abstract class Pantalla extends javax.swing.JPanel {
	/**
	 * Manejador del evento de puesta en funcionamiento.
	 */
	public void alMostrar() {}

	/**
	 * Manejador del evento de ocultación.
	 *
	 * @return {@code true} si se acepta la petición, {@code false} si se
	 * rechaza.
	 */
	public boolean alOcultar() { return true; }

	/**
	 * Manejador del evento de cierre.
	 *
	 * @return {@code true} si se acepta la petición, {@code false} si se
	 * rechaza.
	 */
	public boolean alCerrar() { return true; }

	/**
	 * Obtiene el nombre de la pantalla.
	 */
	public abstract String dameNombre();

	/**
	 * Establece un manejador de pantallas con el que comunicarse.
	 * 
	 * @param manejador Manejador de pantallas.
	 * @param fabrica Fábrica de pantallas. 
	 */
	public void estableceContexto(ManejadorPantallas manejador, FabricaPantallas fabrica) {}
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 8976177894944040873L;
}