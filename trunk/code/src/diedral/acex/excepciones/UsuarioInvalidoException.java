/*
 * UsuarioInvalidoException.java - ACE Gestión Externa - Grupo Diedral 2013
 */

package diedral.acex.excepciones;

/**
 * Excepción lanzada cuando un usuario no es válido.
 * 
 * TODO: explicar que es esta excepción
 *
 */
public class UsuarioInvalidoException extends Exception {
	/**
	 * Contruye una excepción sin mensaje ni causa.
	 */
	public UsuarioInvalidoException() {
		super();
	}

	/**
	 * Contruye una excepción con mensaje.
	 * 
	 * @param mensaje
	 *            Mensaje explicativo de la excepción.
	 */
	public UsuarioInvalidoException(String mensaje) {
		super(mensaje);
	}

	/**
	 * Contruye una excepción dada una causa.
	 * 
	 * @param causa
	 *            Causa de la excepción.
	 */
	public UsuarioInvalidoException(Throwable causa) {
		super(causa);
	}

	/**
	 * Contruye una excepción con mensaje y causa.
	 * 
	 * @param mensaje
	 *            Mensaje explicativo de la excepción.
	 * @param causa
	 *            Causa de la excepción.
	 */
	public UsuarioInvalidoException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 7145573208484864358L;
}
