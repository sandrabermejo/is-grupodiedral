/*
 * Sugerencia.java - ACE Gestión Externa - Grupo diedral 2013
 */

package diedral.acex;

import diedral.acex.excepciones.CampoRequeridoException;
import diedral.acex.excepciones.FormatoIncorrectoException;

/**
 * Esta clase representa una sugerencia o reclamación.
 *
 * <p>Ésta contiene un mensaje descriptivo, opcionalmente el nombre del autor y
 * una dirección de correo electrónico para recibir contestación.
 */
public class Sugerencia implements java.io.Serializable {
	/**
	 * Crea una sugerencia nueva.
	 *
	 * @param mensaje Mensaje de la sugerencia.
	 * @param nombre Nombre del autor (si procede).
	 * @param contacto Correo electrónico de contacto.
	 *
	 * @throws CampoRequeridoException si el campo mensaje se deja vacío.
	 * @throws FormatoIncorrectoException si el formato de la dirección
	 * de correo no se ajusta a la permitida.
	 */
	public Sugerencia(String mensaje, String nombre, String contacto)
		throws CampoRequeridoException, FormatoIncorrectoException {

		if (mensaje == null || mensaje.isEmpty())
			throw new CampoRequeridoException("Falta el mensaje para la sugerencia");

		_mensaje = mensaje;

		_nombre = nombre;

		// TODO: hacer función para verificar que la dirección de correo lo es

		_contacto = contacto;
	}

	/**
	 * Obtiene el mensaje de la sugerencia.
	 *
	 * @return Dicho mensaje.
	 */
	public String dameMensaje(){
		return _mensaje;
	}

	/**
	 * Obtiene el nombre del autor de la sugerencia.
	 *
	 * @return Nombre del autor (pudiera ser {@code null}).
	 */
	public String dameNombreAutor(){
		return _nombre;
	}

	/**
	 * Obtiene la dirección de correo electrónico de contacto.
	 */
	public String dameDireccionContacto(){
		return _contacto;
	}


	// MIEMBROS PRIVADOS

	/**
	 * Mensaje
	 */
	private String _mensaje;

	/**
	 * Nombre del autor
	 */
	private String _nombre;

	/**
	 * Dirección de correo electrónico de contacto
	 */
	private String _contacto;	

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -5554982565154505386L;
}