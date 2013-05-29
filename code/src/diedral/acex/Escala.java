/*
 * Escala.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex;

import java.util.GregorianCalendar;


/**
 * Esta clase representa una escala aeroportuaria.
 */
public class Escala {
	
	/**
	 * Crea una escala.
	 * 
	 * @param aeropuerto Aeropuerto donde se transborda.
	 * @param espera Duración de la espera.
	 */
	public Escala(Aeropuerto aeropuerto, GregorianCalendar espera){
		_aeropuerto = aeropuerto;
		
		_espera = espera;
	}

	/**
	 * Determina el aeropuerto donde se produce la escala.
	 * 
	 * @return Dicho aeropuerto.
	 */
	public Aeropuerto dameAropuerto() {
		return _aeropuerto;
	}

	/**
	 * Determina el tiempo de espera.
	 * 
	 * @return El tiempo de espera.
	 */
	public GregorianCalendar dameEspera() {
		return _espera;
	}
	
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Aeropuerto 
	 */
	private Aeropuerto _aeropuerto;

	/**
	 * Tiempo de espera
	 */
	private GregorianCalendar _espera;
}