/*
 * PaginaConsultaOfertas.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
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
public class PantallaConsultaOfertas extends Pantalla {

	public PantallaConsultaOfertas(){		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(new PanelOfertas()), BorderLayout.NORTH);
	
	}
	
	public String dameNombre() {
		return "Consulta ofertas";
	}
	/**
	 * Panel de búsqueda
	 */
	private class PanelOfertas extends JTable {
		/**
		 * Crea un panel de búsqueda.
		 */
		public PanelOfertas() {
	
		

			
		
		}
		

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