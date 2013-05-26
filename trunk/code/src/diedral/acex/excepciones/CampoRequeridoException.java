/*
 * CampoRequeridoException.java - ACE Gestión Externa - Grupo Diedral 2013
 */

package diedral.acex.excepciones;

/**
 * Excepción por falta de un campo requerido para una operación
 * determinada.
 *
 */
public class CampoRequeridoException extends Exception {
	/**
	 * Contruye una excepción sin mensaje ni causa.
	 */
	public CampoRequeridoException(){
		super();
	}

	/**
	 * Contruye una excepción con mensaje.
	 *
	 * @param mensaje Mensaje explicativo de la excepción.
	 */
	public CampoRequeridoException(String mensaje){
		super(mensaje);
	}
	
	/**
	 * Contruye una excepción dada una causa.
	 *
	 * @param causa Causa de la excepción.
	 */
	public CampoRequeridoException(Throwable causa){
		super(causa);
	}

	/**
	 * Contruye una excepción con mensaje y causa.
	 *
	 * @param mensaje Mensaje explicativo de la excepción.
	 * @param causa Causa de la excepción.
	 */
	public CampoRequeridoException(String mensaje, Throwable causa){
		super(mensaje, causa);
	}

	
	// MIEMBROS PRIVADOS

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 4981402758925040219L;
}
