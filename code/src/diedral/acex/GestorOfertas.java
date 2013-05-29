/*
 * GestorOfertas.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Gestor de ofertas.
 * 
 * Sigue el patrón Singleton.
 */
public class GestorOfertas implements Serializable {
	
	// MÉTODOS PÚBLICOS

	/**
	 * Obtiene la instancia del gestor de ofertas.
	 * 
	 * @return Un {@code GestorOfertas} válido.
	 */
	public static GestorOfertas dameInstancia(){
		if (_instancia == null){
			// Intenta cargarlo de los datos almacenados
			_instancia = (GestorOfertas) AyudantePersistencia.dameInstancia().recuperayVigila(
					versionTID);
			
			// Si no ha funcionado
			if (_instancia == null)
				_instancia = new GestorOfertas();
		}
		
		return _instancia;
	}
	
	/**
	* Devuelve la lista de ofertas contenidas en ese momento en el gestor.
	* @return una lista de ofertas.
	*/
	public Collection<Oferta> dameOfertas(){
		return ofertas.values();
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
	* Almacena una oferta, el identificador de la misma ha de ser único,
	* en caso de existir otra oferta con el mismo identificador será sobreescrita.
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
	
	/*
	* Consulta la cantidad de ofertas disponibles.
	* @return El número de ofertas.
	*/
	public int dimeCuantasOfertas(){
		return ofertas.size();
	}
	
	// Mï¿½TODOS PRIVADOS

	/**
	* Crea un gestor de Ofertas vacio.
	*/
	private GestorOfertas(){
		ofertas = new HashMap<>();
		// Oferta a modo de ejemplo
		int[] v= {18, 25};	
		Oferta nuestroOferton = new Oferta(new TreeSet<Vuelo>(), "Valencia", v, 30, "Oferton Diedral");
		insertarOferta(nuestroOferton);
	}
	
	 // ATRIBUTOS PRIVADOS
	/**
	 * Copia de la instancia
	 */
	private static GestorOfertas _instancia;
	
	/**
	* Listado de ofertas.
	*/
	Map<String, Oferta> ofertas;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1700785123944334817L;
	
	/**
	 * Version TID
	 */
	private static final String versionTID = AyudantePersistencia.generaTID(serialVersionUID);
}
