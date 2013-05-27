/*
 * Pago.java - ACE Gesti�n Externa - Grupo diedral 2013
 */

package diedral.acex;


/**
 * Esta clase abstracta representa un pago.
 *
 * <p>Contiene el importe.
 */
public abstract class Aeropuerto implements java.io.Serializable {
	

	 // METODOS P�BLICOS
	/**
	 * Establece el importe del pago.
	 * 
	 * @param importe El importe del pago.
	 */
	public void establecerImporte(double importe) {
		_importe = importe;
	}

	//	M�TODOS ABSTRACTOS
	
	/**
	* Hace efectivo el pago.
	*/
	public bool efectuar();
	
	/*
	* Calcula la comisi�n asociada a la operaci�n.
	* @return El sobre coste por el pago.
	*/
	public double obtenerSobrecoste();

	// ATRIBUTOS PRIVADOS
	
	/**
	 * Importe del pago
	 */
	public double _importe;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -22637338922237783687L;
}