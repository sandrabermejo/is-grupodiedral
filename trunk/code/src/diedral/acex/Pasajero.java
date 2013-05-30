/*
 * Pasajero.java - ACE Gestión Externa - Grupo diedral 2013
 */

package diedral.acex;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Esta clase representa un pasajero.
 * 
 * <p>Contiene el usuario de la página web que tiene (donde contiene 
 * el nombre y los apellidos), su nacionalidad, su fecha de nacimiento y su DNI.
 */
public class Pasajero implements Serializable {
	/**
	 * Contruye un nuevo pasajero que tiene un usuario.
	 * 
	 * @param usuario
	 * @param nacionalidad
	 * @param fechaNacimiento
	 * @param DNI
	 */
	public Pasajero(Usuario usuario, String nacionalidad, GregorianCalendar fechaNacimiento, Dni DNI){
		_usuario = usuario; 
		_nacionalidad = nacionalidad;
		_fechaNacimiento = fechaNacimiento;
		_DNI = DNI;
		_nombre = usuario.dameNombre();
		_apellido1 = usuario.dameApellido1();
		_apellido2 = usuario.dameApellido2();
	}
	/**
	 * Construye un usuario que no tiene un usuario registrado dado:
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param nacionalidad
	 * @param fechaNacimiento
	 * @param DNI
	 */
	public Pasajero(String nombre, String apellido1, String apellido2, String nacionalidad, GregorianCalendar fechaNacimiento, Dni DNI){
		_nacionalidad = nacionalidad;
		_fechaNacimiento = fechaNacimiento;
		_DNI = DNI;
		_nombre = nombre;
		_apellido1 = apellido1;
		_apellido2 = apellido2;
		_usuario = null;
	}
	/**
	 * Obtiene el usuario asociado a un pasajero
	 * @return el usuario asociado a un pasajero
	 */
	public Usuario dameUsuario() {
		return _usuario;
	}

	/**
	 * Obtiene la nacionalidad de un pasajero
	 * @return la nacionalidad de un pasajero
	 */
	public String dameNacionalidad() {
		return _nacionalidad;
	}

	/**
	 * Obtiene la fecha de nacimiento de un pasajero.
	 * 
	 * @return fecha de nacimiento de un pasajero
	 */
	public GregorianCalendar dameFechaNacimiento() {
		return _fechaNacimiento;
	}

	/**
	 * Obtiene el nombre de un pasajero
	 * @return nombre de un pasajero
	 */
	public String dameNombre() {
		return _nombre;
	}

	/**
	 * Obtiene el primer apellido de un pasajero
	 * @return primer apellido de un pasajero
	 */
	public String dameApellido1() {
		return _apellido1;
	}

	/**
	 * Obtiene el segundo apellido de un pasajero
	 * @return segundo apellido de un pasajero
	 */
	public String dameApellido2() {
		return _apellido2;
	}

	/**
	 * Obtiene el DNI de un pasajero
	 * @return DNI de un pasajero
	 */
	public Dni dameDNI() {
		return _DNI;
	}

	/**
	 * Modifica el nombre de un pasajero
	 * 
	 * @param nombre Nombre de un pasajero.
	 */
	public void ponNombre(String nombre) {
		_nombre = nombre;
	}

	/**
	 * Modifica el primer apellido de un pasajero.
	 * 
	 * @param apellido1 Primer apellido de un pasajero.
	 */
	public void ponApellido1(String apellido1) {
		_apellido1 = apellido1;
	}

	/**
	 * Modifica el segundo apellido de un pasajero.
	 * 
	 * @param apellido2 Segundo apellido de un pasajero.
	 */
	public void ponApellido2(String apellido2) {
		_apellido2 = apellido2;
	}
	

	// ATRIBUTOS PRIVADOS
	
	private Usuario _usuario;
	private String _nacionalidad; 
	private GregorianCalendar _fechaNacimiento;
	private String _nombre, _apellido1, _apellido2;
	private Dni _DNI;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 4699369467043136563L;
}