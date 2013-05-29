/*
 * Avion.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex;

import java.io.Serializable;

/**
 * Representa una avión.
 */
public class Avion implements Serializable {
	
	/**
	 * Crea un avión con su nombre y número de pasajeros.
	 * 
	 * @param nombre Nombre de la aeronave.
	 * @param numPasajeros Número de pasajeros (capacidad).
	 */
	public Avion(String nombre, int numPasajeros){
		_nombre = nombre;
		_numPasajeros = numPasajeros;
	}
	
	/**
	 * Obtiene el nombre del avión.
	 * 
	 * @return El nombre.
	 */
	public String dameNombre(){
		return _nombre;
	}
	
	/**
	 * Obitiene la capacidad del avión en número de pasajeros.
	 * 
	 * @return Dicho número.
	 */
	public int dameNumeroPasajeros(){
		return _numPasajeros;
	}
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Nombre de la aeronave
	 */
	private String _nombre;
	
	/**
	 * Número de pasajeros
	 */
	private int _numPasajeros;

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 2714178085879107729L;	
}