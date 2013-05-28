/*
 * Pago.java - ACE Gesti�n Externa - Grupo diedral 2013
 */

package diedral.acex;


/**
 * Esta clase abstracta representa un pago.
 *
 * <p>Contiene el importe.
 */
public interface Pago extends java.io.Serializable {

	// METODOS P�BLICOS
	/**
	 * Establece el importe del pago.
	 * 
	 * @param importe El importe del pago.
	 */
	public void establecerImporte(double importe);

	//	M�TODOS ABSTRACTOS
	
	/**
	* Hace efectivo el pago.
	*/
	public boolean efectuar();
	
	/*
	* Calcula la comisi�n asociada a la operaci�n.
	* @return El sobre coste por el pago.
	*/
	public double obtenerSobrecoste();
	
}