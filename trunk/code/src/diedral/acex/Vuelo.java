/*
 * Vuelo.java - ACE Gestión Externa - Grupo diedral 2013
 */

package diedral.acex;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import diedral.acex.excepciones.VueloIncorrectoException;

public class Vuelo implements java.io.Serializable {
	
	
	public Vuelo(Aeropuerto origen, Aeropuerto destino, Date salida, Date llegada, Avion avion, int pasajeros, int sobrecoste){
		if (origen == destino)
			throw new VueloIncorrectoException("El aeropuerto de origen y destino no pueden ser iguales");
		if (salida.after(llegada))
			throw new VueloIncorrectoException("La fecha de llegada debe ser posterior a la fecha de salida");
			
	}
	
	
	// ATRIBUTOS PRIVADOS
	
	private Aeropuerto _origen;
	
	private Aeropuerto _destino;
	
	private Date fsalida;
	
	private Date fllegada;
	
	private Avion avion;
	
	private int npasajeros;
	
	private int sobrecoste;
	
	private List<Pasajero> pasajeros;
	
	private List<Escala> escalas;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;
	

}
