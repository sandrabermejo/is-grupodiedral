/*
 * PaginaOferta.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex.gui.pantallas;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import diedral.acex.Oferta;


public class PantallaOferta extends diedral.acex.gui.Pantalla {
	/**
	 * Construye una pantalla con los datos de la oferta seleccionada
	 */
	public PantallaOferta(Oferta oferta) {
		// Aniade una entradilla de texto
		add(new JLabel("Los datos de la oferta seleccionada son: "));
		 
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,1));			
		
		// Creamos las etiqutas
		_nombre = new JLabel("Nombre de la oferta: " + oferta.dameNombre());
		_destino = new JLabel("Destino: " + oferta.dameDestino());
		_descuento = new JLabel("Descuento: " + oferta.dameDescuento() + " euros");
		_edad = new JLabel(oferta.dameCondiciones());
		
		// Las aniadimos al panel
		panel.add(_nombre);
		panel.add(_destino);
		panel.add(_descuento);
		panel.add(_edad);
		
		// Aniadimos el panel a la ventana
		add(panel);
	}
	
	public String dameNombre() {
		return "Oferta seleccionada";
	}	
	
	// MIEMBROS PRIVADOS

		
		/**
		 * Campo de nombre
		 */
		private JLabel _nombre;

		/**
		 * Campo de destino
		 */
		private JLabel _destino;
		
		/**
		 * Campo de descuento
		 */
		private JLabel _descuento;
		
		/**
		 * Campo de vuelos
		 */
		private JLabel _vuelos;
		
		/**
		 * Campo de intervalo de edad
		 */
		private JLabel _edad;
		
		/**
		 * Serial UID
		 */
		private static final long serialVersionUID = 5313233541380924039L;
		
}

		