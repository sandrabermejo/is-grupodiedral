/*
 * GestorVuelos.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import diedral.acex.excepciones.CampoRequeridoException;
import diedral.acex.excepciones.VueloIncorrectoException;

/**
 * Gestor de vuelos.
 */
public class GestorVuelos implements Serializable {
	/**
	 * Obtiene la instancia del gestor de vuelos.
	 * 
	 * @return Un {@code GestorVuelos} válido.
	 */
	public static GestorVuelos dameInstancia(){
		if (_instancia == null){
			// Intenta cargarlo de los datos almacenados
			_instancia = (GestorVuelos) AyudantePersistencia.recupera(versionTID);
			
			// Si no ha funcionado
			if (_instancia == null)
				_instancia = new GestorVuelos();
		}
		
		return _instancia;
	}
	
	/**
	 * Sincroniza el objeto con la base datos.
	 * 
	 * <p>Realmente lo guarda en un archivo.
	 * 
	 * @return {@code true} si todo fue bien. {@code false} en caso
	 * contrario.
	 */
	@SuppressWarnings("unused")
	public static boolean sincronizaDatos(){
		return AyudantePersistencia.almacena(_instancia, 
				versionTID);
	}
	
	
	/**
	 * Inserta un vuelo en el registro de la compañía.
	 * 
	 * <p>Sólo con fines demostrativos pues no se corresponde con esta
	 * parte de la implementación.
	 * @return 
	 */
	public boolean añadeVuelo(Vuelo vuelo){
		return _vuelos.add(vuelo);
	}
	
	/**
	 * Obtiene el conjunto de aeropuertos en los que opera la
	 * compañía.
	 * 
	 * @return Dicho conjunto.
	 */
	public Set<Aeropuerto> dameAeropuertos(){
		/*
		 * Forma nada ortodoxa de obtener la lista de aeropuertos.
		 */
		Set<Aeropuerto> ret = new HashSet<>();
		
		for (Vuelo vuelo : _vuelos) {
			ret.add(vuelo.dameDestino());
			ret.add(vuelo.dameOrigen());
			
			if (vuelo.dameEscalas() != null)
				for (Escala escala : vuelo.dameEscalas())
					ret.add(escala.dameAropuerto());
		}
			
		
		return ret;
	}

	/**
	 * Copia de la instancia
	 */
	private static GestorVuelos _instancia;

	/**
	 * Almacén del vuelos
	 */
	Set<Vuelo> _vuelos = new HashSet<Vuelo>();
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -6922329606269600313L;
	
	/**
	 * Serial UID (modo texto)
	 */
	@SuppressWarnings("unused")
	private static final String versionTID = String.format("%s%s", (serialVersionUID < 0 ? "N" : ""),
			new Long(Math.abs(serialVersionUID)).toString());
}