/*
 * FormatoIncorrectoException.java - ACE Gestión Externa - Grupo Diedral 2013
 */

package diedral.acex.excepciones;

/**
 * Excepción por formato incorrecto de un dato de entrada.
 *
 */
public class FormatoIncorrectoException extends Exception {
	/**
	 * Contruye una excepción sin mensaje ni causa.
	 */
	public FormatoIncorrectoException(){
		super();
	}

	/**
	 * Contruye una excepción con mensaje.
	 *
	 * @param mensaje Mensaje explicativo de la excepción.
	 */
	public FormatoIncorrectoException(String mensaje){
		super(mensaje);
	}
	
	/**
	 * Contruye una excepción dada una causa.
	 *
	 * @param causa Causa de la excepción.
	 */
	public FormatoIncorrectoException(Throwable causa){
		super(causa);
	}

	/**
	 * Contruye una excepción con mensaje y causa.
	 *
	 * @param mensaje Mensaje explicativo de la excepción.
	 * @param causa Causa de la excepción.
	 */
	public FormatoIncorrectoException(String mensaje, Throwable causa){
		super(mensaje, causa);
	}

	
	// MIEMBROS PRIVADOS

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 4645787627410785272L;
}
