/*
 * VueloIncorrectoException.java - ACE Gestión Externa - Grupo Diedral 2013
 */

package diedral.acex.excepciones;
/**
 * Excepción que concurre alguna circustancia por la cual un vuelo no es
 * correcto.
 *
 */
public class VueloIncorrectoException extends Exception {

	/**
	 * Contruye una excepción sin mensaje ni causa.
	 */
	public VueloIncorrectoException(){
		super();
	}

	/**
	 * Contruye una excepción con mensaje.
	 *
	 * @param mensaje Mensaje explicativo de la excepción.
	 */
	public VueloIncorrectoException(String mensaje){
		super(mensaje);
	}
	
	/**
	 * Contruye una excepción dada una causa.
	 *
	 * @param causa Causa de la excepción.
	 */
	public VueloIncorrectoException(Throwable causa){
		super(causa);
	}

	/**
	 * Contruye una excepción con mensaje y causa.
	 *
	 * @param mensaje Mensaje explicativo de la excepción.
	 * @param causa Causa de la excepción.
	 */
	public VueloIncorrectoException(String mensaje, Throwable causa){
		super(mensaje, causa);
	}

	// MIEMBROS PRIVADOS
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;
}
