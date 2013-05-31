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
import java.util.GregorianCalendar;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.MaskFormatter;

import diedral.acex.Aeropuerto;
import diedral.acex.Sesion;
import diedral.acex.Vuelo;
import diedral.acex.gui.FabricaPantallas;
import diedral.acex.gui.ManejadorPantallas;
import diedral.acex.gui.Pantalla;
import diedral.acex.scentral.GestorVuelos;

/**
 * Página de consulta de vuelos.
 */
public class PantallaConsultaVuelos extends Pantalla {

	public PantallaConsultaVuelos(){		
		setLayout(new BorderLayout());
		
		add(new PanelBusqueda(), BorderLayout.NORTH);
		
		_tablaVuelos = new ModeloTablaVuelos();
		
		JTable tabla = new JTable(_tablaVuelos);
		
		add(new JScrollPane(tabla));
		
		// Añade el cambio a información de vuelo seleccionado
		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent lse) {
				Pantalla pantallaDetalle = _fabrica.damePantallaDetalleVuelo(_tablaVuelos.vueloEn(lse.getFirstIndex()));
				pantallaDetalle.estableceContexto(_manejadorPantallas, _fabrica, _sesion);
				_manejadorPantallas.cambiaA(pantallaDetalle);
			}
		});
	}
	
	public String dameNombre() {
		return "Consulta de vuelos";
	}
	
	@Override
	public void estableceContexto(ManejadorPantallas manejador,
			FabricaPantallas fabrica, Sesion sesion) {
		_manejadorPantallas = manejador;
		_fabrica = fabrica;
		_sesion = sesion;
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
			
			_origen = new JComboBox<Aeropuerto>(new Vector<Aeropuerto>(GestorVuelos.dameInstancia().dameAeropuertos()));
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
			
			_destino = new JComboBox<Aeropuerto>(new Vector<Aeropuerto>(GestorVuelos.dameInstancia().dameAeropuertos()));
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
					// Criterio de búsqueda
					GestorVuelos.CriterioBusqueda criterio = new GestorVuelos.CriterioBusqueda();	
					
					criterio.conOrigen(_origen.getItemAt(_origen.getSelectedIndex()));
					criterio.conDestino(_destino.getItemAt(_destino.getSelectedIndex()));
					
					if (_fechaSalida.isEditValid())
						criterio.conSalida(parseaFecha(_fechaSalida.getText()), null);
					
					if (_fechaLlegada.isEditValid())
						criterio.conSalida(parseaFecha(_fechaSalida.getText()), null);
					
					Set<Vuelo> vuelos = GestorVuelos.dameInstancia().buscaVuelo(criterio);
					
					_tablaVuelos.ponVuelos(new Vector<Vuelo>(vuelos));
					
				}
			});
			
			tpanel.add(btn);
			
			add(tpanel);
		}
		
		
		/**
		 * Interpreta una fecha a partir de un texto.
		 */
		private GregorianCalendar parseaFecha(String fecha) {
			// Formateador de fechas
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/mm/yyyy");	
			
			GregorianCalendar ret = new GregorianCalendar();
			
			try {
				ret.setTime(formatoFecha.parse(fecha));
			} catch (ParseException e) {
				return null;
			}
			
			return ret;
		}
		
		// ATRIBUTOS PRIVADOS (de PanelBusqueda)
		
		/**
		 * Selector de aeropuerto de origen
		 */
		private JComboBox<Aeropuerto> _origen;
		
		/**
		 * Selector de aeropuerto de destino
		 */
		private JComboBox<Aeropuerto> _destino;
		
		/**
		 * Selector de fecha de salida
		 */
		private JFormattedTextField _fechaSalida;
		
		/**
		 * Selector de fecha de llegada
		 */
		private JFormattedTextField _fechaLlegada;
		
			
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
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
			
			switch (col){
				case 0 :
					return vuelo.dameNumeroVuelo();
				case 1 :
					return vuelo.dameOrigen();
				case 2 :
					return formatoFecha.format(vuelo.dameFechaSalida().getTime());
				case 3 :
					return vuelo.dameDestino();
				case 4 :
					return formatoFecha.format(vuelo.dameFechaLlegada().getTime());
				default :
					return "--";
			}
		}
		
		
		/**
		 * Devuelve el vuelo en la posición i-ésima.
		 * 
		 * @param indice Índice.
		 */
		public Vuelo vueloEn(int indice){
			return _vuelos.elementAt(indice);
		}
		
		/**
		 * Columnas de la tabla.
		 */
		private String[] _columnas = 
			{"Id", "Origen", "Fecha salida", "Destino", "Fecha llegada"};
		
		/**
		 * Vector de vuelos mostrados.
		 */
		private Vector<Vuelo> _vuelos = new Vector<Vuelo>();
		
		/**
		 * Serial UID 
		 */
		private static final long serialVersionUID = 1853343405213592855L;
	}
	
	/**
	 * Fábrica de pantallas
	 */
	private FabricaPantallas _fabrica;
	
	/**
	 * Manejador de pantallas
	 */
	private ManejadorPantallas _manejadorPantallas;
	
	/**
	 * Sesion
	 */
	private Sesion _sesion;
	
	/**
	 * Modelo de tabla de vuelos
	 */
	private ModeloTablaVuelos _tablaVuelos;
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -4868535547311346409L;
}