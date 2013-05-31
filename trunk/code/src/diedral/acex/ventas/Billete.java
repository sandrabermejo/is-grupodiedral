/*
 * Billete.java - ACE Gesti�n Externa - Grupo diedral 2013
 */

package diedral.acex.ventas;

import diedral.acex.Pasajero;
import diedral.acex.Vuelo;


/**
 * Esta clase representa un billete.
 *
 * <p>Contiene el vuelo, su pasajero y la clase.
 */
public class Billete implements java.io.Serializable {	
	
	// CONSTRUCTOR
	
	/**
	 * Crea un billete con los datos aportados.
	 * 
	 * @param vuelo El vuelo asociado al billete.
	 * @param pasajero El pasajero del vuelo.
	 * @param clase Clase asociada al vuelo.
	 */
	public Billete (Vuelo vuelo, Pasajero pasajero, Clase clase, double precio){
		
		// Almacena los datos
		_vuelo = vuelo;
		_pasajero = pasajero;
		_clase = clase;
		_precio = precio;
	}
	
	// M�TODOS P�BLICOS
	public double damePrecio() {
		return _precio;
	}
	/**
	 * Obtiene el vuelo asociado al billete.
	 * 
	 * @return El vuelo.
	 */
	public Vuelo dameVuelo() {
		return _vuelo;
	}

	/**
	 * Obtiene el pasajero del vuelo.
	 * 
	 * @return El pasajero.
	 */
	public Pasajero damePasajero() {
		return _pasajero;
	}

	/**
	 * Obtiene la clase asociada al vuelo.
	 * 
	 * @return La clase.
	 */
	public Clase dameClase() {
		return _clase;
	}
	
	// ? Sobreescribir m�todo toString?
	
	// ENUM AUXILIAR
	
	public enum Clase{
		BUSINESS, TURISTA, GRUPOS, ACUERDOS_ESPECIALES, TOUROPERADOR
	}
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Vuelo del billete.
	 */
	private Vuelo _vuelo;

	/**
	 * Pasajero.
	 */
	private Pasajero _pasajero;
	
	private double _precio;
	
	
	/**
	 * Clase
	 */
	private Clase _clase;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -3799473743222382953L;

}