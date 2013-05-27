package diedral.acex;

/**
 * Esta clase representa el DNI de una persona. Contiene los campos:
 * _numero: entero con el número de DNI.
 * _letra: char con la letra del DNI.
 */
public class DNI {
	public DNI(int numero, char letra){
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
	
	//ATRIBUTOS PRIVADOS
	
	/**
	 * Numero del DNI
	 */
	private int _numero;
	/**
	 * Letra del DNI
	 */
	private char _letra;
}
