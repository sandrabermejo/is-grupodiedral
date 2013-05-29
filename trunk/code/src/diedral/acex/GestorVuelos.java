/*
 * GestorVuelos.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

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
	 * Busca en la base de datos de vuelo aquellos que cumplan
	 * con las condiciones referidas y los devuelve.
	 * 
	 * @param 
	 */
	public Set<Vuelo> buscaVuelo(CriterioBusqueda criterio){
		Set<Vuelo> ret = new HashSet<>(); 
		
		for (Vuelo vuelo : _vuelos)
			if (criterio.cumpleCriterio(vuelo))
				ret.add(vuelo);
		
		return ret;
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
	 * Criterio de búsqueda de vuelos.
	 *
	 */
	public static class CriterioBusqueda {
		
		/**
		 * Comprueba si un vuelo cumple con los criterios
		 * escogidos.
		 * 
		 * @param vuelo Vuelo a comprobar.
		 */
		public boolean cumpleCriterio(Vuelo vuelo){
			
			// (1) Origen
			if (_origen != null && !_origen.equals(vuelo.dameOrigen()))
				return false;
			
			// (2) Destino
			if (_destino != null && !_destino.equals(vuelo.dameDestino()))
				return false;
			
			// (3) Fecha de salida
			if (_fSalida != null && !_fSalida.equals(vuelo.dameFechaSalida()))
				return false;
			
			// (4) Fecha de salida
			if (_fLlegada != null && !_fLlegada.equals(vuelo.dameFechaLlegada()))
				return false;
			
			
			// (#) Coincide con el criterio
			return true;
		}
		
		/**
		 * Establece filtro por origen.
		 * 
		 * @param origen Aeropuerto de origen.
		 */
		public void conOrigen(Aeropuerto origen) {
			this._origen = origen;
		}

		/**
		 * Establece filtro por aeropuerto de destino.
		 * 
		 * @param destino Aeropuerto de destino.
 		 */
		public void conDestino(Aeropuerto destino) {
			this._destino = destino;
		}

		/**
		 * Establece la fecha de salida.
		 * 
		 * @param fSalida Fecha de salida.
		 */
		public void conSalida(GregorianCalendar fSalida) {
			this._fSalida = fSalida;
		}

		/**
		 * Establece la fecha de llegada.
		 * 
		 * @param fLlegada Fecha de llegada.
		 */
		public void conLlegada(GregorianCalendar fLlegada) {
			this._fLlegada = fLlegada;
		}
		
		
		// ATRIBUTOS PRIVADOS (de CriterioBusqueda)
		
		/**
		 * Aeropuerto de origen
		 */
		private Aeropuerto _origen = null;

		/**
		 * Aeropuerto de destino
		 */
		private Aeropuerto _destino = null;
		
		/**
		 * Fecha de salida
		 */
		private GregorianCalendar _fSalida = null;
		
		/**
		 * Fecha de llegada
		 */
		private GregorianCalendar _fLlegada = null;
	}
	
	// ATRIBUTOS PRIVADOS

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