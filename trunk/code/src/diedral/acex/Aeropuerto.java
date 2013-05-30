/*
 * Aeropuerto.java - ACE Gestión Externa - Grupo diedral 2013
 */

package diedral.acex;

import diedral.acex.excepciones.CampoRequeridoException;

/**
 * Esta clase representa un aeropuerto.
 *
 * <p>Contiene su nombre, el código IATA y la ciudad donde se
 * ubica.
 */
public class Aeropuerto implements java.io.Serializable {
	/**
	 * Crea un aeropuerto con los datos aportados.
	 * 
	 * @param nombre Aeropuertos.
	 * @param codIATA Código IATA.
	 * @param ciudad Nombre de la ciudad.
	 */
	public Aeropuerto(String nombre, String codIATA, String ciudad)
		throws CampoRequeridoException {
		/*
		 * No admite cadenas vacías para ninguno de los parámetros.
		 */
		
		if (nombre == null || nombre.isEmpty())
			throw new CampoRequeridoException(
					"El nombre de aeropuerto no puede quedar vacío");
		
		if (codIATA == null || codIATA.isEmpty())
			throw new CampoRequeridoException(
					"El código IATA no puede quedar vacío");
		
		if (ciudad == null || ciudad.isEmpty())
			throw new CampoRequeridoException(
					"El campo ciudad no puede quedar vacío");
		
		
		// Almacena los nombres
		_nombre = nombre;
		_codigoIATA = codIATA;
		_ciudad = ciudad;
	}
	
	/**
	 * Obtiene el nombre del aeropuerto.
	 * 
	 * @return El nombre.
	 */
	public String dameNombre() {
		return _nombre;
	}

	/**
	 * Obtiene el código IATA del aeropuerto
	 * 
	 * @return El código IATA.
	 */
	public String damCodigoIATA() {
		return _codigoIATA;
	}

	/**
	 * Obtiene el nombre de la ciudad donde se ubica.
	 * 
	 * @return El nombre de la ciudad donde se ubica.
	 */
	public String dameCiudad() {
		return _ciudad;
	}
	
	
	@Override
	public String toString() {
		return _nombre + " (" + _codigoIATA + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Aeropuerto)
			return _codigoIATA.compareTo(((Aeropuerto) obj)._codigoIATA) == 0;
		
		return false;
	}
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Nombre del aeropuerto
	 */
	private String _nombre;

	/**
	 * Código IATA
	 */
	private String _codigoIATA;
	
	/**
	 * Ciudad
	 */
	private String _ciudad;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -2366848740002004741L;
}