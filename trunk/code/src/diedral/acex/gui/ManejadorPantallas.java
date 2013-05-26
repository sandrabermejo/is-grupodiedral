/*
 * ManejadorPantallas.java - ACE Gestión Externa - Grupo Diedral 2013
 */
package diedral.acex.gui;

/**
 * Interfaz para manejador de pantallas.
 *
 */
public interface ManejadorPantallas {
	/**
	 * Solicita al manejador de pantallas que cambie la pantalla
	 * activa por la indicada.
	 *
	 * @param pt Pantalla a la que cambiar.
	 */
	void cambiaA(Pantalla pt);

	/**
	 * Solicita al manejador de pantallas que muestre pantalla
	 * indicada dejando la pantalla actual en segundo plano.
	 *
	 * @param pt Pantalla que mostrar.
	 */
	void muestra(Pantalla pt);

	/**
	 * Solicita al manejador el cierre de la pantalla actual.
	 */
	void cierraPantallaActual();
}
