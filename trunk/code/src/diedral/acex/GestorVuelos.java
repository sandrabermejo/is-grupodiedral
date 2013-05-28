/*
 * GestorVuelos.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * Gestor de vuelos.
 */
public class GestorVuelos implements Serializable {
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

	/**
	 * Almacén del vuelos
	 */
	Set<Vuelo> _vuelos = new TreeSet<Vuelo>();
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -6922329606269600313L;
}
