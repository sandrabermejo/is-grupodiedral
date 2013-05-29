/*
 * FabricaPantallas.java - ACE Gestión Externa - Grupo Diedral 2013
 */
package diedral.acex.gui;

import diedral.acex.Usuario;
import diedral.acex.Vuelo;
import diedral.acex.gui.pantallas.*;

/**
 * Fábrica de pantallas.
 *
 * <p>Esta clase crea las diferentes pantallas de la aplicación, todas ellas
 * herederas de la clase abstract {@link diredral.acex.gui.Pantalla}.
 */
public class FabricaPantallas {
	/**
	 * Contruye una fábrica de pantallas.
	 */
	public FabricaPantallas() {}
	
	/**
	 * Obtiene una pantalla de sugerencias.
	 */
	public Pantalla damePantallaSugerencias(){
		if (_pSugerencias == null)
			_pSugerencias = new PantallaSugerencias();
		
		return _pSugerencias;
	}
	
	/**
	 * Obtiene una pantalla de inicio.
	 */
	public Pantalla damePantallaInicio(){
		if (_pInicio == null)
			_pInicio = new PantallaInicio();
		
		return _pInicio;
	}
	
	/**
	 * Obtiene una pantalla de consulta de vuelos.
	 */
	public Pantalla damePantallaConsultaVuelos(){
		return new PantallaConsultaVuelos();
	}
	/**
	 * Obtiene una pantalla donde un usuario edita sus datos personales.
	 * @return
	 */
	public Pantalla damePantallaEditarDatosPersonales(){
		return new PantallaEditarDatosPersonales();
	}
	
	
	/**
	 * Obtiene una pantalla de consulta de ofertas.
	 */
	public Pantalla damePantallaConsultaOfertas(){
		return new PantallaConsultaOfertas();
	}
	
	/**
	 * Obtiene una pantalla de acceso.
	 */
	public Pantalla damePantallaAcceso(){
		return new PantallaAcceso();
	}
	
	/**
	 * Obtiene una pantalla de compra
	 * 
	 * TODO: documentar
	 * 
	 */
	public Pantalla damePantallaCompra(Vuelo vuelo, int numBilletes){
		return new PantallaCompra(vuelo, numBilletes);
	}
	
	/**
	 * Obtiene una pantalla de realizar pago con tarjeta.
	 * @return
	 */
	/*public Pantalla damePantallaEditarPagoTarjeta(){
		return new PantallaEditarPagoTarjeta();
	}*/
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Pantalla de inicio.
	 */
	private Pantalla _pInicio = null;
	
	/**
	 * Pantalla de sugerencias.
	 */
	private Pantalla _pSugerencias = null;
}
