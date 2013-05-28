/*
 * Pago.java - ACE Gestión Externa - Grupo diedral 2013
 */

package diedral.acex;


/**
 * Esta interfaz representa un pago.
 */
public interface Pago extends java.io.Serializable {

	// MÉTODOS PÚBLICOS

	/**
	 * Establece el importe del pago.
	 * 
	 * @param importe El importe del pago.
	 */
	public void establecerImporte(double importe);

	//	MÉTODOS ABSTRACTOS
	
	/**
	* Hace efectivo el pago.
	*/
	public boolean efectuar();
	
	/*
	* Calcula la comisión asociada a la operación.
	* @return El sobre coste por el pago.
	*/
	public double obtenerSobrecoste();	
}
