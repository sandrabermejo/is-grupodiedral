/*
 * Dni.java - ACE Gestión Externa - Grupo diedral 2013
 */

package diedral.acex;

import java.io.Serializable;

/**
 * Esta clase representa el DNI de una persona.
 *
 */
public class Dni implements Serializable, Comparable<Dni> {
	/**
	 * Crea un nuevo DNI con un número y una letra dados.
	 * 
	 * @param numero Número del DNI
	 * @param letra Letra del DNI
	 */
	public Dni(int numero, char letra) {
		_numero = numero;
		_letra = letra;
	}
	
	/**
	 * Obtiene el numero de un DNI.
	 * 
	 * @return numero de un DNI.
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
	
	/**
	 * Calcula la letra correspondiente al número de DNI dado.
	 * 
	 * @param num Número de DNI (se supone en formato correcto).
	 */
	public static char calculaLetra(int num){		
		return _lcontrol[num % 23];
	}
	
	/**
	 * Obtiene un DNI desde una cadena de texto.
	 * 
	 * @param dni Representación textual de un DNI.
	 */
	public static Dni obtenDni(String dni){
		// Coge la letra (ultimo char del string)
		char letra = dni.charAt(dni.length()-1);
		
		// Coge el numero (el resto del string)
		dni = dni.substring(0, dni.length()-1);
		int numero = Integer.parseInt(dni);
		
		return new Dni(numero, letra);		
	}
	
	/**
	 * Obtiene la representación textual del DNI.
	 * 
	 * @return Lo dicho.
	 */
	public String toString() {
		StringBuilder stb = new StringBuilder();
		
		// Contruye dicha representación
		stb.append(_numero);
		stb.append(calculaLetra(_numero));
		
		return stb.toString();
	}
	
	/**
	 * Informa sobre si un DNI es válido.
	 * 
	 * @return {@code true} si es válido.
	 */
	public boolean esValido() {
		if (_numero < 0 || _numero > 99999999)
			return false;
		
		char letraCorrecta = calculaLetra(_numero);
		
		if (Character.toUpperCase(_letra) != letraCorrecta)
			return false;
		
		return true;
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
	
	/**
	 * Secuencia de letras control
	 */
	private final static char[] _lcontrol = 
		{ 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
		'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

	@Override
	public int compareTo(Dni dni) {
		return _numero - dni._numero;
	}
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1595436200669860941L;
}