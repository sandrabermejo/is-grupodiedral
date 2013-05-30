/*
 * Oferta.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex;

import java.io.Serializable;
import java.util.Set;

/**
 * Esta clase representa una oferta.
 */
public class Oferta implements Serializable {	
	/**
	 * Crea una oferta.
	 * 
	 * @param vuelos
	 * @param destino
	 * @param intervaloEdad
	 * @param descuento
	 */
	public Oferta(Set<Vuelo> vuelos, String destino, int[] intervaloEdad, int descuento, String nombre) {
		_vuelos = vuelos;
		_destino = destino;
		_intervaloEdad = intervaloEdad;
		_descuento = descuento;
		_nombre = nombre;
	}
	
	/**
	 * 
	 * @return el nombre de la oferta
	 */
	public String dameNombre() {
		return _nombre;
	}
	
	/**
	 * 
	 * @return el vuelo sobre el que se aplica la oferta
	 */
	public Set<Vuelo> dameVuelos() {
		return _vuelos;
	}
	
	/**
	 * 
	 * @return las condiciones para poder disfrutar de la oferta
	 */
	public String dameCondiciones() {
		return "Para acceder a esta oferta es necesario tener una edad comprendida entre " + _intervaloEdad[0] + _intervaloEdad[1];
	}
	
	/**
	 * 
	 * @return el destino sobre el que se aplica la oferta
	 */
	public String dameDestino() {
		return _destino;
	}
	
	/**
	 * 
	 * @return el intervalo de edad sobre el que se aplica la oferta
	 */
	public int[] dameIntervaloEdad() {
		return _intervaloEdad;
	}
	
	/**
	 * 
	 * @return el descuento que se aplica en la oferta
	 */
	public int dameDescuento() {
		return _descuento;		
	}
	
	
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Vuelo
	 */
	private Set<Vuelo> _vuelos;
	
	/**
	 * Destino
	 */
	private String _destino;
	
	/**
	 * Intervalo de edad en el que se aplica la oferta
	 */
	private int[] _intervaloEdad;
	
	/**
	 * Descuento
	 */
	private int _descuento;
	
	private String _nombre;

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 4978176227687620628L;
}
