/*
 * PagoTarjeta.java - ACE Gestión Externa - Grupo diedral 2013
 */

package diedral.acex;


/**
 * Esta clase representa un pago con tarjeta.
 *
 * <p>Contiene el importe, el titular, el número de tarjeta
 * y los metodos para calcular el sobrecoste asociado.
 */
public abstract class PagoTarjeta extends Pago implements java.io.Serializable {
	
	// CONSTRUCTOR
	
	/**
	* Crea un Pago de Tarjeta con los datos aportados.
	*
	* @param titular Titular que figura en la tarjeta.
	* @param numeroTarjeta Numeración de la tarjeta.
	* @param importe El importe del pago, este puede ser establecido a posteriori.
	*/
	public PagoTarjeta(String titular, String numeroTarjeta, double importe = 0){
		_titular = titular; //Controlar corrección de datos o lanzar excepciones ?
		_numeroTarjeta = numeroTarjeta;
		_ importe = importe;
	}

	
	//	MÉTODOS PÚBLICOS
	
	/**
	* Hace efectivo el pago.
	*/
	@override
	public bool efectuar(){
		//TODO no se que hacer aqui...
	}
	
	/**
	* Calcula la comisión asociada a la operación.
	* @return El sobre coste por el pago.
	*/
	@
	public double obtenerSobrecoste(){
	 //TODO  mismo comentario que en  funcion anterior
	}

	// ATRIBUTOS PRIVADOS
	
	/**
	 * Importe del pago.
	 */
	public String _titular;
	
	/**
	* Numero de la tarjeta.
	*/
	public String _numeroTarjeta;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -32452338237467732823L;
}