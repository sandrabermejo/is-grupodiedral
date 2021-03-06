/*
 * PagoTarjeta.java - ACE Gestión Externa - Grupo diedral 2013
 */

package diedral.acex.ventas;



/**
 * Esta clase representa un pago con tarjeta.
 *
 * <p>Contiene el importe, el titular, el número de tarjeta
 * y los métodos para calcular el sobrecoste asociado.
 */
public class PagoTarjeta implements Pago {
	// CONSTRUCTOR
	
	/**
	 * Crea un pago con Tarjeta sin ningún dato especificado.
	 */
	public PagoTarjeta(){}
	
	/**
	* Crea un Pago de Tarjeta con los datos aportados.
	*
	* @param titular Titular que figura en la tarjeta.
	* @param numeroTarjeta Numeración de la tarjeta.
	* @param importe El importe del pago, este puede ser establecido a posteriori.
	*/
	public PagoTarjeta(Compra compra, String titular, String numeroTarjeta, double importe){
		_titular = titular; //Controlar corrección de datos o lanzar excepciones ?
		_numeroTarjeta = numeroTarjeta;
		_importe = importe;
		_compra = compra;
	}

	
	// MÉTODOS PÚBLICOS
	
	/**
	 * Establece el titular de este pago.
	 * 
	 * @param titular Titular del pago.
	 */
	public void establecerTitular(String titular){
		_titular = titular;
	}
	/**
	 * Establece el número de tarjeta para realizar este pago.
	 * 
	 * @param numeroTarjeta Número de tarjeta para el cargo.
	 */
	public void establecerNumeroTarjeta(String numeroTarjeta){
		_numeroTarjeta = numeroTarjeta;
	}
	
	/**
	 * Establece la compra para la cual se elabora el pago.
	 * 
	 * @param compra Compra sobre la que se elabora el pago.
	 */
	public void establecerCompra(Compra compra){
		_compra = compra;
	}
	
	/**
	 * Hace efectivo el pago.
	 */
	public boolean efectuar(){
		_compra.marcarPagada();
		return true;
	}
	
	/**
	 * Calcula la comisión asociada a la operación.
	 * 
	 * @return El sobre coste por el pago.
	 */
	public double obtenerSobrecoste(){
		return _importe * 0.03;
	}

	@Override
	public void establecerImporte(double importe) {
		_importe = importe;
	}

	// ATRIBUTOS PRIVADOS
	
	/**
	 * Titular de la tarjeta
	 */
	@SuppressWarnings("unused")
	private String _titular;
	
	/**
	 * Número de la tarjeta
	 */
	@SuppressWarnings("unused")
	private String _numeroTarjeta;
	
	/**
	 * Importe de la operación.
	 */
	private double _importe;
	
	/**
	 * Compra sobre la que versa el pago.
	 */
	private Compra _compra;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 4218885255299801434L;
}