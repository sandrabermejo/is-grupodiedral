/*
 * FabricaPantallas.java - ACE Gestión Externa - Grupo Diedral 2013
 */
package diedral.acex.gui;

import diedral.acex.gui.pantallas.*;

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
	public Pantalla damePantallaEditarDatosPersonales(){
		if(_pEditarDatosPersonales == null)
			_pEditarDatosPersonales = new PantallaEditarDatosPersonales();
		return _pEditarDatosPersonales;
	}
	/**
	 * Obtiene una pantalla de consulta de ofertas.
	 */
	public Pantalla damePantallaConsultaOfertas(){
		return new PantallaConsultaOfertas();
	}
	/**
	 * Obtiene una pantalla de realizar pago con tarjeta.
	 * @return
	 */
	public Pantalla damePantallaEditarPagoTarjeta(){
		return new PantallaEditarPagoTarjeta();
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
	/**
	 * Pantalla de edición de datos personales de un usuario.
	 */
	private Pantalla _pEditarDatosPersonales = null;
}
