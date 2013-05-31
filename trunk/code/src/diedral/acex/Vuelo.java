/*
 * Vuelo.java - ACE Gestión Externa - Grupo diedral 2013
 */

package diedral.acex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import diedral.acex.excepciones.VueloIncorrectoException;

/**
 * Esta clase representa un vuelo.
 */
public class Vuelo implements Serializable {
	/**
	 * Construye un vuelo a partir de los datos aportados.
	 * 
	 * @param nVuelo Número de vuelo
	 * @param origen Aeropuerto de origen.
	 * @param destino Aeropuerto de destino.
	 */
	public Vuelo(int nVuelo, Aeropuerto origen, Aeropuerto destino) 
			throws VueloIncorrectoException {
		if (origen.equals(destino))
			throw new VueloIncorrectoException(
					"El aeropuerto de origen y destino no pueden ser iguales");
		
		_numVuelo = nVuelo;
		_origen = origen;
		_destino = destino;
		_fsalida = null;
		_fllegada = null;
		_avion = null;
		_npasajeros = 0;
		_pasajeros = new TreeSet<Pasajero>();		
		_escalas = new ArrayList<Escala>();
	}

	/**
	 * Construye un vuelo a partir de los datos aportados.
	 */	
	public Vuelo(Aeropuerto origen, Aeropuerto destino, GregorianCalendar salida,
		GregorianCalendar llegada, Avion avion, int pasajeros, List<Escala> escalas)
			throws VueloIncorrectoException {
		
		/*
		 * Comprobaciones de la consistencia de los datos.
		 */
		if (origen.equals(destino))
			throw new VueloIncorrectoException(
					"El aeropuerto de origen y destino no pueden ser iguales");
		
		if (salida.after(llegada))
			throw new VueloIncorrectoException(
					"La fecha de llegada debe ser posterior a la fecha de salida");
		
		if (pasajeros <= 0)
			throw new VueloIncorrectoException(
					"No se puede crear un vuelo que no admita pasajeros");
		
		/*
		 * Guarda los atributos.
		 */
		_origen = origen;
		_destino = destino;
		_fsalida = salida;
		_fllegada = llegada;
		_avion = avion;
		_npasajeros = pasajeros;
		_pasajeros = new TreeSet<Pasajero>();
		_escalas = escalas;
	}
	
	/**
	 * Mete al pasajero en la lista de pasajeros del vuelo
	 * Comprobando que no estaba ya.
	 * 
	 * @param pasajero que añadir a la lista.
	 */
	public void metePasajero(Pasajero pasajero){
		_pasajeros.add(pasajero);
	}
	
	/**
	 * Borra al pasajero de la lista de pasajeros del vuelo.
	 * 
	 * @param pasajero a borrar de la lista.
	 */
	public void borraPasajero(Pasajero pasajero) {
		_pasajeros.remove(pasajero);
	}
	
	/**
	 * Mete una escala en el vuelo.
	 * 
	 * @param escala Una escala.
	 */
	public void meteEscala(Escala escala) {
		if (!_escalas.contains(escala))
			_escalas.add(escala);
	}
	
	/**
	* Borra una escala del vuelo
	*
	* @param escala Una escala existente.
	*/
	public void borraEscala(Escala escala) {
		_escalas.remove(escala);
	}
	
	/**
	 * Obtiene el aeropuerto de origen del vuelo.
	 * 
	 * @return El aeropuerto de origen.
	 */
	public Aeropuerto dameOrigen() {
		return _origen;
	}
	
	/**
	 * Obtiene el aeropuerto de destino del vuelo.
	 * 
	 * @return El aeropuerto de destino.
	 */
	public Aeropuerto dameDestino() {
		return _destino;
	}
	
	/**
	 * Obtiene la fecha de salida del vuelo.
	 * 
	 * @return La fecha de salida.
	 */
	public GregorianCalendar dameFechaSalida() {
		return _fsalida;
	}
	
	/**
	 * Obtiene la fecha de llegada del vuelo.
	 * 
	 * @return La fecha de llegada.
	 */
	public GregorianCalendar dameFechaLlegada() {
		return _fllegada;
	}
	
	/**
	 * Obtiene el avión encargado del vuelo.
	 * 
	 * @return El avión.
	 */
	public Avion dameAvion() {
		return _avion;
	}
	
	/**
	 * Obtiene el número máximo de pasajeros del vuelo.
	 * 
	 * @return El número de pasajeros.
	 */
	public int dameNumPasajeros() {
		return _npasajeros;
	}
	
	/**
	 * Obtiene el precio del vuelo.
	 * 
	 * @return El precio.
	 */
	public double damePrecio() {
		return _precio;
	}
	
	/**
	 * Obtiene el número de vuelo.
	 * 
	 * @return El número de vuelo.
	 */
	public int dameNumeroVuelo(){
		return _numVuelo;
	}
	
	/**
	 * Obtiene la lista de pasajeros del vuelo.
	 * 
	 * @return La lista de pasajeros.
	 */
	public SortedSet<Pasajero> damePasajeros () {
		return _pasajeros;
	}
	
	/**
	 * Obtiene la lista de escalas del vuelo.
	 * 
	 * @return La lista de escalas.
	 */
	public List<Escala> dameEscalas () {
		return _escalas;
	}

	/**
	 * Modifica la fecha de salida del vuelo.
	 * 
	 * @param salida fecha de salida.
	 */
	public void ponFechaSalida(GregorianCalendar salida) {
		_fsalida = salida;
	}

	/**
	 * Modifica la fecha de llegada del vuelo.
	 * 
	 * @param llegada fecha de llegada.
	 */
	public void ponFechaLlegada(GregorianCalendar llegada) {
		_fllegada = llegada;
	}

	/**
	 * Modifica el avión encargado del vuelo.
	 * 
	 * @param avion Avión encargado del vuelo.
	 */
	public void ponAvion(Avion avion) {
		_avion = avion;
	}

	/**
	 * Modifica el número de pasajeros admitidos en el vuelo.
	 * 
	 * @param pasajeros Número de pasajeros del vuelo
	 */
	public void ponNumPasajeros(int pasajeros) {
		_npasajeros = pasajeros;
	}
	
	/**
	 * Modifica el precio del vuelo.
	 * 
	 * @param precio Precio del vuelo.
	 */
	public void ponPrecio(double precio) {
		_precio = precio;
	}

	// ATRIBUTOS PRIVADOS
	
	/**
	 * Número de vuelo
	 */
	private int _numVuelo;

	/**
	 * Aeropuerto de origen
	 */
	private Aeropuerto _origen;
	
	/**
	 * Aeropuerto de destino
	 */
	private Aeropuerto _destino;
	
	/**
	 * Fecha de salida
	 */
	private GregorianCalendar _fsalida;
	
	/**
	 * Fecha de llegada
	 */
	private GregorianCalendar _fllegada;
	
	/**
	 * Avión encargado del vuelo
	 */
	private Avion _avion;
	
	/**
	 * Número máximo de pasajeros
	 */
	private int _npasajeros;
	
	/**
	 * Precio del vuelo
	 */
	private double _precio;
	
	/**
	 * Lista de pasajeros (ordenada por DNI)
	 */
	private SortedSet<Pasajero> _pasajeros;
	
	/**
	 * Lista de escalas
	 */
	private List<Escala> _escalas;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 6321018059660100620L;
}
