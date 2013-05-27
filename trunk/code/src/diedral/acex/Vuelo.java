/*
 * Vuelo.java - ACE GestiÃ³n Externa - Grupo diedral 2013
 */

package diedral.acex;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import diedral.acex.excepciones.VueloIncorrectoException;

public class Vuelo implements java.io.Serializable {
	
	
	public Vuelo(Aeropuerto origen, Aeropuerto destino, Date salida, Date llegada, Avion avion, int pasajeros, int sobrecoste, ArrayList<Escala> escalas) 
			throws VueloIncorrectoException {
		
		if (origen == destino)
			throw new VueloIncorrectoException(
					"El aeropuerto de origen y destino no pueden ser iguales");
		
		if (salida.after(llegada))
			throw new VueloIncorrectoException(
					"La fecha de llegada debe ser posterior a la fecha de salida");
		
		if (pasajeros <= 0)
			throw new VueloIncorrectoException(
					"No se puede crear un vuelo que no admita pasajeros");
		
		_origen = origen;
		_destino = destino;
		_fsalida = salida;
		_fllegada = llegada;
		_avion = avion;
		_npasajeros = pasajeros;
		_sobrecoste = sobrecoste;
		_pasajeros = new ArrayList<Pasajero>();
		_escalas = escalas;
	}
	
	/**
	 * Mete al pasajero en la lista de pasajeros del vuelo
	 * Comprobando que no esté ya
	 * 
	 * @param pasajero que añadir a la lista
	 */
	public void metePasajero(Pasajero pasajero){
		if (!_pasajeros.contains(pasajero)) {
			pos = posPasajero(pasajero.dameDNI());
			_pasajeros.add(pos, pasajero);
		}
	}
	
	/**
	 * Devuelve la posición en la que debe ir un pasajero
	 * Según su DNI
	 * 
	 * @param DNI del pasajero
	 * @return La posición en la que debe ir el pasajero
	 */
	public int posPasajero(DNI dni) {
		int pos = 0;
		while ((pos < _pasajeros.size()) && (dni <_pasajeros.get(pos).dameDNI().dameNumero()))
			pos++;
		return pos;
	}
	
	/**
	 * Borra al pasajero de la lista de pasajeros del vuelo
	 * 
	 * @param pasajero a borrar de la lista
	 */
	public void borraPasajero(Pasajero pasajero) {
		if (_pasajeros.contains(pasajero))
			_pasajeros.remove(pasajero);
	}
	
	/**
	 * Obtiene el aeropuerto de origen del vuelo
	 * 
	 * @return El aeropuerto de origen
	 */
	public Aeropuerto dameOrigen() {
		return _origen;
	}
	
	/**
	 * Obtiene el aeropuerto de destino del vuelo
	 * 
	 * @return El aeropuerto de destino
	 */
	public Aeropuerto dameDestino() {
		return _destino;
	}
	
	/**
	 * Obtiene la fecha de salida del vuelo
	 * 
	 * @return La fecha de salida
	 */
	public Date dameFechaSalida() {
		return _fsalida;
	}
	
	/**
	 * Obtiene la fecha de llegada del vuelo
	 * 
	 * @return La fecha de llegada
	 */
	public Date dameFechaLlegada() {
		return _fllegada;
	}
	
	/**
	 * Obtiene el avión encargado del vuelo
	 * 
	 * @return El avión
	 */
	public Avion dameAvion() {
		return _avion;
	}
	
	/**
	 * Obtiene el número máximo de pasajeros del vuelo
	 * 
	 * @return El número de pasajeros
	 */
	public int dameNumPasajeros() {
		return _npasajeros;
	}
	
	/**
	 * Obtiene el sobrecoste del vuelo
	 * 
	 * @return El sobrecoste
	 */
	public int dameSobrecoste() {
		return _sobrecoste;
	}
	
	/**
	 * Obtiene la lista de pasajeros del vuelo
	 * 
	 * @return La lista de pasajeros
	 */
	public List<Pasajero> damePasajeros () {
		return _pasajeros;
	}
	
	/**
	 * Obtiene la lista de escalas del vuelo
	 * 
	 * @return La lista de escalas
	 */
	public List<Escala> dameEscalas () {
		return _escalas;
	}
	
	// ATRIBUTOS PRIVADOS
	
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
	private Date _fsalida;
	
	/**
	 * Fecha de llegada
	 */
	private Date _fllegada;
	
	/**
	 * Avión encargado del vuelo
	 */
	private Avion _avion;
	
	/**
	 * Número máximo de pasajeros
	 */
	private int _npasajeros;
	
	/**
	 * Sobrecoste del vuelo
	 */
	private int _sobrecoste;
	
	/**
	 * Lista de pasajeros (ordenada por DNI)
	 */
	private ArrayList<Pasajero> _pasajeros;
	
	/**
	 * Lista de escalas
	 */
	private ArrayList<Escala> _escalas;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;
	

}
