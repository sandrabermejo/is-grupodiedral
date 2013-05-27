/*
 * Dni.java - ACE Gestión Externa - Grupo diedral 2013
 */

package diedral.acex;

import java.io.Serializable;

/**
 * Esta clase representa el DNI de una persona. Contiene los campos:
 * _numero: entero con el número de DNI.
 * _letra: char con la letra del DNI.
 */
public class Dni implements Serializable, Comparable<Dni> {
	public Dni(int numero, char letra){
		_numero = numero;
		_letra = letra;
	}
	/**
	 * Obtiene el numero de un DNI
	 * @return numero de un DNI
	 */
	public int dameNumero(){
		return _numero;
	}
	/**
	 * Obtiene la letra de un DNI
	 * @return letra de un DNI
	 */
	public char dameLetra(){
		return _letra;
	}
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Numero del DNI
	 */
	private int _numero;

	/**
	 * Letra del DNI
	 */
	private char _letra;

	@Override
	public int compareTo(Dni dni) {
		return _numero - dni._numero;
	}
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1595436200669860941L;
}
