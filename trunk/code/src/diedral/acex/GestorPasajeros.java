/*
 * GestorPasajeros.java - ACE Gestion Externa - Grupo diedral 2013
 */
package diedral.acex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestor de pasajeros.
 */
public class GestorPasajeros implements Serializable {
	/**
	 * Crea un nuevo gestor de pasajeros.
	 */
	public GestorPasajeros() {
		_pasajeros = new ArrayList<Pasajero>();
	}
	

	/**
	 * Obtiene la instancia del gestor de pasajeros.
	 * 
	 * @return Un {@code GestorVuelos} valido.
	 */
	public static GestorPasajeros dameInstancia(){
		if (_instancia == null){
			// Intenta cargarlo de los datos almacenados
			_instancia = (GestorPasajeros) AyudantePersistencia.dameInstancia().recuperayVigila(
					versionTID);
			
			// Si no ha funcionado
			if (_instancia == null)
				_instancia = new GestorPasajeros();
		}
		
		return _instancia;
	}

	/**
	 * Almacena la instancia tecnica del gestor
	 */
	private static GestorPasajeros _instancia;
	
	/**
	 * Lista de compras de la compania
	 */
	private List<Pasajero> _pasajeros;
 
	/**
	 * Serial UID 
	 */
	private static final long serialVersionUID = -4584109842989367604L;
	
	/**
	 * Serial TID
	 */
	private static final String versionTID = AyudantePersistencia.generaTID(serialVersionUID);
}
