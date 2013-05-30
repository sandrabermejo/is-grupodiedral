/*
 * FabricaPantallas.java - ACE Gestión Externa - Grupo Diedral 2013
 */
package diedral.acex.gui;

import diedral.acex.Compra;
import diedral.acex.Oferta;
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
	 * Obtiene una pantalla de detalle sobre un vuelo.
	 * 
	 * @param v Vuelo seleccionado.
	 */
	public Pantalla damePantallaDetalleVuelo(Vuelo v){
		return new PantallaDetalleVuelo(v);
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
	 * Obtiene una pantalla que muestra los datos de la oferta seleccionada
	 */
	public Pantalla damePantallaOferta(Oferta oferta){
		return new PantallaOferta(oferta);
	}
	
	/**
	 * Obtiene una pantalla de acceso.
	 */
	public Pantalla damePantallaAcceso(){
		return new PantallaAcceso();
	}
	
	/**
	
	/**
	 * Obtiene una pantalla de registro
	 */
	public Pantalla damePantallaRegistro(){
		return new PantallaRegistro();
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
	 * Obtiene una pantalla de pago con tarjeta
	 */
	public Pantalla damePantallaPagoTarjeta(Compra compra){
		return new PantallaPagoTarjeta(compra);
	}
	
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
