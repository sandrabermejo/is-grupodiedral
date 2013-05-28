package diedral.acex;

import java.util.List;
import java.util.Set;

import diedral.acex.excepciones.PagoIncorrectoException;

public class Compra {
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
		pago.realizarPago(precioCompra); //lanza una excepción si el pago no se ha podido realizar correctamente
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
		int i = 0; 
		boolean encontrado = false;
		Oferta oferta = null;
		for(Oferta oferta: ofertas){
			Set<Vuelo> vuelos = oferta.dameVuelos();
			if(vuelos.contains(vuelo)) //si los vuelos son iguales hemos encontrado una 
				//oferta para él.
				return oferta; //TODO MODIFICAR BERME
		}
		
	return oferta;
	}
	/**
	 * Dada una lista de billetes a comprar y una lista de ofertas de un usuario,
	 * calcula el precio de esos billetes.
	 * @param billetes
	 * @return precio total de la lista de billetes dada.
	 */
	public double calculaPrecio(){
		double precioTotal = 0;
		for(Billete billete: _billetes) {
			double precioBillete = billete.damePrecio();
			Oferta ofertaBillete = buscaOferta(_usuario.dameOfertas(), billete.dameVuelo());
			if(ofertaBillete != null) //si hay oferta que aplicar a ese billete, le restamos 
				//el valor del descuento al precio del billete
				precioBillete -= ofertaBillete.dameDescuento();
			
			
			
			precioTotal += precioBillete;
		}
		return precioTotal;
	}
	
	private List<Billete> _billetes;
	private Usuario _usuario;
}
