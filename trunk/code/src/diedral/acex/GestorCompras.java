package diedral.acex;

import java.util.ArrayList;
import java.util.List;
/**
 * Gestiona las compras de esta compañia.
 */
public class GestorCompras {
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
		if(_instancia == null)
			_instancia = new GestorCompras();
		return _instancia;
	}
	
	/**
	 * Almacena la instancia única del gestor
	 */
	private static GestorCompras _instancia;
	
	/**
	 * Almacena la lista de compras de la compañía.
	 */
	private List<Compra> _compras;
}
