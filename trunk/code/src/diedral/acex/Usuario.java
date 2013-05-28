/*
 * Usuario.java - ACE Gestión Externa - Grupo diedral 2013
 */

package diedral.acex;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Usuario de la aplicación.
 */
public class Usuario implements Serializable {
	/**
	 * Constructor
	 */
	public Usuario (String nombre, String apellido1, String apellido2,
			String contrasena, String correo) {
		_nombre = nombre;
		_apellido1 = apellido1;
		_apellido2 = apellido2;
		_contrasena = contrasena;
		_correo = correo;
		_ofertasGenerales = new ArrayList<Oferta>();
		_ofertasPersonales = new ArrayList<Oferta>();
	}
	
	/**
	 *
	 */
	public void meteOfertaGeneral(Oferta oferta) {
		if (!_ofertasGenerales.contains(oferta))
			_ofertasGenerales.add(oferta);
	}
	
	/**
	 *
	 */
	public void borraOfertaPersonal(Oferta oferta) {
		if (_ofertasPersonales.contains(oferta))
			_ofertasPersonales.remove(oferta);
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
	 * Obtiene la contraseña del usuario
	 * 
	 * @return La contraseña
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
	 * Obtiene la lista de ofertas generales del usuario
	 * 
	 * @return
	 */
	public List<Oferta> dameOfertasGenerales() {
		return _ofertasGenerales;
	}
	
	/**
	 * Obtiene la lista de ofertas personalizdas del usuario
	 * 
	 * @return
	 */
	public List<Oferta> dameOfertasPersonales() {
		return _ofertasPersonales;
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
	 * Contraseña del usuario
	 */
	private String _contrasena;
	
	/**
	 * Correo electrónico del usuario
	 */
	private String _correo;
	
	/**
	 * Lista de ofertas generales del usuario
	 */
	private List<Oferta> _ofertasGenerales;
	
	/**
	 * Lista de ofertas personalizadas del usuario
	 */
	private List<Oferta> _ofertasPersonales;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1004802057165749142L;
}
