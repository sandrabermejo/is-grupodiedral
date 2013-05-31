package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTextArea;

import diedral.acex.Pasajero;
import diedral.acex.Vuelo;
import diedral.acex.gui.Pantalla;
import diedral.acex.ventas.Billete;
import diedral.acex.ventas.Compra;

public class PantallaDetalleVueloContratado extends Pantalla {
	
	public PantallaDetalleVueloContratado(Compra compra) {
		_compra = compra;
		Vuelo v = compra.dameVuelo();
		
		setLayout(new BorderLayout());
		
		// Final de línea
		final String ENDL = System.getProperty("line.separator");
		
		SimpleDateFormat forFecha = new SimpleDateFormat();
		
		// Área de texto donde mostrar la información
		JTextArea textArea = new JTextArea();
		
		textArea.setEditable(false);
		
		textArea.append("*** Información detallada del vuelo ***" + ENDL);
		textArea.append("Número de vuelo: " + v.dameNumeroVuelo() + ENDL + ENDL);
		textArea.append("Aeropuerto de origen: " + v.dameOrigen() + ENDL);
		textArea.append("Fecha de salida: " + forFecha.format(v.dameFechaSalida().getTime()) + ENDL);
		textArea.append("Aeropuerto de destino: " + v.dameDestino() + ENDL);
		textArea.append("Fecha de llegada: " + forFecha.format(v.dameFechaLlegada().getTime()) + ENDL + ENDL);
		textArea.append("Número de pasajeros: " + v.dameNumPasajeros() + ENDL);
		textArea.append("Número de escalas: " + (v.dameEscalas() == null ? 0 : v.dameEscalas().size()) + ENDL);
		textArea.append("Precio del billete: " + v.damePrecio() + ENDL + ENDL);
		
		List<Billete> billetes = compra.dameBilletes();
		Pasajero pasajero;
		for (int i = 0; i < billetes.size(); i++) {
			pasajero = billetes.get(i).damePasajero();
			textArea.append("\tPasajero #" + i+1 + ENDL);
			textArea.append("\tNombre: " + pasajero.dameNombre() + ENDL);
			textArea.append("\tApellidos: " + pasajero.dameApellido1() + " " +  pasajero.dameApellido2() + ENDL);
			textArea.append("\tDNI: " + pasajero.dameDNI() + ENDL);
			textArea.append("\tNacionalidad: " + pasajero.dameNacionalidad() + ENDL);	
		}
				
		add(textArea);
	}
	

	@Override
	public String dameNombre() {
		return "Detalle del vuelo contratado";
	}

	// ATRIBUTOS PRIVADOS
	
	/**
	 * Información sobre el vuelo contratado
	 */
	@SuppressWarnings("unused")
	private Compra _compra;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 2681655224057477585L;

}

