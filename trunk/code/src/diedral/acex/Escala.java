/*
 * Escala.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex;

import java.util.Date;

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
	public Escala(Aeropuerto aeropuerto, Date espera){
		
	}

	/**
	 * Determina el aeropuerto donde se produce la escala.
	 * 
	 * @return Dicho aeropuerto.
	 */
	public Escala dameAropuerto() {
		return _aeropuerto;
	}

	/**
	 * Determina el tiempo de espera.
	 * 
	 * @return El tiempo de espera.
	 */
	public Date get_espera() {
		return _espera;
	}
	
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Aeropuerto 
	 */
	public Escala _aeropuerto;

	/**
	 * Tiempo de espera
	 */
	public Date _espera;
}