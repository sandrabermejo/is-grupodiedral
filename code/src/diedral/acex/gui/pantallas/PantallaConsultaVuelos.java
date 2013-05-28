/*
 * PaginaConsultaVuelos.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;

import diedral.acex.Aeropuerto;
import diedral.acex.gui.Pantalla;

/**
 * Página de consulta de vuelos.
 */
public class PantallaConsultaVuelos extends Pantalla {

	public PantallaConsultaVuelos(){		
		setLayout(new BorderLayout());
		
		add(new PanelBusqueda(), BorderLayout.NORTH);
		
		add(new JScrollPane(new JTable()));
	}
	
	public String dameNombre() {
		return "Consulta de vuelos";
	}
	
	/**
	 * Panel de búsqueda
	 */
	private class PanelBusqueda extends JPanel {
		/**
		 * Crea un panel de búsqueda.
		 */
		public PanelBusqueda() {
			setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
			
			_origen = new JComboBox();
			add(_origen);
			
			_destino = new JComboBox();
			add(_destino);
			
			MaskFormatter msk = null;
			
			try {
				 msk = new MaskFormatter("##/##/####");
			}
			catch (ParseException pe){
				// 
			}
			
			_fechaSalida = new JFormattedTextField(msk);
			add(_fechaSalida);
			
			_fechaLlegada = new JFormattedTextField(msk);
			add(_fechaLlegada);
			
			JButton btn = new JButton("Buscar");
			
			btn.setIcon(new ImageIcon(
					this.getClass().getResource("../iconos/system-search.png")));
			
			add(btn);
		}
		
		
		// ATRIBUTOS PRIVADOS (de PanelBusqueda)
		
		/**
		 * Selector de aeropuerto de origen
		 */
		JComboBox<Aeropuerto> _origen;
		
		/**
		 * Selector de aeropuerto de destino
		 */
		JComboBox<Aeropuerto> _destino;
		
		/**
		 * Selector de fecha de salida
		 */
		JFormattedTextField _fechaSalida;
		
		/**
		 * Selector de fecha de llegada
		 */
		JFormattedTextField _fechaLlegada;
		
			
		/**
		 * Serial UID (para PanelBusqueda)
		 */
		private static final long serialVersionUID = -194473111700140658L;
	}
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -4868535547311346409L;
}