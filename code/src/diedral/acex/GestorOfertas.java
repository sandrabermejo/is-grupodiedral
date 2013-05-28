/*
 * GestorOfertas.java - ACE Gesti�n Externa - Grupo diedral 2013
 */
package diedral.acex;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Gestor de ofertas.
 * Sigue el patr�n Singleton.
 */
public class GestorOfertas implements Serializable{
	
	// MÉTODOS PÚBLICOS
	
	/**
	 * Obtiene la instancia del gestor de ofertas.
	 * 
	 * @return Un {@code GestorOfertas} v�lido.
	 */
	public static GestorVuelos dameInstancia(){
		if (_instancia == null)
			_instancia = new GestorVuelos();
		
		return _instancia;
	}
	
	/**
	* Devuelve la oferta con nombre el especificado si la hay o {@code null}
	* en caso contrario.
	* @param nombre El identificador de la oferta.
	*/
	public Oferta buscarOferta(String nombre){
		return ofertas.get(nombre);
	}
	
	/*
	* Almacena una oferta, el identificador de la misma ha de ser �nico,
	* en caso de existir otra oferta con el mismo identificador ser� sobreescrita.
	* @param oferta La nueva oferta.
	*/
	public void insertarOferta(Oferta oferta){
		ofertas.put(oferta.dameNombre(), oferta);
	}
	
	/*
	* Elimina una oferta, dado su identificador,
	* en caso de no existir la oferta no tiene efecto.
	* @param nombre El nombre de la oferta.
	*/
	public void eliminarOferta(String nombre){
		ofertas.remove(nombre);
	}
	
	/*
	* Elimina una oferta,
	* en caso de no existir la oferta no tiene efecto.
	* @param oferta La oferta ha ser eliminada del registro.
	*/
	public void eliminarOferta(Oferta oferta){
		ofertas.remove(oferta.dameNombre());
	}
	
	// M�TODOS PRIVADOS

	/**
	* Crea un gestor de Ofertas vacio.
	*/
	private GestorOfertas(){
		ofertas = new HashMap<>();
	}
	
	 // ATRIBUTOS PRIVADOS
	/**
	 * Copia de la instancia
	 */
	private static GestorVuelos _instancia;
	
	/**
	* Listado de ofertas.
	*/
	Map<String, Oferta> ofertas;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -8705693435085327942L;
}
