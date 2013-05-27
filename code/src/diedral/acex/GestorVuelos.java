/*
 * GestorVuelos.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex;

/**
 * Gestor de vuelos.
 */
public class GestorVuelos {
	
	/**
	 * Obtiene la instancia del gestor de vuelos.
	 * 
	 * @return Un {@code GestorVuelos} válido.
	 */
	public static GestorVuelos dameInstancia(){
		if (_instancia == null)
			_instancia = new GestorVuelos();
		
		return _instancia;
	}

	/**
	 * Copia de la instancia
	 */
	private static GestorVuelos _instancia;
}
