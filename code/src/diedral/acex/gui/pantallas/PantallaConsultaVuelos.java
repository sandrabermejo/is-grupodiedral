/*
 * PaginaConsultaVuelos.java - ACE Gestión Externa - Grupo diedral 2013
 */
package diedral.acex.gui.pantallas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Set;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.MaskFormatter;

import diedral.acex.Aeropuerto;
import diedral.acex.GestorVuelos;
import diedral.acex.Vuelo;
import diedral.acex.gui.Pantalla;

/**
 * Página de consulta de vuelos.
 */
public class PantallaConsultaVuelos extends Pantalla {

	public PantallaConsultaVuelos(){		
		setLayout(new BorderLayout());
		
		add(new PanelBusqueda(), BorderLayout.NORTH);
		
		_tablaVuelos = new ModeloTablaVuelos();
		
		add(new JScrollPane(new JTable(_tablaVuelos)));
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
			setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Buscar"),
					BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			
			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			
			// Crea una máscara para fechas
			MaskFormatter msk = null;
			
			try {
				 msk = new MaskFormatter("##/##/####");
			}
			catch (ParseException pe){
				// Esto se puede determinar en tiempo de compilación
			}
			
			JPanel tpanel = new JPanel();
			tpanel.setLayout(new BoxLayout(tpanel, BoxLayout.LINE_AXIS));
			
			_origen = new JComboBox<>(new Vector<>(GestorVuelos.dameInstancia().dameAeropuertos()));
			_fechaSalida = new JFormattedTextField(msk);
			
			Dimension dim = _fechaSalida.getPreferredSize();
			dim.width *= 2;
			
			_fechaSalida.setMaximumSize(dim);
			_fechaSalida.setPreferredSize(dim);
			
			
			tpanel.add(new JLabel("Salida: "));
			tpanel.add(Box.createHorizontalStrut(10));
			tpanel.add(_origen);
			tpanel.add(_fechaSalida);
			
			add(tpanel);
			
			add(Box.createVerticalStrut(5));
			
			tpanel = new JPanel();
			tpanel.setLayout(new BoxLayout(tpanel, BoxLayout.LINE_AXIS));
			
			_destino = new JComboBox<>(new Vector<>(GestorVuelos.dameInstancia().dameAeropuertos()));
			_fechaLlegada = new JFormattedTextField(msk);
			
			_fechaLlegada.setMaximumSize(dim);
			_fechaLlegada.setPreferredSize(dim);
			
			tpanel.add(new JLabel("Llegada: "));
			tpanel.add(Box.createHorizontalStrut(10));
			tpanel.add(_destino);
			tpanel.add(_fechaLlegada);
			
			add(tpanel);
			
			add(Box.createVerticalStrut(5));
			
			tpanel = new JPanel();
			tpanel.setLayout(new BoxLayout(tpanel, BoxLayout.LINE_AXIS));
			
			tpanel.add(Box.createHorizontalGlue());
			
			JButton btn = new JButton("Buscar");
			
			btn.setIcon(new ImageIcon(
					this.getClass().getResource("../iconos/system-search.png")));
			
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					GestorVuelos.CriterioBusqueda criterio = new GestorVuelos.CriterioBusqueda();
					
					criterio.conOrigen(_origen.getItemAt(_origen.getSelectedIndex()));
					criterio.conDestino(_destino.getItemAt(_destino.getSelectedIndex()));
					
					Set<Vuelo> vuelos = GestorVuelos.dameInstancia().buscaVuelo(criterio);
					
					_tablaVuelos.ponVuelos(new Vector<>(vuelos));
					
				}
			});
			
			tpanel.add(btn);
			
			add(tpanel);
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
	 * Modelo para la tabla de vuelos.
	 *
	 */
	private class ModeloTablaVuelos extends AbstractTableModel {
		/**
		 * Fija la lista de vuelos de la tabla.
		 * 
		 * @param vuelos Vector de vuelos.
		 */
		public void ponVuelos(Vector<Vuelo> vuelos){
			_vuelos = vuelos;
			
			fireTableDataChanged();
		}

		/**
		 * Obtiene el número de columnas de la tabla.
		 */
		public int getColumnCount() {
			return _columnas.length;
		}
		
		/**
		 * Obtiene el nombre de las columnas
		 */
		public String getColumnName (int col){
			if (col >= 0 && col < _columnas.length)
				return _columnas[col];
			else
				return "Desconocido";
		}

		/**
		 * Número de filas
		 */
		public int getRowCount() {
			return _vuelos.size();
		}

		/**
		 * Valor de una celda.
		 */
		public Object getValueAt(int fila, int col) {
			Vuelo vuelo = _vuelos.elementAt(fila);
			SimpleDateFormat formatoFecha = new SimpleDateFormat();
			
			// TODO
			
			switch (col){
				case 0 :
					// Número de vuelo TODO
					return vuelo.dameNumPasajeros();
				case 1 :
					return vuelo.dameOrigen();
				case 2 :
					return formatoFecha.format(vuelo.dameFechaSalida().getGregorianChange());
				case 3 :
					return vuelo.dameDestino();
				case 4 :
					return formatoFecha.format(vuelo.dameFechaLlegada().getGregorianChange());
				default :
					return "--";
			}
		}
		
		/**
		 * Columnas de la tabla.
		 */
		private String[] _columnas = 
			{"Id", "Origen", "Fecha salida", "Destino", "Fecha llegada"};
		
		/**
		 * Vector de vuelos mostrados.
		 */
		private Vector<Vuelo> _vuelos = new Vector<>();
		
		/**
		 * Serial UID 
		 */
		private static final long serialVersionUID = 1853343405213592855L;
	}
	
	/**
	 * Modelo de tabla de vuelos
	 */
	private ModeloTablaVuelos _tablaVuelos;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -4868535547311346409L;
}