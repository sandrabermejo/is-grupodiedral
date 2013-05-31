package diedral.acex;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import diedral.acex.excepciones.PagoIncorrectoException;

public class Compra {
	/**
	 * Crea una compra dado el usuario
	 * @param usuario que efectua la compra
	 */
	public Compra(Usuario usuario) {
		_usuario = usuario;
		_billetes = new ArrayList<Billete>();
		_pagada = false;
	}
	
	/**
	 * 	Anade un billete a la compra
	 * 
	 * @param billete a anadir
	 */
	public void anadeBillete(Billete billete) {
		if (!_billetes.contains(billete))
			_billetes.add(billete);
	}
	
	/**
	 * Este metodo efectua una compra realizando primero el pago y después actualiza 
	 * el número de pasajeros de cada vuelo.
	 * Lanza excepción si el pago ha sido incorrecto.
	 * @param billetes
	 * @param precioCompra
	 * @param pago
	 * @throws PagoIncorrectoException
	 */
	public void efectuarCompra(List<Billete> billetes, double precioCompra, Pago pago) throws PagoIncorrectoException{
		pago.establecerImporte(precioCompra);
		pago.efectuar(); //lanza una excepción si el pago no se ha podido realizar correctamente
		//ahora nos disponemos a cambiar el número de pasajeros de cada vuelo
		for(Billete billete: billetes){
			Vuelo vuelo = billete.dameVuelo();
			vuelo.metePasajero(billete.damePasajero());
		}
	}
	
	/**
	 * Método auxiliar que dada una lista de ofertas y un vuelo, busca
	 * si ese vuelo tiene una oferta concreta en esa lista.
	 * @param ofertas
	 * @param vuelo
	 * @return oferta del vuelo dado. Devuelve null si no hay oferta para ese vuelo.
	 */
	private Oferta buscaOferta(List<Oferta> ofertas, Vuelo vuelo){
		for(Oferta oferta: ofertas){
			Set<Vuelo> vuelos = oferta.dameVuelos();
			if(vuelos.contains(vuelo)) //si los vuelos son iguales hemos encontrado una 
				//oferta para él.
				return oferta;
		}		
		return null;
	}
	
	/**
	 * Dada las listas de ofertas generales y personales y un vuelo, devuelve la mejor oferta del vuelo dado
	 * 
	 * @param ofertasGenerales
	 * @param ofertasPersonales
	 * @param vuelo
	 * @return la mejor oferta, null si no hay oferta asociada a ese vuelo
	 */
	private Oferta buscaMejorOferta(List<Oferta> ofertasGenerales, List<Oferta> ofertasPersonales, Vuelo vuelo) {
		Oferta ofertaGeneral = buscaOferta(ofertasGenerales, vuelo);
		Oferta ofertaPersonal = buscaOferta(ofertasPersonales, vuelo);
		
		if (ofertaGeneral != null && ofertaPersonal != null) { // Estan los dos tipos de ofertas
			// Devolvemos la oferta que aporta mayor descuento
			if (ofertaGeneral.dameDescuento() >= ofertaPersonal.dameDescuento())
				return ofertaGeneral;
			return ofertaPersonal;
		}
		
		// Alguna de las dos ofertas o las dos no estan
		if (ofertaGeneral != null) // Solo hay oferta general
			return ofertaGeneral;
			
		if (ofertaPersonal != null) // Solo hay oferta personal
			return ofertaPersonal;
		// No hay ofertas para ese vuelo
		return null;
	}	
	
	/**
	 * Dada una lista de billetes a comprar y una lista de ofertas de un usuario,
	 * calcula el precio de esos billetes.
	 * 
	 * @return precio total de la lista de billetes dada.
	 */
	public double calculaPrecio(){
		double precioTotal = 0;
		for(Billete billete: _billetes) {
			double precioBillete = billete.damePrecio();
			
			// Hay un usuario seleccionado
			if (_usuario != null) {
				
				Oferta ofertaBillete = buscaMejorOferta(_usuario.dameOfertasGenerales(), _usuario.dameOfertasPersonales(), billete.dameVuelo());
			
				if(ofertaBillete != null) //si hay oferta que aplicar a ese billete, le restamos 
					//el valor del descuento al precio del billete
					precioBillete -= ofertaBillete.dameDescuento();
			}
			
			precioTotal += precioBillete;
		}
		return precioTotal;
	}
	
	/**
	 * Indica si la compra está pagada.
	 */
	public boolean estaPagada(){
		return _pagada;
	}
	
	/**
	 * Marca la compra como pagada.
	 */
	public void marcarPagada(){
		_pagada = true;
	}
	
	/**
	 * Marca la compra como no pagada.
	 */
	public void desmarcarPagada(){
		_pagada = false;
	}
	
	/**
	 * Obtiene la lista de billetes de la compra
	 * 
	 * @return La lista de billetes
	 */
	public List<Billete> dameBilletes() {
		return _billetes;
	}
	
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Indica si la compra está pagada
	 */
	private boolean _pagada;
	
	private List<Billete> _billetes;
	private Usuario _usuario;
}
