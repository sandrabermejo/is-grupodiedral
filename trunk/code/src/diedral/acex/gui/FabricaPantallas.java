/*
 * FabricaPantallas.java - ACE Gestión Externa - Grupo Diedral 2013
 */
package diedral.acex.gui;

import diedral.acex.Usuario;
import diedral.acex.gui.pantallas.*;
import.diedral.acex.Vuelo;

/**
 * Fábrica de pantallas.
 *
 */
public class FabricaPantallas {
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
	public Pantalla damePantallaEditarDatosPersonales(Usuario usuario){
		return new PantallaEditarDatosPersonales(usuario);
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
	public Pantalla damePantallaAcceso(ManejadorSesion mnj){
		return new PantallaAcceso(mnj);
	}
	
	/**
	 * Obtiene una pantalla de compra
	 */
	public Pantalla damePantallaCompra(ManejadorPantallas mnj, ManejadorSesion mnjSesion, Vuelo vuelo, int numBilletes){
		return new PantallaCompra(mnj, mnjSesion, this, vuelo, numBilletes);
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
