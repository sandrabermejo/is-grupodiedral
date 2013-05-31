/*
 * FabricaPantallas.java - ACE Gestión Externa - Grupo Diedral 2013
 */
package diedral.acex.gui;

import diedral.acex.Vuelo;
import diedral.acex.gui.pantallas.*;
import diedral.acex.ventas.Compra;
import diedral.acex.ventas.Oferta;

/**
 * Fábrica de pantallas.
 *
 * <p>Esta clase crea las diferentes pantallas de la aplicación, todas ellas
 * herederas de la clase abstract {@link diedral.acex.gui.Pantalla}.
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
	 * Obtiene una pantalla de restablecer contrasena
	 */
	public Pantalla damePantallaRestablecerContrasena() {
		return new PantallaRestablecerContrasena();
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
	public Pantalla damePantallaCompra(Vuelo vuelo){
		return new PantallaCompra(vuelo);
	}
	
	/**
	 * Obtiene una pantalla de inicio de pago
	 */
	public Pantalla damePantallaInicioPago(Compra compra) {
		return new PantallaInicioPago(compra);
	}
	
	/**
	 * Obtiene una pantalla de pago con tarjeta
	 */
	public Pantalla damePantallaPagoTarjeta(Compra compra){
		return new PantallaPagoTarjeta(compra);
	}
	
	/**
	 * Obtiene una pantalla con información de los vuelos contratados
	 */
	public Pantalla damePantallaVuelosContratado() {
		return new PantallaVuelosContratados();
	}
	
	/**
	 * Obtiene una pantalla con información detallada de un vuelo contratado
	 * @return
	 */
	public Pantalla damePantallaDetalleVueloContratado(Compra compra) {
		return new PantallaDetalleVueloContratado(compra);
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
