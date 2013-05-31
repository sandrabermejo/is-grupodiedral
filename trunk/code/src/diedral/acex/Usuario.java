/*
 * Usuario.java - ACE Gestión Externa - Grupo diedral 2013
 */

package diedral.acex;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import diedral.acex.ventas.Compra;
import diedral.acex.ventas.Oferta;

/**
 * Usuario de la aplicación.
 */
public class Usuario implements Serializable, Comparable<Usuario> {
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
		_compras = new ArrayList<Compra>();
	}
	
	/**
	 * Añade una oferta personal a la lista del usuario
	 */
	public void meteOfertaGeneral(Oferta oferta) {
		if (!_ofertasGenerales.contains(oferta))
			_ofertasGenerales.add(oferta);
	}
	public void meteContrasena(String contrasena){
		_contrasena = contrasena;
	}
	
	/**
	 * Borra una oferta personal de la lista del usuario
	 */
	public void borraOfertaPersonal(Oferta oferta) {
		if (_ofertasPersonales.contains(oferta))
			_ofertasPersonales.remove(oferta);
	}
	
	/**
	 * Añade una compra a la lista de compras del usuario
	 * 
	 * @param compra a añadir
	 */
	public void añadeCompra(Compra compra) {
		_compras.add(compra);
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
	 * Comprueba que la constraseña del usuario sea la 
	 * aportada.
	 * 
	 * @return La pretendida contraseña
	 */
	public String dameContrasena() {
		return _contrasena;
	}

	/**
	 * Comprueba que la constraseña del usuario sea la 
	 * aportada.
	 * 
	 * @return La pretendida contraseña
	 */
	public boolean comprobarContrasena(String clave) {
		return _contrasena.compareTo(clave) == 0;
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
	 * @return Lista de las ofertas generales.
	 */
	public List<Oferta> dameOfertasGenerales() {
		return _ofertasGenerales;
	}
	
	/**
	 * Obtiene la lista de ofertas personalizdas del usuario
	 * 
	 * @return Lista de ofertas personales.
	 */
	public List<Oferta> dameOfertasPersonales() {
		return _ofertasPersonales;
	}
	
	/**
	 * Obtiene la lista de compras realizadas por el usuario
	 * 
	 * @return La lista de compras
	 */
	public List<Compra> dameCompras() {
		return _compras;
	}
	
	/**
	 * Compara dos usuarios por sus apellidos.
	 * 
	 * @param otro Otro usuario con el que comparar.
	 */
	@Override
	public int compareTo(Usuario otro) {
		return String.format("%1 %2", _apellido1, _apellido2).compareToIgnoreCase(
				String.format("%1 %2", otro._apellido1, otro._apellido2));
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
	 * Lista de compras realizadas por el usuario
	 */
	private List<Compra> _compras;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1004802057165749142L;
}
