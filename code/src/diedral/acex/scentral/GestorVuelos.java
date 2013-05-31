/*
 * GestorVuelos.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex.scentral;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import diedral.acex.Aeropuerto;
import diedral.acex.AyudantePersistencia;
import diedral.acex.Escala;
import diedral.acex.Vuelo;

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
			_instancia = (GestorVuelos) AyudantePersistencia.dameInstancia().recuperayVigila(versionTID);
			
			// Si no ha funcionado
			if (_instancia == null) {
				_instancia = new GestorVuelos();
				AyudantePersistencia.dameInstancia().vigila(_instancia, versionTID);
			}
		}
		
		return _instancia;
	}	
	
	/**
	 * Inserta un vuelo en el registro de la compañía.
	 * 
	 * <p>Sólo con fines demostrativos pues no se corresponde con esta
	 * parte de la implementación.
	 * 
	 * @param vuelo Vuelo a insertar.
	 * 
	 * @return {@code true} si ha sido posible, {@code false} en caso
	 * contrario (gte. si ya existe el vuelo en el registro de la compañía).
	 */
	public boolean añadeVuelo(Vuelo vuelo){
		if (vuelo != null)
			return _vuelos.add(vuelo);
		
		return false;
	}
	
	/**
	 * Busca en la base de datos de vuelo aquellos que cumplan
	 * con las condiciones referidas y los devuelve.
	 * 
	 * @param criterio Criterio de búsqueda.
	 */
	public Set<Vuelo> buscaVuelo(CriterioBusqueda criterio){
		Set<Vuelo> ret = new HashSet<Vuelo>(); 
		
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
		Set<Aeropuerto> ret = new HashSet<Aeropuerto>();
		
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
			
			// (3) Fecha de salida (comprueba ambos extremos)
			if (_fSalidaMin != null && _fSalidaMin.compareTo(vuelo.dameFechaSalida()) > 0 )
				return false;
			
			if (_fSalidaMax != null && _fSalidaMax.compareTo(vuelo.dameFechaSalida()) < 0 )
				return false;
			
			// (4) Fecha de salida
			if (_fLlegadaMin != null && _fLlegadaMin.compareTo(vuelo.dameFechaLlegada()) > 0)
				return false;
			
			if (_fLlegadaMax != null && _fLlegadaMax.compareTo(vuelo.dameFechaLlegada()) < 0)
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
			_destino = destino;
		}

		/**
		 * Establece la fecha de salida.
		 * 
		 * @param desde Cota inferior del intervalo de la fecha de salida,
		 * {@code null} significará no acotado.
		 * @param hasta Cota superior del intervalo de la fecha de salida.
		 */
		public void conSalida(GregorianCalendar desde, GregorianCalendar hasta) {
			_fSalidaMin = desde;
			_fSalidaMax = hasta;
		}

		/**
		 * Establece la fecha de llegada.
		 * 
		 * @param desde Cota inferior del intervalo de la fecha de llegada,
		 * {@code null} significará no acotado.
		 * @param hasta Cota superior del intervalo de la fecha de llegada.
		 */
		public void conLlegada(GregorianCalendar desde, GregorianCalendar hasta) {
			_fLlegadaMin = desde;
			_fLlegadaMax = hasta;
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
		 * Cota inferior del intervalo de fecha de salida
		 */
		private GregorianCalendar _fSalidaMin = null;
		
		/**
		 * Cota superior del intervalo de fecha de salida
		 */
		private GregorianCalendar _fSalidaMax = null;
		
		/**
		 * Cota inferior del intervalo de fecha de llegada
		 */
		private GregorianCalendar _fLlegadaMin = null;
		
		/**
		 * Cota superior del intervalo de fecha de llegada
		 */
		private GregorianCalendar _fLlegadaMax = null;
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
	private static final String versionTID = AyudantePersistencia.generaTID(serialVersionUID);
}