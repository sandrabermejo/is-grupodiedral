package diedral.acex;

import java.util.Iterator;
import java.util.List;

import diedral.acex.excepciones.PagoIncorrectoException;
/**
 * Gestiona el proceso de compra y todo lo que se realiza para finalizar
 * el proceso de compra.
 * @author Natalia
 *
 */
public class GestorCompras {
	public GestorCompras(){
	}
	public static void efectuarCompra(List<Billete> billetes, double precioCompra, Pago pago) throws PagoIncorrectoException{
		try{
			pago.realizarPago(precioCompra); //lanza una excepción si el pago no se ha podido realizar correctamente
			//ahora nos disponemos a cambiar el número de pasajeros de cada vuelo
			for(int i = 0; i < billetes.size(); i++){
				Vuelo vuelo = billetes.dameVuelo();
				vuelo.meteNumPasajeros(vuelo.dameNumPasajeros());
			}
		} catch(PagoIncorrectoException ex){
			throw new Exception("El pago no se ha podido efectuar.");
		}
		
	}
	/**
	 * Método auxiliar que dada una lista de ofertas y un vuelo, busca
	 * si ese vuelo tiene una oferta concreta en esa lista.
	 * @param ofertas
	 * @param vuelo
	 * @return oferta del vuelo dado. Devuelve null si no hay oferta para ese vuelo.
	 */
	private static Oferta buscaOferta(List<Ofertas> ofertas, Vuelo vuelo){
		int i = 0; 
		boolean encontrado = false;
		Oferta oferta;
		while(i < ofertas.size() && !encontrado){
			oferta = ofertas.get(i); //la oferta i-ésima
			if(vuelo.equals(ofertas.dameVuelo())) //si los vuelos son iguales hemos encontrado una 
				//oferta para él.
				encontrado = true;
		i++;
		}
		if(!encontrado) //si no hemos encontrado oferta para un vuelo devolvemos null.
			oferta = null;
		
	return oferta;
	}
	/**
	 * Dada una lista de billetes a comprar y una lista de ofertas de un usuario,
	 * calcula el precio de esos billetes.
	 * @param billetes
	 * @return precio total de la lista de billetes dada.
	 */
	public static double calculaPrecio(List<Billete> billetes, List<Oferta> ofertas){
		double precioTotal = 0;
		for(int i = 0; i < billetes.size(); i++) {
			double precioBillete = billetes.get(i).damePrecio();
			Oferta ofertaBillete = _instancia.buscaOferta(ofertas, billetes.get(i).dameVuelo());
			if(ofertaBillete != null) //si hay oferta que aplicar a ese billete, le restamos 
				//el valor del descuento al precio del billete
				precioBillete -= ofertaBillete.dameDescuento();
			
			precioTotal += precioBillete;
		}
		return precioTotal;
	}
	/**
	 * Almacena la instancia única del gestor
	 */
	private static GestorCompras _instancia;
}
