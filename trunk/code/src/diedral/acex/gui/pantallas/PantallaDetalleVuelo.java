/*
 * PantallaDetalleVuelo.java - ACE Gestión Externa - Grupo diedral 2013 
 */
package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import diedral.acex.Sesion;
import diedral.acex.Vuelo;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;

/**
 * Pantalla que muestra la información detallada de un vuelo.
 *
 */
public class PantallaDetalleVuelo extends Pantalla {
	/* (sin Javadoc)
	 * @see diedral.acex.gui.Pantalla#dameNombre()
	 */
	public PantallaDetalleVuelo(Vuelo v){
		_vuelo = v;
		
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
		textArea.append("Aeropuerto de destino: " + v.dameOrigen() + ENDL);
		textArea.append("Fecha de llegada: " + forFecha.format(v.dameFechaLlegada().getTime()) + ENDL + ENDL);
		textArea.append("Número de pasajeros: " + v.dameNumPasajeros() + ENDL);
		textArea.append("Número de escalas: " + (v.dameEscalas() == null ? 0 : v.dameEscalas().size()) + ENDL);
		textArea.append("Precio del billete: " + v.damePrecio() + ENDL);
		
		add(textArea);
		
		// (#) Botón de compra
		
		JPanel sur = new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JButton comprar = new JButton("Comprar billete");
		
		comprar.setIcon(new ImageIcon(this.getClass().getResource("../iconos/emblem-symbolic-link.png")));
		
		comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				_manejador.cambiaA(_fabrica.damePantallaCompra(_vuelo));
			}
		});
		
		sur.add(Box.createHorizontalGlue());
		
		sur.add(comprar);
		
		add(sur, BorderLayout.SOUTH);
	}
	
	@Override
	public String dameNombre() {
		return "Información del vuelo";
	}	
	
	@Override
	public void estableceContexto(ManejadorPantallas manejador,
			FabricaPantallas fabrica, Sesion sesion) {
		_manejador = manejador;
		_fabrica = fabrica;
		_sesion = sesion;
	}
	
	// ATRIBUTOS PRIVADOS
	
	/**
	 * Información sobre el vuelo
	 */
	private Vuelo _vuelo;
	
	/**
	 * Manejador de pantallas
	 */
	private ManejadorPantallas _manejador;
	
	/**
	 * Fábrica de pantallas
	 */
	private FabricaPantallas _fabrica;
	
	/**
	 * Sesion
	 */
	private Sesion _sesion;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 7957391590164640592L;
}
