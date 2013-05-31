package diedral.acex.scentral;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import diedral.acex.AyudantePersistencia;
import diedral.acex.ventas.Compra;

/**
 * Gestiona las compras de esta compañia.
 */
public class GestorCompras implements Serializable {
	/**
	 * Crea un nuevo Gestor de compras.
	 */
	private GestorCompras(){
		_compras = new ArrayList<Compra>();
	}
	
	/**
	 * Devuelve la instancia de la clase.
	 * @return instancia de la clase.
	 */
	public GestorCompras dameInstancia(){
		if (_instancia == null){
			// Intenta cargarlo de los datos almacenados
			_instancia = (GestorCompras) AyudantePersistencia.dameInstancia().recuperayVigila(
					versionTID);
				
			// Si no ha funcionado
			if (_instancia == null) {
				_instancia = new GestorCompras();
				
				AyudantePersistencia.dameInstancia().vigila(_instancia, versionTID);
			}
		}
		
		return _instancia;
	}
	
	/**
	 * Registra compra.
	 * 
	 * @param comp Compra.
	 */
	public boolean registraCompra(Compra comp){
		return _compras.add(comp);
	}
	
	/**
	 * Almacena la instancia única del gestor
	 */
	private static GestorCompras _instancia;
	
	/**
	 * Almacena la lista de compras de la compañía.
	 */
	private List<Compra> _compras;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -135598274202656227L;
	
	/**
	 * Version TID
	 */
	private static final String versionTID = AyudantePersistencia.generaTID(serialVersionUID);
}
