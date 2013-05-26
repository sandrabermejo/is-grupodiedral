/*
 * FabricaPantallas.java - ACE Gestión Externa - Grupo Diedral 2013
 */
package diedral.acex.gui;

import diedral.acex.gui.pantallas.*;

/**
 * Fábrica de pantallas.
 *
 */
public class FabricaPantallas {
	/**
	 * Obtiene una pantalla de sugerencias.
	 */
	public Pantalla damePantallaSugerencias(){
		return new PantallaSugerencias();
	}
	
	/**
	 * Obtiene una pantalla de inicio.
	 */
	public Pantalla damePantallaInicio(){
		return new PantallaInicio();
	}
}
