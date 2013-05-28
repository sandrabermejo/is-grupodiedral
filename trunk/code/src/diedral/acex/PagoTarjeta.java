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
	public PagoTarjeta(String titular, String numeroTarjeta, double importe){
		_titular = titular; //Controlar corrección de datos o lanzar excepciones ?
		_numeroTarjeta = numeroTarjeta;
		_importe = importe;
	}

	
	//METODOS PUBLICOS
	
	public void establecerTitular(String titular){
		_titular = titular;
	}
	
	public void establecerNumeroTarjeta(String numeroTarjeta){
		_numeroTarjeta = numeroTarjeta;
	}
	
	/**
	* Hace efectivo el pago.
	*/
	
	public boolean efectuar(){
		return false;
		//TODO no se que hacer aqui...
	}
	
	/**
	* Calcula la comisión asociada a la operación.
	* @return El sobre coste por el pago.
	*/
	public double obtenerSobrecoste(){
		return _importe;
	 //TODO  mismo comentario que en  funcion anterior
	}

	@Override
	public void establecerImporte(double importe) {
		_importe = importe;
	}

	// ATRIBUTOS PRIVADOS
	
	/**
	 * Importe del pago.
	 */
	private String _titular;
	
	/**
	* Numero de la tarjeta.
	*/
	private String _numeroTarjeta;
	
	private double _importe;
	
	private static final long serialVersionUID = 4218885255299801434L;

}