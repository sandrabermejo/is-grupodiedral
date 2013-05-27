package diedral.acex;

import java.io.Serializable;
import java.util.Date;
/**
 * Esta clase representa un pasajero. Contiene el usuario de la página web que tiene (donde contiene 
 * el nombre y los apellidos), su nacionalidad, su fecha de nacimiento y su DNI.
 */
public class Pasajero implements Serializable{
	public Pasajero(Usuario usuario, String nacionalidad, Date fechaNacimiento, DNI DNI){
		_usuario = usuario; 
		_nacionalidad = nacionalidad;
		_fechaNacimiento = fechaNacimiento;
		_DNI = DNI;
		_nombre = usuario.dameNombre();
		_apellido1 = usuario.dameApellido1();
		_apellido2 = usuario.dameApellido2();
	}
	/**
	 * Obtiene el usuario asociado a un pasajero
	 * @return el usuario asociado a un pasajero
	 */
	public Usuario dameUsuario() {
		return _usuario;
	}
	/**
	 * Obtiene la nacionalidad de un pasajero
	 * @return la nacionalidad de un pasajero
	 */
	public String dameNacionalidad() {
		return _nacionalidad;
	}
	/**
	 * Obtiene la fecha de nacimiento de un pasajero
	 * @return fecha de nacimiento de un pasajero
	 */
	public Date dameFechaNacimiento() {
		return _fechaNacimiento;
	}
	/**
	 * Obtiene el nombre de un pasajero
	 * @return nombre de un pasajero
	 */
	public String dameNombre() {
		return _nombre;
	}
	/**
	 * Obtiene el primer apellido de un pasajero
	 * @return primer apellido de un pasajero
	 */
	public String dameApellido1() {
		return _apellido1;
	}
	/**
	 * Obtiene el segundo apellido de un pasajero
	 * @return segundo apellido de un pasajero
	 */
	public String dameApellido2() {
		return _apellido2;
	}
	/**
	 * Obtiene el DNI de un pasajero
	 * @return DNI de un pasajero
	 */
	public DNI dameDNI() {
		return _DNI;
	}
	/**
	 * Modifica el nombre de un pasajero
	 * @param _nombre nombre de un pasajero
	 */
	public void ponNombre(String _nombre) {
		this._nombre = _nombre;
	}
	/**
	 * Modifica el primer apellido de un pasajero
	 * @param _apellido1 primer apellido de un pasajero
	 */
	public void ponApellido1(String _apellido1) {
		this._apellido1 = _apellido1;
	}
	/**
	 * Modifica el segundo apellido de un pasajero
	 * @param _apellido2 segundo apellido de un pasajero
	 */
	public void ponApellido2(String _apellido2) {
		this._apellido2 = _apellido2;
	}
	
	//ATRIBUTOS PRIVADOS
	
	private static final long serialVersionUID = 4699369467043136563L;
	private Usuario _usuario;
	private String _nacionalidad; 
	private Date _fechaNacimiento;
	private String _nombre, _apellido1, _apellido2;
	private DNI _DNI;
	
}
