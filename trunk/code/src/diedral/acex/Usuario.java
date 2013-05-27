package diedral.acex;

import java.awt.List;
import java.io.Serializable;

public class Usuario implements Serializable {
	
	public Usuario (String nombre, String apellido1, String apellido2, String contrasena, String correo) {
		_nombre = nombre;
		_apellido1 = apellido1;
		_apellido2 = apellido2;
		_contrasena = contrasena;
		_correo = correo;
		_ofertas = new List<Oferta>();
	}
	
	public void meteOferta(Oferta oferta) {
		if (!_ofertas.contains(oferta))
			_ofertas.add(oferta);
	}
	
	public void borraOferta(Oferta oferta) {
		if (_ofertas.contains(oferta))
			_ofertas.remove(oferta);
	}
	
	/**
	 * Obtiene el nombre del usuario
	 * 
	 * @return El nombre
	 */
	public String dameNombre() {
		return _nombre;
	}

	/**
	 * Obtiene el primer apellido del usuario
	 * 
	 * @return El primer apellido
	 */
	public String dameApellido1() {
		return _apellido1;
	}

	/**
	 * Obtiene el segundo apellido del usuario
	 * 
	 * @return El segundo apellido
	 */
	public String dameApellido2() {
		return _apellido2;
	}

	/**
	 * Obtiene la contrase�a del usuario
	 * 
	 * @return La contrase�a
	 */
	public String dameContrasena() {
		return _contrasena;
	}

	/**
	 * Obtiene el correo del usuario
	 * 
	 * @return El correo
	 */
	public String dameCorreo() {
		return _correo;
	}

	/**
	 * Obtiene la lista de ofertas del usuario
	 * 
	 * @return
	 */
	public Lista<Oferta> dameOfertas() {
		return _ofertas;
	}
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Nombre del usuario
	 */
	private String _nombre;
	
	/**
	 * Primer apellido del usuario
	 */
	private String _apellido1;
	
	/**
	 * Segundo apellido del usuario
	 */
	private String _apellido2;
	
	/**
	 * Contrase�a del usuario
	 */
	private String _contrasena;
	
	/**
	 * Correo electr�nico del usuario
	 */
	private String _correo;
	
	/**
	 * Lista de ofertas del usuario
	 */
	private Lista<Oferta> _ofertas;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;

}
