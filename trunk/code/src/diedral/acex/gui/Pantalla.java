/**
 * Pantalla.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex.gui;

import diedral.acex.Sesion;

/**
 * Una pantalla o página representa un elemento de la interacción con el usuario
 * mediante la interfaz gráfica.
 * 
 * <p>Las pantallas son gestionadas por el manejador de ventanas que llamará a los
 * diferentes métodos declarados en esta clase abstracta.
 */
public abstract class Pantalla extends javax.swing.JPanel {
	/**
	 * Manejador del evento de puesta en funcionamiento.
	 * 
	 * <p>Este método es llamado cuando una pantalla se carga para ser
	 * mostrada en el marco.
	 */
	public void alCargar() {}
	
	/**
	 * Manejador del evento de muestra.
	 * 
	 * <p>Este método es llamado cuando una pantalla va a ser mostrada
	 * en el marco.
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
	 * Establece el contexto de la pantalla con la que comunicarse.
	 * 
	 * @param manejador Manejador de pantallas.
	 * @param fabrica Fábrica de pantallas.
	 * @param sesion Sesión activa.
	 */
	public void estableceContexto(ManejadorPantallas manejador, FabricaPantallas fabrica,
			Sesion sesion) {}
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 8976177894944040873L;
}